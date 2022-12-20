package implementations;

import interfaces.LinkedList;

import java.util.Iterator;

public class DoublyLinkedList<E> implements LinkedList<E> {

    private static final String ACCESS_ELEMENT_FROM_EMPTY_LIST_MSG = "Attempt to access element from an empty DoublyLinkedList";

    private static class Node<E> {
        private final E element;
        private Node<E> prev;
        private Node<E> next;

        public Node(E element, Node<E> prev, Node<E> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }

        public E getElement() {
            return this.element;
        }

        public Node<E> getPrev() {
            return this.prev;
        }

        public void setPrev(Node<E> prev) {
            this.prev = prev;
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

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public void addFirst(E element) {
        final Node<E> addedNode = new Node<>(element, null, this.head);

        if (isEmpty()) {
            this.tail = addedNode;
        } else {
            this.head.setPrev(addedNode);
        }
        this.head = addedNode;

        this.size++;
    }

    @Override
    public void addLast(E element) {
        final Node<E> addedNode = new Node<>(element, this.tail, null);

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

        if (this.size == 1) {
            this.head = null;
            this.tail = null;
        } else {
            this.head = this.head.getNext();
            this.head.setPrev(null);
        }

        this.size--;

        return element;
    }

    @Override
    public E removeLast() {
        ensureNotEmpty();

        E element = this.tail.getElement();

        if (this.size == 1) {
            this.head = null;
            this.tail = null;
        } else {
            this.tail = this.tail.getPrev();
            this.tail.setNext(null);
        }

        this.size--;

        return element;
    }

    @Override
    public E getFirst() {
        ensureNotEmpty();
        return this.head.getElement();
    }

    @Override
    public E getLast() {
        ensureNotEmpty();
        return this.tail.getElement();
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
