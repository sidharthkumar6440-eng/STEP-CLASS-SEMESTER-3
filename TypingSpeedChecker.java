public class TypingSpeedChecker {

    public static void checkTypingAccuracy(String original, String typed) {
        // Ensure the lengths are equal as stated in the task requirements
        if (original == null || typed == null || original.length() != typed.length()) {
            System.out.println("Error: The original and typed strings must be of equal length.");
            return;
        }

        int totalCharacters = original.length();
        int matchedCharacters = 0;
        int firstMismatchPosition = -1;

        // Traverse both strings character by character
        for (int i = 0; i < totalCharacters; i++) {
            char origChar = original.charAt(i);
            char typedChar = typed.charAt(i);

            if (origChar == typedChar) {
                matchedCharacters++;
            } else {
                // Record the 1-indexed position of the first mismatch
                if (firstMismatchPosition == -1) {
                    firstMismatchPosition = i + 1;
                }
            }
        }

        // Calculate the accuracy percentage
        double accuracy = ((double) matchedCharacters / totalCharacters) * 100;

        // Print the final result in the exact requested format
        System.out.print("Matched: " + matchedCharacters + "/" + totalCharacters + 
                         " | Accuracy: " + String.format("%.2f", accuracy) + "% | ");

        if (firstMismatchPosition == -1) {
            System.out.println("No Mismatches");
        } else {
            char origMismatchChar = original.charAt(firstMismatchPosition - 1);
            char typedMismatchChar = typed.charAt(firstMismatchPosition - 1);
            System.out.println("First Mismatch at position " + firstMismatchPosition + 
                               " ('" + origMismatchChar + "' vs '" + typedMismatchChar + "')");
        }
    }

    public static void main(String[] args) {
        // Test Case 1
        System.out.println("--- Test Case 1 ---");
        checkTypingAccuracy("hello world", "hello worlt");

        // Test Case 2
        System.out.println("--- Test Case 2 ---");
        checkTypingAccuracy("coding", "coding");
    }
}
