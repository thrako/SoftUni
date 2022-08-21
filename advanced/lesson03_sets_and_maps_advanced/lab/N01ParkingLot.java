package lesson03_sets_and_maps_advanced.lab;

import java.util.*;

public class N01ParkingLot {
    public static void main(String[] args) {
        Set<String> parking = new LinkedHashSet<>();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while (!"END".equals(input)) {
            String[] inputData = input.split(",\\s+");
            String command = inputData[0];
            String plateNumber = inputData[1];
            switch (command) {
                case "IN":
                    parking.add(plateNumber);
                    break;
                case "OUT":
                    parking.remove(plateNumber);
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + command);
            }
            input = scanner.nextLine();
        }

        if (parking.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            for (String plate : parking) {
                System.out.println(plate);
            }
        }
    }


}
