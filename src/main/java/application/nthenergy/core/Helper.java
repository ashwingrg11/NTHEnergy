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



}
