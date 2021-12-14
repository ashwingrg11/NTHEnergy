/*
 * Payment.java
 * Payment class which encapsulates attributes and methods of the payment module.
 *
 * @author: Ashwin Gurung
 */
package application.nthenergy.models;

import application.nthenergy.core.enums.PaidBy;

import java.security.Timestamp;

public class Payment {
    // private attributes of the class
    private int paymentId;
    private int invoiceId;
    private PaidBy paidBy;
    private Timestamp createdAt;

    // getters and setters for the attributes
    /**
     * This method is used to return payment id.
     * @param none
     * @return int paymentId
     */
    public int getPaymentId() {
        return paymentId;
    }

    /**
     * This method is used to set payment id.
     * @param int paymentId
     * @return void
     */
    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

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
     * This method is used to return paid by.
     * @param none
     * @return PaidBy paidBy
     */
    public PaidBy getPaidBy() {
        return paidBy;
    }

    /**
     * This method is used to set paid by.
     * @param PaidBy paidBy
     * @return void
     */
    public void setPaidBy(PaidBy paidBy) {
        this.paidBy = paidBy;
    }

    /**
     * This method is used to return created at timestamp.
     * @param none
     * @return Timestamp createdAt
     */
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    /**
     * This method is used to set created at timestamp.
     * @param Timestamp createdAt
     * @return void
     */
    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
