package lesson04_interfaces.exercise.n04_food_shortage;

public class Citizen
        implements Person, Identifiable, Buyer {

    private final String name;
    private final int age;
    private final String id;
    //unused - required field as per Task Description
    private final String birthDate;
    private int food;

    public Citizen(String name, int age, String id, String birthDate) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.birthDate = birthDate;
        this.food = 0;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public int getFood() {
        return this.food;
    }

    @Override
    public void buyFood() {
        this.food += 10;
    }
}
