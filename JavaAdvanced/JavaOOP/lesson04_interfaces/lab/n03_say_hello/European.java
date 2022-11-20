package lesson04_interfaces.lab.n03_say_hello;

public class European implements Person {
    private final String name;

    public European(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
