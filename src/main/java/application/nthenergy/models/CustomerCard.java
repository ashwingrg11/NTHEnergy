/*
 * CustomerCard.java
 * CustomerCard class which encapsulates attributes and methods of the customer's card.
 *
 * @author: Ashwin Gurung
 */
package application.nthenergy.models;

import application.nthenergy.core.Serialization;

import java.io.File;
import java.io.Serializable;
import java.security.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
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
    private  static  final  long  serialVersionUID = -7760870576612412244L;

    // getters and setters for the attributes
    /**
     * This method is used to return customer card id.
     * @param
     * @return int customerCardId
     */
    public int getCustomerCardId() {
        return customerCardId;
    }

    /**
     * This method is used to set customer card id.
     * @param customerCardId
     * @return void
     */
    public void setCustomerCardId(int customerCardId) {
        this.customerCardId = customerCardId;
    }

    /**
     * This method is used to return customer id.
     * @param
     * @return int customerId
     */
    public int getCustomerId() {
        return customerId;
    }

    /**
     * This method is used to set customer id.
     * @param customerId
     * @return void
     */
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    /**
     * This method is used to return customer card's bank name.
     * @param
     * @return String bankName
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * This method is used to set customer's bank name.
     * @param bankName
     * @return void
     */
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    /**
     * This method is used to return customer card's account number.
     * @param
     * @return String accountNumber
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * This method is used to set customer card's accountNumber.
     * @param accountNumber
     * @return void
     */
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     * This method is used to return customer card number.
     * @param
     * @return String cardNumber
     */
    public String getCardNumber() {
        return cardNumber;
    }

    /**
     * This method is used to set customer card number.
     * @param cardNumber
     * @return void
     */
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    /**
     * This method is used to return customer's name on card.
     * @param
     * @return String nameOnCard
     */
    public String getNameOnCard() {
        return nameOnCard;
    }

    /**
     * This method is used to set customer's name on card.
     * @param nameOnCard
     * @return void
     */
    public void setNameOnCard(String nameOnCard) {
        this.nameOnCard = nameOnCard;
    }

    /**
     * This method is used to return customer card's expiry date.
     * @param
     * @return LocalDate expiryDate
     */
    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    /**
     * This method is used to set customer card's expiry date.
     * @param expiryDate
     * @return void
     */
    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    /**
     * This method is used to return customer card's cvv.
     * @param
     * @return String cvv
     */
    public String getCvv() {
        return cvv;
    }

    /**
     * This method is used to set customer card's cvv number.
     * @param cvv
     * @return void
     */
    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    /**
     * This method is used to return customer card's created at timestamp.
     * @param
     * @return long createdAt
     */
    public long getCreatedAt() {
        return createdAt;
    }

    /**
     * This method is used to set created at timestamp.
     * @param createdAt
     * @return void
     */
    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * This method is used to return customer card's updated at timestamp.
     * @param
     * @return String updatedAt
     */
    public long getUpdatedAt() {
        return updatedAt;
    }

    /**
     * This method is used to set updated at.
     * @param updatedAt
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

    /**
     * This method is used to fetch card info by customer id.
     * @param id
     * @return <CustomerCard>
     */
    public CustomerCard getByCustomerId(int id) {
        File f = new File("./data/customer-cards.txt");
        CustomerCard singleCustomerCard = new CustomerCard();
        ArrayList<CustomerCard> customerCards = new ArrayList<>();
        if(f.isFile()) {
            Serialization serializationHelper = new Serialization();
            customerCards = serializationHelper.deserializeCustomerCards();
            for (CustomerCard customerCard: customerCards) {
                if (customerCard.getCustomerId() == id) {
                    return customerCard;
                }
            }
        }
        return singleCustomerCard;
    }

}
