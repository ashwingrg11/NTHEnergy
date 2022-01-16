/*
 * AdminController.java
 * Controller class to access properties and methods from model class,
 * handles user requests from admin module's views.
 * @author: Ashwin Gurung
 */
package application.nthenergy.controllers;

import application.nthenergy.core.Helper;
import application.nthenergy.core.Serialization;
import application.nthenergy.models.User;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;

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
    private TableView<User> allAdminsTable;

    @FXML
    private TableColumn<User, Integer> colAdminId;

    @FXML
    private TableColumn<User, LocalDate> colCreatedAt;

    @FXML
    private TableColumn<User, String> colEmail;

    @FXML
    private TableColumn<User, String> colMobileNo;

    @FXML
    private TableColumn<User, String> colName;

    @FXML
    private TableColumn<User, String> colRemarks;

    ObservableList<User> obAllAdmins = FXCollections.observableArrayList();

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
//                formMsg.getStyleClass().removeAll("red-text");
//                formMsg.getStyleClass().add("green-text");
//                formMsg.setText("-  New admin has been added successfully.");
            }
        }
    }

    /**
     * This method gets executed before loading the view.
     * @return void
     */
    public void initialize() {
        if (newAdminFirstName == null) {
            DateFormat dateF = new SimpleDateFormat("dd MMM yyyy hh:mm:ss");
            Serialization serializationHelper = new Serialization();
            ArrayList<User> allUsers = serializationHelper.deserializeUsers();
            for (User user: allUsers) {
                if (user.getUserType().toString() == "ADMIN") {
                    obAllAdmins.add(user);
                }
            }
            colAdminId.setCellValueFactory(data -> new ReadOnlyObjectWrapper(data.getValue().getUserId()));
            colCreatedAt.setCellValueFactory(data -> new ReadOnlyObjectWrapper(dateF.format(data.getValue().getCreatedAt())));
            colName.setCellValueFactory(data -> new ReadOnlyObjectWrapper(data.getValue().getFirstName() +" "+data.getValue().getLastName()));
            colEmail.setCellValueFactory(data -> new ReadOnlyObjectWrapper(data.getValue().getEmail()));
            colMobileNo.setCellValueFactory(data -> new ReadOnlyObjectWrapper(data.getValue().getMobNo()));
            allAdminsTable.setItems(obAllAdmins);
        }
    }
}
