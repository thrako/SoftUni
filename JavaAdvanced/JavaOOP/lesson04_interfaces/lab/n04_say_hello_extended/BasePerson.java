package lesson04_interfaces.lab.n04_say_hello_extended;

public abstract class BasePerson implements Person {
    private final String name;

    protected BasePerson(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
