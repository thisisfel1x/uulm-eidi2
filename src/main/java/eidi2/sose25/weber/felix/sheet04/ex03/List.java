package eidi2.sose25.weber.felix.sheet04.ex03;

public class List<T> {

    private Element<T> head;
    private Element<T> tail;

    private int size = 0;

    public List() {
        this.head = null;
        this.tail = null;
    }

    public void prepend(T val) {
        Element<T> element = new Element<>(val);
        element.setNext(this.head);
        this.head = element;

        if (this.tail == null) {
            this.tail = element;
        }

        this.size++;
    }

    public void append(T val) {
        Element<T> newElement = new Element<>(val);

        if (this.head == null) {
            this.head = newElement;
        } else {
            this.tail.setNext(newElement);
        }
        this.tail = newElement;

        this.size++;
    }

    public int size() {
        return this.size;
    }

    public void insert(T val, int index) {

    }

    public T get(int n) {

    }

    public boolean contains(T val) {

    }

    public void remove(int n) {

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        Element<T> element = this.head;
        while (element != null) {
            sb.append("Element ").append(count++).append(": ").append(element).append("\n");
            element = element.getNext();
        }
        return sb.toString();
    }

}
