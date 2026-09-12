// M4. Library ID Card Management
class IdCard {
    String name;
    int booksIssued;

    public IdCard(String name, int booksIssued) {
        this.name = name;
        this.booksIssued = booksIssued;
    }
}

public class M4_IdCard {
    public static void main(String[] args) {
        IdCard ravi = new IdCard("Ravi", 0);
        IdCard duplicate = ravi; // same reference, not a new object

        duplicate.booksIssued = 3; // modifies the same underlying object

        System.out.println("Ravi's booksIssued (via first variable): " + ravi.booksIssued);
        System.out.println("duplicate == ravi: " + (duplicate == ravi));

        IdCard separate = new IdCard("Ravi", 3); // distinct object, same field values
        System.out.println("separate == ravi: " + (separate == ravi));
    }
}