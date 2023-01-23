package mvc;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class ConverterData {

    private static final String DATE_PATTERN = "dd.MM.yyyy";
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_PATTERN);

    public static String formatar(LocalDate data) {
        if (data == null) {
            return null;
        }
        return DATE_FORMATTER.format(data);
    }

    public static LocalDate passar(String dataString) {
        try {
            return DATE_FORMATTER.parse(dataString, LocalDate::from);
        } catch (DateTimeParseException e) {
            return null;
        }
    }

    public static boolean valiData(String dataString) {
        return ConverterData.passar(dataString) != null;
    }
}
