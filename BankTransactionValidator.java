import java.util.Scanner;

public class BankTransactionValidator {

    // First required structural baseline target method
    public static String normalizeReference(String raw) {
        if (raw == null) return "";
        
        String trimmed = raw.trim();
        if (trimmed.length() < 3) {
            return trimmed;
        }

        // Transform only the initial 3 bank identifiers to absolute uppercase
        String bankCodeUpper = trimmed.substring(0, 3).toUpperCase();
        String body = trimmed.substring(3);

        return bankCodeUpper + body;
    }

    // Second required operational structural method
    public static String validateAndFormat(String reference) {
        // Rule check 1: Assert length constraints match exactly 14 characters
        if (reference.length() != 14) {
            return "Invalid: wrong length";
        }

        // Rule check 2: Verify first 3 parts are alphanumeric alpha bounds
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(reference.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }

        // Rule check 3: Verify trailing body elements consist only of numbers
        for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(reference.charAt(i))) {
                return "Invalid: reference body must contain only digits";
            }
        }

        // Segment components into formatting partitions
        String bankCode = reference.substring(0, 3);
        String day = reference.substring(3, 5);
        String month = reference.substring(5, 7);
        String year = reference.substring(7, 9);
        String sequence = reference.substring(9, 14);

        // Build the target layout print signature output
        StringBuilder formatted = new StringBuilder();
        formatted.append("[").append(bankCode).append("] ");
        formatted.append("DATE: ").append(day).append("/").append(month).append("/").append(year);
        formatted.append(" | SEQ: ").append(sequence);

        return formatted.toString();
    }

    public static void main(String[] args) {
        String input1 = " hdf03022600042 ";
        String normalized1 = normalizeReference(input1);
        System.out.println("Input: \"" + input1 + "\" \nOutput: " + validateAndFormat(normalized1));

        System.out.println();

        String input2 = "12F03022600042";
        String normalized2 = normalizeReference(input2);
        System.out.println("Input: \"" + input2 + "\" \nOutput: " + validateAndFormat(normalized2));
    }
}
