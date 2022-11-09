package practice_past_exams.mid.exam05_unknown_regular;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class N01BonusScoringSystem_StreamAPI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int studentsCount = Integer.parseInt(scanner.nextLine());
        int totalLecturesCount = Integer.parseInt(scanner.nextLine());
        int additionalBonus = Integer.parseInt(scanner.nextLine());

        int[] stdMaxScore = new int[2];
        if (studentsCount > 0) {
            int[][] students = new int[studentsCount][2];
            fillStdData(students, scanner, totalLecturesCount, additionalBonus);
            stdMaxScore = Arrays.stream(students).max(Comparator.comparingInt(e -> e[0])).get();
        }

        System.out.printf("" +
                "Max Bonus: %d.%n" +
                "The student has attended %d lectures.",
                stdMaxScore[1], stdMaxScore[0]
        );
    }

    private static void fillStdData(int[][] students, Scanner scanner, int totalLecturesCount, int additionalBonus) {
        Arrays.stream(students).forEach(e -> {
            e[0] = Integer.parseInt(scanner.nextLine()); // students[i][0] - attendances
            e[1] = (int) Math.ceil(((double) e[0] / totalLecturesCount) * (5 + additionalBonus)); // students[i][1] - bonuses
        });
    }
}
