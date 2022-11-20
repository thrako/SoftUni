package lesson04_interfaces.lab.n03_say_hello;

public interface Person {

    String getName();

    default String sayHello() {
        return "Hello";
    }
}
