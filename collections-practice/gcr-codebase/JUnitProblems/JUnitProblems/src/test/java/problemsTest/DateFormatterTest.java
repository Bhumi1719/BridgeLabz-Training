package problemsTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import problems.DateFormatter;

public class DateFormatterTest {

    private final DateFormatter formatter = new DateFormatter();

    @Test
    void testValidDate() {
        assertEquals("15-08-2025", formatter.formatDate("2025-08-15"));
    }

    @Test
    void testInvalidDateFormat() {
        assertThrows(
                IllegalArgumentException.class,
                () -> formatter.formatDate("15-08-2025")
        );
    }

    @Test
    void testInvalidDateValue() {
        assertThrows(
                IllegalArgumentException.class,
                () -> formatter.formatDate("2025-13-40")
        );
    }

    @Test
    void testNullDate() {
        assertThrows(
                IllegalArgumentException.class,
                () -> formatter.formatDate(null)
        );
    }
}

