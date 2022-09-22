package lesson08_generics.lab.N01JarOfT;

import java.util.NoSuchElementException;

public class Jar <T> {
    private static class Node<E> {
        private final E item;
        private final Node<E> prev;

        Node(E element, Node<E> prev) {
            this.item = element;
            this.prev = prev;
        }

        public E getItem() {
            return item;
        }

        public Node<E> getPrev() {
            return prev;
        }
    }

    private Node<T> top;
    private int size = 0;

    public void add(T element) {
        Node<T> current = (this.isEmpty()) ? null : top;
        top = new Node<>(element, current);
        size++;
    }

    public T remove() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("Attempt to access element of empty Jar");
        }
        Node<T> removed = top;
        top = top.getPrev();
        size--;
        return removed.getItem();
    }

    private boolean isEmpty() {
        return size == 0;
    }
}
