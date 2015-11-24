/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lsed.jpa;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author comma
 */
@Entity
@Table(name = "step")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Step.findAll", query = "SELECT s FROM Step s"),
    @NamedQuery(name = "Step.findByStepId", query = "SELECT s FROM Step s WHERE s.stepPK.stepId = :stepId"),
    @NamedQuery(name = "Step.findByCardCardId", query = "SELECT s FROM Step s WHERE s.stepPK.cardCardId = :cardCardId"),
    @NamedQuery(name = "Step.findByCardUSERUserId", query = "SELECT s FROM Step s WHERE s.stepPK.cardUSERUserId = :cardUSERUserId"),
    @NamedQuery(name = "Step.findByNumber", query = "SELECT s FROM Step s WHERE s.number = :number"),
    @NamedQuery(name = "Step.findByTimeToComplete", query = "SELECT s FROM Step s WHERE s.timeToComplete = :timeToComplete"),
    @NamedQuery(name = "Step.findByImageLink", query = "SELECT s FROM Step s WHERE s.imageLink = :imageLink"),
    @NamedQuery(name = "Step.findByDescription", query = "SELECT s FROM Step s WHERE s.description = :description")})
public class Step implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "Heading")
    private String heading;
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected StepPK stepPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Number")
    private int number;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TimeToComplete")
    @Temporal(TemporalType.TIME)
    private Date timeToComplete;
    @Size(max = 256)
    @Column(name = "ImageLink")
    private String imageLink;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 512)
    @Column(name = "Description")
    private String description;
    @JoinColumns({
        @JoinColumn(name = "card_CardId", referencedColumnName = "CardId", insertable = false, updatable = false),
        @JoinColumn(name = "card_USER_UserId", referencedColumnName = "USER_UserId", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Card card;

    public Step() {
    }

    public Step(StepPK stepPK) {
        this.stepPK = stepPK;
    }

    public Step(StepPK stepPK, int number, Date timeToComplete, String description) {
        this.stepPK = stepPK;
        this.number = number;
        this.timeToComplete = timeToComplete;
        this.description = description;
    }

    public Step(int stepId, int cardCardId, int cardUSERUserId) {
        this.stepPK = new StepPK(stepId, cardCardId, cardUSERUserId);
    }

    public StepPK getStepPK() {
        return stepPK;
    }

    public void setStepPK(StepPK stepPK) {
        this.stepPK = stepPK;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Date getTimeToComplete() {
        return timeToComplete;
    }

    public void setTimeToComplete(Date timeToComplete) {
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

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stepPK != null ? stepPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Step)) {
            return false;
        }
        Step other = (Step) object;
        if ((this.stepPK == null && other.stepPK != null) || (this.stepPK != null && !this.stepPK.equals(other.stepPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lsed.jpa.Step[ stepPK=" + stepPK + " ]";
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }
    
}
