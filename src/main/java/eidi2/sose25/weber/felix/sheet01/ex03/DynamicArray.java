package eidi2.sose25.weber.felix.sheet01.ex03;

public class DynamicArray extends Array {

    public DynamicArray() {
        this.array = new int[10];
        this.nextFreeIndex = 0;
    }

    public DynamicArray(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }

        this.array = new int[n];
        this.nextFreeIndex = 0;
    }

    public DynamicArray(int... values) {
        this.array = new int[values.length];
        this.nextFreeIndex = 0;
        for (int value : values) {
            this.array[nextFreeIndex++] = value;
        }
    }

    public void resize(int newLength) {
        if (newLength < 0) {
            throw new IllegalArgumentException();
        }

        int[] newArray = new int[newLength];
        int copyLength = Math.min(newLength, nextFreeIndex);

        if (copyLength >= 0) System.arraycopy(array, 0, newArray, 0, copyLength);

        array = newArray;
        nextFreeIndex = copyLength;
    }

    @Override
    public void add(int val) {
        if (nextFreeIndex >= array.length) {
            int newLength = (array.length == 0) ? 1 : array.length * 2;
            resize(newLength);
        }

        array[nextFreeIndex] = val;
        nextFreeIndex++;
    }
}