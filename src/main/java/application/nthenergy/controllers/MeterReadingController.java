/*
 * MeterReadingController.java
 * Controller class to access properties and methods from model class,
 * handles user requests from meter reading module's views.
 * @author: Ashwin Gurung
 */

package application.nthenergy.controllers;

import application.nthenergy.Dashboard;
import application.nthenergy.core.Helper;
import application.nthenergy.core.Serialization;
import application.nthenergy.core.enums.AdminStatus;
import application.nthenergy.core.enums.MeterType;
import application.nthenergy.core.enums.PaymentStatus;
import application.nthenergy.core.enums.TariffType;
import application.nthenergy.models.Customer;
import application.nthenergy.models.Invoice;
import application.nthenergy.models.MeterReading;
import application.nthenergy.models.Tariff;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;

public class MeterReadingController {
    @FXML
    private Button cancelNewTariffBtn;

    @FXML
    private Label formMsg;

    @FXML
    private DatePicker newMeterReadingClosingDate;

    @FXML
    private TextField newMeterReadingDayClosing;

    @FXML
    private TextField newMeterReadingDayOpening;

    @FXML
    private TextField newMeterReadingElecClosing;

    @FXML
    private TextField newMeterReadingElecNightOpening;

    @FXML
    private TextField newMeterReadingElecOpening;

    @FXML
    private TextField newMeterReadingGasClosing;

    @FXML
    private TextField newMeterReadingGasOpening;

    @FXML
    private TextField newMeterReadingNightClosing;

    @FXML
    private DatePicker newMeterReadingOpeningDate;

    @FXML
    private Button submitNewMerterReadingBtn;

    @FXML
    private Button viewAllMeterReadingsBtn;

    @FXML
    private Button addMeterReadingBtn;

    @FXML
    private Button deleteMeterReadiingBtn;

    @FXML
    private Button editMeterReadingBtn;

    @FXML
    private Label labelElecDayClosing;

    @FXML
    private Label labelElecDayOpening;

    @FXML
    private Label labelElecNightClosing;

    @FXML
    private Label labelElecNightOpening;

    @FXML
    private Label labelElecOpening;

    @FXML
    private Label labelElecClosing;

    @FXML
    private ComboBox<String> newMeterReadingCustomer;

    @FXML
    private TableView<MeterReading> allMeterReadingsTable;

    @FXML
    private TableColumn<MeterReading, LocalDate> colMrClosingDate;

    @FXML
    private TableColumn<MeterReading, Double> colMrElecDayKwh;

    @FXML
    private TableColumn<MeterReading, Double> colMrElecKwh;

    @FXML
    private TableColumn<MeterReading, Double> colMrElecNightKwh;

    @FXML
    private TableColumn<MeterReading, Double> colMrGasKwh;

    @FXML
    private TableColumn<MeterReading, String> colMrCustomerName;

    @FXML
    private TableColumn<MeterReading, LocalDate> colMrOpeningDate;

    ObservableList<MeterReading> obMeterReadings = FXCollections.observableArrayList();
    private ObservableList<String> obAllCustomers = FXCollections.observableArrayList();

    @FXML
    void onClickAddMeterReading(MouseEvent event) throws IOException {
        Helper.setScene(event, "views/meter-readings/new-meter-reading.fxml");
    }

    @FXML
    void onClickSubmitNewMeterReading(MouseEvent event) {
        TextField[] fields = {newMeterReadingGasOpening, newMeterReadingGasClosing};
        DatePicker[] dates = {newMeterReadingOpeningDate, newMeterReadingClosingDate};
        ComboBox[] cmbFields = {newMeterReadingCustomer};
        // validate date input fields
        boolean flag = false;
        // loop through all required text fields
        for(DatePicker date : dates) {
            if(date.getValue() == null) {
                date.getStyleClass().add("input-red-border");
                flag = true;
            }
        }
        // label to show validation error message
        Label formMsg = (Label) submitNewMerterReadingBtn.getScene().lookup("#formMsg");
        if (flag){
            formMsg.getStyleClass().removeAll("green-text");
            formMsg.getStyleClass().add("red-text");
            formMsg.setText("*  Please provide the required information.");
        }
        else {
            formMsg.setText("");
            formMsg.getStyleClass().removeAll("red-text");
            if(Helper.validateRequiredTextFields(submitNewMerterReadingBtn, fields) && Helper.validateRequiredComboBoxFields(submitNewMerterReadingBtn, cmbFields)) {
                MeterReading newMeterReadingData = makeNewMeterReading();
                Serialization serializationHelper = new Serialization();
                System.out.println(newMeterReadingData.toString());
                serializationHelper.serializeMeterReading(newMeterReadingData);
                formMsg.getStyleClass().removeAll("red-text");
                formMsg.getStyleClass().add("green-text");
                formMsg.setText("-  New meter reading has been saved successfully.");
            }
        }

    }


