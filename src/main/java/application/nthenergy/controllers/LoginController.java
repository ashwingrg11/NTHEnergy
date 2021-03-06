/*
 * LoginController.java
 * Controller class to access properties and methods from model class,
 * handles user requests from login views.
 * @author: Ashwin Gurung
 */

package application.nthenergy.controllers;

import application.nthenergy.core.Helper;
import application.nthenergy.core.Serialization;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    private Label emailInputError;

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
    private Label pswInputError;

    @FXML
    private PasswordField pswInput;

    @FXML
    private Label pswInputLabel;

    @FXML
    private Label loginFormMsg;

    public void initialize() {
        emailInputError.setVisible(false);
        pswInputError.setVisible(false);
    }

    @FXML
    void onClickLoginBtn(MouseEvent event) throws IOException {
        if(Helper.validateLoginFields(emailInput, pswInput) && Helper.checkLoginEmail(emailInput, loginBtn)) {
            Serialization serializationHelper = new Serialization();
            if (!serializationHelper.validateLoginCredentials(emailInput.getText(), pswInput.getText())) {
                Label loginFormLabel = (Label) emailInput.getScene().lookup("#loginFormMsg");
                loginFormLabel.getStyleClass().add("red-text");
                loginFormLabel.setText("You have entered an invalid email or password. Please try again.");
            }
            else {
                Helper.setScene(event, "views/dashboard-view.fxml");
            }
        }
    }
}
