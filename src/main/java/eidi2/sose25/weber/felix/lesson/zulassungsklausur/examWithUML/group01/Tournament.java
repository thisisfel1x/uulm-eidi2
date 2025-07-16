package eidi2.sose25.weber.felix.lesson.zulassungsklausur.examWithUML.group01;

import java.util.*;


public class Tournament {

    /**
     * Diese Map speichert die Spieler, die am Turnier teilnehmen.
     * Der Schlüssel der Map ist der Name des Spielers.
     * Der Wert ist das zugehörige Spieler-Objekt selber.
     */
    private final Map<String, Player> players = new HashMap<String, Player>();

    /**
     * In dieser Liste werden alle Spiele des Turniers gespeichert.
     */
    private List<Game> games;

    public Tournament(List<Player> ps) {
        ps.forEach(x -> this.players.put(x.getName(), x));
    }

    /**
     * Die Methode erzeugt 2 Spiele für jeden Spieler gegen jeden Spieler und liefert diese in einer Liste zurück.
     */
    //TODO: Aufgabe 2
    public List<Game> createTournamentGames() {
        List<Game> currentGames = new ArrayList<>();
        List<Player> currentPlayers = new ArrayList<>(players.values());

        for (int i = 0; i < currentPlayers.size(); i++) {
            for (int j = i + 1; j < currentPlayers.size(); j++) {
                Player p1 = currentPlayers.get(i);
                Player p2 = currentPlayers.get(j);

                currentGames.add(new Game(p1, p2));
                currentGames.add(new Game(p2, p1));
            }
        }

        return currentGames;
    }

    /**
     * Die Methode liefert eine sortierte Liste an RankingElementen zurück.
     * <p>
     * Jedes RankingElement beinhaltet den Namen des Spielers und die Anzahl der Siege.
     * Die Sortierung basiert auf der Anzahl an Siegen.
     * Das erste Element der Liste ist der Sieger, also der Spieler mit der höchsten Anzahl an Siegen.
     */
    //TODO: Aufgabe 3
    public List<RankingElement> computeRanking() {
        List<RankingElement> rankingElements = new ArrayList<>();

        for (Player player : players.values()) {
            rankingElements.add(new RankingElement(player.getName(), player.getWins()));
        }

        rankingElements.sort(new Comparator<RankingElement>() {
            @Override
            public int compare(RankingElement o1, RankingElement o2) {
                if (o1.getWins() > o2.getWins()) {
                    return 1;
                } else if (o1.getWins() < o2.getWins()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });

        return null;
    }

    /**
     * Diese Methode führt das Turnier durch, in dem jedes Spiel gespielt wird.
     * <p>
     * Am Ende wird das Ranking ausgegeben.
     */
    public void runTournament() {
        this.games = this.createTournamentGames();
        for (Game game : this.games) {

            game.printField();
            game.runGame();
            System.out.println(game.getGameInformation());
        }

        System.out.println(this.computeRanking());
    }
}
