import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {
    private Library library;
    private Patron patron1;
    private Patron patron2;
    private Book book1;
    private Book book2;

    @BeforeEach
    void setUp() {
        library = new Library();
        patron1 = new Patron("John", "P123");
        patron2 = new Patron("Alice", "P456");
        book1 = new Book("Book 1", "B001", "Author 1");
        book2 = new Book("Book 2", "B002", "Author 2");
    }

    @Test
    void add() {
        library.add(book1);
        List<Item> items = library.getItems();
        assertTrue(items.contains(book1));
        System.out.println("add: " + (items.contains(book1) ? "Passed" : "Failed"));
    }

    @Test
    void remove() {
        library.add(book1);
        library.remove(book1);
        List<Item> items = library.getItems();
        assertFalse(items.contains(book1));
        System.out.println("remove: " + (!items.contains(book1) ? "Passed" : "Failed"));
    }

    @Test
    void listAvailable() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        library.add(book1);
        library.add(book2);
        library.listAvailable();

        String expectedOutput = "Available Items:" + System.lineSeparator() + "Book 1" + System.lineSeparator() + "Book 2" + System.lineSeparator();
        assertEquals(expectedOutput, outContent.toString());
        System.out.println("listAvailable: " + (outContent.toString().equals(expectedOutput) ? "Passed" : "Failed"));
    }

    @Test
    void listBorrowed() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        library.add(book1);
        library.add(book2);
        library.registerPatron(patron1);
        library.registerPatron(patron2);
        library.lendItem(patron1, book1);
        library.lendItem(patron2, book2);

        library.listBorrowed();

        String actualOutput = outContent.toString();
        String expectedOutput = "Book 'Book 1' has been borrowed by a patron." + System.lineSeparator() +
                "Book 'Book 2' has been borrowed by a patron." + System.lineSeparator() +
                "Borrowed Items:" + System.lineSeparator() +
                "Patron: John, Item: Book 1" + System.lineSeparator() +
                "Patron: Alice, Item: Book 2" + System.lineSeparator();

        assertEquals(expectedOutput, actualOutput);
        System.out.println("listBorrowed: " + (actualOutput.equals(expectedOutput) ? "Passed" : "Failed"));
    }
}
