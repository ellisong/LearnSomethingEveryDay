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
public class CardPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "CardId")
    private int cardId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "USER_UserId")
    private int uSERUserId;

    public CardPK() {
    }

    public CardPK(int cardId, int uSERUserId) {
        this.cardId = cardId;
        this.uSERUserId = uSERUserId;
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public int getUSERUserId() {
        return uSERUserId;
    }

    public void setUSERUserId(int uSERUserId) {
        this.uSERUserId = uSERUserId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) cardId;
        hash += (int) uSERUserId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CardPK)) {
            return false;
        }
        CardPK other = (CardPK) object;
        if (this.cardId != other.cardId) {
            return false;
        }
        if (this.uSERUserId != other.uSERUserId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lsed.jpa.CardPK[ cardId=" + cardId + ", uSERUserId=" + uSERUserId + " ]";
    }
    
}
