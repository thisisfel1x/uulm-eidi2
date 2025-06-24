package eidi2.sose25.weber.felix.lesson.zulassungsklausur.examWithUML.group01;

public class Player {
	private String name;
	private char mark;
	private int wins;
	
	public Player(String name, char mark) {
		this.name=name;
		this.mark=mark;
		this.wins=0;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public int getWins() {
		return this.wins;
	}
	
	public void setWins(int wins) {
		this.wins = wins;
	}

	public char getMark() {
		return this.mark;
	}

	public void setMark(char mark) {
		this.mark = mark;
	}

	public void incWins() {
		this.setWins(this.getWins() + 1);	
	}


}
