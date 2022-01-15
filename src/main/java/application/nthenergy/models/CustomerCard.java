/*
 * CustomerCard.java
 * CustomerCard class which encapsulates attributes and methods of the customer's card.
 *
 * @author: Ashwin Gurung
 */
package application.nthenergy.models;

import java.io.Serializable;
import java.security.Timestamp;
import java.time.LocalDate;
import java.util.Date;

public class CustomerCard implements Serializable {
    // private properties of the customer card class
    private int customerCardId;
    private int customerId;
    private String bankName;
    private String accountNumber;
    private String cardNumber;
    private String nameOnCard;
    private LocalDate expiryDate;
    private String cvv;
    private long createdAt;
    private long updatedAt;

    // getters and setters for the attributes
    /**
     * This method is used to return customer card id.
     * @param none
     * @return int customerCardId
     */
    public int getCustomerCardId() {
        return customerCardId;
    }

    /**
     * This method is used to set customer card id.
     * @param int customerCardId
     * @return void
     */
    public void setCustomerCardId(int customerCardId) {
        this.customerCardId = customerCardId;
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
     * This method is used to return customer card's bank name.
     * @param none
     * @return String bankName
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * This method is used to set customer's bank name.
     * @param String bankName
     * @return void
     */
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    /**
     * This method is used to return customer card's account number.
     * @param none
     * @return String accountNumber
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * This method is used to set customer card's accountNumber.
     * @param String accountNumber
     * @return void
     */
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     * This method is used to return customer card number.
     * @param none
     * @return String cardNumber
     */
    public String getCardNumber() {
        return cardNumber;
    }

    /**
     * This method is used to set customer card number.
     * @param String cardNumber
     * @return void
     */
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    /**
     * This method is used to return customer's name on card.
     * @param none
     * @return String nameOnCard
     */
    public String getNameOnCard() {
        return nameOnCard;
    }

    /**
     * This method is used to set customer's name on card.
     * @param String nameOnCard
     * @return void
     */
    public void setNameOnCard(String nameOnCard) {
        this.nameOnCard = nameOnCard;
    }

    /**
     * This method is used to return customer card's expiry date.
     * @param none
     * @return LocalDate expiryDate
     */
    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    /**
     * This method is used to set customer card's expiry date.
     * @param LocalDate expiryDate
     * @return void
     */
    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    /**
     * This method is used to return customer card's cvv.
     * @param none
     * @return String cvv
     */
    public String getCvv() {
        return cvv;
    }

    /**
     * This method is used to set customer card's cvv number.
     * @param String cvv
     * @return void
     */
    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    /**
     * This method is used to return customer card's created at timestamp.
     * @param none
     * @return long createdAt
     */
    public long getCreatedAt() {
        return createdAt;
    }

    /**
     * This method is used to set created at timestamp.
     * @param long createdAt
     * @return void
     */
    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * This method is used to return customer card's updated at timestamp.
     * @param none
     * @return String updatedAt
     */
    public long getUpdatedAt() {
        return updatedAt;
    }

    /**
     * This method is used to set updated at.
     * @param long updatedAt
     * @return void
     */
    public void setUpdatedAt(long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public CustomerCard() {

    }
    public CustomerCard(int customerCardId, int customerId, String bankName, String accountNumber, String cardNumber, String nameOnCard, LocalDate expiryDate, String cvv, long createdAt, long updatedAt) {
        this.customerCardId = customerCardId;
        this.customerId = customerId;
        this.bankName = bankName;
        this.accountNumber = accountNumber;
        this.cardNumber = cardNumber;
        this.nameOnCard = nameOnCard;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
