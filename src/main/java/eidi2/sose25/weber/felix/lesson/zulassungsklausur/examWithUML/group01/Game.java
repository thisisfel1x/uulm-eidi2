package eidi2.sose25.weber.felix.lesson.zulassungsklausur.examWithUML.group01;

import eidi2.sose25.weber.felix.lesson.zulassungsklausur.examWithUML.group01.util.InputManagement;

import java.util.ArrayList;
import java.util.Optional;

public class Game {

    //Spielfeld
    private char[][] field = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};

    //Informationen zu den aktuellen Spielern
    private ArrayList<Player> players;

    //Spieler, der am Zug ist (aktueller Spieler)
    private Player currentPlayer;

    /**
     * Bildet den Spielzustand ab.
     * <p>
     * null, wenn das Spiel noch nicht zu Ende ist.
     * Optional.empty(), wenn das Spiel unentschieden ausgeht, weil kein Zug mehr möglich ist.
     * Optional.of(gewinner), das Spiel hat der Spieler `gewinner` gewonnen
     */
    private Optional<Player> winner;

    // Manager für die Konsoleneingabe
    private InputManagement mngmt;


    /**
     * Erzeugt ein neues Spiel und speichert dazu die Spieler sowie initialisiert den InputManager für die Konsoleneingabe der Koordinaten.
     *
     * @param player1 1. Spielers
     * @param player2 2. Spielers
     */
    public Game(Player player1, Player player2) {
        this.players = new ArrayList<Player>();
        this.players.add(player1);
        this.players.add(player2);
        this.currentPlayer = player1;
        this.mngmt = new InputManagement();
    }

    /**
     * Es werden die folgenden drei Aktionen so lange durchgeführt bis ein Gewinner
     * feststeht oder das Spielfeld vollständig belegt ist: 1. Eingabe der
     * Koordinaten, 2. Setzen der Markierung auf dem Spielfeld, 3. Evaluation des
     * Spielzustands
     *
     * @param game Aktuelles Spiel
     */
    public void runGame() {
        while (this.winner == null) {
            int[] xyPosition = this.getPosition();
            this.setMark(xyPosition[0], xyPosition[1]);
            this.evaluateGameState();
        }
    }

    /**
     * Prüft ob der aktuelle Spieler gewonnen hat.
     *
     * @return Wahr, wenn der aktuelle Spieler gewonnen hat, sonst Falsch
     */
    public boolean checkWinner() {
        boolean hasWinner = false;
        //check horizontal and vertical winner
        for (int i = 0; i < this.field.length; i++) {
            boolean horizontal = true;
            boolean vertical = true;
            for (int j = 0; j < this.field[i].length; j++) {
                horizontal = horizontal && (this.field[i][j] == this.currentPlayer.getMark());
                vertical = vertical && (this.field[j][i] == this.currentPlayer.getMark());
            }
            hasWinner = horizontal || vertical;
            if (hasWinner) {
                this.winner = Optional.of(this.currentPlayer);
                break;
            }
        }
        //check diagonal
        if ((!hasWinner) && (this.field[1][1] == this.currentPlayer.getMark())) {
            hasWinner = (this.field[0][0] == this.currentPlayer.getMark()) && (this.field[this.field.length - 1][this.field[0].length - 1] == this.currentPlayer.getMark());
            hasWinner = hasWinner || ((this.field[0][this.field[0].length - 1] == this.currentPlayer.getMark()) && (this.field[this.field.length - 1][0] == this.currentPlayer.getMark()));
        }
        if (hasWinner) {
            this.winner = Optional.of(this.currentPlayer);
        }
        return hasWinner;
    }

    /**
     * Überprüft den aktuellen Spielzustand und aktualisiert diesen.
     * Die Methode prüft, ob noch freie Felder auf dem Spielfeld vorhanden sind und ob ein Spieler gewonnen hat.
     * Hat ein Spieler gewonnen, wird dieser als Gewinner gesetzt und die Anzahl seiner Siege inkrementiert.
     * Zuletzt wechselt der aktuelle Spieler.
     */
    public void evaluateGameState() {
        boolean freeField = false;
        for (int i = 0; i < this.field.length; i++) {
            for (int j = 0; j < this.field[i].length; j++) {
                if (this.field[i][j] == ' ') {
                    freeField = true;
                    break;
                }
            }
            if (freeField) {
                break;
            }
        }
        if (!freeField) {
            this.winner = Optional.empty();
        }
        if (this.checkWinner()) {
            this.winner = Optional.of(this.currentPlayer);
            this.currentPlayer.incWins();
        }
        this.toogleCurrentPlayer();
    }

    /**
     * Setzt das Symbol des aktuellen Spielers an die angegebene Stelle im Spielfeld. Es werden als Koordinaten Werte zwischen 1-3 erwartet.
     *
     * @param x x-Koordinate im Spielfeld
     * @param y y-Koordinate im Spielfeld
     */
    public void setMark(int x, int y) {
        if ((x > 0) && (y > 0) && (this.field[x - 1][y - 1] == ' ')) {
            this.field[x - 1][y - 1] = this.currentPlayer.getMark();
        }
        this.printField();
    }

    /**
     * Holt über den InputManager die Konsoleneingabe der x- und y-Koordinaten
     *
     * @return Array [x,y] mit den x- und y-Koordinaten auf einem Spielfeld
     */
    public int[] getPosition() {
        return this.mngmt.manageInput(this);
    }

    /**
     * Prüft, ob die angegebene Stelle im Spielfeld bereits belegt ist. Es werden als Koordinaten Werte zwischen 1-3 erwartet.
     *
     * @param x x-Koordinate im Spielfeld
     * @param y y-Koordinate im Spielfeld
     * @return Wahr, wenn die angegebene Position im Spielfeld noch nicht belegt ist, sonst Falsch
     */
    public boolean isFieldFree(int x, int y) {
        return (this.field[x - 1][y - 1] == ' ');
    }

    /**
     * Erzeugt eine Konsolenausgabe des Spielfelds.
     */
    public void printField() {
        for (int i = 0; i < this.field.length; i++) {
            System.out.print("|");
            for (int j = 0; j < this.field[i].length; j++) {
                System.out.print(this.field[i][j]);
                if (j < 2) {
                    System.out.print("| ");
                } else {
                    System.out.println("|");
                }
            }
        }
        System.out.println();

    }

    /**
     * Erzeugt einen Informationstext über den Ausgang einer Spielrunde.
     *
     * @return Information über den Ausgang der aktuellen Runde.
     */
    public String getGameInformation() {
        String msg = "";
        if (this.winner.isEmpty()) {
            msg = "Game over. No winner!";
        } else {
            this.toogleCurrentPlayer();
            msg = this.currentPlayer.getName() + " won for the " + this.currentPlayer.getWins() + ". time";
        }
        return msg;
    }

    /**
     * Aktualisiert den currentPlayer auf den nächsten in der Liste mit Overflow nach vorne durch die Modulo-Operation.
     */
    private void toogleCurrentPlayer() {
        this.currentPlayer = this.players.get((this.players.indexOf(this.currentPlayer) + 1) % this.players.size());
    }

    public char[][] getField() {
        return this.field;
    }

    public void setField(char[][] field) {
        this.field = field;
    }

    public ArrayList<Player> getPlayers() {
        return this.players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public Player getCurrentPlayer() {
        return this.currentPlayer;
    }

    public void setCurrentPlayer(Player player) {
        this.currentPlayer = player;
    }

    public Optional<Player> getWinner() {
        return this.winner;
    }

    public void setWinner(Optional<Player> winner) {
        this.winner = winner;
    }

    public void stopGame() {
        this.mngmt.closeInput();
    }

    public InputManagement getMngmt() {
        return this.mngmt;
    }

    public void setMngmt(InputManagement mngmt) {
        this.mngmt = mngmt;
    }

}
