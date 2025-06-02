## Runtime Analysis / Laufzeitanalyse

**Einleitung**
Laufzeitanalyse untersucht, wie sich die Ausführungszeit eines Programms mit wachsender Eingabegröße ändert. Dabei verwendet man asymptotische Notationen wie O(n), O(n²), O(2ⁿ) und O(n!). Ziel ist, den dominanten Term zu bestimmen und konstante Faktoren zu ignorieren.

---

## O(n) – Lineare Laufzeit

Die Anzahl der Arbeitsschritte wächst proportional zur Eingabegröße n.

```java
public int sum(int[] array) {
    int total = 0;
    for (int i = 0; i < array.length; i++) {
        total += array[i];
    }
    return total;
}
```

* Schleife läuft genau n-mal (`n = array.length`).
* Jeder Schleifendurchlauf macht konstante Arbeit (Addition, Indexzugriff).
* Gesamt: a·n + b  →  O(n).

---

## O(n²) – Quadratische Laufzeit

Die Arbeitsschritte wachsen proportional zu n². Häufig durch zwei verschachtelte Schleifen.

```java
public void printPairs(int[] array) {
    for (int i = 0; i < array.length; i++) {
        for (int j = 0; j < array.length; j++) {
            System.out.println(array[i] + ", " + array[j]);
        }
    }
}
```

* Äußere Schleife iteriert n-mal.
* Innere Schleife iteriert n-mal pro äußere Iteration.
* Total: n × n = n² Durchläufe.
* Jeder Durchlauf führt konstante Arbeit aus (Ausgabe).
* Gesamt: a·n² + b·n + c  →  O(n²).

---

## O(2ⁿ) – Exponentielle Laufzeit

Die Anzahl der Arbeitsschritte verdoppelt sich ungefähr bei jeder Erhöhung von n um 1. Viele rekursive Aufrufe ohne Memoisierung.

```java
public int fib(int n) {
    if (n < 2) {
        return n;
    }
    return fib(n - 1) + fib(n - 2);
}
```

* Rekursive Aufrufe erzeugen ein binäres Aufteilungsbaumwachstum.
* Anzahl der Aufrufe ≈ 2ⁿ.
* Jeder Aufruf macht konstante Arbeit (Addition, Vergleiche).
* Gesamt: c·2ⁿ  →  O(2ⁿ).

---

## O(n!) – Fakultative Laufzeit

Die Anzahl der Arbeitsschritte wächst als Fakultät der Eingabegröße. Typisch bei vollständiger Permutationsgenerierung.

```java
public void permute(int[] array, int start) {
    if (start == array.length) {
        System.out.println(Arrays.toString(array));
        return;
    }
    for (int i = start; i < array.length; i++) {
        swap(array, start, i);
        permute(array, start + 1);
        swap(array, start, i);
    }
}

private void swap(int[] array, int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
}
```

* Bei n Elementen gibt es n! Permutationen.
* Jede Permutation erfordert konstante Arbeit (z.B. Ausgabe).
* Gesamter Arbeitsaufwand ≈ c·n!  →  O(n!).

---

## Tipps und Tricks zur Klausur

1. **Schleifen zählen**

    * Eine einfache for‐Schleife über n Elemente → O(n).
    * Zwei verschachtelte Schleifen über n → O(n²).
    * Drei verschachtelte Schleifen → O(n³).

2. **Rekursive Aufrufe analysieren**

    * Lineare Rekursion (ein Aufruf pro Ebene) → oft O(n).
    * Binäre Rekursion (zwei Aufrufe pro Ebene) → oft O(2ⁿ).
    * Rekursion mit n Zweigen (Permutation) → O(n!).

3. **Konstanten ignorieren**

    * Multiplikative Faktoren (z. B. 2·n) fallen weg → O(n).
    * Summanden niedrigeren Grades (z. B. n + 5) fallen weg → O(n).

4. **Dominanten Term wählen**

    * Bei gemischten Termen (n² + n) zählt n² → O(n²).
    * Bei (2ⁿ + n³) zählt 2ⁿ → O(2ⁿ).

5. **Methodenaufrufe prüfen**

    * Aufruf einer Methode mit O(f(n)) in Schleife über n → O(n·f(n)).
    * Rekursive Methode, die in jeder Ebene selbst wieder O(n) arbeitet → O(n²).

6. **Worst‐Case betrachten**

    * Klausurfragen fragen meist nach Worst‐Case‐Laufzeit.
    * Sicherstellen, dass alle Zweige abgedeckt sind.

7. **Kurze Markierungen im Code**

    * Schreibe in die Skizze: „for → n“, „for → n“, also n·n → n².
    * Schreibe bei Rekursion: T(n) = T(n–1) + T(n–2) → O(2ⁿ).

8. **Stichwort: Backtracking**

    * Backtracking‐Algorithmen haben oft O(2ⁿ) oder O(n!).
    * Erkenne sie an „für jedes Element, versuche … und mache nächsten Schritt“.

9. **Beispielfunktionen memorieren**

    * Lineare Suche → O(n).
    * Bubble Sort → O(n²).
    * Rekursive Fibonacci ohne Memo → O(2ⁿ).
    * Permutationsgenerierung → O(n!).
