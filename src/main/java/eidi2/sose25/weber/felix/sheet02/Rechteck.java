package eidi2.sose25.weber.felix.sheet02;

public class Rechteck implements Volume {

    public int laenge;
    public int breite;

    public Rechteck(int laenge, int breite) {
        this.laenge = laenge;
        this.breite = breite;
    }

    @Override
    public int calculateVolume() {
        return this.laenge * this.breite;
    }
}
