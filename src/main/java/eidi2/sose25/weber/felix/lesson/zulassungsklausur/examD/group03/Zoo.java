package eidi2.sose25.weber.felix.lesson.zulassungsklausur.examD.group03;

import eidi2.sose25.weber.felix.lesson.zulassungsklausur.examD.group03.animal.AAnimal;
import eidi2.sose25.weber.felix.lesson.zulassungsklausur.examD.group03.animal.CanFly;
import eidi2.sose25.weber.felix.lesson.zulassungsklausur.examD.group03.animal.Tiger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Zoo {
	HashMap<Trainer<AAnimal>, List<Enclosure<AAnimal>>> trainings = new HashMap<>();;
	
	public <T extends AAnimal> void addEnclosureForTrainer(Trainer<T> trainer, Enclosure<T> enclosureToAdd) {
        if (enclosureToAdd == null) {
            throw new IllegalArgumentException("Enclosure cannot be null");
        }

        if (!trainings.containsKey(trainer)) {
            trainings.put((Trainer<AAnimal>) trainer, new ArrayList<>());
        }

        // Gehege der Liste hinzufügen
        List<Enclosure<AAnimal>> enclosures = trainings.get(trainer);
        enclosures.add((Enclosure<AAnimal>) enclosureToAdd);

	}
	
	public <T extends AAnimal & CanFly> int countLegsOnGroundInAllEnclosures(Trainer<T> trainer) {
        int totalLegs = 0;

        List<Enclosure<AAnimal>> enclosuresToTrainer = this.trainings.get(trainer);
        if (enclosuresToTrainer == null) {
            return 0;
        }

        for (Enclosure<AAnimal> enclosure : enclosuresToTrainer) {
            for (AAnimal animal : enclosure.animals) {
                if (animal instanceof CanFly canFly) {
                    if (!canFly.isAirborne()) {
                        totalLegs += animal.getLegCount();
                    }
                }
            }
        }

        return totalLegs;

	}
	
	public void gutAllTigers() {
        for (List<Enclosure<AAnimal>> enclosures : this.trainings.values()) {
            for (Enclosure<AAnimal> animalEnclosure : enclosures) {
                for (AAnimal animal : animalEnclosure.animals) {
                    if (animal instanceof Tiger tiger) {
                        tiger.setLegCount(0);
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
