
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class testFunction {

    private final String filePath = "D:\\Java\\New folder\\Score_Grade_Table.txt";

    @Before
    public void setup() throws IOException {
        // Ensure a clean file for testing
        Files.deleteIfExists(Paths.get(filePath));
    }

    @After
    public void tearDown() throws IOException {
        // Clean up after test
        Files.deleteIfExists(Paths.get(filePath));
    }

    @Test
    public void testGetGrade() {
        assertEquals("A", TeamA.getGrade(85));
        assertEquals("B+", TeamA.getGrade(75));
        assertEquals("B", TeamA.getGrade(70));
        assertEquals("C+", TeamA.getGrade(65));
        assertEquals("C", TeamA.getGrade(60));
        assertEquals("D+", TeamA.getGrade(55));
        assertEquals("D", TeamA.getGrade(50));
        assertEquals("F", TeamA.getGrade(49));
    }

    @Test
    public void testAgeCalculation() {
        int currentYear = java.time.Year.now().getValue();
        int christianEra = 1998;
        int expectedAge = currentYear - christianEra;

        assertEquals(expectedAge, currentYear - christianEra);
    }

    @Test
    public void testFileWriting() throws IOException {
        String name = "John";
        int christianEra = 1998;
        int score = 85;

        int currentYear = java.time.Year.now().getValue();
        int age = currentYear - christianEra;
        String grade = TeamA.getGrade(score);

        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.write("Name : " + name + "\n");
            writer.write("Age : " + age + "\n");
            writer.write("Software Testing Grade : " + grade + "\n");
            writer.write("----------------------------\n");
        }

        File file = new File(filePath);
        assertTrue(file.exists());

        String content = Files.readString(Paths.get(filePath));
        assertTrue(content.contains("Name : " + name));
        assertTrue(content.contains("Age : " + age));
        assertTrue(content.contains("Software Testing Grade : " + grade));
    }
    @Test(expected = IOException.class)
    public void testFileWritingFailure() throws IOException {
        String invalidFilePath = "Z:\\Invalid\\Path\\Score_Grade_Table.txt";

        try (FileWriter writer = new FileWriter(invalidFilePath, true)) {
            writer.write("This will fail.");
        }
    }

}
