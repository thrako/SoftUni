package implementations;

import interfaces.List;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayList<E> implements List<E> {
    private static final int INITIAL_CAPACITY = 8;
    private static final int MAX_CAPACITY = Integer.MAX_VALUE - 2;
    private static final String INDEX_OUT_OF_BOUNDS_MSG_FORMAT = "Index %d is out of bounds for size %d";

    private Object[] elements;
    private int size;
    private int capacity;

    public ArrayList() {
        this.elements = new Object[INITIAL_CAPACITY];
        this.size = 0;
        this.capacity = INITIAL_CAPACITY;
    }

    @Override
    public boolean add(E element) {
        return addChecked(this.size, element);
    }

    @Override
    public boolean add(int index, E element) {
        checkIndex(index);
        return addChecked(index, element);
    }

    private boolean addChecked(int index, E element) {
        if (maxCapacityIsReached()) {
            return false;
        }

        ensureCapacity();

        shiftRight(index);

        this.elements[index] = element;
        size++;

        return true;
    }

    @Override
    public E get(int index) {
        checkIndex(index);
        //noinspection unchecked
        return (E) this.elements[index];
    }

    @Override
    public E set(int index, E element) {
        E replacedElement = get(index);
        this.elements[index] = element;
        return replacedElement;
    }

    @Override
    public E remove(int index) {
        E removedElement = get(index);
        shiftLeft(index);
        size--;
        ensureCapacity();
        return removedElement;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public int indexOf(E element) {
        for (int i = 0; i < this.size; i++) {
            if (this.elements[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean contains(E element) {
        return indexOf(element) > -1;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            int current = -1;

            @Override
            public boolean hasNext() {
                return current < size - 1;
            }

            @Override
            public E next() {
                return get(++current);
            }
        };
    }

    private boolean maxCapacityIsReached() {
        return this.size == MAX_CAPACITY;
    }

    private void checkIndex(int index) {
        if (index < 0 || index > this.size - 1) {
            throw new IndexOutOfBoundsException(String.format(INDEX_OUT_OF_BOUNDS_MSG_FORMAT, index, this.size));
        }
    }

    private void ensureCapacity() {
        if (this.size == this.capacity) {
            grow();
        } else if (this.size > INITIAL_CAPACITY * 3 && this.size < this.capacity / 3) {
            shrink();
        }
    }

    private void grow() {
        this.capacity = Math.min(this.capacity * 2, MAX_CAPACITY);
        this.elements = Arrays.copyOf(this.elements, this.capacity);
    }

    private void shrink() {
        this.capacity = Math.max(this.capacity / 2, INITIAL_CAPACITY);
        this.elements = Arrays.copyOf(this.elements, this.capacity);
    }

    private void shiftLeft(int index) {
        System.arraycopy(this.elements, index + 1, this.elements, index, this.size - 1 - index);
    }

    private void shiftRight(int index) {
        System.arraycopy(this.elements, index, this.elements, index + 1, this.size - index);
    }
}
