package eidi2.sose25.weber.felix.sheet05.ex02;

import eidi2.sose25.weber.felix.sheet05.ex01b.Stack;

public class OrderedStack<T extends Comparable<T>> {

    private final Stack<T> stack;

    public OrderedStack() {
        stack = new Stack<>();
    }

    public void push(T element) {
        if (!stack.isEmpty()) {
            T top = stack.peek();

            if (element.compareTo(top) > 0) {
                throw new IllegalStateException("Element is greater than top of stack");
            }
        }

        stack.push(element);
    }

    public T pop() {
        return stack.pop();
    }

    public T peek() {
        return stack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int size() {
        return stack.size();
    }

    @Override
    public String toString() {
        return "OrderedStack{" +
                "stack=" + stack +
                '}';
    }
}
