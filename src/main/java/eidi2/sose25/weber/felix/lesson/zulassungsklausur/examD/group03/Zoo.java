package eidi2.sose25.weber.felix.lesson.zulassungsklausur.examD.group03;

import eidi2.sose25.weber.felix.lesson.zulassungsklausur.examD.group03.animal.AAnimal;
import eidi2.sose25.weber.felix.lesson.zulassungsklausur.examD.group03.animal.CanFly;
import eidi2.sose25.weber.felix.lesson.zulassungsklausur.examD.group03.animal.Raven;
import eidi2.sose25.weber.felix.lesson.zulassungsklausur.examD.group03.animal.Tiger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Zoo {
    HashMap<Trainer<AAnimal>, List<Enclosure<AAnimal>>> trainings = new HashMap<>();

    public <T extends AAnimal> void addEnclosureForTrainer(Trainer<AAnimal> trainer, Enclosure<AAnimal> enclosureToAdd) {
        if (enclosureToAdd == null) {
            throw new IllegalArgumentException("enclosureToAdd cannot be null");
        }

        if (!this.trainings.containsKey(trainer)) {
            this.trainings.put(trainer, new ArrayList<>());
        }

        List<Enclosure<AAnimal>> trainerEnclosures = this.trainings.get(trainer);
        trainerEnclosures.add(enclosureToAdd);

    }

    public <T extends AAnimal & CanFly> int countLegsOnGroundInAllEnclosures(Trainer<T> trainer) {
        int totalLegs = 0;

        List<Enclosure<AAnimal>> trainerEnclosures = this.trainings.get(trainer);
        if (trainerEnclosures == null) {
            return 0;
        }

        for (Enclosure<AAnimal> enclosure : trainerEnclosures) {
            for (AAnimal animal : enclosure.animals) {
                if (animal instanceof Raven raven) {
                    if (!raven.isAirborne()) {
                        totalLegs += raven.getLegCount();
                    }
                }
            }
        }

        return totalLegs;
    }

    public void gutAllTigers() {
        for (List<Enclosure<AAnimal>> enclosureToTrainer : this.trainings.values()) {
            for (Enclosure<AAnimal> enclosure : enclosureToTrainer) {
                for (AAnimal animal : enclosure.animals) {
                    if (animal instanceof Tiger tiger) {
                        animal.setLegCount(0);
                    }
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Zoo [trainings=" + trainings + "]";
    }
}
