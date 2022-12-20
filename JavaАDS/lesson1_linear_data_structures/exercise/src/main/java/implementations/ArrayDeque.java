package implementations;

import interfaces.Deque;

import java.util.Iterator;

public class ArrayDeque<E> implements Deque<E> {

    private static final int DEFAULT_CAPACITY = 7;
    private static final int MAX_CAPACITY = Integer.MAX_VALUE - 8;
    public static final String INDEX_OUT_OF_BOUNDS_MSG_FORMAT = "Index %d out of bounds for size %d";

    private Object[] elements;
    private int begin;
    private int end;
    private int size;
    private long capacity;

    public ArrayDeque() {
        this.elements = new Object[DEFAULT_CAPACITY];
        this.begin = DEFAULT_CAPACITY / 2;
        this.end = this.begin;
        this.size = 0;
        this.capacity = DEFAULT_CAPACITY;
    }


    @Override
    public void add(E element) {
        addLast(element);
    }

    @Override
    public void offer(E element) {
        addFirst(element);
    }

    @Override
    public void addFirst(E element) {
        checkCapacity();
        this.elements[--begin] = element;
        size++;
    }

    @Override
    public void addLast(E element) {
        checkCapacity();
        this.elements[end++] = element;
        size++;
    }

    @Override
    public void push(E element) {
        addLast(element);
    }

    @Override
    public void insert(int index, E element) {
        checkIndex(index);
        checkCapacity();
        int dequeIndex = this.begin + index;

        for (int i = end; i >= dequeIndex; i--) {
            elements[i + 1] = elements[i];
        }
        elements[dequeIndex] = element;
        end++;
        size++;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= this.size()) {
            throw new IndexOutOfBoundsException(String.format(INDEX_OUT_OF_BOUNDS_MSG_FORMAT, index, this.size));
        }
    }

    @Override
    public void set(int index, E element) {
        checkIndex(index);

        int dequeIndex = this.begin + index;
        this.elements[dequeIndex] = element;
    }

    @Override
    public E peek() {
        return get(end - 1 - begin);
    }

    @Override
    public E poll() {
        return removeFirst();
    }

    @Override
    public E pop() {
        return removeLast();
    }

    @Override
    public E get(int index) {
        //noinspection unchecked
        return (E) elements[this.begin + index];
    }

    @Override
    public E get(Object object) {
        for (int i = begin; i < end; i++) {
            if (elements[i].equals(object)) {
                //noinspection unchecked
                return (E) elements[i];
            }
        }
        return null;
    }

    @Override
    public E remove(int index) {
        checkIndex(index);

        final E element = get(index);
        for (int i = index + this.begin; i < this.end; i++) {
            elements[i] = elements[i + 1];
        }

        end--;
        size--;

        checkCapacity();

        return element;
    }

    @Override
    public E remove(Object object) {
        for (int i = this.begin; i < this.end; i++) {
            if (elements[i].equals(object)) {
                return remove(i - this.begin);
            }
        }
        return null;
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }

        final E element = get(0);

        size--;
        begin++;

        checkCapacity();

        return element;
    }

    @Override
    public E removeLast() {
        if (isEmpty()) {
            return null;
        }

        this.size--;
        this.end--;

        checkCapacity();

        return get(this.end - this.begin);
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public int capacity() {
        return (int) this.capacity;
    }

    @Override
    public void trimToSize() {
        this.capacity = this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int currentIdx = 0;

            @Override
            public boolean hasNext() {
                return currentIdx < size();
            }

            @Override
            public E next() {
                return get(currentIdx++);
            }
        };
    }

    private void checkCapacity() {
        if (this.begin == 0 || this.end >= this.capacity - 1) {
            grow();
        } else if (this.capacity > DEFAULT_CAPACITY && this.size <= this.capacity / 3) {
            shrink();
        }
    }

    private void shrink() {
        this.capacity = Math.max(this.capacity / 2, DEFAULT_CAPACITY);
        resize();
    }

    private void grow() {
        if (this.size == MAX_CAPACITY) {
            throw new IllegalStateException("Maximum capacity reached");
        }
        this.capacity = (this.capacity < DEFAULT_CAPACITY) ? DEFAULT_CAPACITY : Math.min(this.capacity * 2, MAX_CAPACITY);

        resize();

    }

    private void resize() {
        int intCapacity = (int) this.capacity;
        int offset = intCapacity / 4;
        Object[] newElements = new Object[intCapacity];
        for (int i = 0; i <= this.size; i++) {
            newElements[offset + i] = this.elements[this.begin + i];
        }

        this.elements = newElements;
        this.begin = offset;
        this.end = offset + this.size;
    }
}
