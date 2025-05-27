### Assignment 2
#### a) Laufzeitanalyse:
| Methode                   | Laufzeit (O)                                 | Begründung                                                         |
|---------------------------|----------------------------------------------|--------------------------------------------------------------------|
| `add(T value)`            | **O(1)** amortisiert, **O(n)** im Worst-Case | Normalerweise O(1), aber bei vollem Array: Resize mit O(n)         |
| `add(int index, T value)` | **O(n)**                                     | Muss ggf. alle Elemente ab `index` nach rechts verschieben         |
| `get(int index)`          | **O(1)**                                     | Direkter Zugriff über Index                                        |
| `size()`                  | **O(1)**                                     | Gibt nur `nextFree` zurück                                         |
| `iterator()`              | **O(1)**                                     | Erzeugt ein Iterator-Objekt                                        |
| Konstruktoren             | **O(n)**                                     | Kopieren von Arrays (z. B. bei `T... values`) oder Initialisierung |

#### b) Amortisierte Laufzeitanalyse
Idee:

Die Methode add(T value) vergrößert das Array nur, wenn es voll ist. Dann wird die Kapazität verdoppelt (resize).
Kostenmodell:

    Kopieren beim Vergrößern kostet O(n).

    Danach folgen viele günstige O(1)-Operationen.

Analyse:

Angenommen, das Array wächst wie folgt:

    Initialgröße: 1

    Danach: 2, 4, 8, ...

Um n Elemente hinzuzufügen, passieren ca. log₂(n) Resizes.

Gesamtkosten fürs Kopieren über alle Resizes:

1 + 2 + 4 + 8 + ... + n/2 = O(n)

Anzahl Operationen:

    n Aufrufe von add(T value)

Amortisierte Kosten pro add:

O(n) / n = O(1)

