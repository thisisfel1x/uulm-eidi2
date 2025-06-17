package eidi2.sose25.weber.felix.lesson.zulassungsklausur.examD.group03;

import eidi2.sose25.weber.felix.lesson.zulassungsklausur.examD.group03.animal.AAnimal;

import java.util.LinkedList;
import java.util.List;

public class Enclosure<T extends AAnimal> {
	public Class<T> enclosedAnimals;
	List<T> animals = new LinkedList<>();
	final int maxSize = 100;

	public Enclosure(Class<T> enclosedAnimalType) {
		this.enclosedAnimals = enclosedAnimalType;
	}

	public boolean addAnimal(T animal) {
		animals.add(animal);
		return true;
	}

	@Override
	public String toString() {
		return "Enclosure [enclosedAnimals=" + enclosedAnimals + ", animals=" + animals + ", maxSize=" + maxSize + "]";
	}
}
