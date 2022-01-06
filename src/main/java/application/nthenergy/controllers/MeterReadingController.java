/*
 * MeterReadingController.java
 * Controller class to access properties and methods from model class,
 * handles user requests from meter reading module's views.
 * @author: Ashwin Gurung
 */

package application.nthenergy.controllers;

import application.nthenergy.Dashboard;
import application.nthenergy.core.Helper;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

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
    void onClickAddMeterReading(MouseEvent event) throws IOException {
        Helper.setScene(event, "views/meter-readings/new-meter-reading.fxml");
    }

    @FXML
    void onClickSubmitNewMeterReading(MouseEvent event) {
        TextField[] fields = {newMeterReadingGasOpening, newMeterReadingGasClosing};
        DatePicker[] dates = {newMeterReadingOpeningDate, newMeterReadingClosingDate};
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
        }
        if(Helper.validateRequiredTextFields(submitNewMerterReadingBtn, fields)) {
            formMsg.getStyleClass().removeAll("red-text");
            formMsg.getStyleClass().add("green-text");
            formMsg.setText("-  New meter reading has been saved successfully.");
        }
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
        if (editMeterReadingBtn != null) editMeterReadingBtn.setDisable(true);
        if (deleteMeterReadiingBtn != null) deleteMeterReadiingBtn.setDisable(true);
    }
}
