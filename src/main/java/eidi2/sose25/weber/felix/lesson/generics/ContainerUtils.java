package eidi2.sose25.weber.felix.lesson.generics;

public class ContainerUtils {

    public <T> void swap(Container<T> container1, Container<T> container2) {
        T temp = container1.get();
        container1.set(container2.get());
        container2.set(temp);
    }

    public boolean isEqual(Container<?> container1, Container<?> container2) {
        Object obj1 = container1.get();
        Object obj2 = container2.get();

        return obj1.equals(obj2);
    }

}
