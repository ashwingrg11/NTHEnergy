/*
 * TariffController.java
 * Controller class to access properties and methods from model class,
 * handles user requests from tariff module's views.
 * @author: Ashwin Gurung
 */

package application.nthenergy.controllers;

import application.nthenergy.Dashboard;
import application.nthenergy.core.Helper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import org.w3c.dom.Text;

import java.io.IOException;

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
    private TextField newTariffNameInput;

    @FXML
    private TextField newTariffStandingFeeInput;

    @FXML
    private TextField newTariffExitFeeInput;

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
            Label formMsg = (Label) submitNewTariffBtn.getScene().lookup("#formMsg");
            formMsg.getStyleClass().removeAll("red-text");
            formMsg.getStyleClass().add("green-text");
            formMsg.setText("-  New tariff has been added successfully.");
        }
    }

    @FXML
    void onTextChanged(KeyEvent event) {
        Helper.validateRequiredTextField(event);
    }
}
