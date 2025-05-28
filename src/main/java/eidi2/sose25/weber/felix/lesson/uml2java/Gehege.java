package eidi2.sose25.weber.felix.lesson.uml2java;

import java.util.ArrayList;

public class Gehege<T extends Tier> {
    private int kapazitaet;
    private double groesse;
    private ArrayList<T> tiere;

    public Gehege(int kapazitaet, double groesse) {
        this.kapazitaet = kapazitaet;
        this.groesse = groesse;
        this.tiere = new ArrayList<>();
    }

    public void addTier(T tier) {
        if (this.tiere.size() < this.kapazitaet) {
            this.tiere.add(tier);
        }
    }

    public void removeTier(T tier) {
        this.tiere.remove(tier);
    }

    public void tiereFuettern() {
        for (T tier : this.tiere) {
            tier.fressen();
        }
    }

    // NOT IN UML DIAGRAM
    public ArrayList<T> getTiere() {
        return this.tiere;
    }
}

