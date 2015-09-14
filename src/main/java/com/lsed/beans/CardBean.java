/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lsed.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import java.sql.CallableStatement;
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
@ViewScoped
public class CardBean extends SqlBeanTemplate
{
    private List<Card> cards;
    
     /**
     * Creates a new instance of CardBean
     * @throws java.sql.SQLException
     */
    public CardBean() throws SQLException
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
            CallableStatement stmt = conn.prepareCall("{CALL queryCardInfo_SortBy(?)}");
            stmt.setString(1, sortParam);
            ResultSet rs = this.executeStatement(stmt);
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
}
