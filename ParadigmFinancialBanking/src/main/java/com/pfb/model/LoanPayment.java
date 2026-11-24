package com.pfb.model;

import java.time.LocalDate;

public class LoanPayment {
    private int paymentId;
    private int loanId;
    private LocalDate paymentDate;
    private int amount;

    public LoanPayment(int paymentId, int loanId, LocalDate paymentDate, int amount) {
        this.paymentId = paymentId;
        this.loanId = loanId;
        this.paymentDate = paymentDate;
        this.amount = amount;
    }
    
    public int getPaymentId() {
        return paymentId;
    }
    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }
    public int getLoanId() {
        return loanId;
    }
    public void setLoanId(int loanId) {
        this.loanId = loanId;
    }
    public LocalDate getPaymentDate() {
        return paymentDate;
    }
    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }
    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }

    
}
