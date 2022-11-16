package lesson04_interfaces.exercise.n07_collections;

public class MyListImpl extends Collection implements MyList {


    @Override
    public int add(String element) {
        if (this.items.size() >= this.maxSize) {
            throw new RuntimeException("Attempt to add into full collection");
        }
        this.items.add(0, element);
        return 0;
    }

    @Override
    public String remove() {
        if (this.items.isEmpty()) {
            throw new RuntimeException("Attempt to remove from an empty collection.");
        }
        return items.remove(0);
    }

    @Override
    public int getUsed() {
        return this.items.size() ;
    }
}
