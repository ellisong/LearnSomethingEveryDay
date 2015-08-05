/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lsed.beans;

import com.lsed.structs.Card;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author comma
 */
public class CardBeanTest {
    
    public CardBeanTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getCards method, of class CardBean.
     * @throws java.lang.Exception
     */
    @Test
    public void getCards_CardsVariableNotNull_CardsVariableReturned() throws Exception {
        System.out.println("getCards_CardsVariableNotNull_CardsVariableReturned");
        List<Card> cards = new ArrayList<>();
        cards.add(new Card());
        
        CardBean instance = new CardBean();
        instance.setCards(cards);
        List<Card> expResult = cards;
        List<Card> result = instance.getCards();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCardInfo_SortBy method, of class CardBean.
     * @throws java.lang.Exception
     */
    @Test(expected=SQLException.class)
    public void getCardInfo_SortBy_AccessesDisconnectedDatabase_ExceptionThrown() throws Exception {
        System.out.println("getCardInfo_SortBy_AccessesDisconnectedDatabase_ExceptionThrown");
        String sortParam = "Title";
        CardBean instance = new CardBean();
        instance.getCardInfo_SortBy(sortParam);
    }
    
}
