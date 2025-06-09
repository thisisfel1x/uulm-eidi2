package eidi2.sose25.weber.felix.sheet05.ex02;

public class Disc implements Comparable<Disc> {

    private int size;

    public Disc(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    @Override
    public int compareTo(Disc other) {
        return Integer.compare(size, other.size);
    }
}
