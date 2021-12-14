/*
 * Invoice.java
 * Invoice class which encapsulates attributes and methods of the invoice module.
 *
 * @author: Ashwin Gurung
 */
package application.nthenergy.models;

import application.nthenergy.core.enums.PaymentStatus;

import java.security.Timestamp;
import java.util.Date;

public class Invoice {
    // private properties of the class
    private int invoiceId;
    private int customerId;
    private Date dateFrom;
    private Date dateUntil;
    private float initialAmount;
    private float vatAmount;
    private float finalAmount;
    private PaymentStatus paymentStatus;
    private Timestamp createdAt;

    // getters and setters for the attributes
    /**
     * This method is used to return invoice id.
     * @param none
     * @return int invoiceId
     */
    public int getInvoiceId() {
        return invoiceId;
    }

    /**
     * This method is used to set invoice id.
     * @param int invoiceId
     * @return void
     */
    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    /**
     * This method is used to return customer id.
     * @param none
     * @return int customerId
     */
    public int getCustomerId() {
        return customerId;
    }

    /**
     * This method is used to set customer id.
     * @param int customerId
     * @return void
     */
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    /**
     * This method is used to return date from.
     * @param none
     * @return Date dateFrom
     */
    public Date getDateFrom() {
        return dateFrom;
    }

    /**
     * This method is used to set date from.
     * @param Date dateFrom
     * @return void
     */
    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    /**
     * This method is used to return date until.
     * @param none
     * @return Date dateUntil
     */
    public Date getDateUntil() {
        return dateUntil;
    }

    /**
     * This method is used to set date until.
     * @param Date dateUntil
     * @return void
     */
    public void setDateUntil(Date dateUntil) {
        this.dateUntil = dateUntil;
    }

    /**
     * This method is used to return initial amount.
     * @param none
     * @return float initialAmount
     */
    public float getInitialAmount() {
        return initialAmount;
    }

    /**
     * This method is used to set initial amount.
     * @param float initialAmount
     * @return void
     */
    public void setInitialAmount(float initialAmount) {
        this.initialAmount = initialAmount;
    }

    /**
     * This method is used to return vat amount.
     * @param none
     * @return float vatAmount
     */
    public float getVatAmount() {
        return vatAmount;
    }

    /**
     * This method is used to set vat amount.
     * @param float vatAmount
     * @return void
     */
    public void setVatAmount(float vatAmount) {
        this.vatAmount = vatAmount;
    }

    /**
     * This method is used to return final amount.
     * @param none
     * @return float finalAmount
     */
    public float getFinalAmount() {
        return finalAmount;
    }

    /**
     * This method is used to set final amount.
     * @param float finalAmount
     * @return void
     */
    public void setFinalAmount(float finalAmount) {
        this.finalAmount = finalAmount;
    }

    /**
     * This method is used to return payment status.
     * @param none
     * @return String paymentStatus
     */
    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    /**
     * This method is used to set payment status.
     * @param PaymentStatus paymentStatus
     * @return void
     */
    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    /**
     * This method is used to return created at timestamp.
     * @param none
     * @return float createdAt
     */
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    /**
     * This method is used to set created at.
     * @param Timestamp createdAt
     * @return void
     */
    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}

