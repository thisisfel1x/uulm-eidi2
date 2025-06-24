package eidi2.sose25.weber.felix.lesson.zulassungsklausur.examWithUML;

import eidi2.sose25.weber.felix.lesson.zulassungsklausur.examWithUML.group01.Player;
import eidi2.sose25.weber.felix.lesson.zulassungsklausur.examWithUML.group01.Tournament;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Main {
    // JavaDocs: https://docs.oracle.com/en/java/javase/11/docs/api/allclasses.html

    /**
     * Führt ein Tic-Tac-Toe-Turnier durch bei dem 4 Spieler jeweils 2-mal gegeneinander spielen.
     *
     * @param args
     */
    public static void main(String[] args) {

        List<Player> players = IntStream.rangeClosed(1, 4).boxed()
                .map(x -> new Player("player" + x, Integer.toString(x).charAt(0)))
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

        Tournament tournament = new Tournament(players);
        tournament.runTournament();

    }


}
