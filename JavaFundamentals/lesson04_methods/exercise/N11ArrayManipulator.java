package lesson04_methods.exercise;

import java.util.*;

public class N11ArrayManipulator {
    private static int[] elements;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        elements = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        String command, evenOrOdd;
        int idx, limit;

        String[] tokens = scanner.nextLine().split(" ");
        while (!"end".equals(tokens[0])) {
            command = tokens[0];

            switch (command) {
                case "exchange":
                    idx = Integer.parseInt(tokens[1]);
                    if (!isInBounds(idx)) System.out.println("Invalid index");
                    else exchange(idx);
                    break;
                case "min":
                case "max":
                    evenOrOdd = tokens[1];
                    System.out.println(find(command, evenOrOdd));
                    break;
                case "first":
                case "last":
                    limit = Integer.parseInt(tokens[1]);
                    evenOrOdd = tokens[2];
                    System.out.println(find(command, limit, evenOrOdd));
                    break;
            }
            tokens = scanner.nextLine().split(" ");
        }
        System.out.println(Arrays.toString(elements));
    }

    private static void exchange(int idx) {

        int length = elements.length;
        int[] tempArr = new int[length];
        for (int i = 0; i < length; i++) {
            tempArr[i] = (idx + i + 1 >= length) ? elements[idx + i + 1 - length] : elements[idx + i + 1];
        }
        elements = tempArr;
    }

    private static String find(String command, String evenOrOdd) {

        int idxSought = ("min".equals(command)) ? getMinIndex(evenOrOdd)
                : "max".equals(command) ? getMaxIndex(evenOrOdd)
                : -1;

        if (idxSought == -1) return "No matches";
        return String.valueOf(idxSought);
    }

    private static String find(String command, int limit, String evenOrOdd) {
        if (limit > elements.length) return "Invalid count";

        Integer[] evensOrOdds = getAll(evenOrOdd);
        int length = evensOrOdds.length;

        if (length <= limit) return Arrays.toString(evensOrOdds);
        if ("first".equals(command)) return Arrays.toString(Arrays.copyOf(evensOrOdds, limit));

        if ("last".equals(command)) {
            Integer[] temp = new Integer[limit];
            System.arraycopy(evensOrOdds, length - limit, temp, 0, limit);
            return Arrays.toString(temp);
        }
        return  Arrays.toString(new Integer[0]);
    }

    private static int getMinIndex(String evenOrOdd) {
        int min = Integer.MAX_VALUE, idx = -1;
        for (int length = elements.length, i = length - 1; i > -1; i--) {
            int num = elements[i];
            if (isTypeSought(evenOrOdd, num) && num < min) {
                idx = i;
                min = num;
            }
        }
        return idx;
    }

    private static int getMaxIndex(String evenOrOdd) {
        int max = Integer.MIN_VALUE, idx = -1;
        for (int length = elements.length, i = length - 1; i > -1; i--) {
            int num = elements[i];
            if (isTypeSought(evenOrOdd, num) && num > max) {
                idx = i;
                max = num;
            }
        }
        return idx;
    }

    private static boolean isInBounds(int idx) {
        return idx >= 0 && idx < elements.length;
    }

    private static Integer[] getAll(String evenOrOdd) {
        List<Integer> tempArrList = new ArrayList<>();
        for (int element : elements) {
            if (isTypeSought(evenOrOdd, element)) {
                tempArrList.add(element);
            }
        }
        return tempArrList.toArray(new Integer[0]);
    }

    private static boolean isTypeSought(String evenOrOdd, int num) {
        return ("even".equals(evenOrOdd) && num % 2 == 0) || ("odd".equals(evenOrOdd) && num % 2 != 0);
    }
}