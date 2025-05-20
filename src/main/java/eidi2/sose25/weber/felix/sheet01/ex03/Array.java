package eidi2.sose25.weber.felix.sheet01.ex03;

public abstract class Array {
    protected int[] array;
    protected int nextFreeIndex = 0;

    public void add(int val) {
        if (nextFreeIndex >= array.length) {
            throw new ArrayIndexOutOfBoundsException();
        }

        array[nextFreeIndex] = val;
        nextFreeIndex++;
    }

    public int size() {
        return nextFreeIndex;
    }

    public int get(int index) {
        if (index < 0 || index >= nextFreeIndex) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return array[index];
    }

    public void remove(int index) {
        if (index < 0 || index >= nextFreeIndex) {
            throw new ArrayIndexOutOfBoundsException();
        }

        // Shift to the left
        for (int i = index; i < nextFreeIndex - 1; i++) {
            array[i] = array[i + 1];
        }

        // Reset last element and decrease next free index by 1
        array[nextFreeIndex - 1] = 0;
        nextFreeIndex--;

    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i != array.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");

        return new String(sb);
    }
}
