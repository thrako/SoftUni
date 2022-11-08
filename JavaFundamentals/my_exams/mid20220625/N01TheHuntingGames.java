package my_exams.mid20220625;

import java.util.Scanner;

public class N01TheHuntingGames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int advDays = Integer.parseInt(scanner.nextLine());
        int playersCount = Integer.parseInt(scanner.nextLine());
        double groupEnergy = Double.parseDouble(scanner.nextLine());
        double dailyWaterPerPerson = Double.parseDouble(scanner.nextLine());
        double dailyFoodPerPerson = Double.parseDouble(scanner.nextLine());
        double groupWater = advDays * playersCount * dailyWaterPerPerson;
        double groupFood = advDays * playersCount * dailyFoodPerPerson;

        boolean enoughEnergy = true;
        for (int day = 1; day <= advDays; day++) {
            double dailyEnergyLoss = Double.parseDouble(scanner.nextLine());
            //check energy
            if (groupEnergy <= dailyEnergyLoss) {
                enoughEnergy = false;
                break;
            }

            //chop wood
            groupEnergy -= dailyEnergyLoss;

            //drink water
            if (day % 2 == 0) {
                groupEnergy *= (1 + 0.05);
                groupWater *= (1 - 0.30);
            }

            //eat food
            if (day % 3 == 0) {
                groupEnergy *= (1 + 0.10);
                groupFood -= groupFood / playersCount;
            }
        }
        if (enoughEnergy) {
            System.out.printf("You are ready for the quest. You will be left with - %.2f energy!%n", groupEnergy);
        } else {
            System.out.printf("You will run out of energy. You will be left with %.2f food and %.2f water.%n", groupFood, groupWater);
        }
    }
}
