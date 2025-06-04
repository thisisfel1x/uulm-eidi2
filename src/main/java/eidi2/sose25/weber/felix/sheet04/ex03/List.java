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
            this.head.setNext(newElement);
        }
        this.tail = newElement;

        this.size++;
    }

    public int size() {
        return this.size;
    }

    public void insert(T val, int index) {
        if (index <= 0) {
            // Verhalten wie prepend
            this.prepend(val);
            return;
        }

        Element<T> newElement = new Element<>(val);

        Element<T> current = this.head;
        int i = 0;

        while (current != null && i < index - 1) {
            current = current.getNext();
            i++;
        }

        // Wenn current == null ist, wurde das Ende der Liste erreicht; wir nutzen append
        if (current == null || current.getNext() == null) {
            this.append(val);
        } else {
            // Ansonsten können wir ganz easy ein neues Element in die Liste einfügen
            newElement.setNext(current.getNext());
            current.setNext(newElement);
        }

        if (newElement.getNext() == null) {
            this.tail = newElement;
        }
    }

    public T get(int n) {
        if (n < 0) throw new IndexOutOfBoundsException();

        Element<T> current = this.head;
        int i = 0;

        while (current != null && i < n) {
            current = current.getNext();
            i++;
        }

        if (current == null) throw new IndexOutOfBoundsException();

        return current.getValue();
    }


    public boolean contains(T val) {
        Element<T> current = head;

        while (current != null) {
            if ((val == null && current.getValue() == null) ||
                    (val != null && val.equals(current.getNext()))) {
                return true;
            }
            current = current.getNext();
        }

        return false;
    }

    public void remove(int n) {
        if (n < 0 || this.head == null) throw new IndexOutOfBoundsException();

        if (n == 0) {
            this.head = this.head.getNext();
            if (this.head == null) this.tail = null;
            return;
        }

        Element<T> current = this.head;
        int i = 0;

        while (current.getNext() != null && i < n - 1) {
            current = current.getNext();
            i++;
        }

        if (current.getNext() == null) throw new IndexOutOfBoundsException();

        // Element entfernen
        Element<T> toRemove = current.getNext();
        current.setNext(toRemove.getNext());

        // tail anpassen, falls letztes Element entfernt wurde
        if (current.getNext() == null) {
            this.tail = current;
        }
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
