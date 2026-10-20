import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Delivery> deliveries = new ArrayList<>();

        System.out.print("How many deliveries? ");
        int number = input.nextInt();

        for (int i = 1; i <= number; i++) {
            System.out.print("Delivery " + i + " - type (R/E): ");
            String type = input.next().toUpperCase();

            if (!type.equals("R") && !type.equals("E")) {
                System.out.println("Invalid type! Use R or E.");
                i--;
                continue;
            }

            System.out.print("Delivery " + i + " - distance (km): ");
            int distance = input.nextInt();

            System.out.print("Delivery " + i + " - weight (kg): ");
            int weight = input.nextInt();

            if (type.equals("R")) {
                deliveries.add(new RegularDelivery(distance, weight));
            } else {
                deliveries.add(new ExpressDelivery(distance, weight));
            }
        }

        long total = 0;

        System.out.println("\n--- DELIVERY FEE SUMMARY ---");

        for (int i = 0; i < deliveries.size(); i++) {
            long fee = deliveries.get(i).calculateFee();

            System.out.println(
                    "Delivery " + (i + 1) + ": " + fee + " units"
            );

            total += fee;
        }

        System.out.println("Total delivery fees: " + total + " units");

        input.close();
    }
}