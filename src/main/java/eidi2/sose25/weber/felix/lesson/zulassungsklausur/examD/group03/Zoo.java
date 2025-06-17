package eidi2.sose25.weber.felix.lesson.zulassungsklausur.examD.group03;

import eidi2.sose25.weber.felix.lesson.zulassungsklausur.examD.group03.animal.AAnimal;
import eidi2.sose25.weber.felix.lesson.zulassungsklausur.examD.group03.animal.CanFly;

import java.util.HashMap;
import java.util.List;

public class Zoo {
	HashMap<Trainer<AAnimal>, List<Enclosure<AAnimal>>> trainings = new HashMap<>();;
	
	public <T extends AAnimal> void addEnclosureForTrainer(Trainer<T> trainer, Enclosure<T> enclosureToAdd) {
		//TODO
	}
	
	public <T extends AAnimal & CanFly> int countLegsOnGroundInAllEnclosures(Trainer<T> trainer) {
		//TODO
		return 0;
	}
	
	public void gutAllTigers() {
		// TODO
	}

	@Override
	public String toString() {
		return "Zoo [trainings=" + trainings + "]";
	}
}
