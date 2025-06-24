package eidi2.sose25.weber.felix.lessons.examWithUML;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import eidi2.sose25.weber.felix.lesson.zulassungsklausur.examWithUML.group01.Player;
import eidi2.sose25.weber.felix.lesson.zulassungsklausur.examWithUML.group01.Tournament;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RankingTest_Exam {

	private Tournament tournament;
	private List<Player> players;

	@BeforeEach
	public void init() {
		players = new ArrayList<Player>();
		var p1 = new Player("PlayerA", 'O');
		p1.setWins(0);
		var p2 = new Player("PlayerB", 'X');
		p2.setWins(2);
		var p3 = new Player("PlayerC", 'U');
		p3.setWins(2);
		var p4 = new Player("PlayerD", 'V');
		p4.setWins(7);
		var p5 = new Player("PlayerE", 'W');
		p5.setWins(1);

		players.add(p1);
		players.add(p2);
		players.add(p3);
		players.add(p4);
		players.add(p5);
		tournament = new Tournament(players);
	}

	@Test
	void testPlayerD() {
		var list = tournament.computeRanking();
		assertEquals("PlayerD", list.get(0).getName());
		assertEquals(7, list.get(0).getWins());
	}
	
	@Test
	void testPlayerC() {
		var list = tournament.computeRanking();
		assertTrue(list.get(1).getName().equals("PlayerC") || list.get(2).getName().equals("PlayerC"));
		assertTrue(list.get(1).getWins() == 2 || list.get(2).getWins() == 2 );
	}

}
