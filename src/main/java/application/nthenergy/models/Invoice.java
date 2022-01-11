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
    private double initialAmount;
    private double vatAmount;
    private double finalAmount;
    private PaymentStatus paymentStatus;
    private long createdAt;

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
     * @return double initialAmount
     */
    public double getInitialAmount() {
        return initialAmount;
    }

    /**
     * This method is used to set initial amount.
     * @param double initialAmount
     * @return void
     */
    public void setInitialAmount(double initialAmount) {
        this.initialAmount = initialAmount;
    }

    /**
     * This method is used to return vat amount.
     * @param none
     * @return double vatAmount
     */
    public double getVatAmount() {
        return vatAmount;
    }

    /**
     * This method is used to set vat amount.
     * @param double vatAmount
     * @return void
     */
    public void setVatAmount(double vatAmount) {
        this.vatAmount = vatAmount;
    }

    /**
     * This method is used to return final amount.
     * @param none
     * @return double finalAmount
     */
    public double getFinalAmount() {
        return finalAmount;
    }

    /**
     * This method is used to set final amount.
     * @param double finalAmount
     * @return void
     */
    public void setFinalAmount(double finalAmount) {
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
     * @return long createdAt
     */
    public long getCreatedAt() {
        return createdAt;
    }

    /**
     * This method is used to set created at.
     * @param long createdAt
     * @return void
     */
    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public Invoice() {

    }

    /**
     * Constructor with parameters.
     *
     * @param invoiceId
     * @param customerId
     * @param dateFrom
     * @param dateUntil
     * @param initialAmount
     * @param vatAmount
     * @param finalAmount
     * @param paymentStatus
     * @param createdAt
     */
    public Invoice(int invoiceId, int customerId, Date dateFrom, Date dateUntil, double initialAmount, double vatAmount, double finalAmount, PaymentStatus paymentStatus, long createdAt) {
        this.invoiceId = invoiceId;
        this.customerId = customerId;
        this.dateFrom = dateFrom;
        this.dateUntil = dateUntil;
        this.initialAmount = initialAmount;
        this.vatAmount = vatAmount;
        this.finalAmount = finalAmount;
        this.paymentStatus = paymentStatus;
        this.createdAt = createdAt;
    }
}

