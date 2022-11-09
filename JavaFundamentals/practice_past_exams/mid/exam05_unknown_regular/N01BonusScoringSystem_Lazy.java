package practice_past_exams.mid.exam05_unknown_regular;

import java.util.Scanner;

public class N01BonusScoringSystem_Lazy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int stdCount = Integer.parseInt(scanner.nextLine());
        int totalLecturesCount = Integer.parseInt(scanner.nextLine());
        int additionalBonus = Integer.parseInt(scanner.nextLine());

        int maxLecturesAttended = 0;
        for (int i = 0, stdAttendance; i < stdCount; i++) {
            stdAttendance = Integer.parseInt(scanner.nextLine());
            if (stdAttendance > maxLecturesAttended) maxLecturesAttended = stdAttendance;
        }

        System.out.printf("" +
                "Max Bonus: %d.%n" +
                "The student has attended %d lectures.",
                (int) Math.ceil(((double) maxLecturesAttended / totalLecturesCount) * (5 + additionalBonus)), maxLecturesAttended
        );
    }
}
