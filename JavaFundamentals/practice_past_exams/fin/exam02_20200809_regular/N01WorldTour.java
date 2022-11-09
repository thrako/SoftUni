package practice_past_exams.fin.exam02_20200809_regular;

import java.util.Scanner;

public class N01WorldTour {
    private static final String END = "Travel";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String stops = scanner.nextLine();
        String first, second, oldStop, newStop;
        int idx, endIdx;
        String[] tokens = scanner.nextLine().split(":");
        while (!END.equals(tokens[0])) {
            switch (tokens[0]) {
                case "Add Stop":
                    idx = Integer.parseInt(tokens[1]);
                    if (isValid(idx, stops.length())) {
                        newStop = tokens[2];
                        first = stops.substring(0, idx);
                        second = stops.substring(idx);
                        stops = first.concat(newStop).concat(second);
                    }
                    System.out.println(stops);
                    break;
                case "Remove Stop":
                    idx = Integer.parseInt(tokens[1]);
                    endIdx = Integer.parseInt(tokens[2]);
                    if (isValid(idx, stops.length()) && isValid(endIdx, stops.length())) {
                        first = stops.substring(0, idx);
                        second = (endIdx < stops.length() - 1) ? stops.substring(endIdx + 1) : "";
                        stops = first.concat(second);
                    }
                    System.out.println(stops);
                    break;
                case "Switch":
                    oldStop = tokens[1];
                    newStop = tokens[2];
                    stops = stops.replace(oldStop, newStop);
                    System.out.println(stops);
                    break;
                default:
            }
            tokens = scanner.nextLine().split(":");
        }
        System.out.printf("Ready for world tour! Planned stops: %s", stops);
    }

    private static boolean isValid(int idx, int length) {
        return idx >= 0 && idx < length;
    }
}
