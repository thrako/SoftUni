package lesson02_encapsulation.exercise.n03_shopping_spree;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Map<String, Person> people = new LinkedHashMap<>();
        Map<String, Product> products = new HashMap<>();

        Scanner scanner = new Scanner(System.in);

        try {
            String[] allPeopleData = scanner.nextLine().split(";");
            for (String personStr : allPeopleData) {
                String[] personData = personStr.split("=");
                String name = personData[0];
                double money = Double.parseDouble(personData[1]);

                Person person = new Person(name, money);
                people.put(name, person);
            }

            String[] allProductsData = scanner.nextLine().split(";");
            for (String productStr : allProductsData) {
                String[] productData = productStr.split("=");
                String name = productData[0];
                double cost = Double.parseDouble(productData[1]);

                Product product = new Product(name, cost);
                products.put(name, product);

            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }


        String input = scanner.nextLine();
        while (!"END".equals(input)) {
            String[] inputData = input.split(" ");
            String personName = inputData[0];
            String productName = inputData[1];

            if (people.containsKey(personName) && products.containsKey(productName)) {
                try {
                    Person person = people.get(personName);
                    Product product = products.get(productName);
                    person.buyProduct(product);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
            input = scanner.nextLine();
        }

        for (Person person : people.values()) {
            person.printProductsBought();
        }
    }
}
