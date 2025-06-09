package eidi2.sose25.weber.felix.sheet05.ex01b;

import eidi2.sose25.weber.felix.sheet05.ex01.BetterStack;

public class Stack<T> implements BetterStack<T> {

    private static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }

    private Node<T> top;
    private int size;

    public Stack() {
        this.top = null;
        this.size = 0;
    }

    @Override
    public BetterStack<T> push(T item) {
        this.top = new Node<T>(item, this.top);
        this.size++;
        return this;
    }

    @Override
    public T peek() {
        if (this.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return this.top.value;
    }

    @Override
    public T pop() {
        if (this.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        T value = this.top.value;
        this.top = this.top.next;
        this.size--;
        return value;
    }

    @Override
    public boolean isEmpty() {
        return this.top == null;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public String toString() {
        return "Stack{" +
                "top=" + top +
                ", size=" + size +
                '}';
    }
}
