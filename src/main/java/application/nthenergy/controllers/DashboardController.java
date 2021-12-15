/*
 * DashboardController.java
 * Controller class to access properties and methods from model class,
 * handles user requests from dashboard.
 * @author: Ashwin Gurung
 */

package application.nthenergy.controllers;

import application.nthenergy.Dashboard;
import application.nthenergy.core.Helper;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;

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
    void onClickAdminsMenu(MouseEvent event) {

    }

    @FXML
    void onClickCustomersMenu(MouseEvent event) {

    }

    @FXML
    void onClickCustomersReportMenu(MouseEvent event) {

    }

    @FXML
    void onClickDashboardMenu(MouseEvent event) throws IOException {
        Helper.setScene(event, "views/dashboard-view.fxml");
    }

    @FXML
    void onClickInvoicesMenu(MouseEvent event) {

    }

    @FXML
    void onClickMeterReadingsMenu(MouseEvent event) {

    }

    @FXML
    void onClickPaymentsMenu(MouseEvent event) {

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