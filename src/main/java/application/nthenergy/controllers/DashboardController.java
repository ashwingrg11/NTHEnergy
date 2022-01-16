/*
 * DashboardController.java
 * Controller class to access properties and methods from model class,
 * handles user requests from dashboard.
 * @author: Ashwin Gurung
 */

package application.nthenergy.controllers;

import application.nthenergy.core.Helper;
import application.nthenergy.core.Serialization;
import application.nthenergy.models.Customer;
import application.nthenergy.models.Invoice;
import application.nthenergy.models.Tariff;
import application.nthenergy.models.User;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.ArrayList;

public class DashboardController {
    @FXML
    private HBox menuLogout;

    @FXML
    private HBox adminsMenuItem;

    @FXML
    private HBox customersMenuItem;

    @FXML
    private HBox customersReportMenuItem;

    @FXML
    private VBox dashboardMainMenu;

    @FXML
    private HBox dashboardMenuItem;

    @FXML
    private VBox dataMainMenu;

    @FXML
    private HBox invoicesMenuItem;

    @FXML
    private HBox meterReadingsMenuItem;

    @FXML
    private HBox paymentsMenuItem;

    @FXML
    private HBox paymentsReportMenuItem;

    @FXML
    private VBox reportMainMenu;

    @FXML
    private HBox tariffsMenuItem;

    @FXML
    private Button addCustomer;

    @FXML
    private Button viewCustomers;

    @FXML
    private Button viewInvoices;

    @FXML
    private Button viewPayments;

    @FXML
    private Label countAdminsLabel;

    @FXML
    private Label countCustomersLabel;

    @FXML
    private Label countInvoicesLabel;

    @FXML
    private Label countTariffsLabel;

    public void initialize() {
        if (countAdminsLabel != null) {
            Serialization serializationHelper = new Serialization();
            ArrayList<Invoice> allInvoices = serializationHelper.deserializeInvoices();
            ArrayList<Customer> allCustomers = serializationHelper.deserializeCustomers();
            ArrayList<User> allAdmins = serializationHelper.deserializeUsers();
            ArrayList<User> admins = new ArrayList<>();
            for (User user: allAdmins) {
                if (user.getUserType().toString() == "ADMIN") {
                    admins.add(user);
                }
            }
            ArrayList<Tariff> allTariffs = serializationHelper.deserializeTariffs();
            countAdminsLabel.setText((allAdmins.size()+""));
            countCustomersLabel.setText((allCustomers.size()+""));
            countInvoicesLabel.setText((allInvoices.size()+""));
            countTariffsLabel.setText((allTariffs.size()+""));
        }
    }

    @FXML
    void qaAddCustomer(MouseEvent event) throws IOException {
        Helper.setScene(event, "views/customers/new-customer.fxml");
    }

    @FXML
    void qaViewCustomers(MouseEvent event) throws IOException {
        Helper.setScene(event, "views/customers/all-customers.fxml");
    }

    @FXML
    void qaViewInvoices(MouseEvent event) throws IOException {
        Helper.setScene(event, "views/invoices/all-invoices.fxml");
    }

    @FXML
    void qaViewPayments(MouseEvent event) throws IOException {
        Helper.setScene(event, "views/payments/all-payments.fxml");
    }

    @FXML
    void onClickAdminsMenu(MouseEvent event) throws IOException {
        Helper.setScene(event, "views/admins/all-admins.fxml");
    }

    @FXML
    void onClickCustomersMenu(MouseEvent event) throws IOException {
        Helper.setScene(event, "views/customers/all-customers.fxml");
    }

    @FXML
    void onClickCustomersReportMenu(MouseEvent event) {

    }

    @FXML
    void onClickDashboardMenu(MouseEvent event) throws IOException {
        Helper.setScene(event, "views/dashboard-view.fxml");
    }

    @FXML
    void onClickInvoicesMenu(MouseEvent event) throws IOException {
        Helper.setScene(event, "views/invoices/all-invoices.fxml");
    }

    @FXML
    void onClickMeterReadingsMenu(MouseEvent event) throws IOException {
        Helper.setScene(event, "views/meter-readings/all-meter-readings.fxml");
    }

    @FXML
    void onClickPaymentsMenu(MouseEvent event) throws IOException {
        Helper.setScene(event, "views/payments/all-payments.fxml");
    }

    @FXML
    void onClickPaymentsReportMenu(MouseEvent event) {

    }

    @FXML
    void onClickTariffsMenu(MouseEvent event) throws IOException {
        Helper.setScene(event, "views/tariffs/all-tariffs.fxml");
    }

    @FXML
    void onClickLogoutMenu(MouseEvent event) throws IOException {
        Helper.setScene(event, "views/login-view.fxml");
    }

}