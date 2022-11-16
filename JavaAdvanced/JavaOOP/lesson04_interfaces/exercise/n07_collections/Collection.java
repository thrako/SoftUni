package lesson04_interfaces.exercise.n07_collections;

import java.util.ArrayList;
import java.util.List;

public abstract class Collection {

    protected int maxSize = 100;
    protected List<String> items;

    public Collection() {
        this.items = new ArrayList<>();
    }
}
