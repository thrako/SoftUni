package implementations;

import interfaces.AbstractStack;

import java.util.Iterator;

public class Stack<E> implements AbstractStack<E> {
    private static final String ACCESS_ELEMENT_FROM_EMPTY_STACK_MSG = "Attempt to access element from an empty stack";

    private static class Node<E> {
        private final E element;
        private Node<E> previous;

        public Node(E element) {
            this.element = element;
        }

        public E getElement() {
            return element;
        }

        public void setPrevious(Node<E> previous) {
            this.previous = previous;
        }

        public Node<E> getPrevious() {
            return previous;
        }
    }
    private Node<E> top;
    private int size;

    public Stack() {
        this.top = null;
        this.size = 0;
    }

    @Override
    public void push(E element) {
        Node<E> pushedNode = new Node<>(element);
        pushedNode.setPrevious(this.top);
        this.top = pushedNode;
        size++;
    }

    @Override
    public E pop() {
        ensureNotEmpty();

        E element = this.top.getElement();
        this.top = this.top.getPrevious();
        size--;

        return element;
    }

    @Override
    public E peek() {
        ensureNotEmpty();
        return this.top.getElement();
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
            Node<E> current = top;

            @Override
            public boolean hasNext() {
                return current.getPrevious() != null;
            }

            @Override
            public E next() {
                E element = current.getElement();
                current = current.getPrevious();
                return element;
            }
        };
    }

    private void ensureNotEmpty() {
        if (isEmpty()) {
            throw new IllegalStateException(ACCESS_ELEMENT_FROM_EMPTY_STACK_MSG);
        }
    }
}
