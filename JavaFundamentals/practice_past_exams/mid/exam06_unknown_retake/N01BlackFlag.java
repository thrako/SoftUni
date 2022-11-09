package practice_past_exams.mid.exam06_unknown_retake;

import java.util.Scanner;

public class N01BlackFlag {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int days = Integer.parseInt(scanner.nextLine());
        int plunderPerDay = Integer.parseInt(scanner.nextLine());
        double expectedPlunder = Double.parseDouble(scanner.nextLine());
        double plunder = 0;
        for (int day = 1; day <= days; day++) {
            plunder += plunderPerDay;
            if (day % 3 == 0) {
                plunder += 0.50 * plunderPerDay;
            }
            if (day % 5 == 0) {
                plunder *= (1 - 0.30);
            }
        }
        if (plunder >= expectedPlunder) {
            System.out.printf("Ahoy! %.2f plunder gained.", plunder);
        } else {
            System.out.printf("Collected only %.2f%% of the plunder.", plunder / expectedPlunder * 100);
        }
    }
}
