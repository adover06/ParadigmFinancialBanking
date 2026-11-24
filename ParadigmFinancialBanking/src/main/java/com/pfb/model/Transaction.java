package com.pfb.model;

import java.time.LocalDate;

public class Transaction {
    private int transactionId;
    private int amount;
    private int accountId;
    private LocalDate transactionDate;
    public Transaction(int transactionId, int amount, int accountId, LocalDate transactionDate) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.accountId = accountId;
        this.transactionDate = transactionDate;
    }
    
    public int getTransactionId() {
        return transactionId;
    }
    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }
    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
    public int getAccountId() {
        return accountId;
    }
    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }
    public LocalDate getTransactionDate() {
        return transactionDate;
    }
    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    
}
