package eidi2.sose25.weber.felix.lesson.uml2java;

public class Main {
    public static void main(String[] args) {
        Elefant elefant = new Elefant();
        elefant.laufen(10.0);
        elefant.trompeten(2.5);

        Tausendfuessler tausendfuessler = new Tausendfuessler("Grün");
        tausendfuessler.beineVerheddern();
        tausendfuessler.beineEntheddern();

        Gehege<Tier> gehege = new Gehege<>(5, 100.0);
        gehege.addTier(elefant);
        gehege.addTier(tausendfuessler);

        // Um welches Tier handelt es sich?
        for (Tier tier : gehege.getTiere()) {
            if (tier instanceof Elefant) {
                Elefant current = (Elefant) tier;
                current.trompeten(200);
                System.out.println("Wir haben einen Elefant!");
            } else if (tier instanceof Tausendfuessler) {
            // } else if (tier instanceof Tausendfuessler current) { -> new syntax
                Tausendfuessler current = (Tausendfuessler) tier;
                current.beineEntheddern();
                System.out.println("Wir haben einen Tausendfuessler!");
            } else {
                System.out.println("Unknown animal " + tier);
            }
        }

        gehege.tiereFuettern();

        gehege.removeTier(elefant);
    }
}
