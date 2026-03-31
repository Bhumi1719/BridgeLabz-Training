package problemsTest;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import problems.FileProcessor;

public class FileProcessorTest {

    private FileProcessor fileProcessor;
    private Path tempFile;

    @BeforeEach
    void setUp() throws IOException {
        fileProcessor = new FileProcessor();
        tempFile = Files.createTempFile("testfile", ".txt");
    }

    @AfterEach
    void tearDown() throws IOException {
        Files.deleteIfExists(tempFile);
    }

    @Test
    void testWriteAndReadFile() throws IOException {
        String content = "Hello JUnit File Testing";

        fileProcessor.writeToFile(tempFile.toString(), content);
        String result = fileProcessor.readFromFile(tempFile.toString());

        assertEquals(content, result);
    }

    @Test
    void testFileExistsAfterWrite() throws IOException {
        fileProcessor.writeToFile(tempFile.toString(), "Test Content");

        assertTrue(Files.exists(tempFile));
    }

    @Test
    void testReadNonExistingFileThrowsException() {
        String invalidFile = "no_such_file.txt";

        assertThrows(IOException.class, () -> {
            fileProcessor.readFromFile(invalidFile);
        });
    }
}
