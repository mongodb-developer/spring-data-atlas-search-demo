package com.mongodb.demo.entities;

import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

public class CreditCard {
    @Field("account_id")
    private String accountId;
    @Field("credit_card_id")
    private String id;
    @Field("credit_card_name")
    private String name;
    @Field("credit_limit")
    private double limit;
    @Field("payment_due_date")
    private Date paymentDue;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLimit() {
        return limit;
    }

    public void setLimit(double limit) {
        this.limit = limit;
    }

    public Date getPaymentDue() {
        return paymentDue;
    }

    public void setPaymentDue(Date paymentDue) {
        this.paymentDue = paymentDue;
    }
}
