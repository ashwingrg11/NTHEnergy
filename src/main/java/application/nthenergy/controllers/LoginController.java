/*
 * LoginController.java
 * Controller class to access properties and methods from model class,
 * handles user requests from login views.
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
import javafx.scene.input.MouseEvent;
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
//        emailInput.setFocusTraversable(false);
//        pswInput.setFocusTraversable(false);
        emailInputError.setVisible(false);
        pswInputError.setVisible(false);
    }

    @FXML
    void onClickLoginBtn(MouseEvent event) throws IOException {
        if(Helper.validateLoginFields(emailInput, pswInput)) {
            Helper.setScene(event, "views/dashboard-view.fxml");
        }
    }
}
