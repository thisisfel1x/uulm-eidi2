package eidi2.sose25.weber.felix.lesson.generics;

public class Container<T> {
    private T element;

    public Container() {

    }

    public T get() {
        return this.element;
    }

    public void set(T element) {
        this.element = element;
    }

    public boolean isEmpty() {
        return this.element == null;
    }

    public void clear() {
        this.element = null;
    }

}
