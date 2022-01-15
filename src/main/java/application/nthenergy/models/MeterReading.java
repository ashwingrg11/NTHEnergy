/*
 * MeterReading.java
 * MeterReading class which encapsulates attributes and methods of the customer's meter readings.
 *
 * @author: Ashwin Gurung
 */
package application.nthenergy.models;

import application.nthenergy.core.Serialization;
import application.nthenergy.core.enums.AdminStatus;

import java.io.File;
import java.io.Serializable;
import java.security.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class MeterReading implements Serializable {
    // private properties of the class
    private int meterReadingId;
    private int customerId;
    private LocalDate openingDate;
    private  static  final  long  serialVersionUID = 7885852170815506762L;
    private LocalDate closingDate;
    private double gasOpening;
    private double gasClosing;
    private double gasKwh;
    private double elecOpening;
    private double elecClosing;
    private double elecKwh;
    private double elecNightOpening;
    private double elecNightClosing;
    private double elecNightKwh;
    private double elecDayOpening;
    private double elecDayClosing;
    private double elecDayKwh;
    private String remarks;
    private AdminStatus adminStatus;
    private long createdAt;
    private long updatedAt;

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
     * @return LocalDate openingDate
     */
    public LocalDate getOpeningDate() {
        return openingDate;
    }

    /**
     * This method is used to set opening date.
     * @param openingDate
     * @return void
     */
    public void setOpeningDate(LocalDate openingDate) {
        this.openingDate = openingDate;
    }

    /**
     * This method is used to return closing date.
     * @param
     * @return Date closingDate
     */
    public LocalDate getClosingDate() {
        return closingDate;
    }

    /**
     * This method is used to set closing date.
     * @param closingDate
     * @return void
     */
    public void setClosingDate(LocalDate closingDate) {
        this.closingDate = closingDate;
    }

    /**
     * This method is used to return gas opening.
     * @param none
     * @return double gasOpening
     */
    public double getGasOpening() {
        return gasOpening;
    }

    /**
     * This method is used to set gas opening.
     * @param double gasOpening
     * @return void
     */
    public void setGasOpening(double gasOpening) {
        this.gasOpening = gasOpening;
    }

    /**
     * This method is used to return gas closing.
     * @param none
     * @return double gasClosing
     */
    public double getGasClosing() {
        return gasClosing;
    }

    /**
     * This method is used to set gas closing.
     * @param double gasClosing
     * @return void
     */
    public void setGasClosing(double gasClosing) {
        this.gasClosing = gasClosing;
    }

    /**
     * This method is used to return gas kwh.
     * @param none
     * @return double gasKwh
     */
    public double getGasKwh() {
        return gasKwh;
    }

    /**
     * This method is used to set gas kwh.
     * @param double gasKwh
     * @return void
     */
    public void setGasKwh(double gasKwh) {
        this.gasKwh = gasKwh;
    }

    /**
     * This method is used to return electricity oepning.
     * @param none
     * @return double elecOpening
     */
    public double getElecOpening() {
        return elecOpening;
    }

    /**
     * This method is used to set electricity opening.
     * @param double elecOpening
     * @return void
     */
    public void setElecOpening(double elecOpening) {
        this.elecOpening = elecOpening;
    }

    /**
     * This method is used to return electricity closing.
     * @param none
     * @return double elecClosing
     */
    public double getElecClosing() {
        return elecClosing;
    }

    /**
     * This method is used to set electricity closing.
     * @param double elecClosing
     * @return void
     */
    public void setElecClosing(double elecClosing) {
        this.elecClosing = elecClosing;
    }

    /**
     * This method is used to return electricity kwh.
     * @param none
     * @return double elecKwh
     */
    public double getElecKwh() {
        return elecKwh;
    }

    /**
     * This method is used to set electricity kwh.
     * @param double elecKwh
     * @return void
     */
    public void setElecKwh(double elecKwh) {
        this.elecKwh = elecKwh;
    }

    /**
     * This method is used to return electricity night opening.
     * @param none
     * @return double elecNightOpening
     */
    public double getElecNightOpening() {
        return elecNightOpening;
    }

    /**
     * This method is used to set electricity night opening.
     * @param double elecNightOpening
     * @return void
     */
    public void setElecNightOpening(double elecNightOpening) {
        this.elecNightOpening = elecNightOpening;
    }

    /**
     * This method is used to return electricity night closing.
     * @param none
     * @return double elecNightClosing
     */
    public double getElecNightClosing() {
        return elecNightClosing;
    }

    /**
     * This method is used to set electricity night closing.
     * @param double elecNightClosing
     * @return void
     */
    public void setElecNightClosing(double elecNightClosing) {
        this.elecNightClosing = elecNightClosing;
    }

    /**
     * This method is used to return electricity night kwh.
     * @param none
     * @return double elecNightKwh
     */
    public double getElecNightKwh() {
        return elecNightKwh;
    }

    /**
     * This method is used to set electricity night kwh.
     * @param double elecNightKwh
     * @return void
     */
    public void setElecNightKwh(double elecNightKwh) {
        this.elecNightKwh = elecNightKwh;
    }

    /**
     * This method is used to return electricity day oepning.
     * @param none
     * @return double elecDayOpening
     */
    public double getElecDayOpening() {
        return elecDayOpening;
    }

    /**
     * This method is used to set electricity day opening.
     * @param double elecDayOpening
     * @return void
     */
    public void setElecDayOpening(double elecDayOpening) {
        this.elecDayOpening = elecDayOpening;
    }

    /**
     * This method is used to return electricity day closing.
     * @param none
     * @return double elecDayClosing
     */
    public double getElecDayClosing() {
        return elecDayClosing;
    }

    /**
     * This method is used to set electricity day closing.
     * @param double elecDayClosing
     * @return void
     */
    public void setElecDayClosing(double elecDayClosing) {
        this.elecDayClosing = elecDayClosing;
    }

    /**
     * This method is used to return electricity day kwh.
     * @param none
     * @return double elecDayKwh
     */
    public double getElecDayKwh() {
        return elecDayKwh;
    }

    /**
     * This method is used to set electricity day kwh.
     * @param double elecDayKwh
     * @return void
     */
    public void setElecDayKwh(double elecDayKwh) {
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
     * This method is used to return updated at timestamp.
     * @param none
     * @return long updatedAt
     */
    public long getUpdatedAt() {
        return updatedAt;
    }

    /**
     * This method is used to set updated at timestamp.
     * @param long updatedAt
     * @return void
     */
    public void setUpdatedAt(long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public MeterReading() {

    }

    /**
     * Constructor with parameters.
     *
     * @param meterReadingId
     * @param customerId
     * @param openingDate
     * @param closingDate
     * @param gasOpening
     * @param gasClosing
     * @param gasKwh
     * @param elecOpening
     * @param elecClosing
     * @param elecKwh
     * @param elecNightOpening
     * @param elecNightClosing
     * @param elecNightKwh
     * @param elecDayOpening
     * @param elecDayClosing
     * @param elecDayKwh
     * @param remarks
     * @param adminStatus
     * @param createdAt
     * @param updatedAt
     */
    public MeterReading(int meterReadingId, int customerId, LocalDate openingDate, LocalDate closingDate, double gasOpening, double gasClosing, double gasKwh, double elecOpening, double elecClosing, double elecKwh, double elecNightOpening, double elecNightClosing, double elecNightKwh, double elecDayOpening, double elecDayClosing, double elecDayKwh, String remarks, AdminStatus adminStatus, long createdAt, long updatedAt) {
        this.meterReadingId = meterReadingId;
        this.customerId = customerId;
        this.openingDate = openingDate;
        this.closingDate = closingDate;
        this.gasOpening = gasOpening;
        this.gasClosing = gasClosing;
        this.gasKwh = gasKwh;
        this.elecOpening = elecOpening;
        this.elecClosing = elecClosing;
        this.elecKwh = elecKwh;
        this.elecNightOpening = elecNightOpening;
        this.elecNightClosing = elecNightClosing;
        this.elecNightKwh = elecNightKwh;
        this.elecDayOpening = elecDayOpening;
        this.elecDayClosing = elecDayClosing;
        this.elecDayKwh = elecDayKwh;
        this.remarks = remarks;
        this.adminStatus = adminStatus;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    /**
     *
     * @param id
     * @return
     */
    public Customer getCustomerById(int id) {
        File f = new File("./data/customers.txt");
        Customer singleCustomer = new Customer();
        ArrayList<Customer> customers = new ArrayList<>();
        if(f.isFile()) {
            Serialization serializationHelper = new Serialization();
            customers = serializationHelper.deserializeCustomers();
            for (Customer customer: customers) {
                if (customer.getCustomerId() == id) {
                    return customer;
                }
            }
        }
        return singleCustomer;
    }

    @Override
    public String toString() {
        return "MeterReading{" +
                "meterReadingId=" + meterReadingId +
                ", customerId=" + customerId +
                ", openingDate=" + openingDate +
                ", closingDate=" + closingDate +
                ", gasOpening=" + gasOpening +
                ", gasClosing=" + gasClosing +
                ", gasKwh=" + gasKwh +
                ", elecOpening=" + elecOpening +
                ", elecClosing=" + elecClosing +
                ", elecKwh=" + elecKwh +
                ", elecNightOpening=" + elecNightOpening +
                ", elecNightClosing=" + elecNightClosing +
                ", elecNightKwh=" + elecNightKwh +
                ", elecDayOpening=" + elecDayOpening +
                ", elecDayClosing=" + elecDayClosing +
                ", elecDayKwh=" + elecDayKwh +
                ", remarks='" + remarks + '\'' +
                ", adminStatus=" + adminStatus +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
