package customers;

import application.nthenergy.models.Customer;
import application.nthenergy.models.CustomerCard;
import application.nthenergy.models.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class CustomerCardSerializationTest {
    private CustomerCard customerCard = new CustomerCard();

    @Before
    public void setup() {
        customerCard.setCustomerCardId(1);
        customerCard.setCustomerId(100);
        customerCard.setBankName("BMO");
        customerCard.setAccountNumber("45X29C");
        customerCard.setCardNumber("123BO");
        customerCard.setNameOnCard("Ashwin Gurung");
        customerCard.setExpiryDate(LocalDate.now());
        customerCard.setCvv("123");
        customerCard.setCreatedAt(1200);
        customerCard.setUpdatedAt(2400);
    }

    @Test
    public void testInstanceOfSerialization() throws IOException, ClassNotFoundException {
        serialize(customerCard);
        Object deserialized = deserialize();
        Assertions.assertTrue(deserialized instanceof CustomerCard);
    }

    /**
     * This method is used to serialized the customer card obj and store the information into a .txt file.
     *
     * @param obj
     * @throws IOException
     */
    private static void serialize(CustomerCard obj) throws IOException {
        FileOutputStream fileOut = new FileOutputStream("./tests/resources/customer-cards.txt");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(obj);
        out.close();
        fileOut.close();
    }

    /**
     * This method is used to deserialize the customer card data from the .txt serialized file.
     *
     * @return deserializeObj
     * @throws IOException
     * @throws ClassNotFoundException
     */
    private static Object deserialize() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("./tests/resources/customer-cards.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        CustomerCard deserializedObj = (CustomerCard) ois.readObject();
        ois.close();
        fis.close();
        return deserializedObj;
    }
}
