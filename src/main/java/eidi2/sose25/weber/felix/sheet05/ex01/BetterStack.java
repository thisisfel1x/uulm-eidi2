package eidi2.sose25.weber.felix.sheet05.ex01;

public interface BetterStack<T> {

    BetterStack<T> push(T item);

    T peek();
    T pop();

    boolean isEmpty();
    int size();

}
