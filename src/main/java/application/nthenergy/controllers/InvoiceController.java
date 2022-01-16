/*
 * InvoiceController.java
 * Controller class to access properties and methods from model class,
 * handles user requests from invoice module's views.
 * @author: Ashwin Gurung
 */

package application.nthenergy.controllers;

import application.nthenergy.core.Exceptions.NoItemSelectedException;
import application.nthenergy.core.GeneratePdf;
import application.nthenergy.core.Helper;
import application.nthenergy.core.SendEmail;
import application.nthenergy.core.Serialization;
import application.nthenergy.core.enums.PaymentStatus;
import application.nthenergy.models.*;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import org.w3c.dom.Document;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;

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

    @FXML
    private Label invoiceDetailsLabel;

    @FXML
    private ListView<String> invoiceDetailsOne;

    @FXML
    private ListView<String> invoiceDetailsTwo;

    @FXML
    private Button viewInvoices;

    ObservableList<Invoice> obAllInvoices = FXCollections.observableArrayList();
    private static Invoice viewDetailsInvoice = null;
    private ObservableList<String> obInvoiceDetailsOne = FXCollections.observableArrayList();
    private ObservableList<String> obInvoiceDetailsTwo = FXCollections.observableArrayList();
    DateFormat df = new SimpleDateFormat("dd MMM yyyy hh:mm:ss");
    DecimalFormat pf = new DecimalFormat("#.##");
    @FXML
    void onClickViewInvoiceDetails(MouseEvent event) throws IOException, NoItemSelectedException {
        viewDetailsInvoice = allInvoicesTable.getSelectionModel().getSelectedItem();
        if (viewDetailsInvoice == null) {
            throw new NoItemSelectedException("Please select an invoice to view the details.");
        }
        else {
            Helper.setScene(event, "views/invoices/invoice-details.fxml");
        }
    }

    @FXML
    void onClickViewAllInvoices(MouseEvent event) throws IOException {
        Helper.setScene(event, "views/invoices/all-invoices.fxml");
    }

    @FXML
    void onClickSendInvoiceEmailBtn(MouseEvent event) throws NoItemSelectedException {
        viewDetailsInvoice = allInvoicesTable.getSelectionModel().getSelectedItem();
        if (viewDetailsInvoice == null) {
            throw new NoItemSelectedException("Please select an invoice to send invoice email.");
        }
        else {
            // generate invoice pdf first
            GeneratePdf pdfObj = new GeneratePdf();
            String fileName = "./invoices/Invoice-"+viewDetailsInvoice.getCustomerId()+"-"+viewDetailsInvoice.getCreatedAt()+".pdf";
            String[] customerData = getInvoiceData("customer");
            String[] gasData = getInvoiceData("gas");
            String[] elecData = getInvoiceData("electricity");
            pdfObj.generateInvoicePdf(customerData, gasData, elecData, fileName);
            // send invoice email
            SendEmail emailUtil = new SendEmail();
            Customer customerObj = new Customer();
            Customer customer = customerObj.getCustomerById(viewDetailsInvoice.getCustomerId());
            String[] recipients = {customer.getEmail()};
            String[] bccRecipients = {"ashwin.grg11@gmail.com", "gloomy.gurung@gmail.com"};
            String subject = "Invoice from Northampton Energy Supplier";
            String message = "Dear "+customer.getName()+",\n\nPlease find enclosed herewith the invoice of gas & electricity from "+viewDetailsInvoice.getDateFrom()+" to "+viewDetailsInvoice.getDateUntil()+".\n\nPlease email us if you have any queries regarding the invoice.\n\nThank You.\n\nRegards,\n\nNorthampton Energy Supplier\nNorthampto, UK";
            emailUtil.sendInvoiceEmail(recipients, bccRecipients, subject, message, fileName);
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
            boolean invoiceFlag = true;
            for (Invoice invoice: allInvoices) {
                if (invoice.getInvoiceId() == invoiceId) {
                    if (invoice.getPaymentStatus().toString() == "PAID") {
                        Alert a = new Alert(Alert.AlertType.ERROR);
                        a.setContentText("Payment for this invoice has already been made.");
                        a.show();
                        invoiceFlag = false;
                        break;
                    }
                    else {
                        invoice.setPaymentStatus(PaymentStatus.PAID);
                        invoice.setUpdatedAt(System.currentTimeMillis());
                    }
                }
                newInvoices.add(invoice);
            }
            if (invoiceFlag) {
                serializationHelper.serializeAllInvoices(newInvoices);
                Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setContentText("Payment has been successfully made for the selected invoice.");
                a.show();
                obAllInvoices.removeAll(obAllInvoices);
                obAllInvoices.addAll(newInvoices);
            }
        }
    }

    /**
     * This method gets executed before loading the view.
     * @return void
     */
    public void initialize() {
        DecimalFormat df = new DecimalFormat("#.##");
        if (invoiceDetailsLabel == null) {
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
        else {
            setInvoiceDetails();
        }
    }

    /**
     * This method is used to set the invoice details data on details page.
     *
     */
    void setInvoiceDetails() {
        Customer customerObj = new Customer();
        Customer customer = customerObj.getCustomerById(viewDetailsInvoice.getCustomerId());
        Tariff customerTariffObj = new Tariff();
        Tariff customerTariff = customerTariffObj.getById(customer.getTariffId());
        String[] propertiesOne = {"Invoice ID: "+viewDetailsInvoice.getInvoiceId(), "Generated On: "+df.format(viewDetailsInvoice.getCreatedAt()), "Payment Status: "+viewDetailsInvoice.getPaymentStatus(), "-------------------- Customer Details --------------------", "Customer Name: "+customer.getName(), "Customer Email: "+customer.getEmail(), "Customer Mob No.: "+customer.getMobNo(), "Customer Address: "+customer.getAddressOne(), "Customer Post Code: "+customer.getPostCode(), "Joined Date: "+customer.getJoinDate(), "Tariff Name: "+customerTariff.getName(), "Tariff Type: "+customerTariff.getTariffType().toString(), "Meter Type: "+customerTariff.getMeterType().toString(), "Meter Number: "+customer.getName()};

        for (int i = 0; i < propertiesOne.length; i++) {
            obInvoiceDetailsOne.add(propertiesOne[i]);
        }
        invoiceDetailsOne.setItems(obInvoiceDetailsOne);

        if (customerTariff.getTariffType().toString() == "FIXED") {
            double gasUnits = viewDetailsInvoice.getGasClosing()-viewDetailsInvoice.getGasClosing();
            double mThree = gasUnits * 3;
            String[] gasProperties = {"-------------------- Gas Statement --------------------", "Period: "+viewDetailsInvoice.getDateFrom()+" - "+viewDetailsInvoice.getDateUntil(), "Opening Read: "+viewDetailsInvoice.getGasOpening(), "Closing Read: "+viewDetailsInvoice.getGasClosing(), "Units: "+gasUnits, "m3: "+mThree, "kWh: "+viewDetailsInvoice.getGasKwh(), "Rate: "+customerTariff.getGasFixRate(), "Price: "+Double.valueOf(pf.format(viewDetailsInvoice.getInitialGasAmount())), "Plus VAT at 5%: "+Double.valueOf(pf.format(viewDetailsInvoice.getGasVatAmount())), "Total Amount for Gas: "+Double.valueOf(pf.format(viewDetailsInvoice.getFinalGasAmount()))};
            String[] elecProperties = {"-------------------- Electricity Statement --------------------", "Period: "+viewDetailsInvoice.getDateFrom()+" - "+viewDetailsInvoice.getDateUntil(), "Opening Read: "+viewDetailsInvoice.getElecOpening(), "Closing Read: "+viewDetailsInvoice.getElecClosing(), "kWh"+viewDetailsInvoice.getElecKwh(), "Rate: "+viewDetailsInvoice.getElecPrice(), "Price: "+Double.valueOf(pf.format(viewDetailsInvoice.getElecInitialTotal())), "Plus VAT at 5%: "+Double.valueOf(pf.format(viewDetailsInvoice.getElecVatAmount())), "Total Amount for Electricity: "+Double.valueOf(pf.format(viewDetailsInvoice.getFinalElecAmount())), "-------------------- Total Payable Price of Gas & Electricity : "+Double.valueOf(pf.format(viewDetailsInvoice.getFinalAmount()))};
            for (int i = 0; i < gasProperties.length; i++) {
                obInvoiceDetailsTwo.add(gasProperties[i]);
            }
            for (int i = 0; i < elecProperties.length; i++) {
                obInvoiceDetailsTwo.add(elecProperties[i]);
            }
            invoiceDetailsTwo.setItems(obInvoiceDetailsTwo);
        }
        else {
            double gasUnits = viewDetailsInvoice.getGasClosing()-viewDetailsInvoice.getGasClosing();
            double mThree = gasUnits * 3;
            String[] gasProperties = {"-------------------- Gas Statement --------------------", "Period: "+viewDetailsInvoice.getDateFrom()+" - "+viewDetailsInvoice.getDateUntil(), "Opening Read: "+viewDetailsInvoice.getGasOpening(), "Closing Read: "+viewDetailsInvoice.getGasClosing(), "Units: "+gasUnits, "m3: "+mThree, "kWh: "+viewDetailsInvoice.getGasKwh(), "Rate: "+customerTariff.getGasUnitRate(), "Price: "+Double.valueOf(pf.format(viewDetailsInvoice.getInitialGasAmount())), "Plus VAT at 5%: "+Double.valueOf(pf.format(viewDetailsInvoice.getGasVatAmount())), "Total Amount for Gas: "+Double.valueOf(pf.format(viewDetailsInvoice.getFinalGasAmount()))};
            String[] elecProperties = {"-------------------- Electricity Statement --------------------", "Period: "+viewDetailsInvoice.getDateFrom()+" - "+viewDetailsInvoice.getDateUntil(), "Night Opening Read: "+viewDetailsInvoice.getElecNightOpening(), "Night Closing Read: "+viewDetailsInvoice.getElecNightClosing(), "Night kWh"+viewDetailsInvoice.getElecNightKwh(), "Night Rate: "+viewDetailsInvoice.getElecNightPrice(), "Total Night Charge: "+Double.valueOf(pf.format(viewDetailsInvoice.getElecNightInitialTotal())), "Day Opening Read: "+viewDetailsInvoice.getElecDayOpening(), "Day Closing Read: "+viewDetailsInvoice.getElecDayClosing(), "Day kWh"+viewDetailsInvoice.getElecDayKwh(), "Day Rate: "+viewDetailsInvoice.getElecDayPrice(), "Day Price: "+Double.valueOf(pf.format(viewDetailsInvoice.getElecDayInitialTotal())), "Total Day Charge: "+Double.valueOf(pf.format(viewDetailsInvoice.getInitialElecAmount())), "Plus VAT at 5%: "+Double.valueOf(pf.format(viewDetailsInvoice.getElecVatAmount())), "Total Amount for Electricity: "+Double.valueOf(pf.format(viewDetailsInvoice.getFinalElecAmount())), "-------------------- Total Payable Price of Gas & Electricity : "+Double.valueOf(pf.format(viewDetailsInvoice.getFinalAmount()))};
            for (int i = 0; i < gasProperties.length; i++) {
                obInvoiceDetailsTwo.add(gasProperties[i]);
            }
            for (int i = 0; i < elecProperties.length; i++) {
                obInvoiceDetailsTwo.add(elecProperties[i]);
            }
            invoiceDetailsTwo.setItems(obInvoiceDetailsTwo);
        }
    }

    /**
     * This function is used to return the data for generating an invoice pdf.
     *
     * @param type
     */
    String[] getInvoiceData(String type) {
        Customer customerObj = new Customer();
        Customer customer = customerObj.getCustomerById(viewDetailsInvoice.getCustomerId());
        Tariff customerTariffObj = new Tariff();
        Tariff customerTariff = customerTariffObj.getById(customer.getTariffId());
        String[] propertiesOne = {"Invoice ID: "+viewDetailsInvoice.getInvoiceId(), "Generated On: "+df.format(viewDetailsInvoice.getCreatedAt()), "Payment Status: "+viewDetailsInvoice.getPaymentStatus(), "------------ Customer Details ------------", "Customer Name: "+customer.getName(), "Customer Email: "+customer.getEmail(), "Customer Mob No.: "+customer.getMobNo(), "Customer Address: "+customer.getAddressOne(), "Customer Post Code: "+customer.getPostCode(), "Joined Date: "+customer.getJoinDate(), "Tariff Name: "+customerTariff.getName(), "Tariff Type: "+customerTariff.getTariffType().toString(), "Meter Type: "+customerTariff.getMeterType().toString(), "Meter Number: "+customer.getName()};
        if (type == "customer") {
            return propertiesOne;
        }
        else {
            if (customerTariff.getTariffType().toString() == "FIXED") {
                double gasUnits = viewDetailsInvoice.getGasClosing()-viewDetailsInvoice.getGasClosing();
                double mThree = gasUnits * 3;
                String[] gasProperties = {"------------ Gas Statement ------------", "Period: "+viewDetailsInvoice.getDateFrom()+" - "+viewDetailsInvoice.getDateUntil(), "Opening Read: "+viewDetailsInvoice.getGasOpening(), "Closing Read: "+viewDetailsInvoice.getGasClosing(), "Units: "+gasUnits, "m3: "+mThree, "kWh: "+viewDetailsInvoice.getGasKwh(), "Rate: "+customerTariff.getGasFixRate(), "Price: "+Double.valueOf(pf.format(viewDetailsInvoice.getInitialGasAmount())), "Plus VAT at 5%: "+Double.valueOf(pf.format(viewDetailsInvoice.getGasVatAmount())), "Total Amount for Gas: "+Double.valueOf(pf.format(viewDetailsInvoice.getFinalGasAmount()))};
                String[] elecProperties = {"------------ Electricity Statement ------------", "Period: "+viewDetailsInvoice.getDateFrom()+" - "+viewDetailsInvoice.getDateUntil(), "Opening Read: "+viewDetailsInvoice.getElecOpening(), "Closing Read: "+viewDetailsInvoice.getElecClosing(), "kWh"+viewDetailsInvoice.getElecKwh(), "Rate: "+viewDetailsInvoice.getElecPrice(), "Price: "+Double.valueOf(pf.format(viewDetailsInvoice.getElecInitialTotal())), "Plus VAT at 5%: "+Double.valueOf(pf.format(viewDetailsInvoice.getElecVatAmount())), "Total Amount for Electricity: "+Double.valueOf(pf.format(viewDetailsInvoice.getFinalElecAmount())), "------- Total Payable Price of Gas & Electricity : "+Double.valueOf(pf.format(viewDetailsInvoice.getFinalAmount()))};
                if (type == "gas") {
                    return gasProperties;
                }
                else {
                    return elecProperties;
                }
            }
            else {
                double gasUnits = viewDetailsInvoice.getGasClosing()-viewDetailsInvoice.getGasClosing();
                double mThree = gasUnits * 3;
                String[] gasProperties = {"-------------------- Gas Statement --------------------", "Period: "+viewDetailsInvoice.getDateFrom()+" - "+viewDetailsInvoice.getDateUntil(), "Opening Read: "+viewDetailsInvoice.getGasOpening(), "Closing Read: "+viewDetailsInvoice.getGasClosing(), "Units: "+gasUnits, "m3: "+mThree, "kWh: "+viewDetailsInvoice.getGasKwh(), "Rate: "+customerTariff.getGasUnitRate(), "Price: "+Double.valueOf(pf.format(viewDetailsInvoice.getInitialGasAmount())), "Plus VAT at 5%: "+Double.valueOf(pf.format(viewDetailsInvoice.getGasVatAmount())), "Total Amount for Gas: "+Double.valueOf(pf.format(viewDetailsInvoice.getFinalGasAmount()))};
                String[] elecProperties = {"-------------------- Electricity Statement --------------------", "Period: "+viewDetailsInvoice.getDateFrom()+" - "+viewDetailsInvoice.getDateUntil(), "Night Opening Read: "+viewDetailsInvoice.getElecNightOpening(), "Night Closing Read: "+viewDetailsInvoice.getElecNightClosing(), "Night kWh"+viewDetailsInvoice.getElecNightKwh(), "Night Rate: "+viewDetailsInvoice.getElecNightPrice(), "Total Night Charge: "+Double.valueOf(pf.format(viewDetailsInvoice.getElecNightInitialTotal())), "Day Opening Read: "+viewDetailsInvoice.getElecDayOpening(), "Day Closing Read: "+viewDetailsInvoice.getElecDayClosing(), "Day kWh"+viewDetailsInvoice.getElecDayKwh(), "Day Rate: "+viewDetailsInvoice.getElecDayPrice(), "Day Price: "+Double.valueOf(pf.format(viewDetailsInvoice.getElecDayInitialTotal())), "Total Day Charge: "+Double.valueOf(pf.format(viewDetailsInvoice.getInitialElecAmount())), "Plus VAT at 5%: "+Double.valueOf(pf.format(viewDetailsInvoice.getElecVatAmount())), "Total Amount for Electricity: "+Double.valueOf(pf.format(viewDetailsInvoice.getFinalElecAmount())), "-------------------- Total Payable Price of Gas & Electricity : "+Double.valueOf(pf.format(viewDetailsInvoice.getFinalAmount()))};
                if (type == "gas") {
                    return gasProperties;
                }
                else {
                    return elecProperties;
                }
            }
        }
    }

}
