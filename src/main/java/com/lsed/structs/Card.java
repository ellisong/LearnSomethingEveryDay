/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lsed.structs;

import java.util.Date;
import java.util.List;
import java.io.Serializable;

/**
 *
 * @author Grady Ellison
 */
public class Card implements Serializable
{

    private String title;
    private Date dateCreated;
    private Date dateModified;
    private String description;
    private String imageLink;
    private String embedLink;
    private List<String> categories;
    private List<String> prerequisites;
    
    public Card()
    {
        title = "";
        dateCreated = null;
        dateModified = null;
        description = "";
        imageLink = "";
        embedLink = "";
        categories = null;
        prerequisites = null;
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

    public String getEmbedLink()
    {
        return embedLink;
    }

    public void setEmbedLink(String embedLink)
    {
        this.embedLink = embedLink;
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
    
}
