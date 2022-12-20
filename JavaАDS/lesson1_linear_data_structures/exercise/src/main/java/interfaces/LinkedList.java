package interfaces;

public interface LinkedList<E> extends Iterable<E> {
    void addFirst(E element);
    void addLast(E element);
    E removeFirst();
    E removeLast();
    E getFirst();
    E getLast();
    int size();
    boolean isEmpty();
}
