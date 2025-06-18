Hier ist eine einfache und klare Erklärung für dein Tutorium:

---

## **Was ist ein balancierter binärer Suchbaum?**

Ein **binärer Suchbaum (BST)** ist eine Baumstruktur mit der Eigenschaft:

* **Links** sind nur kleinere Werte.
* **Rechts** sind nur größere Werte.

Ein **balancierter BST** stellt sicher, dass der Baum nicht zu "einseitig" wird, d.h.:

* Die **Höhen** der linken und rechten Teilbäume **unterscheiden sich höchstens um 1** an jedem Knoten.

### **Warum ist das wichtig?**

* In einem gut balancierten Baum: Einfügen, Suchen, Löschen ≈ **O(log n)**
* In einem unbalancierten Baum (z. B. eine Liste): ≈ **O(n)** → **viel langsamer**

---

## **Beispiel-Array zum Einfügen**

```java
int[] werte = { 5, 3, 7, 1, 4, 6 };
```

Baum nach Einfügen (balanciert):

```
       5
     /   \
    3     7
   / \   /
  1   4 6
```

---

## **Einfügen (add)**

1. Vergleiche neuen Wert mit Wurzel.
2. Gehe links, wenn kleiner. Rechts, wenn größer.
3. Wiederhole, bis freie Stelle erreicht ist.
4. Füge ein.
5. Danach **Balance prüfen und ggf. rotieren (AVL- oder Red-Black-Baum).**

### Beispiel: Füge 2 ein

Ausgangsbaum:

```
     3
    / \
   1   5
```

→ Einfügen 2:

```
     3
    / \
   1   5
    \
     2
```

→ Unbalanciert → Balance-Operation (Rotation) nötig.

---

## **Löschen (remove)**

3 Fälle:

### 1. **Knoten ohne Kinder**

Einfach löschen.

Beispiel:

```
  3
 /
1
```

→ Lösche `1` → bleibt:

```
  3
```

### 2. **Knoten mit 1 Kind**

Ersetze Knoten durch das Kind.

Beispiel:

```
  3
 /
1
 \
  2
```

→ Lösche `1` → Baum wird:

```
  3
 /
2
```

### 3. **Knoten mit 2 Kindern**

* Finde **inorder successor** (kleinster im rechten Teilbaum)
* Ersetze zu löschenden Wert mit diesem
* Lösche den **successor** rekursiv

Beispiel:

```
    5
   / \
  3   7
     /
    6
```

→ Lösche `5`

* Inorder successor: `6`
* Ersetze `5` durch `6`
* Lösche `6` aus rechter Teilbaum

Ergebnis:

```
    6
   / \
  3   7
```

---

## **Wann ist ein Baum nicht mehr balanciert?**

Beispiel: Füge nacheinander ein:

```java
int[] werte = {1, 2, 3, 4, 5};
```

→ Baum sieht aus wie eine Liste:

```
1
 \
  2
   \
    3
     \
      4
       \
        5
```

→ **Höhe = 5**, statt optimal ≈ log₂(5) ≈ 3

---

## **Wie balancieren? (Grundidee, z. B. AVL-Baum)**

1. Nach jedem Einfügen/Löschen Höhe prüfen.
2. Falls **Höhendifferenz > 1** → Rotation:

### **Rotationen (für AVL-Baum):**

* **LL-Rotation** (einfügen links-links)
* **RR-Rotation** (einfügen rechts-rechts)
* **LR-Rotation** (links-rechts)
* **RL-Rotation** (rechts-links)

→ Ziel: Höhe ausgleichen

---

Wenn du willst, kann ich dir Zeichnungen oder Ablaufdiagramme dafür machen.


Hier sind einfache Beispiele für **Inorder**, **Preorder** und **Postorder** Traversierung:

---

## Beispiel-Baum

```
       5
     /   \
    3     7
   / \   /
  1   4 6
```

---

## Traversierungsarten

### 1. **Inorder** (Links – Wurzel – Rechts)

```text
Reihenfolge: 1, 3, 4, 5, 6, 7
```

→ besucht zuerst den linken Teilbaum, dann den Knoten, dann den rechten Teilbaum.

---

### 2. **Preorder** (Wurzel – Links – Rechts)

```text
Reihenfolge: 5, 3, 1, 4, 7, 6
```

→ zuerst Wurzel, dann linker Teilbaum, dann rechter Teilbaum.

---

### 3. **Postorder** (Links – Rechts – Wurzel)

```text
Reihenfolge: 1, 4, 3, 6, 7, 5
```

→ zuerst linker Teilbaum, dann rechter Teilbaum, dann Knoten selbst.

---

Diese drei Methoden haben unterschiedliche Einsatzzwecke:

* **Inorder** → gibt sortierte Reihenfolge.
* **Preorder** → nützlich für Kopieren des Baums.
* **Postorder** → nützlich für Löschen oder Speicherfreigabe.

Wenn du willst, kann ich dir auch Zeichnungen für die Traversierungen machen.
