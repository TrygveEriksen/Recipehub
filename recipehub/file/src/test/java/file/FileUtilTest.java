package file;

import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FileUtilTest {
    private Path filePath = Path.of("test.txt");
    private FileUtil fileUtil = new FileUtil();

    /**
     * Helper method to delete testfiles
     */
    private void deleteFile(Path filePath) {
        try {
            Files.deleteIfExists(filePath);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Tests if the file is created correctly
     */
    @Test
    @DisplayName("Test createFile")
    public void testCreateFile() {
        fileUtil.createFile(filePath);
        Assertions.assertTrue(Files.exists(filePath));
        // Since the file already exists, this will test the rest of the if-statement
        fileUtil.createFile(filePath);
        deleteFile(filePath);
    }

    /**
     * Tests if the file is written to and read from correctly
     */
    @Test
    @DisplayName("Test writeFile and readFile")
    public void testWriteAndReadFile() {
        fileUtil.createFile(filePath);
        fileUtil.writeFile(filePath, "test");
        Assertions.assertEquals("test", fileUtil.readFile(filePath, "", String.class));
        deleteFile(filePath);
    }
}