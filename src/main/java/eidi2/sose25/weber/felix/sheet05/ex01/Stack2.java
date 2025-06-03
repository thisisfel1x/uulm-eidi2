package eidi2.sose25.weber.felix.sheet05.ex01;

import java.util.LinkedList;

public class Stack2<T> implements BetterStack<T> {

    private final LinkedList<T> stack = new LinkedList<T>();

    @Override
    public BetterStack<T> push(T item) {
        this.stack.addFirst(item);
        return this;
    }

    @Override
    public T peek() {
        return this.stack.peek();
    }

    @Override
    public T pop() {
        return this.stack.pop();
    }

    @Override
    public boolean isEmpty() {
        return this.stack.isEmpty();
    }

    @Override
    public int size() {
        return this.stack.size();
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("[");
        for (int i = 0; i < this.stack.size(); i++) {
            str.append(this.stack.get(i));
            if (i < this.stack.size() - 1) {
                str.append(", ");
            }
        }
        str.append("]");
        return str.toString();
    }
}
