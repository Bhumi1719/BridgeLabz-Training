package problemsTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import problems.Performance;

public class PerformanceTest {

    Performance performance = new Performance();

    @Test
    @Timeout(value = 2, unit = TimeUnit.SECONDS)
    void testLongRunningTaskTimeout() throws InterruptedException {
        performance.longRunningTask();
        // Test will FAIL because method takes 3 seconds
    }
}

