import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    void borrowItem() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Book book = new Book("Book 1", "B001", "Author 1");
        book.borrowItem();

        String actualOutput = outContent.toString();
        String expectedOutput = "Book 'Book 1' has been borrowed by a patron." + System.lineSeparator();

        assertEquals(expectedOutput, actualOutput);
        System.out.println("borrowItem: " + (actualOutput.equals(expectedOutput) ? "Passed" : "Failed"));
    }

    @Test
    void returnItem() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Book book = new Book("Book 1", "B001", "Author 1");
        book.returnItem();

        String actualOutput = outContent.toString();
        String expectedOutput = "Book 'Book 1' is not borrowed and cannot be returned." + System.lineSeparator();

        assertEquals(expectedOutput, actualOutput);
        System.out.println("returnItem: " + (actualOutput.equals(expectedOutput) ? "Passed" : "Failed"));
    }
}
