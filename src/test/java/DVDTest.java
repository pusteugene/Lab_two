import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class DVDTest {

    @Test
    void borrowItem() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        DVD dvd = new DVD("DVD 1", "D001", 120);
        dvd.borrowItem();

        String actualOutput = outContent.toString();
        String expectedOutput = "DVD 'DVD 1' has been borrowed by a patron." + System.lineSeparator();

        assertEquals(expectedOutput, actualOutput);
        System.out.println("borrowItem: " + (actualOutput.equals(expectedOutput) ? "Passed" : "Failed"));
    }

    @Test
    void returnItem() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        DVD dvd = new DVD("DVD 1", "D001", 120);
        dvd.returnItem();

        String actualOutput = outContent.toString();
        String expectedOutput = "DVD 'DVD 1' is not borrowed and cannot be returned." + System.lineSeparator();

        assertEquals(expectedOutput, actualOutput);
        System.out.println("returnItem: " + (actualOutput.equals(expectedOutput) ? "Passed" : "Failed"));
    }
}
