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
import application.nthenergy.models.Customer;
import application.nthenergy.models.Tariff;
import javafx.beans.property.ReadOnlyIntegerWrapper;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
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

    @FXML
    private TableView<Tariff> allTariffsTable;

    @FXML
    private TableColumn<Tariff, Double> colElecDayRate;

    @FXML
    private TableColumn<Tariff, Double> colElecFixRate;

    @FXML
    private TableColumn<Tariff, Double> colElecNightRate;

    @FXML
    private TableColumn<Tariff, Double> colExitFee;

    @FXML
    private TableColumn<Tariff, Double> colGasFixRate;

    @FXML
    private TableColumn<Tariff, Double> colGasVariableRate;

    @FXML
    private TableColumn<Tariff, MeterType> colMeterType;

    @FXML
    private TableColumn<Tariff, Double> colStandingFee;

    @FXML
    private TableColumn<Tariff, Integer> colTariffId;

    @FXML
    private TableColumn<Tariff, String> colTariffName;

    @FXML
    private TableColumn<Tariff, TariffType> colTariffType;

    ObservableList<Tariff> obAllTariffs = FXCollections.observableArrayList();

    /**
     * This method gets executed before loading the view.
     * @return void
     */
    public void initialize() {
//        if (editTariffBtn != null) editTariffBtn.setDisable(true);
//        if (deleteTariffBtn != null) deleteTariffBtn.setDisable(true);
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
        else {
            Serialization serializationHelper = new Serialization();
            ArrayList<Tariff> allTariffs = serializationHelper.deserializeTariffs();
            for (Tariff tariff: allTariffs) {
                obAllTariffs.add(tariff);
            }
            colTariffId.setCellValueFactory(data -> new ReadOnlyObjectWrapper(data.getValue().getTariffId()));
            colTariffName.setCellValueFactory(data -> new ReadOnlyObjectWrapper(data.getValue().getName()));
            colTariffType.setCellValueFactory(data -> new ReadOnlyObjectWrapper(data.getValue().getTariffType()));
            colMeterType.setCellValueFactory(data -> new ReadOnlyObjectWrapper(data.getValue().getMeterType()));
            colElecFixRate.setCellValueFactory(data -> new ReadOnlyObjectWrapper(data.getValue().getElecFixRate()));
            colElecNightRate.setCellValueFactory(data -> new ReadOnlyObjectWrapper(data.getValue().getElecNightRate()));
            colElecDayRate.setCellValueFactory(data -> new ReadOnlyObjectWrapper(data.getValue().getElecDayRate()));
            colGasFixRate.setCellValueFactory(data -> new ReadOnlyObjectWrapper(data.getValue().getGasFixRate()));
            colGasVariableRate.setCellValueFactory(data -> new ReadOnlyObjectWrapper(data.getValue().getGasUnitRate()));
            colStandingFee.setCellValueFactory(data -> new ReadOnlyObjectWrapper(data.getValue().getStandingFee()));
            colExitFee.setCellValueFactory(data -> new ReadOnlyObjectWrapper(data.getValue().getExitFee()));
            allTariffsTable.setItems(obAllTariffs);
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
//            ArrayList<Tariff> allTariffs = serializationHelper.deserializeTariffs();
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
            tariffId = allTariffs.get(allTariffs.size() - 1).getTariffId() + 1;
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
        return newTariffObj;
    }

    @FXML
    void onTextChanged(KeyEvent event) {
        Helper.validateRequiredTextField(event);
    }

    @FXML
    void onTariffTypeHidden(Event event) {
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


    @FXML
    void deleteTariffBtnClick(MouseEvent event) {
        Tariff selectedTariff = allTariffsTable.getSelectionModel().getSelectedItem();
        if ( selectedTariff == null) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Please select a tariff you want to delete.");
            a.show();
        }
        else {
            Serialization serializationHelper = new Serialization();
            ArrayList<Tariff> allTariffs = serializationHelper.deserializeTariffs();
            ArrayList<Customer> allCustomers = serializationHelper.deserializeCustomers();
            int deleteId = selectedTariff.getTariffId();
            boolean deleteFlag = true;
            for (Customer customer: allCustomers) {
                if (customer.getTariffId() == deleteId) {
                    Alert a = new Alert(Alert.AlertType.ERROR);
                    a.setContentText("This tariff cannot be deleted because it's being used by customers.");
                    a.show();
                    deleteFlag = false;
                    break;
                }
            }
            if (deleteFlag) {
                ArrayList<Tariff> newTariffs = new ArrayList<>();
                for (Tariff tariff: allTariffs) {
                    if (tariff.getTariffId() != deleteId) {
                        newTariffs.add(tariff);
                    }
                }
                serializationHelper.serializeAllTariffs(newTariffs);
                allTariffsTable.getItems().remove(selectedTariff);
                Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setContentText("Selected tariff has been deleted successfully.");
                a.show();
            }
        }
    }

}
