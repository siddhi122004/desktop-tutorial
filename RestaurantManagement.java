
package restaurant;

import java.util.*;

public class RestaurantManagement {

    static ArrayList<String> food = new ArrayList<>();
    static ArrayList<Integer> price = new ArrayList<>();

    static Scanner sc = new Scanner(System.in);

    // Display Menu
    static void displayMenu() {

        System.out.println("\n===== RESTAURANT MENU =====");

        for (int i = 0; i < food.size(); i++) {
            System.out.println((i + 1) + ". " +
                    food.get(i) + " - Rs." + price.get(i));
        }

        System.out.println("\n6. Place Order");
        System.out.println("7. Exit");
    }

    // Generate Bill
    static void generateBill(
            ArrayList<Integer> selectedItems,
            ArrayList<Integer> quantities) {

        if (selectedItems.isEmpty()) {
            System.out.println("No items ordered!");
            return;
        }

        int total = 0;

        System.out.println("\n========== RESTAURANT BILL ==========");

        System.out.printf("%-18s %-10s %-10s%n",
                "Food Item", "Quantity", "Amount");

        for (int i = 0; i < selectedItems.size(); i++) {

            int index = selectedItems.get(i);
            int quantity = quantities.get(i);

            int amount = price.get(index) * quantity;

            total += amount;

            System.out.printf("%-18s %-10d Rs.%-10d%n",
                    food.get(index), quantity, amount);
        }

        System.out.println("-------------------------------------");
        System.out.println("Total Bill: Rs." + total);
        System.out.println("Thank You! Visit Again!");
        System.out.println("=====================================");
    }

    // Main Method
    public static void main(String[] args) {

        // Adding Food Items
        food.add("Pizza");
        price.add(200);

        food.add("Burger");
        price.add(100);

        food.add("Sandwich");
        price.add(80);

        food.add("Pasta");
        price.add(150);

        food.add("Cold Coffee");
        price.add(90);

        ArrayList<Integer> selectedItems = new ArrayList<>();
        ArrayList<Integer> quantities = new ArrayList<>();

        System.out.println("WELCOME TO OUR RESTAURANT!");

        // Display menu only once
        displayMenu();

        int choice = 0;

        do {

            try {

                System.out.print(
                        "\nEnter food number (1-5), 6 to Place Order, 7 to Exit: ");

                choice = Integer.parseInt(sc.nextLine());

                if (choice >= 1 && choice <= 5) {

                    System.out.print("Enter quantity: ");

                    int quantity = Integer.parseInt(sc.nextLine());

                    if (quantity <= 0) {
                        System.out.println("Invalid quantity!");
                    } else {

                        selectedItems.add(choice - 1);
                        quantities.add(quantity);

                        System.out.println(
                                food.get(choice - 1) +
                                " added successfully!");

                    }
                }

                else if (choice == 6) {

                    // Generate Final Bill
                    generateBill(selectedItems, quantities);

                    selectedItems.clear();
                    quantities.clear();

                    break;
                }

                else if (choice == 7) {

                    System.out.println("Thank You! Visit Again!");
                    break;

                }

                else {
                    System.out.println("Invalid choice!");
                }

            } catch (NumberFormatException e) {

                System.out.println("Please enter a valid number!");

            }

        } while (true);

        sc.close();
    }
}
