/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lsed.jpa;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author comma
 */
@Entity
@Table(name = "card")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Card.findAll", query = "SELECT c FROM Card c"),
    @NamedQuery(name = "Card.findByCardId", query = "SELECT c FROM Card c WHERE c.cardPK.cardId = :cardId"),
    @NamedQuery(name = "Card.findByUSERUserId", query = "SELECT c FROM Card c WHERE c.cardPK.uSERUserId = :uSERUserId"),
    @NamedQuery(name = "Card.findByTitle", query = "SELECT c FROM Card c WHERE c.title = :title"),
    @NamedQuery(name = "Card.findByDateCreated", query = "SELECT c FROM Card c WHERE c.dateCreated = :dateCreated"),
    @NamedQuery(name = "Card.findByDateModified", query = "SELECT c FROM Card c WHERE c.dateModified = :dateModified"),
    @NamedQuery(name = "Card.findByDescription", query = "SELECT c FROM Card c WHERE c.description = :description"),
    @NamedQuery(name = "Card.findByImageLink", query = "SELECT c FROM Card c WHERE c.imageLink = :imageLink"),
    @NamedQuery(name = "Card.findByComments", query = "SELECT c FROM Card c WHERE c.comments = :comments"),
    @NamedQuery(name = "Card.findByTimeToComplete", query = "SELECT c FROM Card c WHERE c.timeToComplete = :timeToComplete")})
public class Card implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "isPublished")
    private int isPublished;
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CardPK cardPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "Title")
    private String title;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DateCreated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DateModified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModified;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "Description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "ImageLink")
    private String imageLink;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 512)
    @Column(name = "Comments")
    private String comments;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TimeToComplete")
    @Temporal(TemporalType.TIME)
    private Date timeToComplete;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "card")
    private Collection<Step> stepCollection;
    @JoinColumn(name = "USER_UserId", referencedColumnName = "UserId", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private User user;

    public Card() {
    }

    public Card(CardPK cardPK) {
        this.cardPK = cardPK;
    }

    public Card(CardPK cardPK, String title, Date dateCreated, Date dateModified, String description, String imageLink, String comments, Date timeToComplete) {
        this.cardPK = cardPK;
        this.title = title;
        this.dateCreated = dateCreated;
        this.dateModified = dateModified;
        this.description = description;
        this.imageLink = imageLink;
        this.comments = comments;
        this.timeToComplete = timeToComplete;
    }

    public Card(int cardId, int uSERUserId) {
        this.cardPK = new CardPK(cardId, uSERUserId);
    }

    public CardPK getCardPK() {
        return cardPK;
    }

    public void setCardPK(CardPK cardPK) {
        this.cardPK = cardPK;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateModified() {
        return dateModified;
    }

    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
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

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Date getTimeToComplete() {
        return timeToComplete;
    }

    public void setTimeToComplete(Date timeToComplete) {
        this.timeToComplete = timeToComplete;
    }

    @XmlTransient
    public Collection<Step> getStepCollection() {
        return stepCollection;
    }

    public void setStepCollection(Collection<Step> stepCollection) {
        this.stepCollection = stepCollection;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cardPK != null ? cardPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Card)) {
            return false;
        }
        Card other = (Card) object;
        if ((this.cardPK == null && other.cardPK != null) || (this.cardPK != null && !this.cardPK.equals(other.cardPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lsed.jpa.Card[ cardPK=" + cardPK + " ]";
    }

    public int getIsPublished() {
        return isPublished;
    }

    public void setIsPublished(int isPublished) {
        this.isPublished = isPublished;
    }
    
}
