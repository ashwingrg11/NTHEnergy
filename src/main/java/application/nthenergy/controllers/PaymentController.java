/*
 * PaymentController.java
 * Controller class to access properties and methods from model class,
 * handles user requests from payment module's views.
 * @author: Ashwin Gurung
 */

package application.nthenergy.controllers;

import application.nthenergy.core.Serialization;
import application.nthenergy.models.Invoice;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;

public class PaymentController {
    @FXML
    private TableView<Invoice> allPaymentsTable;

    @FXML
    private TableColumn<Invoice, Double> colAmount;

    @FXML
    private TableColumn<Invoice, String> colCustomerName;

    @FXML
    private TableColumn<Invoice, Integer> colInvoiceId;

    @FXML
    private TableColumn<Invoice, LocalDate> colPaymentDate;

    @FXML
    private TableColumn<Invoice, String> colRemarks;

    ObservableList<Invoice> obAllInvoices = FXCollections.observableArrayList();

    /**
     * This method gets executed before loading the view.
     * @return void
     */
    public void initialize() {
        DecimalFormat df = new DecimalFormat("#.##");
        DateFormat dateF = new SimpleDateFormat("dd MMM yyyy hh:mm:ss");
        Serialization serializationHelper = new Serialization();
        ArrayList<Invoice> allInvoices = serializationHelper.deserializeInvoices();
        for (Invoice invoice: allInvoices) {
            if (invoice.getPaymentStatus().toString() == "PAID") {
                obAllInvoices.add(invoice);
            }
        }
        colInvoiceId.setCellValueFactory(data -> new ReadOnlyObjectWrapper(data.getValue().getInvoiceId()));
        colPaymentDate.setCellValueFactory(data -> new ReadOnlyObjectWrapper(dateF.format(data.getValue().getUpdatedAt())));
        colCustomerName.setCellValueFactory(data -> new ReadOnlyObjectWrapper(data.getValue().getCustomerById(data.getValue().getCustomerId()).getName()));
        colAmount.setCellValueFactory(data -> new ReadOnlyObjectWrapper(df.format(data.getValue().getFinalAmount())));
        allPaymentsTable.setItems(obAllInvoices);
    }



}
