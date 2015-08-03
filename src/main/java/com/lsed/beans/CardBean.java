/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lsed.beans;

import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.Types;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;
import java.util.ArrayList;

import com.lsed.structs.Card;


/**
 *
 * @author Grady Ellison
 */
@ManagedBean(name = "cardBean", eager = true)
@RequestScoped
public class CardBean
{

    @Resource(lookup="jdbc/lsed_db")
    private DataSource ds;
    private Connection conn;
    
    private List<Card> cards;
    
     /**
     * Creates a new instance of CardBean
     */
    public CardBean()
    {
        cards = null;
    }
    
    public List<Card> getCards() throws SQLException
    {
        return getCardInfo_SortBy("Title");
    }

    public List<Card> getCardInfo_SortBy(String sortParam) throws SQLException
    {
        if (cards == null) {
            ResultSet rs = queryCardInfo_SortBy(sortParam);
            if (rs != null) {
                cards = new ArrayList<>();
                while (rs.next()) {
                    Card card = new Card();

                    card.setTitle(rs.getString("Title"));
                    card.setDescription(rs.getString("Description"));
                    card.setDateCreated(rs.getDate("DateCreated"));
                    card.setDateModified(rs.getDate("DateModified"));
                    card.setImageLink(rs.getString("ImageLink"));
                    card.setEmbedLink(rs.getString("EmbedLink"));

                    cards.add(card);
                }
            }
        }
        return cards;
    }

    public void setCards(List<Card> cards)
    {
        this.cards = cards;
    }
    
    private ResultSet queryCardInfo_SortBy(String sortParam) throws SQLException
    {
        if (ds == null)
            throw new SQLException("DataSource is NULL in getCardList()");
        conn = ds.getConnection();
        if (conn == null)
            throw new SQLException("Cannot get connection from data source in getCardList()");

        CallableStatement stmt = conn.prepareCall("{CALL queryCardInfo_SortBy(?)}");
        stmt.setString(1, sortParam);
        boolean hadResults = stmt.execute();
        if (hadResults)
            return stmt.getResultSet();
        return null;
    }

}
