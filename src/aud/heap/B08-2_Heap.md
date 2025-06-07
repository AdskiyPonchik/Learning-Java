# Heap: Theorie

## 1. Erläuterung der Datenstruktur Heap (MinHeap)

Ein **Heap** ist eine spezielle Baum-basierte Datenstruktur, die die **Heap-Eigenschaft** erfüllt. Beim **MinHeap** gilt:

- Jeder Knoten ist kleiner oder gleich seinen Kindknoten.
- Das bedeutet, dass das kleinste Element immer an der Wurzel (Root) des Baums steht.

### Eigenschaften des MinHeap:
- Vollständiger Binärbaum: Alle Ebenen sind vollständig gefüllt, außer vielleicht die letzte, die von links nach rechts aufgefüllt wird.
- MinHeap-Eigenschaft: Für jeden Knoten `i` gilt: `Heap[i] ≤ Heap[2i + 1]` und `Heap[i] ≤ Heap[2i + 2]` (wenn diese Kinder existieren).
- Effizientes Einfügen und Entfernen des Minimums (Wurzel) in O(log n).

### Beispiel:

Angenommen wir haben die Zahlen: 5, 3, 8, 4, 1.

Der MinHeap sieht als Feld (Array-Darstellung) so aus:  
Index: 0 1 2 3 4  
Wert: 1 3 8 5 4  
Das entspricht diesem Baum:  
      
      1
    /   \
    3   8
    /\
    5 4

# MinHeap

## 1. Wo befindet sich das größte Element in einem MinHeap, wenn alle Elemente verschieden sind?

In einem MinHeap ist das größte Element immer **eines der Blattelemente**, da:

- Die MinHeap-Eigenschaft garantiert nur, dass Elternknoten kleiner als ihre Kinder sind.
- Das größte Element kann also nicht an der Wurzel oder auf einem inneren Knoten stehen, da dort immer kleinere Werte sind.
- Da das größte Element keinen Nachfolger hat, ist es zwangsläufig ein Blatt.

## 2. Ist ein Feld, das in aufsteigend sortierter Reihenfolge vorliegt, ein Heap?

- **Ja**, wenn das Feld aufsteigend sortiert ist (d.h. `array[0] ≤ array[1] ≤ ... ≤ array[n-1]`), dann ist es auch ein MinHeap.
- Denn für jeden Index `i` gilt `array[i] ≤ array[2i + 1]` und `array[i] ≤ array[2i + 2]`, weil die Sortierung global gilt.
- Das heißt, das Feld erfüllt die MinHeap-Eigenschaft.




### Frage 1:
    **5, 1, 19, 25, 17, 21, 5, 19, 20, 9, 15, 14 **

Welche Vertauschungen müssen bei **upHeap** und bei **downHeap** vorgenommen werden, um ein ungeordnetes Feld in einen MinHeap zu überführen?
### Antwort:
### Was passiert bei upHeap und downHeap?

- **upHeap**: Wenn du ein neues Element am Ende des Heaps einfügst, dann schiebst du es nach oben, solange es kleiner ist als sein Elternknoten.
- **downHeap**: Wenn du das erste Element (die Wurzel) entfernst oder tauschst, dann schiebst du das neue Element von oben nach unten, damit der kleinste Wert oben bleibt.


- Um aus einem ungeordneten Feld einen MinHeap zu machen, nutzt man meistens **downHeap** für alle Elternknoten von unten nach oben.
- Das sorgt dafür, dass der Baum die MinHeap-Regel erfüllt (Eltern immer kleiner als Kinder).

Um ein ungeordnetes Feld in einen MinHeap umzuwandeln, wird typischerweise **downHeap** ab der Mitte des Arrays (dem letzten Elternknoten) bis zur Wurzel angewandt, um alle Teilbäume zu korrigieren.

### Frage 2:
Wie groß ist die Komplexität des jeweiligen Vorgehens (upHeap / downHeap) in O-Notation im schlechtesten Fall?

### Antwort:

- **upHeap** dauert maximal so lange, wie die Höhe des Baumes, also **O(log n)**.
- **downHeap** auch **O(log n)** pro Anwendung.
- Wenn du das komplette Feld in einen Heap umwandelst, dauert das insgesamt ungefähr **O(n)**.