    /**
     * This method is used to construct new meter reading object
     * @return
     */
    private MeterReading makeNewMeterReading() {
        int meterReadingId;
        File f = new File("./data/meter-readings.txt");
        if(f.isFile()) {
            Serialization serializationHelper = new Serialization();
            ArrayList<MeterReading> allMeterReadings = serializationHelper.deserializeMeterReadings();
            if (allMeterReadings.size() > 0) {
                meterReadingId = allMeterReadings.get(allMeterReadings.size() - 1).getMeterReadingId() + 1;
            }
            else {
                meterReadingId = 1;
            }
        }
        else {
            meterReadingId = 1;
        }
        // customer id
        Customer selectedCustomer = new Customer();
        Customer selectedCustomerObj = selectedCustomer.getCustomerByName(newMeterReadingCustomer.getValue());
        int customerId = selectedCustomerObj.getCustomerId();
        Tariff tariffObj = new Tariff();
        Tariff currentTariff = tariffObj.getById(selectedCustomerObj.getTariffId());
        LocalDate openingDate = newMeterReadingOpeningDate.getValue();
        LocalDate closingDate = newMeterReadingClosingDate.getValue();
        double gasOpening = Double.parseDouble(newMeterReadingGasOpening.getText());
        double gasClosing = Double.parseDouble(newMeterReadingGasClosing.getText());
        double gasKwh = gasClosing - gasOpening;
        double elecOpening, elecClosing, elecKwh, elecNightOpening, elecNightClosing, elecNightKwh, elecDayOpening, elecDayClosing, elecDayKwh;
        // price calculations of gas and electricity
        if (currentTariff.getTariffType().toString() == "FIXED") {
            elecOpening = Double.parseDouble(newMeterReadingElecOpening.getText());
            elecClosing = Double.parseDouble(newMeterReadingElecClosing.getText());
            elecKwh = elecClosing - elecOpening;
            elecNightOpening = elecNightClosing = elecNightKwh = elecDayOpening = elecDayClosing = elecDayKwh = 0.00;
        }
        else {
            elecNightOpening = Double.parseDouble(newMeterReadingElecNightOpening.getText());
            elecNightClosing = Double.parseDouble(newMeterReadingNightClosing.getText());
            elecNightKwh = elecNightClosing - elecNightOpening;
            elecDayOpening = Double.parseDouble(newMeterReadingDayOpening.getText());
            elecDayClosing = Double.parseDouble(newMeterReadingDayClosing.getText());
            elecDayKwh = elecDayClosing - elecDayOpening;
            elecOpening = elecClosing = elecKwh = 0.00;
        }
        String remarks = "";
        AdminStatus adminStatus = AdminStatus.APPROVED;
        long createdAt = System.currentTimeMillis();
        long updatedAt = System.currentTimeMillis();
        MeterReading newMeterReadingData = new MeterReading(meterReadingId, customerId, openingDate, closingDate, gasOpening, gasClosing, gasKwh, elecOpening, elecClosing, elecKwh, elecNightOpening, elecNightClosing, elecNightKwh, elecDayOpening, elecDayClosing, elecDayKwh, "", adminStatus, createdAt, updatedAt);
        Invoice newInvoiceData = makeNewInvoice(selectedCustomerObj, newMeterReadingData, currentTariff);
        Serialization serializationHelper = new Serialization();
        serializationHelper.serializeInvoice(newInvoiceData);
        return newMeterReadingData;
    }


