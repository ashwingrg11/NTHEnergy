/*
 * Tariff.java
 * Tariff class which encapsulates attributes and methods of the tariff module.
 *
 * @author: Ashwin Gurung
 */
package application.nthenergy.models;

import application.nthenergy.core.Serialization;
import application.nthenergy.core.enums.MeterType;
import application.nthenergy.core.enums.TariffType;

import java.io.File;
import java.io.Serializable;
import java.security.Timestamp;
import java.util.ArrayList;

public class Tariff implements Serializable {
    // private properties of the tariff class
    private int tariffId;
    private String name;
    private String description;
    private TariffType tariffType;
    private MeterType meterType;
    private double elecFixRate;
    private double gasFixRate;
    private double exitFee;
    private double standingFee;
    private double elecNightRate;
    private double elecDayRate;
    private double gasUnitRate;
    private long createdAt;
    private long updatedAt;
    private  static  final  long  serialVersionUID = 11168219141444160L;
    // getters and setters for the attributes
    /**
     * This method is used to return tariff id.
     * @param none
     * @return int tariffId
     */
    public int getTariffId() {
        return tariffId;
    }

    /**
     * This method is used to set tariff id.
     * @param int tariffId
     * @return void
     */
    public void setTariffId(int tariffId) {
        this.tariffId = tariffId;
    }

    /**
     * This method is used to return tariff name.
     * @param none
     * @return String name
     */
    public String getName() {
        return name;
    }

    /**
     * This method is used to set tariff name.
     * @param String name
     * @return void
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method is used to return tariff description.
     * @param none
     * @return String description
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method is used to set tariff description.
     * @param String description
     * @return void
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * This method is used to return tariff type.
     * @param none
     * @return TariffType tariffType
     */
    public TariffType getTariffType() {
        return tariffType;
    }

    /**
     * This method is used to set tariff type.
     * @param TariffType tariffType
     * @return void
     */
    public void setTariffType(TariffType tariffType) {
        this.tariffType = tariffType;
    }

    /**
     * This method is used to return meter type.
     * @param none
     * @return MeterType meterType
     */
    public MeterType getMeterType() {
        return meterType;
    }

    /**
     * This method is used to set meter type.
     * @param MeterType meterType
     * @return void
     */
    public void setMeterType(MeterType meterType) {
        this.meterType = meterType;
    }

    /**
     * This method is used to return electricity fixed rate.
     * @param none
     * @return double elecFixRate
     */
    public double getElecFixRate() {
        return elecFixRate;
    }

    /**
     * This method is used to set electricity fix rate.
     * @param double elecFixRate
     * @return void
     */
    public void setElecFixRate(double elecFixRate) {
        this.elecFixRate = elecFixRate;
    }

    /**
     * This method is used to return gas fixed rate.
     * @param none
     * @return double gasFixRate
     */
    public double getGasFixRate() {
        return gasFixRate;
    }

    /**
     * This method is used to set gas fix rate.
     * @param double gaxFixRate
     * @return void
     */
    public void setGasFixRate(double gasFixRate) {
        this.gasFixRate = gasFixRate;
    }

    /**
     * This method is used to return exit fee.
     * @param none
     * @return double exitFee
     */
    public double getExitFee() {
        return exitFee;
    }

    /**
     * This method is used to set exit fee.
     * @param double exitFee
     * @return void
     */
    public void setExitFee(double exitFee) {
        this.exitFee = exitFee;
    }

    /**
     * This method is used to return standing fee.
     * @param none
     * @return double standingFee
     */
    public double getStandingFee() {
        return standingFee;
    }

    /**
     * This method is used to set standing fee.
     * @param double standingFee
     * @return void
     */
    public void setStandingFee(double standingFee) {
        this.standingFee = standingFee;
    }

    /**
     * This method is used to return electricity night rate.
     * @param none
     * @return double elecNightRate
     */
    public double getElecNightRate() {
        return elecNightRate;
    }

    /**
     * This method is used to set electricity night rate.
     * @param double elecNightRate
     * @return void
     */
    public void setElecNightRate(double elecNightRate) {
        this.elecNightRate = elecNightRate;
    }

    /**
     * This method is used to return electricity day rate.
     * @param none
     * @return double elecDayRate
     */
    public double getElecDayRate() {
        return elecDayRate;
    }

    /**
     * This method is used to set elecricity day rate.
     * @param double elecDayRate
     * @return void
     */
    public void setElecDayRate(double elecDayRate) {
        this.elecDayRate = elecDayRate;
    }

    /**
     * This method is used to return gas unit rate.
     * @param none
     * @return double gasUnitRate
     */
    public double getGasUnitRate() {
        return gasUnitRate;
    }

    /**
     * This method is used to set gas unit rate.
     * @param double gasUnitRate
     * @return void
     */
    public void setGasUnitRate(double gasUnitRate) {
        this.gasUnitRate = gasUnitRate;
    }

    /**
     * This method is used to return timestamp of created at.
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
     * This method is used to return timestamp of updated at.
     * @param none
     * @return Timestamp updatedAt
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

    public Tariff() {

    }

    /**
     * Constructor with parameters
     *
     * @param tariffId
     * @param name
     * @param description
     * @param tariffType
     * @param meterType
     * @param elecFixRate
     * @param gasFixRate
     * @param exitFee
     * @param standingFee
     * @param elecNightRate
     * @param elecDayRate
     * @param gasUnitRate
     * @param createdAt
     * @param updatedAt
     */
    public Tariff(int tariffId, String name, String description, TariffType tariffType, MeterType meterType, double elecFixRate, double gasFixRate, double exitFee, double standingFee, double elecNightRate, double elecDayRate, double gasUnitRate, long createdAt, long updatedAt) {
        this.tariffId = tariffId;
        this.name = name;
        this.description = description;
        this.tariffType = tariffType;
        this.meterType = meterType;
        this.elecFixRate = elecFixRate;
        this.gasFixRate = gasFixRate;
        this.exitFee = exitFee;
        this.standingFee = standingFee;
        this.elecNightRate = elecNightRate;
        this.elecDayRate = elecDayRate;
        this.gasUnitRate = gasUnitRate;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    /**
     * This method is used to fetch tariff inifo by tariff id.
     * @param id
     * @return <Tariff>
     */
    public Tariff getById(int id) {
        File f = new File("./data/tariffs.txt");
        Tariff singleTariff = new Tariff();
        ArrayList<Tariff> tariffs = new ArrayList<>();
        if(f.isFile()) {
            Serialization serializationHelper = new Serialization();
            tariffs = serializationHelper.deserializeTariffs();
            for (Tariff tariff: tariffs) {
                if (tariff.getTariffId() == id) {
                    return tariff;
                }
            }
        }
        return singleTariff;
    }

    @Override
    public String toString() {
        return this.getName();
//        return "Tariff{" +
//                "tariffId=" + tariffId +
//                ", name='" + name + '\'' +
//                ", description='" + description + '\'' +
//                ", tariffType=" + tariffType +
//                ", meterType=" + meterType +
//                ", elecFixRate=" + elecFixRate +
//                ", gasFixRate=" + gasFixRate +
//                ", exitFee=" + exitFee +
//                ", standingFee=" + standingFee +
//                ", elecNightRate=" + elecNightRate +
//                ", elecDayRate=" + elecDayRate +
//                ", gasUnitRate=" + gasUnitRate +
//                ", createdAt=" + createdAt +
//                ", updatedAt=" + updatedAt +
//                '}';
    }
}
