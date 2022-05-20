package datatypesandvariables.exercise;

import java.util.Scanner;

public class N08_Beer_Kegs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String biggestModel = "";
        double biggestVolume = 0;

        int lines = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < lines; i++) {
            String currModel = scanner.nextLine();
            double currRadius = Double.parseDouble(scanner.nextLine());
            int currHeight = Integer.parseInt(scanner.nextLine());
            double currVolume = Math.PI * Math.pow(currRadius, 2) * currHeight;
            if (currVolume > biggestVolume) {
                biggestVolume = currVolume;
                biggestModel = currModel;
            }
        }
        System.out.println(biggestModel);
    }
}
