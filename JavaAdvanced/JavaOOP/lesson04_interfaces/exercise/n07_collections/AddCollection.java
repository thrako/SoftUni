package lesson04_interfaces.exercise.n07_collections;

public class AddCollection extends Collection implements Addable {

    @Override
    public int add(String element) {
        if (this.items.size() >= this.maxSize) {
            throw new RuntimeException("Attempt to add into full collection");
        }
        this.items.add(element);
        return this.items.lastIndexOf(element);
    }
}
