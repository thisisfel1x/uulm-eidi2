package eidi2.sose25.weber.felix.lesson.zulassungsklausur.examWithUML.group01.util;

import eidi2.sose25.weber.felix.lesson.zulassungsklausur.examWithUML.group01.Game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputManagement {

    private BufferedReader bufferReader;

    /**
     * Implementiert das Einlesen der Koordinaten über die Konsole und die Aufbereitung des dadurch erhaltenen Strings. Bei einer Falscheingabe wird der aktuelle Spieler aufgefordert erneut Koordinaten einzugeben.
     *
     * @param game Aktuelles Spiel, für das Koordinaten als Konsoleneingabe erwartet werden
     * @return Array [x,y] mit den x- und y-Koordinaten auf einem Spielfeld
     */
    public int[] manageInput(Game game) {
        int[] xyPosition = {-1, -1};
        this.bufferReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            while ((xyPosition[0] == -1) && (xyPosition[1] == -1)) {
                System.out.print(this.getPlayerInformation(game));
                String coordinates = this.bufferReader.readLine();
                xyPosition = this.getInput(game, coordinates);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return xyPosition;
    }

    /**
     * Schließt den Stream, der verwendet wird um die Koordinaten über die Konsole einzulesen.
     */
    public void closeInput() {
        try {
            this.bufferReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Extrahiert aus den in coordinates übergebenen Text die x- und y-Koordinaten als int[].
     *
     * @param game        Aktuelles Spiel, für das Koordinaten als Konsoleneingabe erwartet werden
     * @param coordinates Über die Konsole eingegebene x- und y-Koordinaten. Diese werden in folgendem Format erwartet: x-y
     * @return Array [x,y] mit den aufbereiteten x- und y-Koordinaten. Im Fehlerfall wird das Array [-1,-1] zurück gegeben
     */
    private int[] getInput(Game game, String coordinates) {
        String[] split = coordinates.replaceAll(" ", "").split("-");
        int[] xyPosition = {-1, -1};
        if (split.length == 2) {
            try {
                int x = Integer.parseInt(split[0]);
                int y = Integer.parseInt(split[1]);
                if ((x > 0) && (x <= 3) && (y > 0) && (y <= 3) && game.isFieldFree(x, y)) {
                    xyPosition[0] = x;
                    xyPosition[1] = y;
                }

            } catch (NumberFormatException e) {
                return xyPosition;
            }
        }

        return xyPosition;
    }

    /**
     * Erzeugt den Text für eine Eingabeaufforderung an den aktuellen Spieler
     *
     * @param game Aktuelles Spiel, für das Koordinaten als Konsoleneingabe erwartet werden
     * @return Text zur Eingabeaufforderung an den aktuellen Spieler
     */
    private String getPlayerInformation(Game game) {
        String msg = "";
        msg = game.getCurrentPlayer().getName() + " it is our turn. Please enter your coordinats. For example 1-2 x=1 & y=2. Pleas note 1<=x,y<=3.";
        return msg;
    }

}
