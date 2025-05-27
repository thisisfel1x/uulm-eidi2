package eidi2.sose25.weber.felix.sheet02;

public class Main {

    public static void main(String[] args) {
        Rechteck rechteck = new Rechteck(5, 10);
        Würfel würfel = new Würfel(5);

        Volume volume = (Volume) rechteck;
        System.out.println(volume.calculateVolume());
    }

}
