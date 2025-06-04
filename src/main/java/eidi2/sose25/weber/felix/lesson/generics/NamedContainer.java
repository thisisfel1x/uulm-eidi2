package eidi2.sose25.weber.felix.lesson.generics;

public class NamedContainer<T> extends Container<T> {
    private String name;

    public NamedContainer(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
