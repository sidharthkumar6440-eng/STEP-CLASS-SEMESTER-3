import java.util.Scanner;

public class UniqueLetterHunt {

    // Required method signature
    public static char findFirstNonRepeatingChar(String text) {
        int[] counts = new int[256]; // Supports standard ASCII characters

        // Step 1: Count frequency of each character
        for (int i = 0; i < text.length(); i++) {
            counts[text.charAt(i)]++;
        }

        // Step 2: Scan left-to-right for the first unique character
        for (int i = 0; i < text.length(); i++) {
            if (counts[text.charAt(i)] == 1) {
                return text.charAt(i);
            }
        }

        return '\0'; // Return null character if no unique character exists
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String input = scanner.nextLine();

        char result = findFirstNonRepeatingChar(input);

        if (result != '\0') {
            System.out.println("First Non-Repeating Character: '" + result + "'");
        } else {
            System.out.println("No Non-Repeating Character Found");
        }
        scanner.close();
    }
}
