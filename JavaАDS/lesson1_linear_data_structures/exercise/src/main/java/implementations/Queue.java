package implementations;

import interfaces.AbstractQueue;

import java.util.Iterator;

public class Queue<E> implements AbstractQueue<E> {
    private static final String ACCESS_ELEMENT_FROM_EMPTY_QUEUE_MSG = "Attempt to access element from an empty queue";

    private static class Node<E> {
        private final E element;
        private Node<E> next;

        public Node(E element) {
            this.element = element;
            this.next = null;
        }

        public E getElement() {
            return this.element;
        }

        public Node<E> getNext() {
            return this.next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public Queue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public void offer(E element) {
        final Node<E> offeredNode = new Node<>(element);

        if (isEmpty()) {
            this.head = offeredNode;
        } else {
            this.tail.setNext(offeredNode);
        }
        this.tail = offeredNode;

        this.size++;
    }

    @Override
    public E poll() {
        ensureNotEmpty();

        final E element = this.head.getElement();

        this.head = this.head.getNext();
        this.size--;

        return element;
    }

    @Override
    public E peek() {
        ensureNotEmpty();
        return this.head.getElement();
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            Node<E> current = head;

            @Override
            public boolean hasNext() {
                return current.getNext() != null;
            }

            @Override
            public E next() {
                final E element = current.getElement();
                current = current.getNext();
                return element;
            }
        };
    }

    private void ensureNotEmpty() {
        if (isEmpty()) {
            throw new IllegalStateException(ACCESS_ELEMENT_FROM_EMPTY_QUEUE_MSG);
        }
    }
}
