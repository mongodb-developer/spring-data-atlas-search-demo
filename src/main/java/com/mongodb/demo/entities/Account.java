package com.mongodb.demo.entities;

import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.Collection;

public class Account {
    @Field("account_id")
    private String id;
    @Field("user_id")
    private String userId;
    @Field("account_type")
    private String accountType;
    @Field("bank_name")
    private String bank;
    @Field("account_number")
    private String accountNumber;

    private double balance;

    @Field("credit_cards")
    private Collection<CreditCard> creditCards = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Collection<CreditCard> getCreditCards() {
        return creditCards;
    }

    public void setCreditCards(Collection<CreditCard> creditCards) {
        this.creditCards = creditCards;
    }
}
