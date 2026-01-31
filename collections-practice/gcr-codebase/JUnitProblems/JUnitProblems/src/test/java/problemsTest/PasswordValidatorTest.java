package problemsTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import problems.PasswordValidator;

public class PasswordValidatorTest {

    PasswordValidator validator = new PasswordValidator();

    @Test
    void testValidPassword() {
        assertTrue(validator.isValid("Password1"));
        assertTrue(validator.isValid("StrongPass9"));
    }
    
    @Test
    void testPasswordTooShort() {
        assertFalse(validator.isValid("Pass1"));
    }

    @Test
    void testPasswordWithoutUppercase() {
        assertFalse(validator.isValid("password1"));
    }

    @Test
    void testPasswordWithoutDigit() {
        assertFalse(validator.isValid("Password"));
    }

    @Test
    void testNullPassword() {
        assertFalse(validator.isValid(null));
    }
}

