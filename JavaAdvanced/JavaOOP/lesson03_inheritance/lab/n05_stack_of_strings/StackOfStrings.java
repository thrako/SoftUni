package lesson03_inheritance.lab.n05_stack_of_strings;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class StackOfStrings {

    private final ArrayList<String> data;

    public StackOfStrings() {
        this.data = new ArrayList<>();
    }

    public void push(String item) {
        data.add(item);
    }

    public String pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("stack is empty");
        }
        return data.remove(data.size() - 1);
    }

    public String peek() {
        if (data.isEmpty()) {
            return null;
        }
        return data.get(data.size() - 1);
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }
}
