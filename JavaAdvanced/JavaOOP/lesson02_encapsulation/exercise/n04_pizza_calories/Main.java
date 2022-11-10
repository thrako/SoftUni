package lesson02_encapsulation.exercise.n04_pizza_calories;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] pizzaData = scanner.nextLine().split("\\s+");
        String pizzaName = pizzaData[1];
        int pizzaNumOfToppings = Integer.parseInt(pizzaData[2]);
        Pizza pizza;
        try {
            pizza = new Pizza(pizzaName, pizzaNumOfToppings);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }

        String[] doughData = scanner.nextLine().split("\\s+");
        String doughFlour = doughData[1];
        String doughTechnique = doughData[2];
        double doughWeight = Double.parseDouble(doughData[3]);
        try {
            Dough dough = new Dough(doughFlour, doughTechnique, doughWeight);
            pizza.setDough(dough);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }

        String input = scanner.nextLine();
        while (!"END".equals(input)) {
            String[] toppingData = input.split("\\s+");
            String toppingType = toppingData[1];
            double toppingWeight = Double.parseDouble(toppingData[2]);
            try {
                pizza.addTopping(new Topping(toppingType, toppingWeight));
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return;
            }
            input = scanner.nextLine();
        }

        System.out.printf("%s - %.2f", pizza.getName(), pizza.getOverallCalories());
    }
}
