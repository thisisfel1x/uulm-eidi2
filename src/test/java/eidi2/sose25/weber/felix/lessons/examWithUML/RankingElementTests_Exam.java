package eidi2.sose25.weber.felix.lessons.examWithUML;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import eidi2.sose25.weber.felix.lesson.zulassungsklausur.examWithUML.group01.RankingElement;
import org.junit.jupiter.api.Test;

class RankingElementTests_Exam {

	
	@Test
	void testRankingElementSetName() {
		var rankingElement = new RankingElement("foo", 42);
		rankingElement.setName("bar");
		assertEquals("bar", rankingElement.getName());
		assertEquals(42, rankingElement.getWins());
	}
	
}
