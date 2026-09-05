import java.util.Scanner;

public class PhoneNumberFormatter {

    // Target method from the task specification
    public static String maskPhoneNumber(String phone) {
        // Rule: Verify length is exactly 10 characters
        if (phone == null || phone.length() != 10) {
            return "Invalid phone number";
        }

        // Rule: All characters must be digit elements
        for (int i = 0; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i))) {
                return "Invalid phone number";
            }
        }

        // Extract last 4 digit profile segments using a substring split
        String lastFourDigits = phone.substring(6);

        // Combine segments cleanly with a StringBuilder pipeline
        StringBuilder sb = new StringBuilder("XXXXXX");
        sb.append("-");
        sb.append(lastFourDigits);

        return sb.toString();
    }

    public static void main(String[] args) {
        String phone1 = "9876543210";
        String phone2 = "98765";

        System.out.println("Input: \"" + phone1 + "\" -> Output: " + maskPhoneNumber(phone1));
        System.out.println("Input: \"" + phone2 + "\" -> Output: " + maskPhoneNumber(phone2));
    }
}
