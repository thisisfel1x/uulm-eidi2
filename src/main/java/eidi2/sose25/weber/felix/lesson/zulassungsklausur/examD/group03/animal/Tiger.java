package eidi2.sose25.weber.felix.lesson.zulassungsklausur.examD.group03.animal;

import eidi2.sose25.weber.felix.lesson.zulassungsklausur.examD.group03.util.Sex;

public class Tiger extends AAnimal {

	public Tiger(int legCount, Sex sex) {
		super(legCount, sex);
	}

	public void eat() {

	}

	@Override
	public String toString() {
		return "Tiger [legCount=" + legCount + ", sex=" + sex + "]";
	}

}
