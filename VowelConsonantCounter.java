public class VowelConsonantCounter {

    // Method to count and display vowels and consonants case-insensitively
    public static void countVowelsAndConsonants(String text) {
        if (text == null) {
            System.out.println("Vowels: 0 | Consonants: 0");
            return;
        }

        int vowelsCount = 0;
        int consonantsCount = 0;

        // Loop through each character using charAt()
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            // Convert to lowercase to ensure case-insensitive comparison
            char lowCh = Character.toLowerCase(ch);

            // Ignore spaces as specified in the task rules
            if (lowCh == ' ') {
                continue;
            }

            // Check if the character is a vowel
            if (lowCh == 'a' || lowCh == 'e' || lowCh == 'i' || lowCh == 'o' || lowCh == 'u') {
                vowelsCount++;
            } else if (lowCh >= 'a' && lowCh <= 'z') { 
                // Since input contains only letters and spaces, remaining letters are consonants
                consonantsCount++;
            }
        }

        // Print the output matching the exact format shown in the sample
        System.out.println("Vowels: " + vowelsCount + " | Consonants: " + consonantsCount);
    }

    public static void main(String[] args) {
        // Sample test case
        String sampleInput = "Java Programming";
        
        System.out.println("--- Test Case ---");
        System.out.println("Input: \"" + sampleInput + "\"");
        System.out.print("Output: ");
        countVowelsAndConsonants(sampleInput);
    }
}
