package com.iconnect360.iterview.azotov.model;

import java.util.Date;

/**
 * Created by alexey.zotov on 3/31/2016.
 */
public class Card {

    String cardNumber;
    String name;
    Date expiry;
    String cvv;

    public String getCardNumber() {
        return cardNumber;
    }
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Date getExpiry() {
        return expiry;
    }
    public void setExpiry(Date expiry) {
        this.expiry = expiry;
    }

    public String getCvv() {
        return cvv;
    }
    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    @Override
    public String toString() {
        return new org.apache.commons.lang3.builder.ToStringBuilder(this)
                .append("cardNumber", cardNumber)
                .append("name", name)
                .append("expiry", expiry)
                .append("cvv", cvv)
                .toString();
    }

}
