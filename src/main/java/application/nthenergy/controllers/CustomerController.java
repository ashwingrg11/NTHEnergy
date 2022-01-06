/*
 * CustomerController.java
 * Controller class to access properties and methods from model class,
 * handles user requests from customer module's views.
 * @author: Ashwin Gurung
 */

package application.nthenergy.controllers;

import application.nthenergy.core.Helper;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

import java.io.IOException;
import java.time.LocalDate;

public class CustomerController {
    @FXML
    private Button addCustomerBtn;

    @FXML
    private Button deleteCustomerBtn;

    @FXML
    private Button editCustomerBtn;

    @FXML
    private Button cancelNewTariffBtn;

    @FXML
    private Label formMsg;

    @FXML
    private TextField newCustomerAccountNumber;

    @FXML
    private TextField newCustomerAddressLineOne;

    @FXML
    private TextField newCustomerAlternateContactNo;

    @FXML
    private TextField newCustomerBankName;

    @FXML
    private TextField newCustomerCardNumber;

    @FXML
    private TextField newCustomerEmail;

    @FXML
    private TextField newCustomerFirstName;

    @FXML
    private DatePicker newCustomerJoinDate;

    @FXML
    private TextField newCustomerLastName;

    @FXML
    private TextField newCustomerMeterNumber;

    @FXML
    private TextField newCustomerMiddleName;

    @FXML
    private TextField newCustomerMobNo;

    @FXML
    private TextField newCustomerPassword;

    @FXML
    private TextField newCustomerPostCode;

    @FXML
    private ComboBox<?> newCustomerTariff;

    @FXML
    private DatePicker newCustomerTariffEndDate;

    @FXML
    private DatePicker newCustomerTariffStartDate;

    @FXML
    private TextField newCustomerTownCity;

    @FXML
    private TextField newCustomerUsername;

    @FXML
    private TextField newCustomerNameOnCard;

    @FXML
    private TextField newCustomerCvv;

    @FXML
    private DatePicker newCustomerCardExpiryDate;

    @FXML
    private Button submitNewCustomerBtn;

    @FXML
    private Button viewAllCustomersBtn;

    @FXML
    private Button viewCustomerDetails;

    @FXML
    void onClickAddCustomer(MouseEvent event) throws IOException {
        Helper.setScene(event, "views/customers/new-customer.fxml");
    }

    @FXML
    void onClickViewCustomerDetails(MouseEvent event) {

    }

    /**
     * This method gets executed before loading the view.
     * @return void
     */
    public void initialize() {
        if (editCustomerBtn != null) editCustomerBtn.setDisable(true);
        if (deleteCustomerBtn != null) deleteCustomerBtn.setDisable(true);
    }

    @FXML
    void onClickSubmitNewCustomer(MouseEvent event) {
        TextField[] fields = {newCustomerFirstName, newCustomerLastName, newCustomerEmail, newCustomerPassword, newCustomerMobNo, newCustomerPostCode, newCustomerTownCity, newCustomerMeterNumber, newCustomerAddressLineOne, newCustomerBankName, newCustomerAccountNumber, newCustomerCardNumber, newCustomerNameOnCard, newCustomerCvv};
        DatePicker[] dates = {newCustomerCardExpiryDate, newCustomerJoinDate, newCustomerTariffStartDate, newCustomerTariffEndDate};
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
        Label formMsg = (Label) submitNewCustomerBtn.getScene().lookup("#formMsg");
        if (flag){
            formMsg.getStyleClass().removeAll("green-text");
            formMsg.getStyleClass().add("red-text");
            formMsg.setText("*  Please provide the required information.");
        }
        else {
            formMsg.setText("");
            formMsg.getStyleClass().removeAll("red-text");
        }
        if(Helper.validateRequiredTextFields(submitNewCustomerBtn, fields)) {
            if (Helper.emailValidate(newCustomerEmail, submitNewCustomerBtn)) {
                formMsg.getStyleClass().removeAll("red-text");
                formMsg.getStyleClass().add("green-text");
                formMsg.setText("-  New customer has been added successfully.");
            }
        }
    }

    @FXML
    void onClickViewAllCustomers(MouseEvent event) throws IOException {
        Helper.setScene(event, "views/customers/all-customers.fxml");
    }

    @FXML
    void onTextChanged(KeyEvent event) {
        Helper.validateRequiredTextField(event);
    }

    @FXML
    void onDateChanged(Event event) {
        Helper.validateRequiredDateField(event);
    }


}
