package tariffs;

import application.nthenergy.core.enums.MeterType;
import application.nthenergy.core.enums.TariffType;
import application.nthenergy.models.Tariff;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.*;
import java.util.ArrayList;
import static org.junit.Assert.*;

public class TariffGetByTariffIdTest {
    private Tariff tariffObj = new Tariff();

    @Before
    public void setup() {
        tariffObj.setTariffId(1);
        tariffObj.setName("Test Tariff");
        tariffObj.setDescription("Description");
        tariffObj.setTariffType(TariffType.FIXED);
        tariffObj.setMeterType(MeterType.DIGITAL);
        tariffObj.setCreatedAt(System.currentTimeMillis());
        tariffObj.setUpdatedAt(System.currentTimeMillis());
    }

    @Test
    public void testTariffObjectById() throws IOException, ClassNotFoundException {
        serializeTariff(tariffObj);
        Tariff deserializedTariff = deserializeTariff(tariffObj.getTariffId());
        Assertions.assertAll("Match serialized tariff object with deserialized tariff object.",
                () -> assertEquals(tariffObj.getTariffId(), deserializedTariff.getTariffId()),
                () -> assertEquals(tariffObj.getName(), deserializedTariff.getName()),
                () -> assertEquals(tariffObj.getTariffType(), deserializedTariff.getTariffType()),
                () -> assertEquals(tariffObj.getMeterType(), deserializedTariff.getMeterType()),
                () -> assertEquals(tariffObj.getDescription(), deserializedTariff.getDescription()),
                () -> assertEquals(tariffObj.getCreatedAt(), deserializedTariff.getCreatedAt()),
                () -> assertEquals(tariffObj.getUpdatedAt(), deserializedTariff.getUpdatedAt())
        );
    }

    /**
     * This method is used to serialize the tariff obj and store the information into a .txt file.
     *
     * @param tariff
     * @throws IOException
     */
    private static void serializeTariff(Tariff tariff) throws IOException {
        FileOutputStream fileOut = new FileOutputStream("./tests/resources/tariffs.txt");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(tariff);
        out.close();
        fileOut.close();
    }

    /**
     * This method is used to deserialize the tariff obj data from the .txt serialized file.
     *
     * @return deserializeObj
     * @throws IOException
     * @throws ClassNotFoundException
     */
    private static Tariff deserializeTariff(int id) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("./tests/resources/tariffs.txt");
        ArrayList<Tariff> tariffs = new ArrayList<>();
        Tariff tariffObj = new Tariff();
        FileOutputStream fileOut = new FileOutputStream("./data/tariffs.txt");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(tariffs);
        out.close();
        fileOut.close();
        for (Tariff tariff: tariffs) {
            if (tariff.getTariffId() == id) {
                return tariff;
            }
        }
        out.close();
        fileOut.close();
        return tariffObj;
    }
}
