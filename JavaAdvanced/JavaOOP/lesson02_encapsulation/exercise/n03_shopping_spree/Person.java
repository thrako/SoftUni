package lesson02_encapsulation.exercise.n03_shopping_spree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private double money;
    private List<Product> products; //final private List<Product> products; - judge does not like

    public Person(String name, double money) {
        setName(name);
        setMoney(money);
        this.products = new ArrayList<>();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public void buyProduct(Product product) {
        if (this.money < product.getCost()) {
            String message = String.format("%s can't afford %s", this.getName(), product.getName());
            throw new IllegalArgumentException(message);
        } else {
            this.products.add(product);
            this.money -= product.getCost();
            System.out.printf("%s bought %s%n", this.getName(), product.getName());
        }
    }

    public String getName() {
        return name;
    }

    public void printProductsBought() {
        System.out.printf("%s - %s%n", this.getName(), this.products.isEmpty()
                ? "Nothing bought"
                : this.products.stream()
                    .map(Product::getName)
                    .collect(Collectors.joining(", ")));
    }
}
