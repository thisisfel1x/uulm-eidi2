package eidi2.sose25.weber.felix.sheet05.ex01;

public class Example {

    public static void main(String[] args) {
        Stack2<Integer> stack2 = new Stack2<>();
        stack2.push(1).push(2).push(3).push(4).push(5).push(6);

        System.out.println(stack2);

        System.out.println("Peek " + stack2.peek());

        System.out.println(stack2);

        System.out.println("Pop " + stack2.pop());

        System.out.println(stack2);
    }

}
