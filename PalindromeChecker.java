import java.util.Scanner;

public class PalindromeChecker {

    // 1. Iterative Approach: Compare characters from both ends moving toward the middle
    public static boolean isPalindromeIterative(String text) {
        if (text == null) return false;
        
        int left = 0;
        int right = text.length() - 1;
        
        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // 2. Recursive Approach: Compare first and last, then recursively check the substring
    public static boolean isPalindromeRecursive(String text) {
        if (text == null) return false;
        
        // Base cases
        if (text.length() <= 1) {
            return true;
        }
        
        // Check outer characters
        if (text.charAt(0) != text.charAt(text.length() - 1)) {
            return false;
        }
        
        // Recursive step: strip first and last character
        return isPalindromeRecursive(text.substring(1, text.length() - 1));
    }

    // 3. Array Reversal Approach: Convert to char array, reverse it, and compare to original
    public static boolean isPalindromeArrayReversal(String text) {
        if (text == null) return false;
        
        char[] original = text.toCharArray();
        char[] reversed = new char[original.length];
        
        // Build reversed array
        for (int i = 0; i < original.length; i++) {
            reversed[i] = original[original.length - 1 - i];
        }
        
        // Compare the contents of both arrays
        for (int i = 0; i < original.length; i++) {
            if (original[i] != reversed[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("--- QA Text Verification Toolkit: Palindrome Checker ---");
        System.out.print("Enter a word or short phrase: ");
        String input = scanner.nextLine();
        
        // Execute all three independent logic branches
        boolean iterativeResult = isPalindromeIterative(input);
        boolean recursiveResult = isPalindromeRecursive(input);
        boolean reversalResult = isPalindromeArrayReversal(input);
        
        // Format readable text versions of the boolean values
        String iterativeStr = iterativeResult ? "Palindrome" : "Not Palindrome";
        String recursiveStr = recursiveResult ? "Palindrome" : "Not Palindrome";
        String reversalStr = reversalResult ? "Palindrome" : "Not Palindrome";
        
        // Print the final combined confirmation output matching the specification layout
        System.out.println("\nOutput:");
        System.out.printf("Iterative: %s | Recursive: %s | Array Reversal: %s\n", 
                iterativeStr, recursiveStr, reversalStr);
                
        // Validation check to make sure all three systems agree
        if (iterativeResult == recursiveResult && recursiveResult == reversalResult) {
            System.out.println("\n[Verification Success] All three independent algorithms agree on the result.");
        } else {
            System.out.println("\n[Warning] Discrepancy detected between implementation models.");
        }
        
        scanner.close();
    }
}

