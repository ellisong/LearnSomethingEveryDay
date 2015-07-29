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
import java.sql.PreparedStatement;
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
        if (cards == null) {
            if (ds == null)
                throw new SQLException("DataSource is NULL in getCardList()");
            conn = ds.getConnection();
            if (conn == null)
                throw new SQLException("Cannot get connection from data source in getCardList()");

            String query = "SELECT CARD.Title, CARD.Description, CARD.DateCreated, CARD.DateModified, CARD.ImageLink, CARD.EmbedLink FROM CARD WHERE Title <> ?;";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, "''");
            ResultSet rs = stmt.executeQuery();

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
        return cards;
    }

    public void setCards(List<Card> cards)
    {
        this.cards = cards;
    }

}
