import java.util.ArrayList;
import java.util.List;

public class Library implements IManageable {
    private List<Item> items;
    private List<Patron> patrons;

    public Library() {
        this.items = new ArrayList<>();
        this.patrons = new ArrayList<>();
    }

    public void registerPatron(Patron patron) {
        patrons.add(patron);
    }

    public void lendItem(Patron patron, Item item) {
        if (patrons.contains(patron) && items.contains(item) && !item.isBorrowed()) {
            patron.borrow(item);
            item.borrowItem();
        }
    }

    public void returnItem(Patron patron, Item item) {
        if (patrons.contains(patron) && items.contains(item) && patron.getBorrowedItems().contains(item)) {
            patron.returnItem(item);
            item.returnItem();
        }
    }

    public void add(Item item) {
        items.add(item);
    }

    public void remove(Item item) {
        items.remove(item);
    }

    public List<Item> getItems() {
        return items;
    }

    public void listAvailable() {
        System.out.println("Available Items:");
        for (Item item : items) {
            if (!item.isBorrowed()) {
                System.out.println(item.getTitle());
            }
        }
    }

    public void listBorrowed() {
        System.out.println("Borrowed Items:");
        for (Patron patron : patrons) {
            List<Item> borrowedItems = patron.getBorrowedItems();
            for (Item item : borrowedItems) {
                System.out.println("Patron: " + patron.getName() + ", Item: " + item.getTitle());
            }
        }
    }
}