    /**
     * This method is used to calculate and construcut new object for invoice data.
     *
     * @param currentCustomer
     * @param meterReading
     * @param currentTariff
     * @return Invoice object
     */
    private Invoice makeNewInvoice(Customer currentCustomer, MeterReading meterReading, Tariff currentTariff) {
        int invoiceId;
        File f = new File("./data/invoices.txt");
        if(f.isFile()) {
            Serialization serializationHelper = new Serialization();
            ArrayList<Invoice> allInvoices = serializationHelper.deserializeInvoices();
            if (allInvoices.size() > 0) {
                invoiceId = allInvoices.get(allInvoices.size() - 1).getInvoiceId() + 1;
            }
            else {
                invoiceId = 1;
            }
        }
        else {
            invoiceId = 1;
        }
        int customerId = currentCustomer.getCustomerId();
        int meterReadingId = meterReading.getMeterReadingId();
        LocalDate dateFrom = meterReading.getOpeningDate();
        LocalDate dateUntil = meterReading.getClosingDate();
        // electricity bill calculations
        double elecOpening, elecClosing, elecKwh, elecNightOpening, elecNightClosing, elecNightKwh, elecDayOpening, elecDayClosing, elecDayKwh, gasPrice, elecPrice, elecDayPrice, elecNightPrice;
        double elecCharge, totalCharge, elecVatAmount, finalElecAmount, elecNightCharge, elecDayCharge;
        double elecInitialTotal, elecDayInitialTotal, elecNightInitialTotal;
        if (currentTariff.getTariffType().toString() == "FIXED") {
            elecCharge = meterReading.getElecKwh() * currentTariff.getElecFixRate();
            totalCharge = elecCharge;
            elecVatAmount = (totalCharge * 5)/100;
            finalElecAmount = totalCharge + elecVatAmount;
            //
            elecOpening = meterReading.getElecOpening();
            elecClosing = meterReading.getElecClosing();
            elecKwh = meterReading.getElecKwh();
            elecPrice = currentTariff.getElecFixRate();
            gasPrice = currentTariff.getGasFixRate();
            elecInitialTotal = totalCharge;
            elecNightOpening = elecNightClosing = elecNightKwh = elecDayOpening = elecDayClosing = elecDayKwh = elecDayPrice = elecNightPrice = elecDayInitialTotal = elecNightInitialTotal = 0;
        }
        else {
            elecNightCharge = meterReading.getElecNightKwh() * currentTariff.getElecNightRate();
            elecDayCharge = meterReading.getElecDayKwh() * currentTariff.getElecDayRate();
            totalCharge = elecDayCharge + elecNightCharge;
            elecVatAmount = (totalCharge * 5)/100;
            finalElecAmount = totalCharge + elecVatAmount;
            //
            elecNightOpening = meterReading.getElecNightOpening();
            elecNightClosing = meterReading.getElecNightClosing();
            elecNightKwh = meterReading.getElecNightKwh();
            elecDayOpening = meterReading.getElecDayOpening();
            elecDayClosing = meterReading.getElecDayClosing();
            elecDayKwh = meterReading.getElecDayKwh();
            gasPrice = currentTariff.getGasUnitRate();
            elecDayPrice = currentTariff.getElecDayRate();
            elecNightPrice = currentTariff.getElecNightRate();
            elecDayInitialTotal = elecDayCharge;
            elecNightInitialTotal = elecNightCharge;
            elecInitialTotal = elecDayInitialTotal + elecNightInitialTotal;
            elecOpening = elecClosing = elecKwh = elecPrice = 0;

        }

        // gas bill calculations
        double gasMthree = meterReading.getGasKwh();
        double gasCorrection = gasMthree * 1.02264 * 39.4;
        double finalGasKwh = gasCorrection / 3.6;
        double initialGasAmount;
        if (currentTariff.getTariffType().toString() == "FIXED") {
            initialGasAmount = finalGasKwh * currentTariff.getGasFixRate();

        }
        else {
            initialGasAmount = finalGasKwh * currentTariff.getGasUnitRate();
        }
        double gasVatAmount = (initialGasAmount * 5)/100;
        double finalGasAmount = initialGasAmount + gasVatAmount;
        double finalAmount = finalGasAmount + finalElecAmount;
        PaymentStatus paymentStatus = PaymentStatus.PENDING;
        long createdAt = System.currentTimeMillis();
        long updatedAt = System.currentTimeMillis();
        //
        Invoice newInvoiceData = new Invoice(invoiceId, customerId, meterReadingId, dateFrom, dateUntil, meterReading.getGasOpening(), meterReading.getGasClosing(), meterReading.getGasKwh(), elecOpening, elecClosing, elecKwh, elecNightOpening, elecNightClosing, elecNightKwh, elecDayOpening, elecDayClosing, elecDayKwh, gasPrice, elecPrice, elecDayPrice, elecNightPrice, elecDayInitialTotal, elecNightInitialTotal, elecInitialTotal, elecInitialTotal, initialGasAmount, elecVatAmount, gasVatAmount, finalElecAmount, finalGasAmount, finalAmount, paymentStatus, createdAt, updatedAt);
        System.out.println("new invoice data");
        System.out.println(newInvoiceData.toString());
        return newInvoiceData;
    }

    @FXML
    void onClickViewAllMeterReadings(MouseEvent event) throws IOException {
        Helper.setScene(event, "views/meter-readings/all-meter-readings.fxml");
    }

    @FXML
    void onDateChanged(Event event) {
        Helper.validateRequiredDateField(event);
    }

