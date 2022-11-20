package lesson04_interfaces.lab.n04_say_hello_extended;

public interface Person {

    String getName();

    default String sayHello() {
        return "Hello";
    }
}
