package application.nthenergy.core;

import application.nthenergy.core.enums.MeterType;
import application.nthenergy.core.enums.TariffType;
import application.nthenergy.models.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Serialization implements Serializable {
    private  static  final  long  serialVersionUID = 1L;

    /**
     * This method is used to serialize the objects based on the received parameters of tariffs.
     *
     * return void
     */
    public void serializeTariff(Tariff newTariffData) {
        ArrayList<Tariff> tariffs = new ArrayList<>();
        File f = new File("./data/tariffs.txt");
        if(f.isFile()) {
            tariffs = deserializeTariffs();
        }
        tariffs.add(newTariffData);
        // Let's serialize an Object
        try {
            FileOutputStream fileOut = new FileOutputStream("./data/tariffs.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(tariffs);
            out.close();
            fileOut.close();
            System.out.println("\nSerialization Successful tariff...\n");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is used to serialize all received tariffs.
     *
     * return void
     */
    public void serializeAllTariffs(ArrayList<Tariff> allTariffs) {
        try {
            FileOutputStream fileOut = new FileOutputStream("./data/tariffs.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(allTariffs);
            out.close();
            fileOut.close();
            System.out.println("\nSerialization Successful all tariffs...\n");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is used to deserialize tariffs data.
     *
     * @return ArrayList<Tariff> tariffs
     */
    public ArrayList<Tariff> deserializeTariffs() {
        ArrayList<Tariff> tariffs = new ArrayList<>();
        File f = new File("./data/tariffs.txt");
        if(f.isFile()) {
            try {
                FileInputStream fis = new FileInputStream("./data/tariffs.txt");
                ObjectInputStream ois = new ObjectInputStream(fis);
                tariffs = (ArrayList) ois.readObject();
                ois.close();
                fis.close();
            }
            catch (IOException ioe) {
                System.out.println("IOException caught");
                ioe.printStackTrace();
            }
            catch (ClassNotFoundException c) {
                System.out.println("Class not found");
                c.printStackTrace();
            }
        }
        return tariffs;
    }

    /**
     * This method is used to validate user login details.
     * @return
     */
    public boolean validateLoginCredentials(String email, String psw) {
        ArrayList<User> users = deserializeUsers();
        boolean loginFlag = false;
        for (User user: users) {
            if (user.getEmail().equals(email) && user.getPassword().equals(psw) && user.getUserType().toString() == "ADMIN") {
                return true;
            }
        }
        return loginFlag;
    }

    /**
     * This method is used to serialize the objects based on the received parameters of user.
     *
     * return void
     */
    public void serializeUser(User newUserData) {
        ArrayList<User> users = new ArrayList<>();
        File f = new File("./data/users.txt");
        if(f.isFile()) {
            users = deserializeUsers();
        }
        users.add(newUserData);
        // Let's serialize an Object
        try {
            FileOutputStream fileOut = new FileOutputStream("./data/users.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(users);
            out.close();
            fileOut.close();
            System.out.println("\nSerialization Successful user...\n");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is used to serialize all received users.
     *
     * return void
     */
    public void serializeAllUsers(ArrayList<User> allUsers) {
        try {
            FileOutputStream fileOut = new FileOutputStream("./data/users.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(allUsers);
            out.close();
            fileOut.close();
            System.out.println("\nSerialization Successful all users...\n");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is used to deserialize users data.
     *
     * @return ArrayList<User> users
     */
    public ArrayList<User> deserializeUsers() {
        ArrayList<User> users = new ArrayList<>();
        File f = new File("./data/users.txt");
        if(f.isFile()) {
            try {
                FileInputStream fis = new FileInputStream("./data/users.txt");
                ObjectInputStream ois = new ObjectInputStream(fis);
                users = (ArrayList) ois.readObject();
                ois.close();
                fis.close();
            }
            catch (IOException ioe) {
                System.out.println("IOException caught");
                ioe.printStackTrace();
            }
            catch (ClassNotFoundException c) {
                System.out.println("Class not found");
                c.printStackTrace();
            }
        }
        return users;
    }

    /**
     * This method is used to serialize the objects based on the received parameters of customer.
     *
     * return void
     */
    public void serializeCustomer(Customer newCustomerData) {
        ArrayList<Customer> customers = new ArrayList<>();
        File f = new File("./data/customers.txt");
        if(f.isFile()) {
            customers = deserializeCustomers();
        }
        customers.add(newCustomerData);
        // Let's serialize an Object
        try {
            FileOutputStream fileOut = new FileOutputStream("./data/customers.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(customers);
            out.close();
            fileOut.close();
            System.out.println("\nSerialization Successful customer...\n");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is used to serialize all received customers.
     *
     * return void
     */
    public void serializeAllCustomers(ArrayList<Customer> allCustomers) {
        try {
            FileOutputStream fileOut = new FileOutputStream("./data/customers.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(allCustomers);
            out.close();
            fileOut.close();
            System.out.println("\nSerialization Successful all customers...\n");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is used to deserialize customers data.
     *
     * @return ArrayList<Customer> customers
     */
    public ArrayList<Customer> deserializeCustomers() {
        ArrayList<Customer> customers = new ArrayList<>();
        File f = new File("./data/customers.txt");
        if(f.isFile()) {
            try {
                FileInputStream fis = new FileInputStream("./data/customers.txt");
                ObjectInputStream ois = new ObjectInputStream(fis);
                customers = (ArrayList) ois.readObject();
                ois.close();
                fis.close();
            }
            catch (IOException ioe) {
                System.out.println("IOException caught");
                ioe.printStackTrace();
            }
            catch (ClassNotFoundException c) {
                System.out.println("Class not found");
                c.printStackTrace();
            }
        }
        return customers;
    }

    /**
     * This method is used to serialize the objects based on the received parameters of customer card.
     *
     * return void
     */
    public void serializeCustomerCard(CustomerCard newCustomerCardData) {
        ArrayList<CustomerCard> customerCards = new ArrayList<>();
        File f = new File("./data/customer-cards.txt");
        if(f.isFile()) {
            customerCards = deserializeCustomerCards();
        }
        customerCards.add(newCustomerCardData);
        // Let's serialize an Object
        try {
            FileOutputStream fileOut = new FileOutputStream("./data/customer-cards.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(customerCards);
            out.close();
            fileOut.close();
            System.out.println("\nSerialization Successful customer card...\n");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is used to serialize all received customer cards.
     *
     * return void
     */
    public void serializeAllCustomerCards(ArrayList<CustomerCard> allCustomerCards) {
        try {
            FileOutputStream fileOut = new FileOutputStream("./data/customer-cards.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(allCustomerCards);
            out.close();
            fileOut.close();
            System.out.println("\nSerialization Successful all customerCards...\n");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is used to deserialize customer cards data.
     *
     * @return ArrayList<CustomerCard> customerCards
     */
    public ArrayList<CustomerCard> deserializeCustomerCards() {
        ArrayList<CustomerCard> customerCards = new ArrayList<>();
        File f = new File("./data/customer-cards.txt");
        if(f.isFile()) {
            try {
                FileInputStream fis = new FileInputStream("./data/customer-cards.txt");
                ObjectInputStream ois = new ObjectInputStream(fis);
                customerCards = (ArrayList) ois.readObject();
                ois.close();
                fis.close();
            }
            catch (IOException ioe) {
                System.out.println("IOException caught");
                ioe.printStackTrace();
            }
            catch (ClassNotFoundException c) {
                System.out.println("Class not found");
                c.printStackTrace();
            }
        }
        return customerCards;
    }

    /**
     * This method is used to serialize the objects based on the received parameters of invoice.
     *
     * return void
     */
    public void serializeInvoice(Invoice newInvoiceData) {
        ArrayList<Invoice> invoices = new ArrayList<>();
        File f = new File("./data/invoices.txt");
        if(f.isFile()) {
            invoices = deserializeInvoices();
        }
        invoices.add(newInvoiceData);
        // Let's serialize an Object
        try {
            FileOutputStream fileOut = new FileOutputStream("./data/invoices.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(invoices);
            out.close();
            fileOut.close();
            System.out.println("\nSerialization Successful invoice...\n");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is used to serialize all received invoices.
     *
     * return void
     */
    public void serializeAllInvoices(ArrayList<Invoice> allInvoices) {
        try {
            FileOutputStream fileOut = new FileOutputStream("./data/invoices.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(allInvoices);
            out.close();
            fileOut.close();
            System.out.println("\nSerialization Successful all invoices...\n");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is used to deserialize invoices data.
     *
     * @return ArrayList<Invoice> invoices
     */
    public ArrayList<Invoice> deserializeInvoices() {
        ArrayList<Invoice> invoices = new ArrayList<>();
        File f = new File("./data/invoices.txt");
        if(f.isFile()) {
            try {
                FileInputStream fis = new FileInputStream("./data/invoices.txt");
                ObjectInputStream ois = new ObjectInputStream(fis);
                invoices = (ArrayList) ois.readObject();
                ois.close();
                fis.close();
            }
            catch (IOException ioe) {
                System.out.println("IOException caught");
                ioe.printStackTrace();
            }
            catch (ClassNotFoundException c) {
                System.out.println("Class not found");
                c.printStackTrace();
            }
        }
        return invoices;
    }

    /**
     * This method is used to serialize the objects based on the received parameters of meter reading.
     *
     * return void
     */
    public void serializeMeterReading(MeterReading newMeterReadingData) {
        ArrayList<MeterReading> meterReadings = new ArrayList<>();
        File f = new File("./data/meter-readings.txt");
        if(f.isFile()) {
            meterReadings = deserializeMeterReadings();
        }
        meterReadings.add(newMeterReadingData);
        // Let's serialize an Object
        try {
            FileOutputStream fileOut = new FileOutputStream("./data/meter-readings.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(meterReadings);
            out.close();
            fileOut.close();
            System.out.println("\nSerialization Successful meter reading...\n");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is used to deserialize meter readings data.
     *
     * @return ArrayList<MeterReading> meterReadings
     */
    public ArrayList<MeterReading> deserializeMeterReadings() {
        ArrayList<MeterReading> meterReadings = new ArrayList<>();
        File f = new File("./data/meter-readings.txt");
        if(f.isFile()) {
            try {
                FileInputStream fis = new FileInputStream("./data/meter-readings.txt");
                ObjectInputStream ois = new ObjectInputStream(fis);
                meterReadings = (ArrayList) ois.readObject();
                ois.close();
                fis.close();
            }
            catch (IOException ioe) {
                System.out.println("IOException caught");
                ioe.printStackTrace();
            }
            catch (ClassNotFoundException c) {
                System.out.println("Class not found");
                c.printStackTrace();
            }
        }
        return meterReadings;
    }

    /**
     * This method is used to serialize the objects based on the received parameters of payment.
     *
     * return void
     */
    public void serializePayment(Payment newPaymentData) {
        ArrayList<Payment> payments = new ArrayList<>();
        File f = new File("./data/payments.txt");
        if(f.isFile()) {
            payments = deserializePayments();
        }
        payments.add(newPaymentData);
        // Let's serialize an Object
        try {
            FileOutputStream fileOut = new FileOutputStream("./data/payments.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(payments);
            out.close();
            fileOut.close();
            System.out.println("\nSerialization Successful payment...\n");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is used to deserialize payments data.
     *
     * @return ArrayList<Payment> payments
     */
    public ArrayList<Payment> deserializePayments() {
        ArrayList<Payment> payments = new ArrayList<>();
        File f = new File("./data/payments.txt");
        if(f.isFile()) {
            try {
                FileInputStream fis = new FileInputStream("./data/payments.txt");
                ObjectInputStream ois = new ObjectInputStream(fis);
                payments = (ArrayList) ois.readObject();
                ois.close();
                fis.close();
            }
            catch (IOException ioe) {
                System.out.println("IOException caught");
                ioe.printStackTrace();
            }
            catch (ClassNotFoundException c) {
                System.out.println("Class not found");
                c.printStackTrace();
            }
        }
        return payments;
    }




}
