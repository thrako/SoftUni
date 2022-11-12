package lesson02_encapsulation.lab.n01_sort_by_name_and_age;

public class Person {
    private static final String DESCRIPTION_FORMAT = "%s %s is %d years old.";
    private final String firstName;
    private final String lastName;
    private final int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return String.format(DESCRIPTION_FORMAT,
                firstName, lastName, age);
    }
}
