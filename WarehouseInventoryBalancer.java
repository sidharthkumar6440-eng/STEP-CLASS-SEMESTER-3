public class WarehouseInventoryBalancer {

    public static void analyzeInventory(int[] sectionA, int[] sectionB) {
        // Validation check for array lengths
        if (sectionA == null || sectionB == null || sectionA.length != sectionB.length) {
            System.out.println("Error: Sections must be non-null and have equal categories.");
            return;
        }

        int totalA = 0;
        int totalB = 0;
        
        int highestQuantity = Integer.MIN_VALUE;
        String highestSection = "";
        int highestItemIndex = -1; // Will store 1-based index

        // Scan both arrays simultaneously
        for (int i = 0; i < sectionA.length; i++) {
            totalA += sectionA[i];
            totalB += sectionB[i];

            // Check Section A for highest quantity
            if (sectionA[i] > highestQuantity) {
                highestQuantity = sectionA[i];
                highestSection = "Section A";
                highestItemIndex = i + 1; // 1-based index for "Item X"
            }

            // Check Section B for highest quantity
            if (sectionB[i] > highestQuantity) {
                highestQuantity = sectionB[i];
                highestSection = "Section B";
                highestItemIndex = i + 1;
            }
        }

        // Determine status string
        String status = (totalA == totalB) ? "Balanced" : "Not Balanced";

        // Print final result matching the exact layout format
        System.out.println("Section A Total: " + totalA + 
                           " | Section B Total: " + totalB + 
                           " | Status: " + status + 
                           " | Highest Quantity: " + highestQuantity + 
                           " (" + highestSection + ", Item " + highestItemIndex + ")");
    }

    public static void main(String[] args) {
        // Test case from the sample input/output
        int[] sectionA = {20, 15, 30};
        int[] sectionB = {25, 10, 30};

        System.out.println("--- Test Case ---");
        analyzeInventory(sectionA, sectionB);
    }
}

