package com.pfb.model;

import java.time.LocalDate;

public class Transfer {
    private int amount;
    private LocalDate transferDate;
    private int transferId;
    private int senderId;
    private int receiverId;

    public Transfer(int amount, LocalDate transferDate, int transferId, int senderId, int receiverId) {
        this.amount = amount;
        this.transferDate = transferDate;
        this.transferId = transferId;
        this.senderId = senderId;
        this.receiverId = receiverId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public LocalDate getTransferDate() {
        return transferDate;
    }

    public void setTransferDate(LocalDate transferDate) {
        this.transferDate = transferDate;
    }

    public int getTransferId() {
        return transferId;
    }

    public void setTransferId(int transferId) {
        this.transferId = transferId;
    }

    public int getSenderId() {
        return senderId;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    public int getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(int receiverId) {
        this.receiverId = receiverId;
    }

    
}
