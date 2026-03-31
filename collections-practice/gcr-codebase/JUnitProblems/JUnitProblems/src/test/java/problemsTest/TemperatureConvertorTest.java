package problemsTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import problems.TemperatureConvertor;

public class TemperatureConvertorTest {

    private static final double VALUE = 0.0001; // tolerance for doubles
    private final TemperatureConvertor converter = new TemperatureConvertor();

    // ✅ Celsius → Fahrenheit tests
    @Test
    void testCelsiusToFahrenheit() {
        assertEquals(32.0, converter.celsiusToFahrenheit(0), VALUE);
        assertEquals(212.0, converter.celsiusToFahrenheit(100), VALUE);
        assertEquals(-40.0, converter.celsiusToFahrenheit(-40), VALUE);
    }

    // ✅ Fahrenheit → Celsius tests
    @Test
    void testFahrenheitToCelsius() {
        assertEquals(0.0, converter.fahrenheitToCelsius(32), VALUE);
        assertEquals(100.0, converter.fahrenheitToCelsius(212), VALUE);
        assertEquals(-40.0, converter.fahrenheitToCelsius(-40), VALUE);
    }
}

