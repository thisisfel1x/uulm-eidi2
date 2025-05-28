package eidi2.sose25.weber.felix.lesson.uml2java.task;

public class Elefant extends Tier {

    public Elefant() {
        super(4, "Grau");
    }

    private void trompeten(double dauer) {
        // TODO
    }

    @Override
    public void fressen() {
        System.out.println("Elefant");
        super.fressen();
    }

    @Override
    public String toString() {
        return "Elefant";
    }

}
