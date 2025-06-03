package eidi2.sose25.weber.felix.sheet05.ex03;

import eidi2.sose25.weber.felix.sheet05.ex01b.Stack;

public class StackUtil {

    public static <T> void reverse(Stack<T> stack) {
        Stack<T> temp1 = new Stack<>();
        Stack<T> temp2 = new Stack<>();

        while (!stack.isEmpty()) {
            temp1.push(stack.pop());
        }

        while (!temp1.isEmpty()) {
            temp2.push(temp1.pop());
        }

        while (!temp2.isEmpty()) {
            stack.push(temp2.pop());
        }
    }

    public static Stack<Integer> merge(Stack<Integer> stack1, Stack<Integer> stack2) {
        if (stack1.isEmpty()) return stack2;
        if (stack2.isEmpty()) return stack1;

        int top1 = stack1.peek();
        int top2 = stack2.peek();

        Stack<Integer> result;

        if (top1 <= top2) {
            stack1.pop();
            result = merge(stack1, stack2);
            result.push(top1);
        } else {
            stack2.pop();
            result = merge(stack1, stack2);
            result.push(top2);
        }

        return result;
    }

}
