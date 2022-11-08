package lesson01_working_with_abstraction.lab.n03_strudents_system;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentSystem studentSystem = new StudentSystem();

        String line = scanner.nextLine();
        while (!"Exit".equals(line)) {
            String[] lineParts = line.split(" ");
            final String command = lineParts[0];

            switch (command) {
                case "Create": {
                    String name = lineParts[1];
                    int age = Integer.parseInt(lineParts[2]);
                    double grade = Double.parseDouble(lineParts[3]);
                    studentSystem.createStudent(name, age, grade);
                    break;
                }
                case "Show": {
                    String name = lineParts[1];
                    studentSystem.show(name);
                    break;
                }
            }

            line = scanner.nextLine();
        }
    }

}
