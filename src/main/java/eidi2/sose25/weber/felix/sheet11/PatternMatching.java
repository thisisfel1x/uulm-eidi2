package eidi2.sose25.weber.felix.sheet11;

public class PatternMatching {

    public static int[] bruteForce(String pattern, String text) {
        int n = text.length();
        int m = pattern.length();
        int comparisons = 0;

        for (int i = 0; i <= n - m; i++) {
            int j = 0;
            while (j < m && text.charAt(i + j) == pattern.charAt(j)) {
                comparisons++;
                j++;
            }
            if (j < m) {
                comparisons++;
            }
            if (j == m) { // Wort gefunden
                return new int[]{i, comparisons};
            }
        }
        return new int[]{-1, comparisons}; // Nichts gefunden
    }

    public static int[] computeDelta1(String pattern) {
        int[] delta1 = new int[256]; // ASCII-Zeichen

        int m = pattern.length();
        // Standardwert setzen
        for (int i = 0; i < 256; i++) {
            delta1[i] = m;
        }

        // Delta1 für im Muster vorhandene Zeichen berechnen
        for (int i = 0; i < m - 1; i++) {
            delta1[pattern.charAt(i)] = m - 1 - i;
        }

        return delta1;
    }

    public static int[] boyerMoore(String pattern, String text) {
        int n = text.length();
        int m = pattern.length();
        int[] delta1 = computeDelta1(pattern);
        int comparisons = 0;
        int i = 0;

        while (i <= n - m) {
            int j = m - 1;
            while (j >= 0 && text.charAt(i + j) == pattern.charAt(j)) {
                comparisons++;
                j--;
            }
            if (j >= 0) {
                comparisons++; // letzter Vergleich, bei dem die Zeichen ungleich sind
                char badChar = text.charAt(i + j);
                int shift = delta1[badChar];
                if (shift < 1) shift = 1; // Mindestverschiebung 1
                i += shift;
            } else {
                return new int[]{i, comparisons};
            }
        }

        return new int[]{-1, comparisons};
    }

    public static int[] kmp(String pattern, String text) {
        int n = text.length();
        int m = pattern.length();
        int[] prefix = computePrefix(pattern);
        int comparisons = 0;

        int i = 0; // Index für Text
        int j = 0; // Index für Pattern

        while (i < n) {
            comparisons++;
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
                if (j == m) {
                    return new int[]{i - m, comparisons};
                }
            } else {
                if (j > 0) {
                    j = prefix[j - 1];
                } else {
                    i++;
                }
            }
        }

        return new int[]{-1, comparisons};
    }

    public static int[] computePrefix(String pattern) {
        int m = pattern.length();
        int[] prefix = new int[m];
        prefix[0] = 0;

        int j = 0; // Länge des aktuellen Präfix-Suffix

        for (int i = 1; i < m; i++) {
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = prefix[j - 1];
            }
            if (pattern.charAt(i) == pattern.charAt(j)) {
                j++;
            }
            prefix[i] = j;
        }

        return prefix;
    }

    public static void main(String[] args) {
        test("lauch", "baerlauch");
        test("babcabab", "abababcbababcababcab");
        test("erdbeere", "erdbeebenbringenerdezumbeeben");
    }

    public static void test(String pattern, String text) {
        System.out.println("Pattern: " + pattern);
        System.out.println("Text: " + text);

        int[] bfResult = PatternMatching.bruteForce(pattern, text);
        System.out.println("Brute Force: Position = " + bfResult[0] + ", Vergleiche = " + bfResult[1]);

        int[] bmResult = PatternMatching.boyerMoore(pattern, text);
        System.out.println("Boyer Moore: Position = " + bmResult[0] + ", Vergleiche = " + bmResult[1]);

        int[] kmpResult = PatternMatching.kmp(pattern, text);
        System.out.println("KMP: Position = " + kmpResult[0] + ", Vergleiche = " + kmpResult[1]);

        System.out.println();
    }
}
