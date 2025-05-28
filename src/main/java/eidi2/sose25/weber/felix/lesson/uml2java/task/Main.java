package eidi2.sose25.weber.felix.lesson.uml2java.task;

public class Main {

    public static void main(String[] args) {

        Elefant elefant = new Elefant();
        Tausendfuessler tausendfuessler = new Tausendfuessler("Grau");
        Tier signleTier = new Tier(10, "blau");

        elefant.fressen();
        tausendfuessler.fressen();

        Gehege<Tier> gehege = new Gehege<>(5, 20);
        gehege.addTier(elefant);
        gehege.addTier(tausendfuessler);
        gehege.addTier(signleTier);

        for(Tier tier : gehege.getTiere()) {
            if (tier instanceof Elefant) {
                Elefant current = (Elefant) tier;
                current.fressen();
            } else if (tier instanceof Tausendfuessler) {
                // tausendfuessler
            } else {
                // tier
            }

        }

    }

}
