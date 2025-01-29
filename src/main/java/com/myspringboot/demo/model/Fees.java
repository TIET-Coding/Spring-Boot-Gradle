package com.myspringboot.demo.model;

public class Fees {
    private long F_ID;
    private long SD_ID;
    private String Amount;
    private String DueDate;
    private String PaymentStatus;

    public Fees(long f_ID, long SD_ID, String amount, String dueDate, String paymentStatus) {
        F_ID = f_ID;
        this.SD_ID = SD_ID;
        Amount = amount;
        DueDate = dueDate;
        PaymentStatus = paymentStatus;
    }


    public long getF_ID() {
        return F_ID;
    }

    public void setF_ID(long f_ID) {
        F_ID = f_ID;
    }

    public long getSD_ID() {
        return SD_ID;
    }

    public void setSD_ID(long SD_ID) {
        this.SD_ID = SD_ID;
    }

    public String getAmount() {
        return Amount;
    }

    public void setAmount(String amount) {
        Amount = amount;
    }

    public String getDueDate() {
        return DueDate;
    }

    public void setDueDate(String dueDate) {
        DueDate = dueDate;
    }

    public String getPaymentStatus() {
        return PaymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        PaymentStatus = paymentStatus;
    }
}
