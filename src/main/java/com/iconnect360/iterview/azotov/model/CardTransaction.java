package com.iconnect360.iterview.azotov.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.math.BigDecimal;

/**
 * Created by alexey.zotov on 3/31/2016.
 */
public class CardTransaction {
    Card card;
    BigDecimal amount;


    public Card getCard() {
        return card;
    }
    public void setCard(Card card) {
        this.card = card;
    }
    public BigDecimal getAmount() {
        return amount;
    }
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("card", card)
                .append("amount", amount)
                .toString();
    }
}
