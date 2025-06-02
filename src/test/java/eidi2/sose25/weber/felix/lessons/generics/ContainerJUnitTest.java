package eidi2.sose25.weber.felix.lessons.generics;

import eidi2.sose25.weber.felix.lesson.generics.solution.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContainerJUnitTest {

    @Test
    void testContainerSetGetClearAndIsEmpty() {
        Container<Integer> container = new Container<>();
        assertTrue(container.isEmpty());
        container.set(42);
        assertFalse(container.isEmpty());
        assertEquals(42, container.get());
        container.clear();
        assertTrue(container.isEmpty());
        assertNull(container.get());
    }

    @Test
    void testNamedContainerGetNameAndElement() {
        NamedContainer<String> named = new NamedContainer<>("TestContainer");
        assertEquals("TestContainer", named.getName());
        assertTrue(named.isEmpty());
        named.set("Hallo");
        assertFalse(named.isEmpty());
        assertEquals("Hallo", named.get());
    }

    @Test
    void testNamedContainerConstructorNullNameThrows() {
        assertThrows(IllegalArgumentException.class, () -> {
            new NamedContainer<>(null);
        });
    }

    @Test
    void testSwapContainers() {
        Container<String> c1 = new Container<>();
        Container<String> c2 = new Container<>();
        c1.set("A");
        c2.set("B");
        ContainerUtils.swap(c1, c2);
        assertEquals("B", c1.get());
        assertEquals("A", c2.get());
        // Tausch mit leerem Container
        c2.clear();
        ContainerUtils.swap(c1, c2);
        assertNull(c1.get());
        assertEquals("B", c2.get());
    }

    @Test
    void testIsEqualContainers() {
        Container<String> c1 = new Container<>();
        Container<String> c2 = new Container<>();
        // Beide leer
        assertTrue(ContainerUtils.isEqual(c1, c2));
        c1.set("X");
        // Unterschiedliche Inhalte
        assertFalse(ContainerUtils.isEqual(c1, c2));
        c2.set("X");
        // Gleiche Inhalte
        assertTrue(ContainerUtils.isEqual(c1, c2));
        // Nullvergleich
        c1.clear();
        c2.clear();
        c1.set(null);
        c2.set(null);
        assertTrue(ContainerUtils.isEqual(c1, c2));
    }
}

