package com.iconnect360.iterview.azotov.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by alexey.zotov on 3/31/2016.
 */
public class CardTransactionRz {
    public CardTransactionRz(CardTransaction transaction) {
        this.transaction = transaction;
    }

    private CardTransaction transaction;

    private CardType cardType;

    private String code;
    private String description;


    public CardTransaction getTransaction() {
        return transaction;
    }

    public void setTransaction(CardTransaction transaction) {
        this.transaction = transaction;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("transaction", getTransaction())
                .append("cardType", getCardType())
                .append("code", getCode())
                .append("description", getDescription())
                .toString();
    }

}
