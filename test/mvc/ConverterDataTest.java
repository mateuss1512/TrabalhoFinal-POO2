package mvc;

import java.text.ParseException;
import java.time.LocalDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ConverterDataTest {

    public ConverterDataTest() {
    }

    @Test
    public void testValiData() throws ParseException {
        String dataString = null;
        ConverterData.passar(dataString);
        Assertions.assertTrue(dataString == null);
    }
}
