package lesson07_custom_data_structures.custom_arraylist;

import java.util.function.Consumer;

public class CustomArrayList<T> {
    private final static int INITIAL_CAPACITY = 4;
    private Object[] data;
    private int size = 0;
    private int capacity;

    public CustomArrayList() {
        this.data = new Object[INITIAL_CAPACITY];
        this.capacity = INITIAL_CAPACITY;
    }

    public CustomArrayList(int capacity) {
        this.data = new Object[capacity];
        this.capacity = (capacity < 1_073_741_824) ? roundUpToNextPowerOfTwo(capacity) : Integer.MAX_VALUE;
    }

    public void add(T element) {
        add(size, element);
    }

    public void add(int index, T element) {
        checkIndexToAdd(index);
        shiftRight(index);
        data[index] = element;
        size++;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        checkIndex(index);
        return (T)data[index];
    }

    public T remove(int index) {
        checkIndex(index);
        T removedElement = get(index);
        shiftLeft(index);
        size--;
        return removedElement;
    }

    @SuppressWarnings("UnusedReturnValue")
    public T removeLast() {
        return remove(size - 1);
    }

    public boolean contains(T element) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(element)) return true;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public void forEach(Consumer<T> consumer) {
        for (int i = 0; i < size; i++) {
            consumer.accept(get(i));
        }
    }

    private void shiftLeft(int index) {
        checkExcessCapacity();
        if (size - 1 - index >= 0) System.arraycopy(data, index + 1, data, index, size - 1 - index);
        data[size - 1] = null;
    }

    private void shiftRight(int index) {
        ensureEnoughCapacity();
        if (size - index >= 0) System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = null;
    }

    private int roundUpToNextPowerOfTwo(int capacity) {
        return Integer.highestOneBit(capacity - 1) * 2;
    }

    private void ensureEnoughCapacity() {
        if (size == capacity) resize();
    }

    private void checkExcessCapacity() {
        if (size * 3 <= capacity) shrink();
    }

    private void resize() {
        this.capacity *= 2;
        Object[] copy = new Object[capacity];
        System.arraycopy(data, 0, copy, 0, size);
        data = copy;
    }

    private void shrink() {
        this.capacity /= 2;
        Object[] copy = new Object[capacity];
        System.arraycopy(data, 0, copy, 0, size);
        data = copy;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(String.format("CustomArrayList index %d out of bounds for size %d", index, size));
        }
    }

    private void checkIndexToAdd(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(String.format("CustomArrayList index %d out of bounds for size %d", index, size));
        }
    }

}
