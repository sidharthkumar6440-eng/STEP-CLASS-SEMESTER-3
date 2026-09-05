public class SeatDuplicationChecker{

    // Required method signature using standard loops and arrays only
    public static void checkDuplicateSeats(int[] seatNumbers) {
        if (seatNumbers == null || seatNumbers.length == 0) {
            System.out.println("No Duplicate Seats Found");
            return;
        }

        boolean duplicateFound = false;

        // Nested loops to compare every element against every other element
        for (int i = 0; i < seatNumbers.length; i++) {
            for (int j = i + 1; j < seatNumbers.length; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
                    duplicateFound = true;
                    // Break inner loop to prevent printing the same pair multiple times
                    break; 
                }
            }
        }

        // If the loop finished without finding any matches
        if (!duplicateFound) {
            System.out.println("No Duplicate Seats Found");
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Test Case 1 (Duplicates Present) ---");
        int[] testSet1 = {101, 102, 103, 102, 105};
        System.out.print("Input: {101, 102, 103, 102, 105} -> ");
        checkDuplicateSeats(testSet1);

        System.out.println("\n--- Test Case 2 (No Duplicates) ---");
        int[] testSet2 = {101, 102, 103, 104, 105};
        System.out.print("Input: {101, 102, 103, 104, 105} -> ");
        checkDuplicateSeats(testSet2);
    }
}
