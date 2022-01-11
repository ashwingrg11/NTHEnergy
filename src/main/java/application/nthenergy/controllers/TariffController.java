/*
 * TariffController.java
 * Controller class to access properties and methods from model class,
 * handles user requests from tariff module's views.
 * @author: Ashwin Gurung
 */

package application.nthenergy.controllers;

import application.nthenergy.Dashboard;
import application.nthenergy.core.Helper;
import application.nthenergy.core.Serialization;
import application.nthenergy.core.enums.MeterType;
import application.nthenergy.core.enums.TariffType;
import application.nthenergy.models.Tariff;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import org.w3c.dom.Text;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class TariffController {
    @FXML
    private Button addTariffBtn;

    @FXML
    private Button deleteTariffBtn;

    @FXML
    private Button editTariffBtn;

    @FXML
    private Button cancelNewTariffBtn;

    @FXML
    private Button submitNewTariffBtn;

    @FXML
    private Button viewAllTariffsBtn;

    @FXML
    private ComboBox<String> tariffTypeCbx;

    @FXML
    private ComboBox<String> meterTypeCbx;

    @FXML
    private Label formMsg;

    private ObservableList<String> tariffTypeList = FXCollections.observableArrayList("FIXED", "VARIABLE");

    private ObservableList<String> meterTypeList = FXCollections.observableArrayList("DUALFUEL", "SMART", "DIGITAL");

    @FXML
    private TextArea newTariffDescriptionInput;

    @FXML
    private TextField newTariffElecDayRateInput;

    @FXML
    private TextField newTariffElecFixRateInput;

    @FXML
    private TextField newTariffElecNightRateInput;

    @FXML
    private TextField newTariffExitFeeInput;

    @FXML
    private TextField newTariffGasFixRateInput;

    @FXML
    private TextField newTariffGasVariableRateInput;

    @FXML
    private TextField newTariffNameInput;

    @FXML
    private TextField newTariffStandingFeeInput;

    @FXML
    private Label newTariffGasFixRateLabel;

    @FXML
    private Label newTariffElecFixRateLabel;

    @FXML
    private Label newTariffGasVariableRateLabel;

    @FXML
    private Label newTariffElecDayRateLabel;

    @FXML
    private Label newTariffElecNightRateLabel;

    /**
     * This method gets executed before loading the view.
     * @return void
     */
    public void initialize() {
        if (editTariffBtn != null) editTariffBtn.setDisable(true);
        if (deleteTariffBtn != null) deleteTariffBtn.setDisable(true);
        if (tariffTypeCbx != null){
            tariffTypeCbx.setItems(tariffTypeList);
            tariffTypeCbx.getSelectionModel().selectFirst();
            meterTypeCbx.setItems(meterTypeList);
            meterTypeCbx.getSelectionModel().selectFirst();
            newTariffGasVariableRateInput.setVisible(false);
            newTariffElecDayRateInput.setVisible(false);
            newTariffElecNightRateInput.setVisible(false);
            newTariffGasVariableRateLabel.setVisible(false);
            newTariffElecDayRateLabel.setVisible(false);
            newTariffElecNightRateLabel.setVisible(false);
        }

    }

    @FXML
    void onClickAddTariff(MouseEvent event) throws IOException {
        Helper.setScene(event, "views/tariffs/new-tariff.fxml");
    }

    @FXML
    void onClickViewAllTariffs(MouseEvent event) throws IOException {
        Helper.setScene(event, "views/tariffs/all-tariffs.fxml");
    }


    @FXML
    void onClickSubmitNewTariff(MouseEvent event) {
        TextField[] fields = {newTariffNameInput, newTariffStandingFeeInput, newTariffExitFeeInput };
        if(Helper.validateRequiredTextFields(submitNewTariffBtn, fields)) {
//            Serialization serializationHelper = new Serialization();
//            ArrayList<Tariff> allTariffs = serializationHelper.deserializeTariffs();
//            for (Tariff tariff: allTariffs) {
//                System.out.println(tariff.toString());
//            }
            Tariff newTariffData = makeNewTariff();
            Serialization serializationHelper = new Serialization();
            serializationHelper.serializeTariff(newTariffData);
            ArrayList<Tariff> allTariffs = serializationHelper.deserializeTariffs();
            Label formMsg = (Label) submitNewTariffBtn.getScene().lookup("#formMsg");
            formMsg.getStyleClass().removeAll("red-text");
            formMsg.getStyleClass().add("green-text");
            formMsg.setText("-  New tariff has been added successfully.");
        }
    }

    /**
     * This method is used to create new object of tariff while adding a new tariff.
     *
     * @return newTariffObj
     */
    private Tariff makeNewTariff() {
        int tariffId;
        File f = new File("./data/tariffs.txt");
        if(f.isFile()) {
            Serialization serializationHelper = new Serialization();
            ArrayList<Tariff> allTariffs = serializationHelper.deserializeTariffs();
            System.out.println(allTariffs.size()+"this is size.");
            tariffId = allTariffs.size() + 1;
            serializationHelper = null;
        }
        else {
            tariffId = 1;
        }
        String name = newTariffNameInput.getText();
        String description = newTariffDescriptionInput.getText();
        TariffType tariffType = TariffType.valueOf(tariffTypeCbx.getValue());
        MeterType meterType = MeterType.valueOf(meterTypeCbx.getValue());
        double exitFee = Double.parseDouble(newTariffExitFeeInput.getText());
        double standingFee = Double.parseDouble(newTariffStandingFeeInput.getText());
        double elecFixRate, gasFixRate, elecNightRate, elecDayRate, gasUnitRate;
        long createdAt = System.currentTimeMillis();
        long updatedAt = System.currentTimeMillis();
        if (tariffTypeCbx.getValue() == "FIXED") {
            elecFixRate = Double.parseDouble(newTariffElecFixRateInput.getText());
            gasFixRate = Double.parseDouble(newTariffGasFixRateInput.getText());
            elecNightRate = 0.00;
            elecDayRate = 0.00;
            gasUnitRate = 0.00;
        }
        else {
            elecNightRate = Double.parseDouble(newTariffElecNightRateInput.getText());
            elecDayRate = Double.parseDouble(newTariffElecDayRateInput.getText());
            gasUnitRate = Double.parseDouble(newTariffGasVariableRateInput.getText());
            elecFixRate = 0.00;
            gasFixRate = 0.00;
        }
        Tariff newTariffObj = new Tariff(tariffId, name, description, tariffType, meterType, elecFixRate, gasFixRate, exitFee, standingFee, elecNightRate, elecDayRate, gasUnitRate, createdAt, updatedAt);
//        System.out.println(newTariffObj.toString());
        return newTariffObj;
    }

    @FXML
    void onTextChanged(KeyEvent event) {
        Helper.validateRequiredTextField(event);
    }

    @FXML
    void onTariffTypeHidden(Event event) {
        System.out.println(event.getSource());
        System.out.println(tariffTypeCbx.getValue());
        // labels and inputs for fixed tariff type
        Label[] fixedShowLabels = {newTariffGasFixRateLabel, newTariffElecFixRateLabel};
        TextField[] fixedShowTextFields = {newTariffElecFixRateInput, newTariffGasFixRateInput};
        Label[] fixedHideLabels = {newTariffGasVariableRateLabel, newTariffElecDayRateLabel, newTariffElecNightRateLabel};
        TextField[] fixedHideTextFields = {newTariffGasVariableRateInput, newTariffElecDayRateInput, newTariffElecNightRateInput};
        // labels and inputs for variable tariff type
        Label[] variableShowLabels = {newTariffGasVariableRateLabel, newTariffElecDayRateLabel, newTariffElecNightRateLabel};
        TextField[] variableShowTextFields = {newTariffGasVariableRateInput, newTariffElecDayRateInput, newTariffElecNightRateInput};
        Label[] variableHideLabels = {newTariffElecFixRateLabel, newTariffGasFixRateLabel};
        TextField[] variableHideTextFields = {newTariffElecFixRateInput, newTariffGasFixRateInput};
        if (tariffTypeCbx.getValue() == "FIXED") {
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
