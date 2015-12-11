/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lsed.beans;

import com.lsed.jpa.Card;
import com.lsed.jpa.Step;
import com.lsed.jpa.StepPK;
import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.Persistence;
import javax.sql.DataSource;

/**
 *
 * @author Grady Ellison
 */
@ManagedBean(name = "stepBean", eager = true)
@ViewScoped
public class StepBean implements Serializable
{
    @Resource(lookup="jdbc/lsed_db")
    protected DataSource ds;
    
    private List<Step> steps;
    private int publish;
    private List<String> imageList;
    
    private int stepId;
    private int cardId;
    private int number;
    private String heading;
    private String description;
    private String imageLink;
    private Time timeToComplete;
    
     /**
     * Creates a new instance of StepBean
     * @throws java.sql.SQLException
     */
    public StepBean() throws SQLException
    {
        steps = new ArrayList<>();
        updateImageList();
        imageLink = "";
        timeToComplete = new Time(0);
        publish = 0;
    }

    public List<Step> getSteps() throws SQLException {
        return steps;
    }
    
    public List<Step> getSteps_ByCardId() throws SQLException {
        Connection conn = null;
        try {
            if (cardId > 0) {
                if (ds == null)
                    throw new SQLException("DataSource is NULL in StepBean");
                conn = ds.getConnection();
                if (conn == null)
                    throw new SQLException("Cannot get connection from data source in StepBean");

                CallableStatement stmt = conn.prepareCall("{CALL querySteps_ByCardId(?)}");
                stmt.setInt(1, cardId);
                if (stmt.execute()) {
                    ResultSet rs = stmt.getResultSet();
                    if (rs != null) {
                        steps.clear();
                        while (rs.next()) {
                            Step step = new Step();

                            step.setStepPK(new StepPK(rs.getInt("StepId"), rs.getInt("card_CardId"), rs.getInt("card_USER_UserId")));
                            step.setHeading(rs.getString("Heading"));
                            step.setNumber(rs.getInt("Number"));
                            step.setTimeToComplete(rs.getTime("TimeToComplete"));
                            step.setImageLink(rs.getString("ImageLink"));
                            step.setDescription(rs.getString("Description"));

                            steps.add(step);
                        }
                    }
                }
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
        return steps;
    }

    public void setSteps(List<Step> steps) {
        this.steps = steps;
    }
    
    public List<String> getImageList() {
        return imageList;
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }
    
    public int getStepId() {
        return stepId;
    }

    public void setStepId(int stepId) {
        this.stepId = stepId;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public int getPublish() {
        return publish;
    }

    public void setPublish(int publish) throws SQLException {
        this.publish = publish;
    }

    public Time getTimeToComplete() {
        return timeToComplete;
    }

    public void setTimeToComplete(Time timeToComplete) {
        this.timeToComplete = timeToComplete;
    }
    
    public void publish(int publish) throws SQLException {
        if ((publish == 0) || (publish == 1))
            setPublish(publish);
        Connection conn = null;
        try {
            if (cardId > 0) {
                if (ds == null)
                    throw new SQLException("DataSource is NULL in StepBean");
                conn = ds.getConnection();
                if (conn == null)
                    throw new SQLException("Cannot get connection from data source in StepBean");

                CallableStatement stmt = conn.prepareCall("{CALL publishCard(?, ?)}");
                stmt.setInt(1, cardId);
                stmt.setInt(2, this.publish);
                stmt.execute();
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
        //return "viewcard.xhtml?cardId=" + cardId;
    }
    
    public void submit() throws SQLException {
        //(IN cardId INT(11), IN userId INT(11), IN timeToComplete TIME, IN imageLink VARCHAR(256), IN description VARCHAR(512), IN heading VARCHAR(128))
        Connection conn = null;
        try {
            if (cardId > 0) {
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.lsed.LearnSomethingEveryDay");
                EntityManager em = emf.createEntityManager();
                TypedQuery query = em.createNamedQuery("Card.findByCardId", Card.class);
                query.setParameter("cardId", cardId);
                List<Card> results = query.getResultList();
                int userId = -1;
                if (!results.isEmpty()) {
                    userId = results.get(0).getUser().getUserId();
                }
                if (userId > 0) {
                    if (ds == null)
                        throw new SQLException("DataSource is NULL in StepBean");
                    conn = ds.getConnection();
                    if (conn == null)
                        throw new SQLException("Cannot get connection from data source in StepBean");

                    CallableStatement stmt = conn.prepareCall("{CALL insertLatestStepForCard(?, ?, ?, ?, ?, ?)}");
                    stmt.setInt(1, cardId);
                    stmt.setInt(2, userId);
                    stmt.setTime(3, timeToComplete);
                    stmt.setString(4, imageLink);
                    stmt.setString(5, description);
                    stmt.setString(6, heading);
                    stmt.execute();
                }
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
    }
    
    public List<String> updateImageList() throws SQLException {
        Connection conn = null;
        try {
            if (cardId > 0) {
                if (ds == null)
                    throw new SQLException("DataSource is NULL in StepBean");
                conn = ds.getConnection();
                if (conn == null)
                    throw new SQLException("Cannot get connection from data source in StepBean");

                CallableStatement stmt = conn.prepareCall("{CALL getImagesFromStepsFromCard(?)}");
                stmt.setInt(1, cardId);
                if (stmt.execute()) {
                    ResultSet rs = stmt.getResultSet();
                    if (rs != null) {
                        imageList = new ArrayList<>();
                        while (rs.next()) {
                            imageList.add(rs.getString("ImageLink"));
                        }
                    }
                }
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
        return imageList;
        //return "viewcard.xhtml?cardId=" + cardId;
    }
}
