package interfaces;

public interface Deque<E> extends Iterable<E> {
    void add(E element);
    void offer(E element);
    void addFirst(E element);
    void addLast(E element);
    void push(E element);
    void insert(int index, E element);
    void set(int index, E element);
    E peek();
    E poll();
    E pop();
    E get(int index);
    E get(Object object);
    E remove(int index);
    E remove(Object object);
    E removeFirst();
    E removeLast();
    int size();
    int capacity();
    void trimToSize();
    boolean isEmpty();
}
