/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lsed.beans;

import com.lsed.jpa.Card;
import com.lsed.jpa.Step;
import com.lsed.jpa.StepPK;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
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
public class StepBean
{
    @Resource(lookup="jdbc/lsed_db")
    protected DataSource ds;
    protected Connection conn;
    
    private List<Step> steps;
    
    public int stepId;
    public int cardId;
    public int number;
    public String heading;
    public String description;
    public String imageLink;
    public Time timeToComplete;
    
     /**
     * Creates a new instance of StepBean
     * @throws java.sql.SQLException
     */
    public StepBean() throws SQLException
    {
        steps = null;
        cardId = 0;
        stepId = 0;
        number = 1;
        heading = "";
        description = "";
        imageLink = "";
        timeToComplete = new Time(0);
    }

    public List<Step> getSteps() throws SQLException {
        return getSteps_ByCardId();
    }
    
    public List<Step> getSteps_ByCardId() throws SQLException {
        if (steps == null) {
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
                        steps = new ArrayList<>();
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
        }
        return steps;
    }

    public void setSteps(List<Step> steps) {
        this.steps = steps;
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
    
    public void submit() throws SQLException {
        //(IN cardId INT(11), IN userId INT(11), IN timeToComplete TIME, IN imageLink VARCHAR(256), IN description VARCHAR(512), IN heading VARCHAR(128))
        System.out.println("cardId: " + cardId);
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
            System.out.println("userId: " + userId);
            if (userId > 0) {
                if (ds == null)
                    throw new SQLException("DataSource is NULL in StepBean");
                conn = ds.getConnection();
                if (conn == null)
                    throw new SQLException("Cannot get connection from data source in StepBean");

                CallableStatement stmt = conn.prepareCall("{CALL insertLatestStepForCard(?, ?, ?, ?, ?, ?)}");
                System.out.println("imageLink: " + imageLink);
                System.out.println("description: " + description);
                System.out.println("heading: " + heading);
                stmt.setInt(1, cardId);
                stmt.setInt(2, userId);
                stmt.setTime(3, timeToComplete);
                stmt.setString(4, imageLink);
                stmt.setString(5, description);
                stmt.setString(6, heading);
                stmt.execute();
            }
        }
    }
}
