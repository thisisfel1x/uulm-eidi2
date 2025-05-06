package eidi2.sose25.weber.felix.sheet01.ex02;

import java.util.Arrays;
import java.util.Random;

public class HelloWorld {

    public static void main(String[] args) {
        int[] array = new int[1000];
        Random rand = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(101); // 0 bis 100
        }

        System.out.println(Arrays.toString(array));

        // Call-by-value: pass copy of reference of array -> direct change in original array
        sort(array);

        System.out.println(Arrays.toString(array));
    }

    // bubble sort algorithm
    public static void sort(int[] array) {
        if (array == null) {
            return;
        }

        int length = array.length;
        boolean swapped;

        for (int i = 0; i < length - 1; i++) {
            swapped = false;

            for (int j = 0; j < length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    // swap
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;

                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }
    }

}
