package lesson03_arrays.exercise;

import java.util.Scanner;

public class N10TreasureHunt {
    final static String END = "Yohoho!";
    static String[] chestItems;

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        chestItems = scanner.nextLine().split("\\|");

        String[] inputs = scanner.nextLine().split(" ");
        while (!inputs[0].equals(END)) {
            switch (inputs[0]) {
                case "Loot":
                    for (int i = 1, length = inputs.length; i < length; i++) {
                        if (!isContained(inputs[i])) {
                            add(inputs[i]);
                        }
                    }
                    break;
                case "Drop":
                    int index = Integer.parseInt(inputs[1]);
                    drop(index);
                    break;
                case "Steal":
                    int numStolenItems = Integer.parseInt(inputs[1]);
                    steal(numStolenItems);
                    break;
            }
            inputs = scanner.nextLine().split(" ");
        }

        printResult();
    }

    private static boolean isContained(String item) {
        for (String chestItem : chestItems) {
            if (item.equals(chestItem)) {
                return true;
            }
        }
        return false;
    }

    private static void add(String item) {
        int length = chestItems.length;
        String[] tempArr = new String[length + 1];
        tempArr[0] = item;
        System.arraycopy(chestItems, 0, tempArr, 1, length);
        chestItems = tempArr;
    }

    private static void drop(int index) {
        if (index < 0 || index >= chestItems.length - 1) {
            return;
        }
        int length = chestItems.length;
        String droppedItem = chestItems[index];
        String[] tempArr = new String[length];
        System.arraycopy(chestItems, 0, tempArr, 0, index);
        System.arraycopy(chestItems, index + 1, tempArr, index, length - 1 - index);
        tempArr[length-1] = droppedItem;
        chestItems = tempArr;
    }

    private static void steal(int numStolenItems) {
        int currentLength = chestItems.length;
        int reducedLength = (numStolenItems <= currentLength) ? currentLength - numStolenItems : 0;
        String[] tempArr = new String[reducedLength];

        System.arraycopy(chestItems, 0, tempArr, 0, reducedLength);

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = reducedLength; i < currentLength - 1; i++) {
            stringBuilder.append(chestItems[i]).append(", ");
        }
        stringBuilder.append(chestItems[currentLength - 1]);
        System.out.println(stringBuilder);

        chestItems = tempArr;
    }

    private static double calculateAvgGain(String[] chestItems) {
        int count = chestItems.length;
        double sum = 0;
        for (String item: chestItems) {
            sum += item.length();
        }
        return sum / count;
    }

    private static void printResult() {
        if (chestItems.length > 0) {
            double avgGain = calculateAvgGain(chestItems);
            System.out.printf("Average treasure gain: %.2f pirate credits.", avgGain);
        } else {
            System.out.println("Failed treasure hunt.");
        }
    }
}
