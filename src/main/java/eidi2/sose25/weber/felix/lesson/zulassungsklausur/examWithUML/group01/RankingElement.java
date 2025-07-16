package eidi2.sose25.weber.felix.lesson.zulassungsklausur.examWithUML.group01;

//TODO: Aufgabe 1
public class RankingElement {
    private String name;
    private int wins;

    public RankingElement(String name, int wins) {
        this.name = name;
        this.wins = wins;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }
}
