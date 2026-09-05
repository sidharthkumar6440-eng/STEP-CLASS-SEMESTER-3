public class CSVStudentRecordParser {

    // Method to parse and validate CSV line data
    public static void parseStudentRecord(String csvLine) {
        if (csvLine == null || csvLine.trim().isEmpty()) {
            System.out.println("Invalid Record");
            return;
        }

        // Split the input line by the comma delimiter
        String[] fields = csvLine.split(",");

        // Validate that exactly 3 fields are present
        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }

        // Clean up any extra leading or trailing spaces from the fields
        String name = fields[0].trim();
        String rollNo = fields[1].trim();
        String dept = fields[2].trim();

        // Print the formatted record exactly as shown in the first sample output
        System.out.println("Name: " + name + " | Roll No: " + rollNo + " | Dept: " + dept);
    }

    public static void main(String[] args) {
        // Test Case 1: Valid Record
        System.out.println("--- Test Case 1 (Valid) ---");
        String input1 = "Ananya Verma,RA2211003010123,CSE";
        System.out.println("Input:  \"" + input1 + "\"");
        System.out.print("Output: ");
        parseStudentRecord(input1);

        System.out.println();

        // Test Case 2: Invalid Record (Missing Roll Number)
        System.out.println("--- Test Case 2 (Invalid) ---");
        String input2 = "Ananya Verma,CSE";
        System.out.println("Input:  \"" + input2 + "\"");
        System.out.print("Output: ");
        parseStudentRecord(input2);
    }
}
