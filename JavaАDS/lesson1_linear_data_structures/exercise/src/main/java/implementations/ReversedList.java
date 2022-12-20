package implementations;

import java.util.Iterator;

public class ReversedList<E> implements Iterable<E> {

    private static final int INITIAL_CAPACITY = 2;
    private static final int MAX_CAPACITY = Integer.MAX_VALUE - 8;
    private static final String MAXIMUM_CAPACITY_IS_REACHED = "Cannot add an element. Maximum capacity is reached";
    private static final String INDEX_OUT_OF_BOUNDS_MSG_FORMAT = "Index %d is out of bounds for size %d!";

    private long capacity;
    private int size;
    private Object[] elements;

    public ReversedList() {
        this.capacity = INITIAL_CAPACITY;
        this.size = 0;
        this.elements = new Object[(int) this.capacity];
    }

    public void add(E element) {
        checkCapacity();
        this.elements[size++] = element;
    }

    public int size() {
        return this.size;
    }

    public int capacity() {
        return (int) this.capacity;
    }

    public E get(int index) {
        return getReversed(index);
    }

    public E removeAt(int index) {
        checkIndex(index);

        E removedElement = getReversed(index);

        int reversedIdx = reverseIndex(index);

        while (reversedIdx < size - 1) {
            elements[reversedIdx] = elements[reversedIdx + 1];
            reversedIdx++;
        }
        elements[size - 1] = null;

        size--;

        return removedElement;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int idx = 0;

            @Override
            public boolean hasNext() {
                return idx < size;
            }

            @Override
            public E next() {
                return getReversed(idx++);
            }
        };
    }

    private void checkCapacity() {
        if (this.size == MAX_CAPACITY) {
            throw new IllegalStateException(MAXIMUM_CAPACITY_IS_REACHED);
        }

        if (this.size >= this.capacity) {
            this.capacity = Math.min(this.capacity * 2, MAX_CAPACITY);
            grow();
        }
    }

    private void grow() {
        Object[] newElements = new Object[(int) this.capacity];
        if (this.size >= 0) System.arraycopy(this.elements, 0, newElements, 0, this.size);
        this.elements = newElements;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(String.format(INDEX_OUT_OF_BOUNDS_MSG_FORMAT, index, size));
        }

    }

    private E getReversed(int index) {
        checkIndex(index);
        //noinspection unchecked
        return (E) this.elements[reverseIndex(index)];
    }

    private int reverseIndex(int index) {
        return size - 1 - index;
    }
}
