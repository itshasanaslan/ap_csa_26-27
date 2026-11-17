package week06;

/**
 * Day 11 Live Coding Lab: ShippingCalculator.java
 * Demonstrates:
 *  - Multi-way selection using if-else-if chains
 *  - Correct condition ordering from lower/upper boundaries
 *  - Nested conditionals for speed handling
 *  - Invalid input handling and boundary edge cases
 */
public class ShippingCalculator {

    /**
     * Calculates the total shipping fee for a package.
     *
     * @param weight          package weight in pounds
     * @param isExpress       true if express delivery is requested
     * @param isInternational true if shipping outside the country
     * @return total shipping cost, or -1.0 if weight is invalid (<= 0)
     */
    public static double calculateShipping(double weight, boolean isExpress, boolean isInternational) {
        // Precondition / Validation Check
        if (weight <= 0.0) {
            return -1.0;
        }

        // Variable scoping: declare totalCost before branch statements
        double totalCost = 0.0;

        // TODO 1: Implement the base weight tier using an if-else-if ladder.

        // Be careful with condition ordering!
        // - Up to 2.0 lbs: $5.00
        // - Up to 5.0 lbs: $9.00
        // - Up to 10.0 lbs: $15.00
        // - Over 10.0 lbs: $25.00 + $2.00 for each whole pound over 10.0
        if (weight <= 2) {
            totalCost += 5;
        }
         if (weight <= 5) {
            totalCost += 9;
        }
         if (weight <= 10) {
            totalCost += 15;
        }        
        else {
            totalCost += 25 + ((int) (weight - 10) * 2);
        }


        // TODO 2: Implement delivery speed surcharge using a nested conditional.

        // If express:
        //    - packages up to 10.0 lbs add $12.00
        //    - packages over 10.0 lbs add $20.00



        // TODO 3: Add an international surcharge of $15.00 if isInternational is true.



        return totalCost;
    }

    public static void main(String[] args) {
        System.out.println("=== Day 11 Shipping Calculator Test Suite ===");

        // Test 1: Light package, standard, domestic -> $5.00
        System.out.println("Test 1 (1.5 lbs, standard, domestic): $" 
            + calculateShipping(1.5, false, false) + " [Expected: $5.0]");

        // Test 2: Exact boundary, express, domestic -> $9.00 + $12.00 = $21.00
        System.out.println("Test 2 (5.0 lbs, express, domestic): $" 
            + calculateShipping(5.0, true, false) + " [Expected: $21.0]");

        // Test 3: Heavy package, express, international -> Base: $25.0 + (3 * $2.0) = $31.0; Express: $20.0; Intl: $15.0 -> $66.0
        System.out.println("Test 3 (13.5 lbs, express, international): $" 
            + calculateShipping(13.5, true, true) + " [Expected: $66.0]");

        // Test 4: Invalid weight -> -1.0
        System.out.println("Test 4 (-2.0 lbs): " 
            + calculateShipping(-2.0, false, false) + " [Expected: -1.0]");
    }
}
