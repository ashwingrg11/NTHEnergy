/*
 * Helper.java
 * This class includes all static methods to access helper methods througout the application.
 *
 * @author: Ashwin Gurung
 */

package application.nthenergy.core;

import application.nthenergy.Dashboard;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.w3c.dom.Text;

import java.io.IOException;

public class Helper {

    /**
     * This method is used to set scene based on the received view.
     *
     * @param event
     * @param view
     * @throws IOException
     * @return void
     */
    public static void setScene(MouseEvent event, String view) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Dashboard.class.getResource(view));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("NTH Energy - Customer Data Platform");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * This method overrides the setSchene method with different type of parameters which is the instance of Stage.
     *
     * @param stage
     * @param view
     * @throws IOException
     */
    public static void setScene(Stage stage, String view) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Dashboard.class.getResource(view));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("NTH Energy - Customer Data Platform - Login");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * This method is used to validate multiple required input fields.
     * @param btn
     * @param fields
     */
    public static boolean validateRequiredTextFields(Button btn, TextField[] fields) {
        boolean flag = false;
        // loop through all required text fields
        for(TextField field : fields) {
            if(field.getText().equals("")) {
                field.getStyleClass().add("input-red-border");
                flag = true;
            }
        }
        // label to show validation error message
        Label formMsg = (Label) btn.getScene().lookup("#formMsg");
        if (flag){
            formMsg.getStyleClass().removeAll("green-text");
            formMsg.getStyleClass().add("red-text");
            formMsg.setText("*  Please provide the required information.");
            return false;
        }
        else {
            formMsg.setText("");
            formMsg.getStyleClass().removeAll("red-text");
            return true;
        }
    }

    /**
     * This method is used to validated single required text field.
     * @param event
     */
    public static void validateRequiredTextField(KeyEvent event) {
        TextField field = (TextField) event.getSource();
        if(field.getText().equals("")) {
            field.getStyleClass().add("input-red-border");
        }
        else {
            field.getStyleClass().removeAll("input-red-border");
        }
    }

    /**
     * This method validates required fields in login form, username/email and password
     * @param usernameEmail TextField
     * @param psw PasswordField
     * @return boolean
     */
    public static boolean validateLoginFields(TextField usernameEmail, PasswordField psw) {
        Label usernameEmailLabel = (Label) usernameEmail.getScene().lookup("#emailInputError");
        Label pswLabel = (Label) usernameEmail.getScene().lookup("#pswInputError");
        Label loginFormLabel = (Label) usernameEmail.getScene().lookup("#loginFormMsg");
        boolean validateFlag = true;
        // username or email input field
        if(usernameEmail.getText().equals("")) {
            usernameEmailLabel.setVisible(true);
            validateFlag = false;
        }
        else {
            usernameEmailLabel.setVisible(false);
        }
        // password input field
        if(psw.getText().equals("")) {
            pswLabel.setVisible(true);
            validateFlag = false;
        }
        else {
            pswLabel.setVisible(false);
        }
        // display message to the login form label
        if(!validateFlag) {
            loginFormLabel.getStyleClass().add("red-text");
            loginFormLabel.setText("Please provide the required information.");
        }
        return validateFlag;
    }


}
