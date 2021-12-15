/*
 * TariffController.java
 * Controller class to access properties and methods from model class,
 * handles user requests from tariff module's views.
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

public class TariffController {
    @FXML
    private Button addTariffBtn;

    @FXML
    private Button deleteTariffBtn;

    @FXML
    private Button editTariffBtn;

    @FXML
    private Button cancelNewTariffBtn;

    @FXML
    private Button submitNewTariffBtn;

    @FXML
    private Button viewAllTariffsBtn;

    /**
     * This method gets executed before loading the view.
     * @param none
     * @return void
     */
    public void initialize() {
        if (editTariffBtn != null) editTariffBtn.setDisable(true);
        if (deleteTariffBtn != null) deleteTariffBtn.setDisable(true);
    }

    @FXML
    void onClickAddTariff(MouseEvent event) throws IOException {
        Helper.setScene(event, "views/tariffs/new-tariff.fxml");
    }

    @FXML
    void onClickViewAllTariffs(MouseEvent event) throws IOException {
        Helper.setScene(event, "views/tariffs/all-tariffs.fxml");
    }
}
