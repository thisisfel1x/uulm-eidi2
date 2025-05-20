package eidi2.sose25.weber.felix.sheet01.ex03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DynamicArrayTest {

    private static DynamicArray init() {
        DynamicArray array = new DynamicArray();
        for (int i = 0; i < 10; i++) {
            array.add(i + 1);
        }
        return array;
    }

    @Test
    public void testValuedConstructor() {
        DynamicArray array = new DynamicArray(5, 4, 3, 2, 1);
        assertEquals(5, array.get(0));
    }

    @Test
    public void testAdd() {
        DynamicArray array = init();
        assertEquals(10, array.size());
        assertEquals(1, array.get(0));
        assertEquals(4, array.get(3));
    }

    @Test
    public void testResize() {
        DynamicArray array = init();

        assertEquals(10, array.size());

        array.resize(5);
        assertEquals(5, array.get(4));
        assertEquals(5, array.size());

        array.resize(10);
        assertEquals(5, array.size());
    }

    @Test
    public void testRemove() {
        DynamicArray array = init();

        array.remove(4); // entfernt Wert 5
        assertEquals(6, array.get(4)); // 6 rutscht nach links
        assertEquals(9, array.size());
    }

    @Test
    public void testResizeException() {
        DynamicArray array = init();
        assertThrows(IllegalArgumentException.class, () -> array.resize(-1));
    }

    @Test
    public void testRemoveException1() {
        DynamicArray array = init();
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> array.remove(-1));
    }

    @Test
    public void testRemoveException2() {
        DynamicArray array = init();
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> array.remove(10));
    }

    @Test
    public void testGetException1() {
        DynamicArray array = init();
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> array.get(-1));
    }

    @Test
    public void testGetException2() {
        DynamicArray array = init();
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> array.get(10));
    }

}
