import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PatronTest {

    @Test
    void getName() {
        Patron patron = new Patron("John", "P001");
        assertEquals("John", patron.getName());
    }

    @Test
    void setName() {
        Patron patron = new Patron("Alice", "P002");
        patron.setName("Bob");
        assertEquals("Bob", patron.getName());
    }

    @Test
    void getID() {
        Patron patron = new Patron("Eve", "P003");
        assertEquals("P003", patron.getID());
    }

    @Test
    void setID() {
        Patron patron = new Patron("Dave", "P004");
        patron.setID("P005");
        assertEquals("P005", patron.getID());
    }

    @Test
    void getBorrowedItems() {
        Patron patron = new Patron("Mary", "P006");
        Book book1 = new Book("Book 1", "B001", "Author 1");
        Book book2 = new Book("Book 2", "B002", "Author 2");

        patron.borrow(book1);
        patron.borrow(book2);

        assertEquals(2, patron.getBorrowedItems().size());
        assertTrue(patron.getBorrowedItems().contains(book1));
        assertTrue(patron.getBorrowedItems().contains(book2));
    }

    @Test
    void borrow() {
        Patron patron = new Patron("John", "P001");
        Book book = new Book("Book 1", "B001", "Author 1");

        patron.borrow(book);
        assertTrue(patron.getBorrowedItems().contains(book));
    }

    @Test
    void returnItem() {
        Patron patron = new Patron("Alice", "P002");
        Book book = new Book("Book 2", "B002", "Author 2");
        patron.borrow(book);

        patron.returnItem(book);
        assertFalse(patron.getBorrowedItems().contains(book));
    }
}
