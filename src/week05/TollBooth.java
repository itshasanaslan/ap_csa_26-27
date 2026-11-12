package week05;

public class TollBooth {

    /**
     * Calculates the total toll for a vehicle.
     *
     * @param vehicleType 1 for Passenger Car, 2 for Commercial Truck
     * @param passengers  number of occupants in the vehicle (>= 1)
     * @param isRushHour  true if during peak hours, false otherwise
     * @param hasTransponder true if vehicle has an electronic pass, false otherwise
     * @return the final calculated toll fee
     */
    public static double calculateToll(int vehicleType, int passengers, boolean isRushHour, boolean hasTransponder) {
        
        // TODO 1: Declare your toll variable in the outer scope.
        // Watch your scope! If you declare it inside an if block, you cannot return it.

        // TODO 2: Determine base rate using a two-way if-else statement.
        // vehicleType 1 -> $5.00, otherwise -> $10.00.
            

        // TODO 3: Add a $2.50 surcharge if it is rush hour.


        // TODO 4: Apply a $2.00 carpool discount if the vehicle is a 
        // passenger car AND has 3 or more passengers.


        // TODO 5: Add a $3.00 administrative fee if the driver does NOT have a transponder.


        // TODO 6: Ensure the toll is never negative (safety floor check).


        // TODO 7: Return the final calculated toll.
        return 0.0; // Replace with your variable
    }

    public static void main(String[] args) {
        System.out.println("--- Running Toll Booth Test Suite ---");

        // Test 1: Solo car, off-peak, with transponder -> Expected: $5.00
        System.out.println("Test 1: $" + calculateToll(1, 1, false, true) + " (Expected: $5.0)");

        // Test 2: Carpool car (3 passengers), rush hour, with transponder -> Expected: $5.50
        System.out.println("Test 2: $" + calculateToll(1, 3, true, true) + " (Expected: $5.5)");

        // Test 3: Commercial truck, rush hour, NO transponder -> Expected: $15.50
        System.out.println("Test 3: $" + calculateToll(2, 1, true, false) + " (Expected: $15.5)");

        // Test 4: Solo car, off-peak, NO transponder -> Expected: $8.00
        System.out.println("Test 4: $" + calculateToll(1, 1, false, false) + " (Expected: $8.0)");
    }
}