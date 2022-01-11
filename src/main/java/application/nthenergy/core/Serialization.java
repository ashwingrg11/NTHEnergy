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
     * This method is used to serialize the objects based on the received parameters.
     *
     * return void
     */
    public void serializeTariff() {
        Tariff data = new Tariff(1, "tariff name", "tariff description", TariffType.FIXED, MeterType.DIGITAL, 4.50, 5.50, 0.00, 0.50, 0.00, 0.00, 0.00, System.currentTimeMillis(), System.currentTimeMillis());
        List<Tariff> obj = new ArrayList<>();
        obj.add(data);
        obj.add(new Tariff(2, "tariff name2", "tariff description2", TariffType.VARIABLE, MeterType.DUALFUEL, 4.50, 5.50, 0.00, 0.50, 0.00, 0.00, 0.00, System.currentTimeMillis(), System.currentTimeMillis()));
        // Let's serialize an Object
        try {
            FileOutputStream fileOut = new FileOutputStream("./data/tariffs.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(obj);
            out.close();
            fileOut.close();
            System.out.println("\nSerialization Successful...\n");

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
//        for (Tariff tariff : tariffs) {
//            System.out.println(tariff.getName());
//        }
        return tariffs;
    }

    /**
     * This method is used to serialize the objects based on the received parameters of customer.
     *
     * return void
     */
    public void serializeCustomer() {
        Customer data = new Customer();
        List<Customer> obj = new ArrayList<>();
        obj.add(data);
        // Let's serialize an Object
        try {
            FileOutputStream fileOut = new FileOutputStream("./data/customers.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(obj);
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
     * This method is used to deserialize customers data.
     *
     * @return ArrayList<Customer> customers
     */
    public ArrayList<Customer> deserializeCustomers() {
        ArrayList<Customer> customers = new ArrayList<>();
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
//        for (Customer customer : customers) {
//            System.out.println(customer.getId());
//        }
        return customers;
    }

    /**
     * This method is used to serialize the objects based on the received parameters of user.
     *
     * return void
     */
    public void serializeUser() {
        User data = new User();
        List<User> obj = new ArrayList<>();
        obj.add(data);
        // Let's serialize an Object
        try {
            FileOutputStream fileOut = new FileOutputStream("./data/users.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(obj);
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
     * This method is used to deserialize users data.
     *
     * @return ArrayList<User> users
     */
    public ArrayList<User> deserializeUsers() {
        ArrayList<User> users = new ArrayList<>();
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
//        for (User user : users) {
//            System.out.println(user.getId());
//        }
        return users;
    }

    /**
     * This method is used to serialize the objects based on the received parameters of customer card.
     *
     * return void
     */
    public void serializeCustomerCard() {
        CustomerCard data = new CustomerCard();
        List<CustomerCard> obj = new ArrayList<>();
        obj.add(data);
        // Let's serialize an Object
        try {
            FileOutputStream fileOut = new FileOutputStream("./data/customer_card.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(obj);
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
     * This method is used to deserialize customer card data.
     *
     * @return ArrayList<CustomerCard> customerCards
     */
    public ArrayList<CustomerCard> deserializeCustomerCards() {
        ArrayList<CustomerCard> customerCards = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream("./data/customer_card.txt");
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
//        for (CustomerCard customerCard : customerCards) {
//            System.out.println(customerCard.getId());
//        }
        return customerCards;
    }


    /**
     * This method is used to serialize the objects based on the received parameters of invoice.
     *
     * return void
     */
    public void serializeInvoice() {
        Invoice data = new Invoice();
        List<Invoice> obj = new ArrayList<>();
        obj.add(data);
        // Let's serialize an Object
        try {
            FileOutputStream fileOut = new FileOutputStream("./data/invoices.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(obj);
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
     * This method is used to deserialize invoices data.
     *
     * @return ArrayList<Invoice> invoices
     */
    public ArrayList<Invoice> deserializeInvoices() {
        ArrayList<Invoice> invoices = new ArrayList<>();
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
//        for (Invoice invoice : invoices) {
//            System.out.println(invoice.getId());
//        }
        return invoices;
    }

    /**
     * This method is used to serialize the objects based on the received parameters of meter reading.
     *
     * return void
     */
    public void serializeMeterReading() {
        MeterReading data = new MeterReading();
        List<MeterReading> obj = new ArrayList<>();
        obj.add(data);
        // Let's serialize an Object
        try {
            FileOutputStream fileOut = new FileOutputStream("./data/meter_readings.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(obj);
            out.close();
            fileOut.close();
            System.out.println("\nSerialization Successful meter readings...\n");
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
        try {
            FileInputStream fis = new FileInputStream("./data/meter_readings.txt");
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
//        for (MeterReading meterReading : meterReadings) {
//            System.out.println(meterReading.getId());
//        }
        return meterReadings;
    }

    /**
     * This method is used to serialize the objects based on the received parameters of payment.
     *
     * return void
     */
    public void serializePayment() {
        Payment data = new Payment();
        List<Payment> obj = new ArrayList<>();
        obj.add(data);
        // Let's serialize an Object
        try {
            FileOutputStream fileOut = new FileOutputStream("./data/payments.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(obj);
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
//        for (Payment payment : payments) {
//            System.out.println(payment.getId());
//        }
        return payments;
    }



}
