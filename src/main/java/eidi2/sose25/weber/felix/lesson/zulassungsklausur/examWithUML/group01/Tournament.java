package eidi2.sose25.weber.felix.lesson.zulassungsklausur.examWithUML.group01;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Tournament {
	
	/**
	 * Diese Map speichert die Spieler, die am Turnier teilnehmen.
	 * Der Schlüssel der Map ist der Name des Spielers.
	 * Der Wert ist das zugehörige Spieler-Objekt selber. 
	 *  
	 */
	private Map<String, Player> players = new HashMap<String, Player>();
	
	/**
	 *  In dieser Liste werden alle Spiele des Turniers gespeichert.
	 */
	private List<Game> games;
	
	public Tournament(List<Player> ps) {
		ps.forEach(x -> this.players.put(x.getName(), x));
	}

	/**
	 *  Die Methode erzeugt 2 Spiele für jeden Spieler gegen jeden Spieler und liefert diese in einer Liste zurück.
	 */
	//TODO: Aufgabe 2
	List<Game> createTournamentGames() {

	}

	/**
	 * Die Methode liefert eine sortierte Liste an RankingElementen zurück.
	 *
	 * Jedes RankingElement beinhaltet den Namen des Spielers und die Anzahl der Siege.
	 * Die Sortierung basiert auf der Anzahl an Siegen.
	 * Das erste Element der Liste ist der Sieger, also der Spieler mit der höchsten Anzahl an Siegen.
	 */
	//TODO: Aufgabe 3
	public List<RankingElement> computeRanking() {

	}

	/**
	 * Diese Methode führt das Turnier durch, in dem jedes Spiel gespielt wird.
	 * 
	 * Am Ende wird das Ranking ausgegeben. 
	 */
	public void runTournament() {
		games = createTournamentGames();
		for (Game game : games) {

			game.printField();
			game.runGame();
			System.out.println(game.getGameInformation());
		}
		
		System.out.println(computeRanking());
	}
}
