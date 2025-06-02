package eidi2.sose25.weber.felix.lesson.generics.solution;

/**
 * Generische Klasse zur Speicherung eines einzelnen Objekts.
 * @param <T> Typ des gespeicherten Objekts.
 */
public class Container<T> {
    private T element;

    /**
     * Legt ein Element ab.
     * @param element Objekt, kann null sein.
     */
    public void set(T element) {
        this.element = element;
    }

    /**
     * Liefert das gespeicherte Element.
     * @return gespeichertes Objekt oder null.
     */
    public T get() {
        return element;
    }

    /**
     * Löscht das gespeicherte Element.
     */
    public void clear() {
        element = null;
    }

    /**
     * Prüft, ob kein Element gespeichert ist.
     * @return true, wenn leer.
     */
    public boolean isEmpty() {
        return element == null;
    }
}

