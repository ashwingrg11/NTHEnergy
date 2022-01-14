/*
 * InvoiceController.java
 * Controller class to access properties and methods from model class,
 * handles user requests from invoice module's views.
 * @author: Ashwin Gurung
 */

package application.nthenergy.controllers;

import application.nthenergy.core.Serialization;
import application.nthenergy.core.enums.PaymentStatus;
import application.nthenergy.models.Customer;
import application.nthenergy.models.Invoice;
import application.nthenergy.models.MeterReading;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;

public class InvoiceController {

    @FXML
    private TableView<Invoice> allInvoicesTable;

    @FXML
    private TableColumn<Invoice, LocalDate> colDateFrom;

    @FXML
    private TableColumn<Invoice, LocalDate> colDateUntil;

    @FXML
    private TableColumn<Invoice, Double> colFinalAmount;

    @FXML
    private TableColumn<Invoice, String> colCustomerName;

    @FXML
    private TableColumn<Invoice, Integer> colInvoiceId;

    @FXML
    private TableColumn<Invoice, PaymentStatus> colPaymentStatus;

    @FXML
    private Button viewInvoiceDetailsBtn;

    @FXML
    private Button makePaymentBtn;

    @FXML
    private Button sendInvoiceEmailBtn;


    ObservableList<Invoice> obAllInvoices = FXCollections.observableArrayList();

    @FXML
    void onClickViewInvoiceDetails(MouseEvent event) {

    }

    @FXML
    void onClickSendInvoiceEmailBtn(MouseEvent event) {
        Invoice selectedInvoice = allInvoicesTable.getSelectionModel().getSelectedItem();
        if (selectedInvoice == null) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Please select an invoice to send invoice email.");
            a.show();
        }
        else {

        }
    }

    @FXML
    void onClickMakePayment(MouseEvent event) {
        Invoice selectedInvoice = allInvoicesTable.getSelectionModel().getSelectedItem();
        if (selectedInvoice == null) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Please select an invoice to make a payment.");
            a.show();
        }
        else {
            int invoiceId = selectedInvoice.getInvoiceId();
            Serialization serializationHelper = new Serialization();
            ArrayList<Invoice> newInvoices = new ArrayList<>();
            ArrayList<Invoice> allInvoices = serializationHelper.deserializeInvoices();
            for (Invoice invoice: allInvoices) {
                if (invoice.getInvoiceId() == invoiceId) {
                    invoice.setPaymentStatus(PaymentStatus.PAID);
                }
                newInvoices.add(invoice);
            }
            serializationHelper.serializeAllInvoices(newInvoices);
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("Payment has been successfully made for the selected invoice.");
            a.show();
            obAllInvoices.removeAll(obAllInvoices);
            obAllInvoices.addAll(newInvoices);


        }
    }

    /**
     * This method gets executed before loading the view.
     * @return void
     */
    public void initialize() {
        DecimalFormat df = new DecimalFormat("#.##");
//        if (viewInvoiceDetailsBtn != null) viewInvoiceDetailsBtn.setDisable(true);
        Serialization serializationHelper = new Serialization();
        ArrayList<Invoice> allInvoices = serializationHelper.deserializeInvoices();
        for (Invoice invoice: allInvoices) {
            obAllInvoices.add(invoice);
        }
        colInvoiceId.setCellValueFactory(data -> new ReadOnlyObjectWrapper(data.getValue().getInvoiceId()));
        colDateFrom.setCellValueFactory(data -> new ReadOnlyObjectWrapper(data.getValue().getDateFrom()));
        colCustomerName.setCellValueFactory(data -> new ReadOnlyObjectWrapper(data.getValue().getCustomerById(data.getValue().getCustomerId()).getName()));
        colDateUntil.setCellValueFactory(data -> new ReadOnlyObjectWrapper(data.getValue().getDateUntil()));
        colFinalAmount.setCellValueFactory(data -> new ReadOnlyObjectWrapper(df.format(data.getValue().getFinalAmount())));
        colPaymentStatus.setCellValueFactory(data -> new ReadOnlyObjectWrapper(data.getValue().getPaymentStatus()));
        allInvoicesTable.setItems(obAllInvoices);
    }
}
