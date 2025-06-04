package eidi2.sose25.weber.felix.lesson.generics.solution;

import java.util.Objects;

/**
 * Hilfsklasse mit statischen Methoden für Container.
 */
public class ContainerUtils {

    /**
     * Tauscht die Inhalte von zwei Containern gleicher Typen.
     * @param c1 erster Container.
     * @param c2 zweiter Container.
     * @param <T> Typ der Container.
     */
    public static <T> void swap(Container<T> c1, Container<T> c2) {
        T temp = c1.get();
        c1.set(c2.get());
        c2.set(temp);
    }

    /**
     * Prüft, ob beide Container denselben Inhalt haben.
     * @param c1 erster Container.
     * @param c2 zweiter Container.
     * @return true, wenn beide null oder gleich mittels equals.
     */
    public static boolean isEqual(Container<?> c1, Container<?> c2) {
        Object e1 = c1.get();
        Object e2 = c2.get();
        return Objects.equals(e1, e2);
    }
}

