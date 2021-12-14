/*
 * LoginController.java
 * Controller class to access properties and methods from model class,
 * handles user requests from login views.
 * @author: Ashwin Gurung
 */

package application.nthenergy.controllers;

import application.nthenergy.Dashboard;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    private Label emailErrorLabel;

    @FXML
    private TextField emailInput;

    @FXML
    private Label emailInputLabel;

    @FXML
    private Button loginBtn;

    @FXML
    private Label loginText;

    @FXML
    private Label loginTitle;

    @FXML
    private Label pswErrorLabel;

    @FXML
    private PasswordField pswInput;

    @FXML
    private Label pswInputLabel;

    @FXML
    void loginBtnClicked(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Dashboard.class.getResource("views/dashboard-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("NTH Energy - Customer Data Platform - Login");
        stage.setScene(scene);
        stage.show();
    }

    public void initialize() {
//        emailInput.setFocusTraversable(false);
        emailErrorLabel.setVisible(false);
        pswErrorLabel.setVisible(false);
    }

}
