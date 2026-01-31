package problemsTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import problems.DatabaseConnection;

public class DatabaseConnectionTest {

    private DatabaseConnection dbConnection;

    // Runs BEFORE each test
    @BeforeEach
    void setUp() {
        dbConnection = new DatabaseConnection();
        dbConnection.connect();
    }

    // Runs AFTER each test
    @AfterEach
    void tearDown() {
        dbConnection.disconnect();
    }

    @Test
    void testConnectionEstablished() {
        assertTrue(dbConnection.isConnected());
    }

    @Test
    void testConnectionClosedAfterTest() {
        assertTrue(dbConnection.isConnected());
    }
}
