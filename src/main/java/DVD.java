public class DVD extends Item {
    private int duration;

    public DVD(String title, String uniqueID, int duration) {
        super(title, uniqueID);
        this.duration = duration;
    }

    @Override
    public void borrowItem() {
        if (!isBorrowed()) {
            setBorrowed(true);
            System.out.println("DVD '" + getTitle() + "' has been borrowed by a patron.");
        } else {
            System.out.println("DVD '" + getTitle() + "' is already borrowed.");
        }
    }

    @Override
    public void returnItem() {
        if (isBorrowed()) {
            setBorrowed(false);
            System.out.println("DVD '" + getTitle() + "' has been returned to the library.");
        } else {
            System.out.println("DVD '" + getTitle() + "' is not borrowed and cannot be returned.");
        }
    }
}