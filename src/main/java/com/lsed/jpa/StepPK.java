/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lsed.jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author comma
 */
@Embeddable
public class StepPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "StepId")
    private int stepId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "card_CardId")
    private int cardCardId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "card_USER_UserId")
    private int cardUSERUserId;

    public StepPK() {
    }

    public StepPK(int stepId, int cardCardId, int cardUSERUserId) {
        this.stepId = stepId;
        this.cardCardId = cardCardId;
        this.cardUSERUserId = cardUSERUserId;
    }

    public int getStepId() {
        return stepId;
    }

    public void setStepId(int stepId) {
        this.stepId = stepId;
    }

    public int getCardCardId() {
        return cardCardId;
    }

    public void setCardCardId(int cardCardId) {
        this.cardCardId = cardCardId;
    }

    public int getCardUSERUserId() {
        return cardUSERUserId;
    }

    public void setCardUSERUserId(int cardUSERUserId) {
        this.cardUSERUserId = cardUSERUserId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) stepId;
        hash += (int) cardCardId;
        hash += (int) cardUSERUserId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StepPK)) {
            return false;
        }
        StepPK other = (StepPK) object;
        if (this.stepId != other.stepId) {
            return false;
        }
        if (this.cardCardId != other.cardCardId) {
            return false;
        }
        if (this.cardUSERUserId != other.cardUSERUserId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lsed.jpa.StepPK[ stepId=" + stepId + ", cardCardId=" + cardCardId + ", cardUSERUserId=" + cardUSERUserId + " ]";
    }
    
}
