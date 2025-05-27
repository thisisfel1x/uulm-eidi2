package eidi2.sose25.weber.felix.sheet04.ex03;

public class Element<T> {

    private T value;
    private Element<T> next;

    public Element(T value) {
        this.value = value;
        this.next = null;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Element<T> getNext() {
        return next;
    }

    public void setNext(Element<T> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Element{" +
                "value=" + value +
                ", next=" + next +
                '}';
    }
}
