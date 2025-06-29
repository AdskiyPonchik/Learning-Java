# Darstellung von Graphen

## 1. Was ist ein Graph? Welche Arten von Graphen gibt es?

Ein **Graph** ist ein mathematisches Konstrukt zur Darstellung von Beziehungen zwischen Objekten. Ein Graph besteht aus:
- einer Menge von **Knoten** (engl. *vertices*)
- einer Menge von **Kanten** (engl. *edges*)

### Typen von Graphen:

| Typ                    | Beschreibung |
|------------------------|--------------|
| **Ungerichteter Graph** | Kanten haben keine Richtung: {a, b} = {b, a} |
| **Gerichteter Graph**  | Kanten haben eine Richtung: (a, b) ≠ (b, a) |
| **Gewichteter Graph**  | Jede Kante hat ein Gewicht (z.B. Kosten, Entfernung) |
| **Ungewichteter Graph**| Kanten haben alle denselben Wert |
| **Zusammenhängender Graph** | Es gibt einen Pfad zwischen allen Knoten |

---

## 3. Repräsentation des ungerichteten Graphen
### a) Kantenliste
{1, 2}
{1, 3}
{1, 4}
{1, 5}
{2, 4}
{2, 5}
{3, 4}
{4, 5}
### b) KnotenListe
1, 2, 3, 4, 5

c) Adjazenzmatrix

### c) Adjazenzmatrix

|   | 1 | 2 | 3 | 4 | 5 |
|---|---|---|---|---|---|
| 1 | 0 | 1 | 1 | 1 | 1 |
| 2 | 1 | 0 | 0 | 1 | 1 |
| 3 | 1 | 0 | 0 | 1 | 0 |
| 4 | 1 | 1 | 1 | 0 | 1 |
| 5 | 1 | 1 | 0 | 1 | 0 |

### d) Adjazenzliste
1: [2, 3, 4, 5]
2: [1, 4, 5]
3: [1, 4]
4: [1, 2, 3, 5]
5: [1, 2, 4]

### Entsprechende Datenstrukturen in Java

| Darstellung       | Java-Datenstruktur                         |
|-------------------|---------------------------------------------|
| Kantenliste       | `List<Edge>` (z.B. mit `class Edge {int u,v;}`) |
| Knotenliste       | `Set<Integer>` oder `List<Integer>`        |
| Adjazenzmatrix    | `int[][]` oder `boolean[][]`               |
| Adjazenzliste     | `Map<Integer, List<Integer>>`|

---

## 4. Java-Algorithmen zur Umwandlung
### a) Kantenliste → Adjazenzmatrix

```java
int[][] adjMatrix = new int[n + 1][n + 1]; // n = Anzahl der Knoten
for (Edge edge : edgeList) {
    int u = edge.u, v = edge.v;
    adjMatrix[u][v] = 1;
    adjMatrix[v][u] = 1; // weil ungerichtet
}
```
O(E) - anzahl von Kanten
### b) Kantenliste → Adjazenzliste (mit `Map<Integer, List<Integer>>`)
```java
Map<Integer, List<Integer>> adjList = new HashMap<>();

for (Edge edge : edgeList) {
        int u = edge.u, v = edge.v;
// u → v
    adjList.computeIfAbsent(u, k -> new ArrayList<>()).add(v); //addieren u wenn nicht in map
//nutze k -> new ArrayList<>() um verschiedene datentypen zu verwenden.
// v → u (weil ungerichtet)
    adjList.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
}
O(E)
```
