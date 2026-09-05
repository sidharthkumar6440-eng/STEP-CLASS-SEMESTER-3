import java.util.Random;

public class BmiTeamCalculator {

    // 1. Core method: Classifies the health status based on standard BMI thresholds
    public static String getBmiStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25.0) { // 18.5 to 24.9
            return "Normal";
        } else if (bmi < 30.0) { // 25.0 to 29.9
            return "Overweight";
        } else { // 30.0 and above
            return "Obese";
        }
    }

    // 2. Reporting method: Computes metrics and formats the final summary table
    public static void printWellnessReport(double[] heights, double[] weights) {
        int totalPeople = heights.length;
        
        System.out.println("======================================== CORPORATE WELLNESS REPORT ========================================");
        System.out.printf("%-10s | %-12s | %-12s | %-10s | %-15s\n", "Person", "Height (m)", "Weight (kg)", "BMI", "Status");
        System.out.println("----------------------------------------------------------------------------------------------------------");
        
        for (int i = 0; i < totalPeople; i++) {
            double height = heights[i];
            double weight = weights[i];
            
            // Formula: BMI = weight / (height * height)
            double bmi = weight / (height * height);
            String status = getBmiStatus(bmi);
            
            System.out.printf("Person %-3d | %-12.2f | %-12.1f | %-10.2f | %-15s\n", 
                    (i + 1), height, weight, bmi, status);
        }
        System.out.println("==========================================================================================================");
    }

    public static void main(String[] args) {
        Random random = new Random();
        int teamSize = 10; // Suggested team size: 10

        // Parallel arrays to hold dataset values
        double[] heights = new double[teamSize];
        double[] weights = new double[teamSize];

        // Seed random values within realistic ranges for adult human demographics
        // Heights: 1.50m to 1.95m
        // Weights: 45.0kg to 110.0kg
        for (int i = 0; i < teamSize; i++) {
            heights[i] = 1.50 + (random.nextDouble() * 0.45);
            weights[i] = 45.0 + (random.nextDouble() * 65.0);
        }

        // Generate the dashboard layout
        printWellnessReport(heights, weights);
    }
}
