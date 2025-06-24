package eidi2.sose25.weber.felix.lessons.examWithUML;

import eidi2.sose25.weber.felix.lesson.zulassungsklausur.examWithUML.group01.Game;
import eidi2.sose25.weber.felix.lesson.zulassungsklausur.examWithUML.group01.Player;

public class TestGame extends Game {
	
	private boolean testWinner=false;

	public TestGame(Player p1, Player p2) {
		super(p1, p2);
		this.setMngmt(new TestInputManagement());
	}
	
	public boolean checkWinner() {
		return this.testWinner;
	}

	public boolean isTestWinner() {
		return testWinner;
	}

	public void setTestWinner(boolean testWinner) {
		this.testWinner = testWinner;
	}

}
