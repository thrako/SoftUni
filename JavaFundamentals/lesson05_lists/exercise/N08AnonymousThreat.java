package lesson05_lists.exercise;

import java.util.*;

public class N08AnonymousThreat {
    private static final String END = "3:1";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> inputs = new ArrayList<>(Arrays.asList(scanner.nextLine().split("\\s+")));
        String[] tokens = scanner.nextLine().split("\\s+");
        int startIndex, endIndex, index, partitions;
        while(!END.equals(tokens[0])) {
            String command = tokens[0];
            switch (command) {
                case "merge":
                    startIndex = Integer.parseInt(tokens[1]);
                    endIndex = Integer.parseInt(tokens[2]);
                    merge(inputs, startIndex, endIndex);
                    break;
                case "divide":
                    index = Integer.parseInt(tokens[1]);
                    partitions = Integer.parseInt(tokens[2]);
                    divide(inputs, index, partitions);
                    break;
            }
            tokens = scanner.nextLine().split("\\s+");
        }
        printDelimited(inputs, " ");
    }

    private static void merge(List<String> inputs, int startIndex, int endIndex) {
        StringBuilder strBld = new StringBuilder();
        int size = inputs.size();
        int start = isInBounds(startIndex, size) ? startIndex : 0;
        int end = isInBounds(endIndex, size) ? endIndex : size - 1;

        for (int i = start; i <= end; i++) {
            strBld.append(inputs.get(i));
        }
        inputs.set(start, strBld.toString());
        inputs.removeAll(inputs.subList(start + 1, end + 1));
    }

    private static boolean isInBounds(int idx, int size) {
        return idx >= 0 && idx < size;
    }

    private static void divide(List<String> inputs, int index, int partitions) {
        String strToDivide = inputs.get(index);
        int strLength = strToDivide.length();
        int defaultSubStrLength = strLength / partitions;
        int lastSubStrLength = defaultSubStrLength + strLength % partitions;

        List<String> subStrings = new ArrayList<>(partitions);
        if (strLength >= partitions) {
            for (int i = 0; i < partitions - 1; i++) {
                String sub = strToDivide.substring(defaultSubStrLength * i, defaultSubStrLength * (i + 1));
                subStrings.add(sub);
            }
            String last = strToDivide.substring(strLength - lastSubStrLength, strLength);
            subStrings.add(last);
        }
        inputs.remove(index);
        inputs.addAll(index, subStrings);
    }

    private static void printDelimited(List<String> strings, String delimiter) {
        StringBuilder strBld = new StringBuilder();
        for (String string : strings) strBld.append(string).append(delimiter);
        strBld.delete(strBld.length() - 1, strBld.length());
        System.out.println(strBld);
    }
}
