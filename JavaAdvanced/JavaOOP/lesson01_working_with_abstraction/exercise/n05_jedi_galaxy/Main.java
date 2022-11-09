package lesson01_working_with_abstraction.exercise.n05_jedi_galaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = parseIntArray(scanner.nextLine());
        int rows = dimensions[0];
        int columns = dimensions[1];
        Galaxy galaxy = new Galaxy(rows, columns);

        Evil evil = new Evil();
        Jedi jedi = new Jedi();

        String line = scanner.nextLine();

        while (!line.equals("Let the Force be with you")) {
            int[] playerPosition = parseIntArray(line);
            int[] evilPosition = parseIntArray(scanner.nextLine());

            evil.destroyStars(galaxy.getBoard(), evilPosition);
            jedi.collectStars(galaxy.getBoard(), playerPosition);

            line = scanner.nextLine();
        }

        System.out.println(jedi.getPoints());
    }

    private static int[] parseIntArray(String scanner) {
        return Arrays.stream(scanner.split(" ")).mapToInt(Integer::parseInt).toArray();
    }

}
