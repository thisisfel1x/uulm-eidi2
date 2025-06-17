package eidi2.sose25.weber.felix.lesson.zulassungsklausur.examD.group03.animal;

import eidi2.sose25.weber.felix.lesson.zulassungsklausur.examD.group03.util.Sex;

public abstract class AAnimal {
	int legCount;
	public int getLegCount() {
		return legCount;
	}

	public void setLegCount(int legCount) {
		this.legCount = legCount;
	}

	public Sex getSex() {
		return sex;
	}

	public void changeSex(Sex sex) {
		this.sex = sex;
	}

	Sex sex;
	
	public AAnimal(int legCount, Sex sex) {
		this.legCount = legCount;
		this.sex = sex;
	}
}
