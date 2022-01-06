/*
 * InvoiceController.java
 * Controller class to access properties and methods from model class,
 * handles user requests from invoice module's views.
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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class InvoiceController {

    @FXML
    private Button viewInvoiceDetailsBtn;

    @FXML
    void onClickViewInvoiceDetails(MouseEvent event) {

    }

    /**
     * This method gets executed before loading the view.
     * @return void
     */
    public void initialize() {
        if (viewInvoiceDetailsBtn != null) viewInvoiceDetailsBtn.setDisable(true);
    }
}
