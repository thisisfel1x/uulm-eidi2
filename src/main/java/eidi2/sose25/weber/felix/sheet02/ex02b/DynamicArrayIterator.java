package eidi2.sose25.weber.felix.sheet02.ex02b;

import eidi2.sose25.weber.felix.sheet02.ex02b.DynamicArray;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DynamicArrayIterator implements Iterator<Integer> {

    private final eidi2.sose25.weber.felix.sheet02.ex02b.DynamicArray array;
    private int currentIndex;

    public DynamicArrayIterator(DynamicArray array) {
        this.array = array;
        this.currentIndex = 0;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < array.size();
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return array.get(currentIndex++);
    }
}
