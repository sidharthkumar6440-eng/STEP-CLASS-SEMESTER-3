import java.util.Scanner;

public class CustomerIdentityVerification {

    // Required method signature
    public static String reverseCustomerName(String customerName) {
        if (customerName == null) return "";
        
        char[] characters = customerName.toCharArray();
        String reversed = "";
        
        // Loop backwards through the character array to reconstruct the string
        for (int i = characters.length - 1; i >= 0; i--) {
            reversed += characters[i];
        }
        
        return reversed;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter Customer Name: ");
        String originalName = scanner.nextLine();
        
        // Call the reversal method
        String reversedName = reverseCustomerName(originalName);
        
        // Print the original and reversed names as requested
        System.out.println("\nOutput:");
        System.out.println("Original Name: " + originalName);
        System.out.println("Reversed Name: " + reversedName);
        
        scanner.close();
    }
}
