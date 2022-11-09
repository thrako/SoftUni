package practice_past_exams.mid.exam05_unknown_regular;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class N01BonusScoringSystem_Loops {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int studentsCount = Integer.parseInt(scanner.nextLine());
        int totalLecturesCount = Integer.parseInt(scanner.nextLine());
        int additionalBonus = Integer.parseInt(scanner.nextLine());

        int[] stdMaxScore = new int[2];
        if (studentsCount > 0) {
            int[][] students = new int[studentsCount][2];
            for (int i = 0, length = students.length; i < length; i++) {
                int[] student = students[i];
                student[0] = Integer.parseInt(scanner.nextLine()); // students[i][0] - attendances
                student[1] = (int) Math.ceil(((double) student[0] / totalLecturesCount) * (5 + additionalBonus)); // students[i][1] - bonuses
            }
            stdMaxScore = Arrays.stream(students).max(Comparator.comparingInt(e -> e[0])).get();
        }

        System.out.printf("" +
                "Max Bonus: %d.%n" +
                "The student has attended %d lectures.",
                stdMaxScore[1], stdMaxScore[0]
        );
    }
}
