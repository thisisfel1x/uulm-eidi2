package eidi2.sose25.weber.felix.sheet05.ex02;

public class Main {

    public static void main(String[] args) {
        OrderedStack<Integer> stack = new OrderedStack<>();

        stack.push(5);
        stack.push(3);
        stack.push(2);

        System.out.println("Top element: " + stack.peek()); // 2

        try {
            stack.push(4); // 4 > 2 → Exception erwartet
        } catch (IllegalStateException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }

        while (!stack.isEmpty()) {
            System.out.println("Pop: " + stack.pop());
        }
    }

}
