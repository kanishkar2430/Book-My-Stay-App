/**
 * Demonstrates centralized inventory management using HashMap.
 * This class encapsulates all room availability logic.
 *
 * @author YourName
 * @version 1.0
 */

import java.util.HashMap;
import java.util.Map;

// Inventory management class
class RoomInventory {

    // HashMap to store room type and availability
    private Map<String, Integer> inventory;

    // Constructor - initialize inventory
    public RoomInventory() {
        inventory = new HashMap<>();

        // Register room types with initial availability
        inventory.put("Single Room", 5);
        inventory.put("Double Room", 3);
        inventory.put("Suite Room", 2);
    }

    // Method to get availability of a specific room type
    public int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }

    // Method to update availability (increase or decrease)
    public void updateAvailability(String roomType, int countChange) {
        int current = inventory.getOrDefault(roomType, 0);
        inventory.put(roomType, current + countChange);
    }

    // Method to display full inventory
    public void displayInventory() {
        System.out.println("====== Room Inventory ======");
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        System.out.println("============================");
    }
}

// Main application class
public class HotelBookingApp {

    public static void main(String[] args) {

        // Initialize inventory system
        RoomInventory inventory = new RoomInventory();

        // Display initial inventory
        inventory.displayInventory();

        // Retrieve availability
        System.out.println("\nChecking availability for Suite Room:");
        System.out.println("Available: " + inventory.getAvailability("Suite Room"));

        // Update availability (e.g., booking 1 suite room)
        System.out.println("\nBooking 1 Suite Room...");
        inventory.updateAvailability("Suite Room", -1);

        // Display updated inventory
        inventory.displayInventory();

        System.out.println("\nApplication terminated.");
    }
}