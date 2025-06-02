package eidi2.sose25.weber.felix.lesson.generics.solution;

/**
 * Erweiterung von Container. Fügt Namen hinzu.
 * @param <T> Typ des gespeicherten Objekts.
 */
public class NamedContainer<T> extends Container<T> {
    private String name;

    /**
     * Konstruktor mit Namen.
     * @param name Name des Containers, darf nicht null sein.
     */
    public NamedContainer(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name darf nicht null sein");
        }
        this.name = name;
    }

    /**
     * Liefert den Namen.
     * @return Name des Containers.
     */
    public String getName() {
        return name;
    }
}

