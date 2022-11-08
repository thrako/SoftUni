package lesson06_defining_classes.exercise.N08FamilyTree;

import java.util.ArrayList;
import java.util.List;

class Person {
    private String name = "";
    private String birthDate = "";
    private final List<Person> parents = new ArrayList<>();
    private final List<Person> children = new ArrayList<>();

    public Person() {}

    public Person(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person withName(String name) {
        this.name = name;
        return this;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public Person withBirthDate(String birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public void addParent(Person person) {
        this.parents.add(person);
    }

    public void addChild(Person person) {
        this.children.add(person);
    }

    public List<Person> getParents() {
        return parents;
    }

    public List<Person> getChildren() {
        return children;
    }

    public String getInfo() {
        StringBuilder strBld = new StringBuilder();
        strBld.append(this).append(System.lineSeparator())
                .append("Parents:").append(System.lineSeparator());
        for (Person parent : parents) {
            strBld.append(parent).append(System.lineSeparator());
        }
        strBld.append("Children:").append(System.lineSeparator());
        for (Person child : children) {
            strBld.append(child).append(System.lineSeparator());
        }
        return strBld.toString();
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.name, this.birthDate);
    }
}
