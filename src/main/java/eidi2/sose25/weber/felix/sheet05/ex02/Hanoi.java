package eidi2.sose25.weber.felix.sheet05.ex02;

import java.util.Arrays;

public class Hanoi {

    public static void main(String[] args) {
        int n = 3; // Beispiel mit 3 Scheiben

        Tower[] towers = new Tower[3];
        for (int i = 0; i < 3; i++) {
            towers[i] = new Tower();
        }

        for (int size = n; size >= 1; size--) {
            towers[0].push(new Disc(size));
        }

        System.out.println("Startzustand:");
        printTowers(towers);

        solve(n, 0, 2, 1, towers); // Von Turm 0 nach 2 mit Hilfsturm 1

        System.out.println("Endzustand:");
        printTowers(towers);
    }

    public static void printTowers(Tower[] towers) {
        for (int i = 0; i < towers.length; i++) {
            System.out.print("Turm " + i + ": ");
            Arrays.stream(towers).forEach(tower -> System.out.print(tower.toString() + " "));
            System.out.println();
        }
    }

    public static void solve(int n, int from, int to, int aux, Tower[] towers) {
        if (n == 0) return;

        solve(n - 1, from, aux, to, towers);

        Disc disc = towers[from].pop();
        towers[to].push(disc);
        System.out.println("Bewege Scheibe " + disc.getSize() + " von Turm " + from + " nach Turm " + to);

        solve(n - 1, aux, to, from, towers);
    }


}

