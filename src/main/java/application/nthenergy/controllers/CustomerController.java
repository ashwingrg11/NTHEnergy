/*
 * CustomerController.java
 * Controller class to access properties and methods from model class,
 * handles user requests from customer module's views.
 * @author: Ashwin Gurung
 */

package application.nthenergy.controllers;

import application.nthenergy.core.Helper;
import application.nthenergy.core.Serialization;
import application.nthenergy.core.enums.AccountStatus;
import application.nthenergy.core.enums.UserType;
import application.nthenergy.models.Customer;
import application.nthenergy.models.CustomerCard;
import application.nthenergy.models.Tariff;
import application.nthenergy.models.User;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.KeyEvent;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

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
    private ComboBox<String> newCustomerTariff;

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
    private TableView<Customer> allCustomerTable;

    @FXML
    private TableColumn<Customer, String> colCustomerAddressOne;

    @FXML
    private TableColumn<Customer, String> colCustomerEmail;

    @FXML
    private TableColumn<Customer, Integer> colCustomerId;

    @FXML
    private TableColumn<Customer, Date> colCustomerJoinDate;

    @FXML
    private TableColumn<Customer, String> colCustomerMeter;

    @FXML
    private TableColumn<Customer, String> colCustomerMobNo;

    @FXML
    private TableColumn<Customer, String> colCustomerName;

    @FXML
    private TableColumn<Customer, String> colCustomerPostCode;

    @FXML
    private TableColumn<Customer, String> colCustomerTariff;

    ObservableList<Customer> obAllCustomers = FXCollections.observableArrayList();
    private ObservableList<String> obAllTariffs = FXCollections.observableArrayList();

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
        Serialization serializationHelper = new Serialization();
        if (newCustomerEmail == null) {
            ArrayList<Customer> allCustomers = serializationHelper.deserializeCustomers();
            ArrayList<Tariff> availableTariffs = serializationHelper.deserializeTariffs();
            for (Customer customer: allCustomers) {
                obAllCustomers.add(customer);
            }
            colCustomerId.setCellValueFactory(data -> new ReadOnlyObjectWrapper(data.getValue().getCustomerId()));
            colCustomerName.setCellValueFactory(data -> new ReadOnlyObjectWrapper(data.getValue().getName()));
            colCustomerEmail.setCellValueFactory(data -> new ReadOnlyObjectWrapper(data.getValue().getName()));
            colCustomerTariff.setCellValueFactory(data -> new ReadOnlyObjectWrapper(data.getValue().getCustomerTariff(data.getValue().getTariffId()).getName()));
            colCustomerMeter.setCellValueFactory(data -> new ReadOnlyObjectWrapper(data.getValue().getMeterNumber()));
            colCustomerJoinDate.setCellValueFactory(data -> new ReadOnlyObjectWrapper(data.getValue().getJoinDate()));
            colCustomerMobNo.setCellValueFactory(data -> new ReadOnlyObjectWrapper(data.getValue().getMobNo()));
            colCustomerPostCode.setCellValueFactory(data -> new ReadOnlyObjectWrapper(data.getValue().getPostCode()));
            colCustomerAddressOne.setCellValueFactory(data -> new ReadOnlyObjectWrapper(data.getValue().getAddressOne()));
            allCustomerTable.setItems(obAllCustomers);
        }
        else {
            ArrayList<Tariff> allTariffs = serializationHelper.deserializeTariffs();
            for (Tariff tariff: allTariffs) {
                obAllTariffs.add(tariff.getName());
            }
            newCustomerTariff.setItems(obAllTariffs);
            newCustomerTariff.getSelectionModel().selectFirst();
        }
    }

    @FXML
    void onClickSubmitNewCustomer(MouseEvent event) {
        TextField[] fields = {newCustomerFirstName, newCustomerLastName, newCustomerEmail, newCustomerPassword, newCustomerMobNo, newCustomerPostCode, newCustomerTownCity, newCustomerMeterNumber, newCustomerAddressLineOne, newCustomerBankName, newCustomerAccountNumber, newCustomerCardNumber, newCustomerNameOnCard, newCustomerCvv};
        DatePicker[] dates = {newCustomerCardExpiryDate, newCustomerJoinDate, newCustomerTariffStartDate, newCustomerTariffEndDate};
        ComboBox[] cmbFields = {newCustomerTariff};
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
        if(Helper.validateRequiredTextFields(submitNewCustomerBtn, fields) && Helper.validateRequiredComboBoxFields(submitNewCustomerBtn, cmbFields)) {
            if (Helper.emailValidate(newCustomerEmail, submitNewCustomerBtn)) {
                User newUserData = makeNewUser();
                int userId = newUserData.getUserId();
                Customer newCustomerData = makeNewCustomer(userId);
                int customerId = newCustomerData.getCustomerId();
                CustomerCard newCustomerCardData = makeNewCustomerCard(customerId);
                Serialization serializationHelper = new Serialization();
                serializationHelper.serializeUser(newUserData);
                serializationHelper.serializeCustomer(newCustomerData);
                serializationHelper.serializeCustomerCard(newCustomerCardData);
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

    /**
     * This method is used to create new object of user while adding a new customer.
     *
     * @return newUserObj
     */
    private User makeNewUser() {
        int userId;
        File f = new File("./data/users.txt");
        if(f.isFile()) {
            Serialization serializationHelper = new Serialization();
            ArrayList<User> allUsers = serializationHelper.deserializeUsers();
            if (allUsers.size() > 0) {
                userId = allUsers.get(allUsers.size() - 1).getUserId() + 1;
            }
            else {
                userId = 1;
            }
        }
        else {
            userId = 1;
        }
        // user
        String firstName = newCustomerFirstName.getText();
        String middleName = newCustomerMiddleName.getText();
        String lastName = newCustomerLastName.getText();
        UserType userType = UserType.CUSTOMER;
        String email = newCustomerEmail.getText();
        String username = newCustomerUsername.getText();
        String password = newCustomerPassword.getText();
        String mobNo = newCustomerMobNo.getText();
        AccountStatus accountStatus = AccountStatus.ACTIVE;
        String remarks = "";
        long createdAt = System.currentTimeMillis();
        long updatedAt = System.currentTimeMillis();
        User newUserObj = new User(userId, firstName, middleName, lastName, userType, email, username, password, mobNo, accountStatus, remarks, createdAt, updatedAt);
        return newUserObj;
    }


    /**
     * This method is used to create new object of customer while adding a new customer.
     *
     * @param userId
     * @return newCustomerObj
     */
    private Customer makeNewCustomer(int userId) {
        int customerId;
        File f = new File("./data/customers.txt");
        Serialization serializationHelper = new Serialization();
        if(f.isFile()) {
            ArrayList<Customer> allCustomers = serializationHelper.deserializeCustomers();
            if (allCustomers.size() > 0) {
                customerId = allCustomers.get(allCustomers.size() - 1).getCustomerId() + 1;
            }
            else {
                customerId = 1;
            }
        }
        else {
            customerId = 1;
        }
        // customer
        // tariff id
        int selectedIndex = newCustomerTariff.getSelectionModel().getSelectedIndex();
        ArrayList<Tariff> myTariffs = serializationHelper.deserializeTariffs();
        int tariffId = myTariffs.get(selectedIndex).getTariffId();
        String name;
        if (newCustomerMiddleName.getText() == "") {
            name = newCustomerFirstName.getText() + " " + newCustomerLastName.getText();
        }
        else {
            name = newCustomerFirstName.getText() + " " + newCustomerMiddleName.getText() + " " + newCustomerLastName.getText();
        }
        String mobNo = newCustomerMobNo.getText();
        String email = newCustomerEmail.getText();
        String postCode = newCustomerPostCode.getText();
        String addressOne = newCustomerAddressLineOne.getText();
        String addressTwo = "";
        String townCity = newCustomerTownCity.getText();
        String county = "";
        LocalDate joinDate = newCustomerJoinDate.getValue();
        LocalDate tariffStartDate = newCustomerTariffStartDate.getValue();
        LocalDate tariffEndDate = newCustomerTariffEndDate.getValue();
        String meterNumber = newCustomerMeterNumber.getText();
        String alternateContactNo = newCustomerAlternateContactNo.getText();
        long createdAt = System.currentTimeMillis();
        long updatedAt = System.currentTimeMillis();
        Customer newCustomerObj = new Customer(customerId, userId, tariffId, name, mobNo, email, postCode, addressOne, addressTwo, townCity, county, joinDate, tariffStartDate, tariffEndDate, meterNumber, alternateContactNo, createdAt, updatedAt);
        return newCustomerObj;
    }

    /**
     * This method is used to create new object of customer card while adding a new customer.
     *
     * @return newCustomerCardObj
     */
    private CustomerCard makeNewCustomerCard(int customerId) {
        int customerCardId;
        File f = new File("./data/customer-cards.txt");
        if(f.isFile()) {
            Serialization serializationHelper = new Serialization();
            ArrayList<CustomerCard> allCustomerCards = serializationHelper.deserializeCustomerCards();
            if (allCustomerCards.size() > 0) {
                customerCardId = allCustomerCards.get(allCustomerCards.size() - 1).getCustomerCardId() + 1;
            }
            else {
                customerCardId = 1;
            }
        }
        else {
            customerCardId = 1;
        }
        // customer card attributes
        String bankName = newCustomerBankName.getText();
        String accountNumber = newCustomerAccountNumber.getText();
        String cardNumber = newCustomerCardNumber.getText();
        String nameOnCard = newCustomerNameOnCard.getText();
        LocalDate expiryDate = newCustomerCardExpiryDate.getValue();
        String cvv = newCustomerCvv.getText();
        long createdAt = System.currentTimeMillis();
        long updatedAt = System.currentTimeMillis();
        CustomerCard newCustomerCardObj = new CustomerCard(customerCardId, customerId, bankName, accountNumber, cardNumber, nameOnCard, expiryDate, cvv, createdAt, updatedAt);
        return newCustomerCardObj;
    }

    @FXML
    void onClickDeleteCustomerBtn(MouseEvent event) {
        Customer selectedCustomer = allCustomerTable.getSelectionModel().getSelectedItem();
        if (selectedCustomer == null) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Please select a customer you want to delete.");
            a.show();
        }
        else {
            Serialization serializationHelper = new Serialization();
            ArrayList<Customer> allCustomers = serializationHelper.deserializeCustomers();
            int deleteIdCustomer = selectedCustomer.getCustomerId();
            int deleteUserId = selectedCustomer.getUserId();
            // delete customer
            ArrayList<Customer> newCustomers = new ArrayList<>();
            for (Customer customer: allCustomers) {
                if (customer.getCustomerId() != deleteIdCustomer) {
                    newCustomers.add(customer);
                }
            }
            serializationHelper.serializeAllCustomers(newCustomers);
            // delete user
            ArrayList<User> allUsers = serializationHelper.deserializeUsers();
            ArrayList<User> newUsers = new ArrayList<>();
            for (User user: allUsers) {
                if (user.getUserId() != deleteUserId) {
                    newUsers.add(user);
                }
            }
            serializationHelper.serializeAllUsers(newUsers);
            // delete customer card
            ArrayList<CustomerCard> allCustomerCards = serializationHelper.deserializeCustomerCards();
            ArrayList<CustomerCard> newCustomerCards = new ArrayList<>();
            for (CustomerCard customerCard: allCustomerCards) {
                if (customerCard.getCustomerId() != deleteIdCustomer) {
                    newCustomerCards.add(customerCard);
                }
            }
            serializationHelper.serializeAllCustomerCards(newCustomerCards);
            allCustomerTable.getItems().remove(selectedCustomer);
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("Selected customer has been deleted successfully.");
            a.show();
        }
    }


}
