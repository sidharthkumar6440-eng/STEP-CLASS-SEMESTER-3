public class TrafficSignalAnalyzer {

    public static void findLongestStreak(String signalLog) {
        // Handle empty or null input scenarios safely
        if (signalLog == null || signalLog.isEmpty()) {
            System.out.println("No logs available.");
            return;
        }

        char longestChar = signalLog.charAt(0);
        int longestStreak = 1;

        char currentChar = signalLog.charAt(0);
        int currentStreak = 1;

        // Traverse the string starting from the second character
        for (int i = 1; i < signalLog.length(); i++) {
            char nextChar = signalLog.charAt(i);

            if (nextChar == currentChar) {
                currentStreak++;
            } else {
                // Update the global running maximum if the current streak is broken and longer
                if (currentStreak > longestStreak) {
                    longestStreak = currentStreak;
                    longestChar = currentChar;
                }
                // Reset tracker for the new character sequence
                currentChar = nextChar;
                currentStreak = 1;
            }
        }

        // Final check after loop terminates to account for streaks reaching the end of the string
        if (currentStreak > longestStreak) {
            longestStreak = currentStreak;
            longestChar = currentChar;
        }

        // Print the result exactly matching the sample output format
        System.out.println("Longest Streak: '" + longestChar + "' repeated " + longestStreak + " times");
    }

    public static void main(String[] args) {
        // Test Case 1
        System.out.print("Input: \"RRGGGYRR\" -> ");
        findLongestStreak("RRGGGYRR");

        // Test Case 2
        System.out.print("Input: \"RRRRYYGG\" -> ");
        findLongestStreak("RRRRYYGG");
    }
}
