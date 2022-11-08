package my_exam.T03_animal_shelter.shelter;

public class Animal {
    private String name;
    private int age;
    private String caretaker;
    
    public Animal(String name, int age, String caretaker) {
        setName(name);
        setAge(age);
        setCaretaker(caretaker);
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public void setCaretaker(String caretaker) {
        this.caretaker = caretaker;
    }
    
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
    
    public String getCaretaker() {
        return caretaker;
    }

    @Override
    public String toString() {
        return String.format("%s %d (%s)", name, age, caretaker);
    }
}
