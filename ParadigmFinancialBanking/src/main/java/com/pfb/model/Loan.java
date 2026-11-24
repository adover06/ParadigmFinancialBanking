package com.pfb.model;

import java.time.LocalDate;

public class Loan {
    private int loanId;
    private int interestRate;
    private String loanType;
    private int accountId;
    private LocalDate startDate;
    private int amount;
    
    public Loan(int loanId, int interestRate, String loanType, int accountId, LocalDate startDate, int amount) {
        this.loanId = loanId;
        this.interestRate = interestRate;
        this.loanType = loanType;
        this.accountId = accountId;
        this.startDate = startDate;
        this.amount = amount;
    }

    public int getLoanId() {
        return loanId;
    }

    public void setLoanId(int loanId) {
        this.loanId = loanId;
    }

    public int getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(int interestRate) {
        this.interestRate = interestRate;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    
}
