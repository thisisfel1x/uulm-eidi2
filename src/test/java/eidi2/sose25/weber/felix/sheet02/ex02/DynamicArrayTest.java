package eidi2.sose25.weber.felix.sheet02.ex02;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DynamicArrayTest {

    @Test
    public void testAddAndGet() {
        DynamicArray arr = new DynamicArray();
        arr.add(42);
        arr.add(17);
        assertEquals(42, arr.get(0));
        assertEquals(17, arr.get(1));
    }

    @Test
    public void testAddAtIndex() {
        DynamicArray arr = new DynamicArray();
        arr.add(1);
        arr.add(3);
        assertEquals(1, arr.get(0));
        assertEquals(3, arr.get(1));
    }

    @Test
    public void testRemoveByIndex() {
        DynamicArray arr = new DynamicArray(10, 20, 30);
        arr.remove(1);
        assertEquals(30, arr.get(1));  // 30 wurde nach vorne verschoben
        assertEquals(2, arr.size());
    }
}
