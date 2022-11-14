package lesson03_inheritance.exercise.n05_restaurant;

public class Main {
    public static void main(String[] args) {
        Coffee coffee = new Coffee("Lavazza", 100);
        System.out.println("name " + coffee.getName());
        System.out.println("price " + coffee.getPrice());
        System.out.println("ml " + coffee.getMilliliters());
        System.out.println("caffeine " + coffee.getCaffeine());
    }
}
