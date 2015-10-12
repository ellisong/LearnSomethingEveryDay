/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lsed.structs;

import java.sql.Time;
import java.io.Serializable;

/**
 *
 * @author Grady Ellison
 */
public class Step implements Serializable {
    private int stepId;
    private int cardId;
    private int number;
    private Time timeToComplete;
    private String imageLink;
    private String description;
    
    public Step() {
        stepId = 0;
        cardId = 0;
        number = 0;
        timeToComplete = null;
        imageLink = "";
        description = "";
    }

    public int getStepId() {
        return stepId;
    }

    public void setStepId(int stepId) {
        this.stepId = stepId;
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }
    
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    
    public Time getTimeToComplete() {
        return timeToComplete;
    }

    public void setTimeToComplete(Time timeToComplete) {
        this.timeToComplete = timeToComplete;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
