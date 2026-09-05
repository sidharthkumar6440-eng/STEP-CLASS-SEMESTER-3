import java.util.Scanner;

public class FileExtensionValidator {

    // Target method from the task specification
    public static String validateFileExtension(String filename) {
        // Validation check for empty or dotless naming files
        if (filename == null || !filename.contains(".")) {
            return "Rejected — invalid file type";
        }

        // Find the last dot marker using lastIndexOf and slice the suffix
        int lastDotIndex = filename.lastIndexOf('.');
        String extension = filename.substring(lastDotIndex + 1);

        // Perform case-insensitive checks against the whitelist
        if (extension.equalsIgnoreCase("pdf") || 
            extension.equalsIgnoreCase("docx") || 
            extension.equalsIgnoreCase("zip")) {
            return "Accepted";
        }

        return "Rejected — invalid file type";
    }

    public static void main(String[] args) {
        String test1 = "Assignment1.PDF";
        String test2 = "notes.txt";

        System.out.println("Input: \"" + test1 + "\" -> Output: " + validateFileExtension(test1));
        System.out.println("Input: \"" + test2 + "\" -> Output: " + validateFileExtension(test2));
    }
}
