package practice_past_exams.mid.exam03_20200407_retake;

import java.util.Arrays;
import java.util.Scanner;

public class N02ShootForTheWin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] targets = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int targetsShot = 0;
        String input = scanner.nextLine();
        while (!"End".equals(input)) {
            int idx = Integer.parseInt(input);
            if (isValid(targets, idx)) {
                int shotTargetVal = targets[idx];
                for (int i = 0, length = targets.length; i < length; i++) {
                    if (i == idx) {
                        targets[i] = -1;
                        targetsShot++;
                    } else if (targets[i] != -1) {
                        if (targets[i] > shotTargetVal) {
                            targets[i] -= shotTargetVal;
                        } else {
                            targets[i] += shotTargetVal;
                        }
                    }
                }
            }
            input = scanner.nextLine();
        }
        System.out.printf("Shot targets: %d ->", targetsShot);
        StringBuilder strBld = new StringBuilder();
        for (int target : targets) {
            strBld.append(" ").append(target);
        }
        System.out.print(strBld);
    }

    private static boolean isValid(int[] targets, int idx) {
        return idx >= 0 && idx < targets.length && targets[idx] != -1;
    }
}
