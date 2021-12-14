/*
 * Tariff.java
 * Tariff class which encapsulates attributes and methods of the tariff module.
 *
 * @author: Ashwin Gurung
 */
package application.nthenergy.models;

import application.nthenergy.core.enums.MeterType;
import application.nthenergy.core.enums.TariffType;

import java.security.Timestamp;

public class Tariff {
    // private properties of the tariff class
    private int tariffId;
    private String name;
    private String description;
    private TariffType tariffType;
    private MeterType meterType;
    private float elecFixRate;
    private float gasFixRate;
    private float exitFee;
    private float standingFee;
    private float elecNightRate;
    private float elecDayRate;
    private float gasUnitRate;
    private Timestamp createdAt;
    private Timestamp updatedAt;

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
     * @return float elecFixRate
     */
    public float getElecFixRate() {
        return elecFixRate;
    }

    /**
     * This method is used to set electricity fix rate.
     * @param float elecFixRate
     * @return void
     */
    public void setElecFixRate(float elecFixRate) {
        this.elecFixRate = elecFixRate;
    }

    /**
     * This method is used to return gas fixed rate.
     * @param none
     * @return float gasFixRate
     */
    public float getGasFixRate() {
        return gasFixRate;
    }

    /**
     * This method is used to set gas fix rate.
     * @param float gaxFixRate
     * @return void
     */
    public void setGasFixRate(float gasFixRate) {
        this.gasFixRate = gasFixRate;
    }

    /**
     * This method is used to return exit fee.
     * @param none
     * @return float exitFee
     */
    public float getExitFee() {
        return exitFee;
    }

    /**
     * This method is used to set exit fee.
     * @param float exitFee
     * @return void
     */
    public void setExitFee(float exitFee) {
        this.exitFee = exitFee;
    }

    /**
     * This method is used to return standing fee.
     * @param none
     * @return float standingFee
     */
    public float getStandingFee() {
        return standingFee;
    }

    /**
     * This method is used to set standing fee.
     * @param float standingFee
     * @return void
     */
    public void setStandingFee(float standingFee) {
        this.standingFee = standingFee;
    }

    /**
     * This method is used to return electricity night rate.
     * @param none
     * @return float elecNightRate
     */
    public float getElecNightRate() {
        return elecNightRate;
    }

    /**
     * This method is used to set electricity night rate.
     * @param float elecNightRate
     * @return void
     */
    public void setElecNightRate(float elecNightRate) {
        this.elecNightRate = elecNightRate;
    }

    /**
     * This method is used to return electricity day rate.
     * @param none
     * @return float elecDayRate
     */
    public float getElecDayRate() {
        return elecDayRate;
    }

    /**
     * This method is used to set elecricity day rate.
     * @param float elecDayRate
     * @return void
     */
    public void setElecDayRate(float elecDayRate) {
        this.elecDayRate = elecDayRate;
    }

    /**
     * This method is used to return gas unit rate.
     * @param none
     * @return float gasUnitRate
     */
    public float getGasUnitRate() {
        return gasUnitRate;
    }

    /**
     * This method is used to set gas unit rate.
     * @param float gasUnitRate
     * @return void
     */
    public void setGasUnitRate(float gasUnitRate) {
        this.gasUnitRate = gasUnitRate;
    }

    /**
     * This method is used to return timestamp of created at.
     * @param none
     * @return Timestamp createdAt
     */
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    /**
     * This method is used to set created at timestamp.
     * @param float createdAt
     * @return void
     */
    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * This method is used to return timestamp of updated at.
     * @param none
     * @return Timestamp updatedAt
     */
    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    /**
     * This method is used to set updated at timestamp.
     * @param float updatedAt
     * @return void
     */
    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }
}
