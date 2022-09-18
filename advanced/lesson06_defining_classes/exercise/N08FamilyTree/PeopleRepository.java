package lesson06_defining_classes.exercise.N08FamilyTree;

import java.util.ArrayList;
import java.util.List;

class PeopleRepository {
    List<Person> people = new ArrayList<>();

    public void add(Person person) {
        people.add(person);
    }

    public void addIfAbsent(Person person) {
        if (!people.contains(person)) people.add(person);
    }

    public void setRelation(Person parent, Person child) {
        if (!parent.getChildren().contains(child)) parent.addChild(child);
        if (!child.getParents().contains(parent)) child.addParent(parent);
    }

    public Person findPersonByBirthDate(String data) {
        return people.stream()
                .filter(p -> p.getBirthDate().equals(data))
                .findFirst().orElse(null);
    }

    public Person findPersonByName(String data) {
        return people.stream()
                .filter(p -> p.getName().equals(data))
                .findFirst().orElse(null);
    }

    public void remove(Person person) {
        this.people.remove(person);
    }

    public Person getOrCreate(String data) {
        Person person;
        if (data.contains("/")) {
            person = findPersonByBirthDate(data);
            if (person == null) person = new Person().withBirthDate(data);
        } else {
            person = findPersonByName(data);
            if (person == null) person = new Person().withName(data);
        }
        return person;
    }

    public Person getOrCreate(String name, String birthDate) {
        Person personByName = findPersonByName(name);
        boolean isFoundByName = personByName != null;
        Person personByBirthDate = findPersonByBirthDate(birthDate);
        boolean isFoundByBirthDate = personByBirthDate != null;

        if (isFoundByName && isFoundByBirthDate) {
            if (personByName == personByBirthDate) return personByName;
            else return getMerged(personByName, personByBirthDate);
        } else if (isFoundByName) {
            return  personByName.withBirthDate(birthDate);
        } else if (isFoundByBirthDate) {
            return personByBirthDate.withName(name);
        } else {
            return new Person().withName(name).withBirthDate(birthDate);
        }
    }

    public Person getMerged(Person personByName, Person personByBirthDate) {
        personByName.setBirthDate(personByBirthDate.getBirthDate());
        for (Person parent : personByBirthDate.getParents()) {
            if (!personByName.getParents().contains(parent)) {
                parent.getChildren().remove(personByBirthDate);
                setRelation(parent, personByName);
            }
        }
        for (var child : personByBirthDate.getChildren()) {
            if (!personByName.getChildren().contains(child)) {
                child.getParents().remove(personByBirthDate);
                setRelation(personByName, child);
            }
        }
        remove(personByBirthDate);
        return personByName;
    }
}
