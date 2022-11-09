package practice_past_exams.mid.exam06_unknown_retake;

import java.util.Arrays;
import java.util.Scanner;

public class N03ManOWar {
    private static final String END = "Retire";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] pirateShip = Arrays.stream(scanner.nextLine().split(">"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] warShip = Arrays.stream(scanner.nextLine().split(">"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int maxHealthCap = Integer.parseInt(scanner.nextLine());
        String[] tokens = scanner.nextLine().split("\\s+");
        String command;
        int idx, damage, startIdx, endIdx, health, criticalSectorsCount;

        battle:
        while (true) {
            command = tokens[0];
            switch (command) {
                case END:
                    int pirateShipSum = Arrays.stream(pirateShip).sum();
                    int warShipSum = Arrays.stream(warShip).sum();
                    System.out.printf(
                            "Pirate ship status: %d%n" +
                            "Warship status: %d",
                            pirateShipSum, warShipSum
                    );
                    break battle;

                case "Fire":
                    idx = Integer.parseInt(tokens[1]);
                    if (isValid(idx, warShip.length)) {
                        damage = Integer.parseInt(tokens[2]);
                        warShip[idx] -= damage;
                        if (warShip[idx] <= 0) {
                            System.out.println("You won! The enemy ship has sunken.");
                            break battle;
                        }
                    }
                    break;

                case "Defend":
                    startIdx = Integer.parseInt(tokens[1]);
                    endIdx = Integer.parseInt(tokens[2]);
                    if (!isValid(startIdx, pirateShip.length) || !isValid(endIdx, pirateShip.length)) {
                        break;
                    }
                    damage = Integer.parseInt(tokens[3]);
                    for (int i = startIdx; i <= endIdx ; i++) {
                        pirateShip[i] -= damage;
                        if (pirateShip[i] <= 0) {
                            System.out.println("You lost! The pirate ship has sunken.");
                            break battle;
                        }
                    }
                    break;

                case "Repair":
                    idx = Integer.parseInt(tokens[1]);
                    if (!isValid(idx, pirateShip.length)) {
                        break;
                    }
                    health = Integer.parseInt(tokens[2]);
                    pirateShip[idx] = Math.min(maxHealthCap, pirateShip[idx] + health);
                    break;

                case "Status":
                    criticalSectorsCount = 0;
                    for (int sector : pirateShip) {
                        if ((double) sector < maxHealthCap*0.20)
                            criticalSectorsCount++;
                    }
                    System.out.printf("%d sections need repair.%n", criticalSectorsCount);
                    break;
            }
            tokens = scanner.nextLine().split("\\s+");

        }
    }

    private static boolean isValid(int idx, int length) {
        return idx >= 0 && idx < length;
    }
}
