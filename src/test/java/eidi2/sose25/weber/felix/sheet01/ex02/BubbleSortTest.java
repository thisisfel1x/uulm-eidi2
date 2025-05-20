package eidi2.sose25.weber.felix.sheet01.ex02;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class BubbleSortTest {

    @Test
    public void testNullArray() {
        assertDoesNotThrow(() -> HelloWorld.sort(null));
    }

    @Test
    public void test() {
        int[] orginalArray = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] kopiertesArray = orginalArray.clone();

        orginalArray[0] = 99;

        System.out.println(Arrays.toString(orginalArray));
        System.out.println(Arrays.toString(kopiertesArray));
    }

    @Test
    public void testEmptyArray() {
        int[] array = new int[0];
        HelloWorld.sort(array);
        assertArrayEquals(new int[0], array);
    }

    @Test
    public void testSortedAscendingArray() {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] expected = array.clone();
        HelloWorld.sort(array);
        assertArrayEquals(expected, array);
    }

    @Test
    public void testSortedDescendingArray() {
        int[] array = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        HelloWorld.sort(array);
        assertArrayEquals(expected, array);
    }

    @Test
    public void testLargeArray() {
        Random rand = new Random();

        for (int i = 0; i < 1000; i++) {
            int[] array = new int[1000];
            for (int j = 0; j < array.length; j++) {
                array[j] = rand.nextInt();
            }

            int[] expected = array.clone();
            Arrays.sort(expected);
            HelloWorld.sort(array);

            assertArrayEquals(expected, array);
        }
    }

}
