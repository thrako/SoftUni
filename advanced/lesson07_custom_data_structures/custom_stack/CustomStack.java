package lesson07_custom_data_structures.custom_stack;

import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class CustomStack<T> {

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

    public void push(T element) {
        Node<T> current = (this.isEmpty()) ? null : top;
        top = new Node<>(element, current);
        size++;
    }

    public T pop() {
        ensureNotEmpty();
        Node<T> popped = top;
        top = top.getPrev();
        size--;
        return popped.getItem();
    }

    public T peek() {
        return (this.isEmpty()) ? null : top.getItem();
    }

    public void forEach(Consumer<T> consumer) {
        Node<T> current = top;
        while (current != null) {
            consumer.accept(current.getItem());
            current = current.getPrev();
        }
    }

    private void ensureNotEmpty() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("Attempt to access element of empty CustomStack");
        }
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int size() {
        return this.size;
    }

}
