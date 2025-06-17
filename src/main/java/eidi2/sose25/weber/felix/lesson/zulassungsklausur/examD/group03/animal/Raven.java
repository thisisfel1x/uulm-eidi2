package eidi2.sose25.weber.felix.lesson.zulassungsklausur.examD.group03.animal;

import eidi2.sose25.weber.felix.lesson.zulassungsklausur.examD.group03.util.Sex;

public class Raven extends AAnimal implements CanFly {
	private boolean isFlying = false;

	public Raven(int legCount, Sex sex) {
		super(legCount, sex);
	}

	@Override
	public boolean isAirborne() {
		return isFlying;
	}
	
	@Override
	public void land() {
		isFlying = false;
	}
	
	@Override
	public void takeOff() {
		isFlying = true;
	}

	@Override
	public String toString() {
		return "Raven [isFlying=" + isFlying + ", legCount=" + legCount + ", sex=" + sex + "]";
	}

}
