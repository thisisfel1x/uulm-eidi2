package eidi2.sose25.weber.felix.lesson.generics.solution;

/**
 * Testklasse für Container und NamedContainer.
 */
public class ContainerTest {
    public static void main(String[] args) {
        // Einfacher Container für Integer
        Container<Integer> intC = new Container<>();
        intC.set(5);
        System.out.println("intC: " + intC.get());  // Ausgabe: 5

        // Einfacher Container für String
        Container<String> strC = new Container<>();
        strC.set("Hallo");
        System.out.println("strC: " + strC.get());  // Ausgabe: Hallo

        // Tauschen von Inhalten
        ContainerUtils.swap(intC, new Container<>());  // neuer Container ist leer
        System.out.println("intC nach swap: " + intC.get());  // Ausgabe: null

        // NamedContainer
        NamedContainer<String> named = new NamedContainer<>("MeinContainer");
        named.set("Test");
        System.out.println(named.getName() + ": " + named.get());  // Ausgabe: MeinContainer: Test

        // Gleichheitsprüfung
        Container<String> a = new Container<>();
        Container<String> b = new Container<>();
        a.set("X");
        b.set("X");
        boolean gleich = ContainerUtils.isEqual(a, b);
        System.out.println("a und b gleich? " + gleich);  // Ausgabe: true
    }
}

