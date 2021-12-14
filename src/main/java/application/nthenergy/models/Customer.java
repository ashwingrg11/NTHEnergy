/*
 * Customer.java
 * Customer class which encapsulates attributes and methods of the Customer class.
 *
 * @author: Ashwin Gurung
 */
package application.nthenergy.models;

import java.security.Timestamp;
import java.util.Date;

public class Customer {
    // private attributes of the customer class
    private int customerId;
    private int userId;
    private int tariffId;
    private String postCode;
    private String addressOne;
    private String addressTwo;
    private String townCity;
    private String county;
    private Date joinDate;
    private String meterNumber;
    private String alternateContactNo;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    // getters and setters of the customer's class attributes
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
    public void setId(int customerId) {
        this.customerId = customerId;
    }

    /**
     * This method is used to return customer's user id.
     * @param none
     * @return int userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * This method is used to set customer's user id.
     * @param int userId
     * @return void
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * This method is used to return customer's tariff id.
     * @param none
     * @return int tariffId
     */
    public int getTariffId() {
        return tariffId;
    }

    /**
     * This method is used to set customer's tariff id.
     * @param int tariffId
     * @return void
     */
    public void setTariffId(int tariffId) {
        this.tariffId = tariffId;
    }

    /**
     * This method is used to return customer's post code.
     * @param none
     * @return String postCode
     */
    public String getPostCode() {
        return postCode;
    }

    /**
     * This method is used to set customer's post code.
     * @param String postCode
     * @return void
     */
    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    /**
     * This method is used to return customer's address line one.
     * @param none
     * @return String addressOne
     */
    public String getAddressOne() {
        return addressOne;
    }

    /**
     * This method is used to set customer's address line one.
     * @param String addressOne
     * @return void
     */
    public void setAddressOne(String addressOne) {
        this.addressOne = addressOne;
    }

    /**
     * This method is used to return customer's address line two.
     * @param none
     * @return String addressTwo
     */
    public String getAddressTwo() {
        return addressTwo;
    }

    /**
     * This method is used to set customer's address line two.
     * @param String addressTwo
     * @return void
     */
    public void setAddressTwo(String addressTwo) {
        this.addressTwo = addressTwo;
    }

    /**
     * This method is used to return customer's town or city.
     * @param none
     * @return String townCity
     */
    public String getTownCity() {
        return townCity;
    }

    /**
     * This method is used to set customer's town or city.
     * @param String townCity
     * @return void
     */
    public void setTownCity(String townCity) {
        this.townCity = townCity;
    }

    /**
     * This method is used to return customer's county.
     * @param none
     * @return String county
     */
    public String getCounty() {
        return county;
    }

    /**
     * This method is used to set customer's county.
     * @param String county
     * @return void
     */
    public void setCounty(String county) {
        this.county = county;
    }

    /**
     * This method is used to return customer's joined date.
     * @param none
     * @return Date joinDate
     */
    public Date getJoinDate() {
        return joinDate;
    }

    /**
     * This method is used to set customer's join code.
     * @param Date joinDate
     * @return void
     */
    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    /**
     * This method is used to return customer's meter number.
     * @param none
     * @return String meterNumber
     */
    public String getMeterNumber() {
        return meterNumber;
    }

    /**
     * This method is used to set customer's meter number.
     * @param String meterNumber
     * @return void
     */
    public void setMeterNumber(String meterNumber) {
        this.meterNumber = meterNumber;
    }

    /**
     * This method is used to return customer's alternative contact number.
     * @param none
     * @return String alternateContactNo
     */
    public String getAlternateContactNo() {
        return alternateContactNo;
    }

    /**
     * This method is used to set customer's alternative contact number.
     * @param String alternateContactNo
     * @return void
     */
    public void setAlternateContactNo(String alternateContactNo) {
        this.alternateContactNo = alternateContactNo;
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

    /**
     * This method is used to return updated at timestamp.
     * @param none
     * @return Timestamp updatedAt
     */
    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    /**
     * This method is used to set updated at timestamp.
     * @param Timestamp updatedAt
     * @return void
     */
    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }
}
