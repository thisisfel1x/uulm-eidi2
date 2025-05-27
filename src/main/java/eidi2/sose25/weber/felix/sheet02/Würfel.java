package eidi2.sose25.weber.felix.sheet02;

public class Würfel implements Volume {

    public int laenge;

    public Würfel(int laenge) {
        this.laenge = laenge;
    }

    @Override
    public int calculateVolume() {
        return laenge * laenge * laenge;
    }
}
