package eidi2.sose25.weber.felix.lesson.uml2java;

public class Tausendfuessler extends Tier {
    private boolean verheddert;

    public Tausendfuessler(String farbe) {
        super(1000, farbe);
        this.verheddert = false;
    }

    public void beineEntheddern() {
        this.verheddert = false;
    }

    public void beineVerheddern() {
        this.verheddert = true;
    }
}

