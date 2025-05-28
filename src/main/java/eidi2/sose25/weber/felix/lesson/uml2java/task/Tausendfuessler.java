package eidi2.sose25.weber.felix.lesson.uml2java.task;

public class Tausendfuessler extends Tier {
    private boolean verheddert;

    public Tausendfuessler(String farbe) {
        super(1000, farbe);
        this.verheddert = false;
    }

    public void beineEntheddern() {
        // TODO
    }

    private void beineVerheddern() {
        // TODO
    }

    @Override
    public void fressen() {
        System.out.println("Tausendfuessler");
    }
}
