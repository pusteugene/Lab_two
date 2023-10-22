public class Book extends Item {
    private String author;

    public Book(String title, String uniqueID, String author) {
        super(title, uniqueID);
        this.author = author;
    }

    @Override
    public void borrowItem() {
        if (!isBorrowed()) {
            setBorrowed(true);
            System.out.println("Book '" + getTitle() + "' has been borrowed by a patron.");
        } else {
            System.out.println("Book '" + getTitle() + "' is already borrowed.");
        }
    }

    @Override
    public void returnItem() {
        if (isBorrowed()) {
            setBorrowed(false);
            System.out.println("Book '" + getTitle() + "' has been returned to the library.");
        } else {
            System.out.println("Book '" + getTitle() + "' is not borrowed and cannot be returned.");
        }
    }
}