    @FXML
    void onTextChanged(KeyEvent event) {
        Helper.validateRequiredTextField(event);
    }

    /**
     * This method gets executed before loading the view.
     * @return void
     */
    public void initialize() {
        Serialization serializationHelper = new Serialization();
        ArrayList<Customer> allCustomers = serializationHelper.deserializeCustomers();
        if (newMeterReadingElecClosing == null) {
            ArrayList<MeterReading> allMeterReadings = serializationHelper.deserializeMeterReadings();
            for (MeterReading meterReading: allMeterReadings) {
                obMeterReadings.add(meterReading);
            }
            colMrOpeningDate.setCellValueFactory(data -> new ReadOnlyObjectWrapper(data.getValue().getOpeningDate()));
            colMrClosingDate.setCellValueFactory(data -> new ReadOnlyObjectWrapper(data.getValue().getClosingDate()));
            colMrGasKwh.setCellValueFactory(data -> new ReadOnlyObjectWrapper(data.getValue().getGasKwh()));
            colMrElecKwh.setCellValueFactory(data -> new ReadOnlyObjectWrapper(data.getValue().getElecKwh()));
            colMrElecNightKwh.setCellValueFactory(data -> new ReadOnlyObjectWrapper(data.getValue().getElecNightKwh()));
            colMrElecDayKwh.setCellValueFactory(data -> new ReadOnlyObjectWrapper(data.getValue().getElecDayKwh()));
            colMrCustomerName.setCellValueFactory(data -> new ReadOnlyObjectWrapper(data.getValue().getCustomerById(data.getValue().getCustomerId()).getName()));
//            colCustomerTariff.setCellValueFactory(data -> new ReadOnlyObjectWrapper(data.getValue().getCustomerTariff(data.getValue().getTariffId()).getName()));
            allMeterReadingsTable.setItems(obMeterReadings);
        }
        else {
            for (Customer customer: allCustomers) {
                obAllCustomers.add(customer.getName());
            }
            newMeterReadingCustomer.setItems(obAllCustomers);
            newMeterReadingCustomer.getSelectionModel().selectFirst();
            showHideInputs(allCustomers);
        }
    }

    @FXML
    void onCustomerSelectChange(Event event) {
        Serialization serializationHelper = new Serialization();
        ArrayList<Customer> allCustomers = serializationHelper.deserializeCustomers();
        showHideInputs(allCustomers);
    }

    /**
     * This method is used to view dynamic contnets based on customers
     * @param customers
     */
    public void showHideInputs(ArrayList<Customer> customers) {
        if (customers.size() > 0) {
            Customer selectedCustomer = new Customer();
            Customer selectedCustomerObj = selectedCustomer.getCustomerByName(newMeterReadingCustomer.getValue());
            Tariff tariffObj = new Tariff();
            Tariff currentTariff = tariffObj.getById(selectedCustomerObj.getTariffId());
            // fixed components
            Label[] fixedShowLabels = {labelElecOpening, labelElecClosing};
            TextField[] fixedShowTextFields = {newMeterReadingElecOpening, newMeterReadingElecClosing};
            Label[] fixedHideLabels = {labelElecNightOpening, labelElecNightClosing, labelElecDayOpening, labelElecDayClosing};
            TextField[] fixedHideTextFields = {newMeterReadingElecNightOpening, newMeterReadingNightClosing, newMeterReadingDayOpening, newMeterReadingDayClosing};
            // variable components
            Label[] variableShowLabels = {labelElecNightOpening, labelElecNightClosing, labelElecDayOpening, labelElecDayClosing};
            TextField[] variableShowTextFields = {newMeterReadingElecNightOpening, newMeterReadingNightClosing, newMeterReadingDayOpening, newMeterReadingDayClosing};
            Label[] variableHideLabels = {labelElecOpening, labelElecClosing};
            TextField[] variableHideTextFields = {newMeterReadingElecOpening, newMeterReadingElecClosing};
            if (currentTariff.getTariffType().toString() == "FIXED") {
                Helper.showHideLabelElement(fixedShowLabels, true);
                Helper.showHideTextFieldElement(fixedShowTextFields, true);
                Helper.showHideLabelElement(fixedHideLabels, false);
                Helper.showHideTextFieldElement(fixedHideTextFields, false);
            }
            else {
                Helper.showHideLabelElement(variableShowLabels, true);
                Helper.showHideTextFieldElement(variableShowTextFields, true);
                Helper.showHideLabelElement(variableHideLabels, false);
                Helper.showHideTextFieldElement(variableHideTextFields, false);
            }
        }
    }

}
