/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lsed.structs;

import java.util.Date;
import java.sql.Time;
import java.util.List;
import java.io.Serializable;

/**
 *
 * @author Grady Ellison
 */
public class Card implements Serializable
{
    private int cardId;
    private int userId;
    private String title;
    private Date dateCreated;
    private Date dateModified;
    private String description;
    private String imageLink;
    private String comments;
    private Time timeToComplete;
    private List<String> categories;
    private List<String> prerequisites;
    private List<Step> steps;
    
    public Card()
    {
        cardId = 0;
        userId = 0;
        title = "";
        dateCreated = null;
        dateModified = null;
        description = "";
        imageLink = "";
        comments = "";
        timeToComplete = null;
        categories = null;
        prerequisites = null;
        steps = null;
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public Date getDateCreated()
    {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated)
    {
        this.dateCreated = dateCreated;
    }

    public Date getDateModified()
    {
        return dateModified;
    }

    public void setDateModified(Date dateModified)
    {
        this.dateModified = dateModified;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getImageLink()
    {
        return imageLink;
    }

    public void setImageLink(String imageLink)
    {
        this.imageLink = imageLink;
    }
    
    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Time getTimeToComplete() {
        return timeToComplete;
    }

    public void setTimeToComplete(Time timeToComplete) {
        this.timeToComplete = timeToComplete;
    }

    public List<String> getCategories()
    {
        return categories;
    }

    public void setCategories(List<String> categories)
    {
        this.categories = categories;
    }

    public List<String> getPrerequisites()
    {
        return prerequisites;
    }

    public void setPrerequisites(List<String> prerequisites)
    {
        this.prerequisites = prerequisites;
    }

    public List<Step> getSteps() {
        return steps;
    }

    public void setSteps(List<Step> steps) {
        this.steps = steps;
    }
    
}
