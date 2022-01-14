/*
 * Invoice.java
 * Invoice class which encapsulates attributes and methods of the invoice module.
 *
 * @author: Ashwin Gurung
 */
package application.nthenergy.models;

import application.nthenergy.core.Serialization;
import application.nthenergy.core.enums.PaymentStatus;

import java.io.File;
import java.io.Serializable;
import java.security.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Invoice implements Serializable {
    private  static  final  long  serialVersionUID = 9031584928346912528L;
    // private properties of the class
    private int invoiceId;
    private int customerId;
    private int meterReadingId;
    private LocalDate dateFrom;
    private LocalDate dateUntil;
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
    private double gasPrice;
    private double elecPrice;
    private double elecDayPrice;
    private double elecNightPrice;
    private double elecDayInitialTotal;
    private double elecNightInitialTotal;
    private double elecInitialTotal;
    private double initialElecAmount;
    private double initialGasAmount;
    private double elecVatAmount;
    private double gasVatAmount;
    private double finalElecAmount;
    private double finalGasAmount;
    private double finalAmount;
    private PaymentStatus paymentStatus;
    private long createdAt;

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public double getElecDayInitialTotal() {
        return elecDayInitialTotal;
    }

    public void setElecDayInitialTotal(double elecDayInitialTotal) {
        this.elecDayInitialTotal = elecDayInitialTotal;
    }

    public double getElecNightInitialTotal() {
        return elecNightInitialTotal;
    }

    public void setElecNightInitialTotal(double elecNightInitialTotal) {
        this.elecNightInitialTotal = elecNightInitialTotal;
    }

    public double getElecInitialTotal() {
        return elecInitialTotal;
    }

    public void setElecInitialTotal(double elecInitialTotal) {
        this.elecInitialTotal = elecInitialTotal;
    }

    public int getMeterReadingId() {
        return meterReadingId;
    }

    public void setMeterReadingId(int meterReadingId) {
        this.meterReadingId = meterReadingId;
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(LocalDate dateFrom) {
        this.dateFrom = dateFrom;
    }

    public LocalDate getDateUntil() {
        return dateUntil;
    }

    public void setDateUntil(LocalDate dateUntil) {
        this.dateUntil = dateUntil;
    }

    public double getGasOpening() {
        return gasOpening;
    }

    public void setGasOpening(double gasOpening) {
        this.gasOpening = gasOpening;
    }

    public double getGasClosing() {
        return gasClosing;
    }

    public void setGasClosing(double gasClosing) {
        this.gasClosing = gasClosing;
    }

    public double getGasKwh() {
        return gasKwh;
    }

    public void setGasKwh(double gasKwh) {
        this.gasKwh = gasKwh;
    }

    public double getElecOpening() {
        return elecOpening;
    }

    public void setElecOpening(double elecOpening) {
        this.elecOpening = elecOpening;
    }

    public double getElecClosing() {
        return elecClosing;
    }

    public void setElecClosing(double elecClosing) {
        this.elecClosing = elecClosing;
    }

    public double getElecKwh() {
        return elecKwh;
    }

    public void setElecKwh(double elecKwh) {
        this.elecKwh = elecKwh;
    }

    public double getElecNightOpening() {
        return elecNightOpening;
    }

    public void setElecNightOpening(double elecNightOpening) {
        this.elecNightOpening = elecNightOpening;
    }

    public double getElecNightClosing() {
        return elecNightClosing;
    }

    public void setElecNightClosing(double elecNightClosing) {
        this.elecNightClosing = elecNightClosing;
    }

    public double getElecNightKwh() {
        return elecNightKwh;
    }

    public void setElecNightKwh(double elecNightKwh) {
        this.elecNightKwh = elecNightKwh;
    }

    public double getElecDayOpening() {
        return elecDayOpening;
    }

    public void setElecDayOpening(double elecDayOpening) {
        this.elecDayOpening = elecDayOpening;
    }

    public double getElecDayClosing() {
        return elecDayClosing;
    }

    public void setElecDayClosing(double elecDayClosing) {
        this.elecDayClosing = elecDayClosing;
    }

    public double getElecDayKwh() {
        return elecDayKwh;
    }

    public void setElecDayKwh(double elecDayKwh) {
        this.elecDayKwh = elecDayKwh;
    }

    public double getGasPrice() {
        return gasPrice;
    }

    public void setGasPrice(double gasPrice) {
        this.gasPrice = gasPrice;
    }

    public double getElecPrice() {
        return elecPrice;
    }

    public void setElecPrice(double elecPrice) {
        this.elecPrice = elecPrice;
    }

    public double getElecDayPrice() {
        return elecDayPrice;
    }

    public void setElecDayPrice(double elecDayPrice) {
        this.elecDayPrice = elecDayPrice;
    }

    public double getElecNightPrice() {
        return elecNightPrice;
    }

    public void setElecNightPrice(double elecNightPrice) {
        this.elecNightPrice = elecNightPrice;
    }

    public double getInitialElecAmount() {
        return initialElecAmount;
    }

    public void setInitialElecAmount(double initialElecAmount) {
        this.initialElecAmount = initialElecAmount;
    }

    public double getInitialGasAmount() {
        return initialGasAmount;
    }

    public void setInitialGasAmount(double initialGasAmount) {
        this.initialGasAmount = initialGasAmount;
    }

    public double getElecVatAmount() {
        return elecVatAmount;
    }

    public void setElecVatAmount(double elecVatAmount) {
        this.elecVatAmount = elecVatAmount;
    }

    public double getGasVatAmount() {
        return gasVatAmount;
    }

    public void setGasVatAmount(double gasVatAmount) {
        this.gasVatAmount = gasVatAmount;
    }

    public double getFinalElecAmount() {
        return finalElecAmount;
    }

    public void setFinalElecAmount(double finalElecAmount) {
        this.finalElecAmount = finalElecAmount;
    }

    public double getFinalGasAmount() {
        return finalGasAmount;
    }

    public void setFinalGasAmount(double finalGasAmount) {
        this.finalGasAmount = finalGasAmount;
    }

    public double getFinalAmount() {
        return finalAmount;
    }

    public void setFinalAmount(double finalAmount) {
        this.finalAmount = finalAmount;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public Invoice() {

    }

    public Invoice(int invoiceId, int customerId, int meterReadingId, LocalDate dateFrom, LocalDate dateUntil, double gasOpening, double gasClosing, double gasKwh, double elecOpening, double elecClosing, double elecKwh, double elecNightOpening, double elecNightClosing, double elecNightKwh, double elecDayOpening, double elecDayClosing, double elecDayKwh, double gasPrice, double elecPrice, double elecDayPrice, double elecNightPrice, double elecDayInitialTotal, double elecNightInitialTotal, double elecInitialTotal, double initialElecAmount,  double initialGasAmount, double elecVatAmount, double gasVatAmount, double finalElecAmount, double finalGasAmount, double finalAmount, PaymentStatus paymentStatus, long createdAt) {
        this.invoiceId = invoiceId;
        this.customerId = customerId;
        this.meterReadingId = meterReadingId;
        this.dateFrom = dateFrom;
        this.dateUntil = dateUntil;
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
        this.gasPrice = gasPrice;
        this.elecPrice = elecPrice;
        this.elecDayPrice = elecDayPrice;
        this.elecNightPrice = elecNightPrice;
        this.elecDayInitialTotal = elecDayInitialTotal;
        this.elecNightInitialTotal = elecNightInitialTotal;
        this.elecInitialTotal = elecInitialTotal;
        this.initialElecAmount = initialElecAmount;
        this.initialGasAmount = initialGasAmount;
        this.elecVatAmount = elecVatAmount;
        this.gasVatAmount = gasVatAmount;
        this.finalElecAmount = finalElecAmount;
        this.finalGasAmount = finalGasAmount;
        this.finalAmount = finalAmount;
        this.paymentStatus = paymentStatus;
        this.createdAt = createdAt;
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
}

