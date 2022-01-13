/*
 * Customer.java
 * Customer class which encapsulates attributes and methods of the Customer class.
 *
 * @author: Ashwin Gurung
 */
package application.nthenergy.models;

import application.nthenergy.core.Helper;
import application.nthenergy.core.Serialization;

import java.io.*;
import java.security.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Customer implements Serializable {
    private  static  final  long  serialVersionUID = 2265231150309506442L;
    // private attributes of the customer class
    private int customerId;
    private int userId;
    private int tariffId;
    private String name;
    private String mobNo;
    private String email;
    private String postCode;
    private String addressOne;
    private String addressTwo;
    private String townCity;
    private String county;
    private LocalDate joinDate;
    private LocalDate tariffStartDate;
    private LocalDate tariffEndDate;
    private String meterNumber;
    private String alternateContactNo;
    private long createdAt;
    private long updatedAt;

    // getters and setters of the customer's class attributes
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
     * param int customerId
     * @return void
     */
    public void setId(int customerId) {
        this.customerId = customerId;
    }

    /**
     * This method is used to return customer's user id.
     * param none
     * @return int userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * This method is used to set customer's user id.
     * param int userId
     * @return void
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * This method is used to return customer's tariff id.
     * param none
     * @return int tariffId
     */
    public int getTariffId() {
        return tariffId;
    }

    /**
     * This method is used to set customer's tariff id.
     * param int tariffId
     * @return void
     */
    public void setTariffId(int tariffId) {
        this.tariffId = tariffId;
    }

    /**
     * This method is used to return customer's post code.
     * param none
     * @return String postCode
     */
    public String getPostCode() {
        return postCode;
    }

    /**
     * This method is used to set customer's post code.
     * param String postCode
     * @return void
     */
    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    /**
     * This method is used to return customer's name.
     * param none
     * @return String name
     */
    public String getName() {
        return name;
    }

    /**
     * This method is used to set customer's name.
     * param String name
     * @return void
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     * This method is used to return customer's mob No.
     * param none
     * @return String mobNo
     */
    public String getMobNo() {
        return mobNo;
    }

    /**
     * This method is used to set customer's mobile no.
     * param String mobNo
     * @return void
     */
    public void setMobNo(String mobNo) {
        this.mobNo = mobNo;
    }

    /**
     * This method is used to return customer's email.
     * param none
     * @return String email
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method is used to set customer's email.
     * param String email
     * @return void
     */
    public void setEmail(String email) {
        this.email = email;
    }


    /**
     * This method is used to return customer's address line one.
     * param none
     * @return String addressOne
     */
    public String getAddressOne() {
        return addressOne;
    }

    /**
     * This method is used to set customer's address line one.
     * param String addressOne
     * @return void
     */
    public void setAddressOne(String addressOne) {
        this.addressOne = addressOne;
    }

    /**
     * This method is used to return customer's address line two.
     * param none
     * @return String addressTwo
     */
    public String getAddressTwo() {
        return addressTwo;
    }

    /**
     * This method is used to set customer's address line two.
     * param String addressTwo
     * @return void
     */
    public void setAddressTwo(String addressTwo) {
        this.addressTwo = addressTwo;
    }

    /**
     * This method is used to return customer's town or city.
     * param none
     * @return String townCity
     */
    public String getTownCity() {
        return townCity;
    }

    /**
     * This method is used to set customer's town or city.
     * param String townCity
     * @return void
     */
    public void setTownCity(String townCity) {
        this.townCity = townCity;
    }

    /**
     * This method is used to return customer's county.
     * param none
     * @return String county
     */
    public String getCounty() {
        return county;
    }

    /**
     * This method is used to set customer's county.
     * param String county
     * @return void
     */
    public void setCounty(String county) {
        this.county = county;
    }

    /**
     * This method is used to return customer's joined date.
     * param none
     * @return LocalDate joinDate
     */
    public LocalDate getJoinDate() {
        return joinDate;
    }

    /**
     * This method is used to set customer's join code.
     * param LocalDate joinDate
     * @return void
     */
    public void setJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
    }

    /**
     * This method is used to return customer's tariff start date.
     * param none
     * @return tariffStartDate
     */
    public LocalDate getTariffStartDate() {
        return tariffStartDate;
    }

    /**
     * This method is used to set customer's tariff start date.
     * param LocalDate tariffStartDate
     * @return void
     */
    public void setTariffStartDate(LocalDate tariffStartDate) {
        this.tariffStartDate = tariffStartDate;
    }

    /**
     * This method is used to return customer's tariff end date.
     * param none
     * @return LocalDate tariffEndDate
     */
    public LocalDate getTariffEndDate() {
        return tariffEndDate;
    }

    /**
     * This method is used to set customer's tariff end date.
     * param LocalDate tariffEndDate
     * @return void
     */
    public void setTariffEndDate(LocalDate tariffEndDate) {
        this.tariffEndDate = tariffEndDate;
    }

    /**
     * This method is used to return customer's meter number.
     * param none
     * @return String meterNumber
     */
    public String getMeterNumber() {
        return meterNumber;
    }

    /**
     * This method is used to set customer's meter number.
     * param String meterNumber
     * @return void
     */
    public void setMeterNumber(String meterNumber) {
        this.meterNumber = meterNumber;
    }

    /**
     * This method is used to return customer's alternative contact number.
     * param none
     * @return String alternateContactNo
     */
    public String getAlternateContactNo() {
        return alternateContactNo;
    }

    /**
     * This method is used to set customer's alternative contact number.
     * param String alternateContactNo
     * @return void
     */
    public void setAlternateContactNo(String alternateContactNo) {
        this.alternateContactNo = alternateContactNo;
    }

    /**
     * This method is used to return created at timestamp.
     * param none
     * @return long createdAt
     */
    public long getCreatedAt() {
        return createdAt;
    }

    /**
     * This method is used to set created at timestamp.
     * param long createdAt
     * @return void
     */
    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * This method is used to return updated at timestamp.
     * param none
     * @return long updatedAt
     */
    public long getUpdatedAt() {
        return updatedAt;
    }

    /**
     * This method is used to set updated at timestamp.
     * param long updatedAt
     * @return void
     */
    public void setUpdatedAt(long updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * This method is used to return customer tariff index value from tariffs data.
     * @param tariffId
     * @return
     */
    public Tariff getCustomerTariff(int tariffId) {
        int ind = -1;
        ArrayList<Tariff> tariffs = new ArrayList<>();
        Tariff singleTariff = new Tariff();
        File f = new File("./data/tariffs.txt");
        if(f.isFile()) {
            Serialization serializationHelper = new Serialization();
            tariffs = serializationHelper.deserializeTariffs();
            int count = 0;
            for (Tariff tariff: tariffs) {
                if (tariff.getTariffId() == tariffId) {
                    return tariff;
                }
                count++;
            }
        }
        return singleTariff;
    }

    public Customer() {

    }

    /**
     * Constructor with parameters.
     *
     * @param customerId
     * @param userId
     * @param tariffId
     * @param postCode
     * @param addressOne
     * @param addressTwo
     * @param townCity
     * @param county
     * @param joinDate
     * @param meterNumber
     * @param alternateContactNo
     * @param createdAt
     * @param updatedAt
     */
    public Customer(int customerId, int userId, int tariffId, String name, String mobNo, String email, String postCode, String addressOne, String addressTwo, String townCity, String county, LocalDate joinDate, LocalDate tariffStartDate, LocalDate tariffEndDate, String meterNumber, String alternateContactNo, long createdAt, long updatedAt) {
        this.customerId = customerId;
        this.userId = userId;
        this.tariffId = tariffId;
        this.name = name;
        this.mobNo = mobNo;
        this.email = email;
        this.postCode = postCode;
        this.addressOne = addressOne;
        this.addressTwo = addressTwo;
        this.townCity = townCity;
        this.county = county;
        this.joinDate = joinDate;
        this.tariffStartDate = tariffStartDate;
        this.tariffEndDate = tariffEndDate;
        this.meterNumber = meterNumber;
        this.alternateContactNo = alternateContactNo;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
