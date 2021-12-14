/*
 * MeterReading.java
 * MeterReading class which encapsulates attributes and methods of the customer's meter readings.
 *
 * @author: Ashwin Gurung
 */
package application.nthenergy.models;

import application.nthenergy.core.enums.AdminStatus;
import java.security.Timestamp;
import java.util.Date;

public class MeterReading {
    // private properties of the class
    private int meterReadingId;
    private int customerId;
    private Date openingDate;
    private Date closingDate;
    private float gasOpening;
    private float gasClosing;
    private float gasKwh;
    private float elecOpening;
    private float elecClosing;
    private float elecKwh;
    private float elecNightOpening;
    private float elecNightClosing;
    private float elecNightKwh;
    private float elecDayOpening;
    private float elecDayClosing;
    private float elecDayKwh;
    private String remarks;
    private AdminStatus adminStatus;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    // getters and setters for the attributes
    /**
     * This method is used to return meter reading id.
     * @param none
     * @return int meterReadingId
     */
    public int getMeterReadingId() {
        return meterReadingId;
    }

    /**
     * This method is used to set meter reading id.
     * @param int meterReadingId
     * @return void
     */
    public void setMeterReadingId(int meterReadingId) {
        this.meterReadingId = meterReadingId;
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
     * This method is used to return opening date.
     * @param none
     * @return Date openingDate
     */
    public Date getOpeningDate() {
        return openingDate;
    }

    /**
     * This method is used to set opening date.
     * @param Date openingDate
     * @return void
     */
    public void setOpeningDate(Date openingDate) {
        this.openingDate = openingDate;
    }

    /**
     * This method is used to return closing date.
     * @param none
     * @return Date closingDate
     */
    public Date getClosingDate() {
        return closingDate;
    }

    /**
     * This method is used to set closing date.
     * @param Date closingDate
     * @return void
     */
    public void setClosingDate(Date closingDate) {
        this.closingDate = closingDate;
    }

    /**
     * This method is used to return gas opening.
     * @param none
     * @return float gasOpening
     */
    public float getGasOpening() {
        return gasOpening;
    }

    /**
     * This method is used to set gas opening.
     * @param float gasOpening
     * @return void
     */
    public void setGasOpening(float gasOpening) {
        this.gasOpening = gasOpening;
    }

    /**
     * This method is used to return gas closing.
     * @param none
     * @return float gasClosing
     */
    public float getGasClosing() {
        return gasClosing;
    }

    /**
     * This method is used to set gas closing.
     * @param float gasClosing
     * @return void
     */
    public void setGasClosing(float gasClosing) {
        this.gasClosing = gasClosing;
    }

    /**
     * This method is used to return gas kwh.
     * @param none
     * @return float gasKwh
     */
    public float getGasKwh() {
        return gasKwh;
    }

    /**
     * This method is used to set gas kwh.
     * @param float gasKwh
     * @return void
     */
    public void setGasKwh(float gasKwh) {
        this.gasKwh = gasKwh;
    }

    /**
     * This method is used to return electricity oepning.
     * @param none
     * @return float elecOpening
     */
    public float getElecOpening() {
        return elecOpening;
    }

    /**
     * This method is used to set electricity opening.
     * @param float elecOpening
     * @return void
     */
    public void setElecOpening(float elecOpening) {
        this.elecOpening = elecOpening;
    }

    /**
     * This method is used to return electricity closing.
     * @param none
     * @return float elecClosing
     */
    public float getElecClosing() {
        return elecClosing;
    }

    /**
     * This method is used to set electricity closing.
     * @param float elecClosing
     * @return void
     */
    public void setElecClosing(float elecClosing) {
        this.elecClosing = elecClosing;
    }

    /**
     * This method is used to return electricity kwh.
     * @param none
     * @return float elecKwh
     */
    public float getElecKwh() {
        return elecKwh;
    }

    /**
     * This method is used to set electricity kwh.
     * @param float elecKwh
     * @return void
     */
    public void setElecKwh(float elecKwh) {
        this.elecKwh = elecKwh;
    }

    /**
     * This method is used to return electricity night opening.
     * @param none
     * @return float elecNightOpening
     */
    public float getElecNightOpening() {
        return elecNightOpening;
    }

    /**
     * This method is used to set electricity night opening.
     * @param float elecNightOpening
     * @return void
     */
    public void setElecNightOpening(float elecNightOpening) {
        this.elecNightOpening = elecNightOpening;
    }

    /**
     * This method is used to return electricity night closing.
     * @param none
     * @return float elecNightClosing
     */
    public float getElecNightClosing() {
        return elecNightClosing;
    }

    /**
     * This method is used to set electricity night closing.
     * @param float elecNightClosing
     * @return void
     */
    public void setElecNightClosing(float elecNightClosing) {
        this.elecNightClosing = elecNightClosing;
    }

    /**
     * This method is used to return electricity night kwh.
     * @param none
     * @return float elecNightKwh
     */
    public float getElecNightKwh() {
        return elecNightKwh;
    }

    /**
     * This method is used to set electricity night kwh.
     * @param float elecNightKwh
     * @return void
     */
    public void setElecNightKwh(float elecNightKwh) {
        this.elecNightKwh = elecNightKwh;
    }

    /**
     * This method is used to return electricity day oepning.
     * @param none
     * @return float elecDayOpening
     */
    public float getElecDayOpening() {
        return elecDayOpening;
    }

    /**
     * This method is used to set electricity day opening.
     * @param float elecDayOpening
     * @return void
     */
    public void setElecDayOpening(float elecDayOpening) {
        this.elecDayOpening = elecDayOpening;
    }

    /**
     * This method is used to return electricity day closing.
     * @param none
     * @return float elecDayClosing
     */
    public float getElecDayClosing() {
        return elecDayClosing;
    }

    /**
     * This method is used to set electricity day closing.
     * @param float elecDayClosing
     * @return void
     */
    public void setElecDayClosing(float elecDayClosing) {
        this.elecDayClosing = elecDayClosing;
    }

    /**
     * This method is used to return electricity day kwh.
     * @param none
     * @return float elecDayKwh
     */
    public float getElecDayKwh() {
        return elecDayKwh;
    }

    /**
     * This method is used to set electricity day kwh.
     * @param float elecDayKwh
     * @return void
     */
    public void setElecDayKwh(float elecDayKwh) {
        this.elecDayKwh = elecDayKwh;
    }

    /**
     * This method is used to return remarks.
     * @param none
     * @return String remarks
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * This method is used to set remarks.
     * @param String remarks
     * @return void
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /**
     * This method is used to return admin status.
     * @param none
     * @return AdminStatus adminStatus
     */
    public AdminStatus getAdminStatus() {
        return adminStatus;
    }

    /**
     * This method is used to set admin status.
     * @param AdminStatus adminStatus
     * @return void
     */
    public void setAdminStatus(AdminStatus adminStatus) {
        this.adminStatus = adminStatus;
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
