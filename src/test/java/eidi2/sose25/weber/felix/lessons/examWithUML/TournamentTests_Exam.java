package eidi2.sose25.weber.felix.lessons.examWithUML;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import eidi2.sose25.weber.felix.lesson.zulassungsklausur.examWithUML.group01.Player;
import eidi2.sose25.weber.felix.lesson.zulassungsklausur.examWithUML.group01.Tournament;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TournamentTests_Exam {

	private List<Player> players;

	@BeforeEach
	public void init() {
		players = new ArrayList<Player>();
		var p1 = new Player("PlayerA", 'O');
		var p2 = new Player("PlayerB", 'X');
		var p3 = new Player("PlayerC", 'U');
		var p4 = new Player("PlayerD", 'V');
		players.add(p1);
		players.add(p2);
		players.add(p3);
		players.add(p4);
	}

	@Test
	public void testCreateGames() {
		var tournament = new Tournament(players);

		assertEquals(12, tournament.createTournamentGames().size());
	}

}
