package com.example.lowleveldesign.carrentalsytem.payment;

import java.util.Date;

public class PaymentDetails {
    private int paymentId;
    private int amountPaid;
    private Date paymentDate;
    private boolean isRefunded;
    private PaymentMode paymentMode;

    public PaymentDetails(int paymentId, int amountPaid, Date paymentDate, boolean isRefunded, PaymentMode paymentMode) {
        this.paymentId = paymentId;
        this.amountPaid = amountPaid;
        this.paymentDate = paymentDate;
        this.isRefunded = isRefunded;
        this.paymentMode = paymentMode;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public int getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(int amountPaid) {
        this.amountPaid = amountPaid;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public boolean isRefunded() {
        return isRefunded;
    }

    public void setRefunded(boolean refunded) {
        isRefunded = refunded;
    }

    public PaymentMode getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(PaymentMode paymentMode) {
        this.paymentMode = paymentMode;
    }
}
