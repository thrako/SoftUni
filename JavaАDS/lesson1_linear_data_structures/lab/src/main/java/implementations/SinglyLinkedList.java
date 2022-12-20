package implementations;

import interfaces.LinkedList;

import java.util.Iterator;

public class SinglyLinkedList<E> implements LinkedList<E> {

    private static final String ACCESS_ELEMENT_FROM_EMPTY_LIST_MSG = "Attempt to access element from an empty SinglyLinkedList";

    private static class Node<E> {
        private final E element;
        private Node<E> next;

        public Node(E element) {
            this.element = element;
            this.next = null;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }
    private Node<E> head;
    private Node<E> tail;
    private int size;

    public SinglyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public void addFirst(E element) {
        final Node<E> addedNode = new Node<>(element);

        if (isEmpty()) {
            this.head = addedNode;
            this.tail = addedNode;
        } else {
            addedNode.setNext(this.head);
            this.head = addedNode;
        }

        this.size++;
    }

    @Override
    public void addLast(E element) {
        final Node<E> addedNode = new Node<>(element);

        if (isEmpty()) {
            this.head = addedNode;
        } else {
            this.tail.setNext(addedNode);
        }
        this.tail = addedNode;

        this.size++;
    }

    @Override
    public E removeFirst() {
        ensureNotEmpty();

        E element = this.head.getElement();
        this.head = this.head.getNext();
        this.size--;

        return element;
    }

    @Override
    public E removeLast() {
        ensureNotEmpty();
        E element = this.tail.getElement();

        Node<E> current = this.head;
        while (!current.getNext().equals(this.tail)) {
            current = current.getNext();
        }
        this.tail = current;
        this.size--;

        return element;
    }

    @Override
    public E getFirst() {
        ensureNotEmpty();
        return head.getElement();
    }

    @Override
    public E getLast() {
        ensureNotEmpty();
        return tail.getElement();
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
                E element = current.getElement();
                current = current.getNext();
                return element;
            }
        };
    }

    private void ensureNotEmpty() {
        if (isEmpty()) {
            throw new IllegalStateException(ACCESS_ELEMENT_FROM_EMPTY_LIST_MSG);
        }
    }
}
