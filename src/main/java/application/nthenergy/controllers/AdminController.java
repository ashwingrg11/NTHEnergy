/*
 * AdminController.java
 * Controller class to access properties and methods from model class,
 * handles user requests from admin module's views.
 * @author: Ashwin Gurung
 */
package application.nthenergy.controllers;

import application.nthenergy.Dashboard;
import application.nthenergy.core.Helper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminController {
    @FXML
    private Button cancelNewTariffBtn;

    @FXML
    private Label formMsg;

    @FXML
    private TextField newAdminEmail;

    @FXML
    private TextField newAdminFirstName;

    @FXML
    private TextField newAdminLastName;

    @FXML
    private TextField newAdminMiddleName;

    @FXML
    private TextField newAdminMobNo;

    @FXML
    private TextField newAdminPassword;

    @FXML
    private TextField newAdminUsername;

    @FXML
    private Button submitNewAdminBtn;

    @FXML
    private Button viewAllAdminsBtn;

    @FXML
    private Button addAdminBtn;

    @FXML
    private Button deleteAdminBtn;

    @FXML
    private Button editAdminBtn;


    @FXML
    void onClickAddAdmin(MouseEvent event) throws IOException {
        Helper.setScene(event, "views/admins/new-admin.fxml");
    }

    @FXML
    void onClickViewAllAdmins(MouseEvent event) throws IOException {
        Helper.setScene(event, "views/admins/all-admins.fxml");
    }

    @FXML
    void onTextChanged(KeyEvent event) {

    }

    @FXML
    void onClickSubmitNewAdmin(MouseEvent event) {
        TextField[] fields = {newAdminFirstName, newAdminLastName, newAdminEmail, newAdminPassword, newAdminMobNo};
        if(Helper.validateRequiredTextFields(submitNewAdminBtn, fields)) {
            if (Helper.emailValidate(newAdminEmail, submitNewAdminBtn)) {
                formMsg.getStyleClass().removeAll("red-text");
                formMsg.getStyleClass().add("green-text");
                formMsg.setText("-  New admin has been added successfully.");
            }
        }
    }

    /**
     * This method gets executed before loading the view.
     * @return void
     */
    public void initialize() {
        if (editAdminBtn != null) editAdminBtn.setDisable(true);
        if (deleteAdminBtn != null) deleteAdminBtn.setDisable(true);
    }
}
