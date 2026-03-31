package problemsTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import problems.MathUtils;

public class MathUtilsTest {

    MathUtils mathUtils = new MathUtils();

    //  Verifying that exception is thrown
    @Test
    void testDivideByZeroThrowsException() {

        ArithmeticException exception = assertThrows(
                ArithmeticException.class,
                () -> mathUtils.divide(10, 0)
        );

        assertEquals("Division by zero is not allowed", exception.getMessage());
    }

    // Verifying that normal division works
    @Test
    void testDivideValidInput() {
        assertEquals(5, mathUtils.divide(10, 2));
    }
}

