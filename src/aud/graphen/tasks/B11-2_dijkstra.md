# Dijkstra-Algorithmus am Beispiel

## Schritt-für-Schritt-Anwendung auf den gegebenen Graphen

**Startknoten: 0**

---

### Initialisierung

| Knoten | Distanz | Vorgänger |
|--------|---------|-----------|
| 0      | 0       | -         |
| 1      | ∞       | -         |
| 2      | ∞       | -         |
| 3      | ∞       | -         |
| 4      | ∞       | -         |
| 5      | ∞       | -         |

---

### Schritt 1: Besuchter Knoten: 0

Nachbarn:
- 1: Distanz = 0 + 2 = 2
- 2: Distanz = 0 + 5 = 5
- 3: Distanz = 0 + 3 = 3

| Knoten | Distanz | Vorgänger |
|--------|---------|-----------|
| 0      | 0       | -         |
| 1      | 2       | 0         |
| 2      | 5       | 0         |
| 3      | 3       | 0         |
| 4      | ∞       | -         |
| 5      | ∞       | -         |

---

### Schritt 2: Besuchter Knoten: 1,2,3

Nachbarn:
- 2: 3(3) + 1 = 4 → besser als 5 → aktualisiert!
- 3: 2(4) + 5 = 9 - nein
- 4: 2(4) + 7 = 11 → aktualisiert!
- 5: 1(2) + 4 = 6

| Knoten | Distanz | Vorgänger |
|--------|---------|-----------|
| 0      | 0       | -         |
| 1      | 2       | 0         |
| 2      | 4       | 3         |
| 3      | 3       | 0         |
| 4      | 11      | 2         |
| 5      | 6       | 1         |

---
## Ergebnis: Kürzeste Wege von Knoten 0

| Knoten | Distanz | Kürzester Pfad |
|--------|---------|----------------|
| 0      | 0       | 0              |
| 1      | 2       | 0 → 1          |
| 2      | 4       | 0 → 3 → 2      |
| 3      | 3       | 0 → 3          |
| 4      | 11      | 0 → 3 → 2 → 4  |
| 5      | 6       | 0 → 1 → 5      |


2. **auf dem blattpapier**

-------
3. 

**Kanten mit Gewichten:**
- A → B: 5
- A → C: 2
- B → C: -10

**Startknoten:** A  
**Zielknoten:** C

---
A ----5----> B
\          /
\        /
2    -10
\    /
\  /
\/
C
## Korrekte kürzeste Distanz

Der **tatsächlich kürzeste Pfad** von A nach C ist:  
**A → B → C** mit Gesamtkosten: 5 + (-10) = **-5**

### Initialisierung:

- Distanz zu A: 0
- Distanz zu B: ∞
- Distanz zu C: ∞
- Unbesuchte Knoten: {A, B, C}
---

### Schritt 1: Verarbeitung von Knoten A

**Aktueller Knoten:** A (Distanz: 0)

**Nachbarn von A aktualisieren:**
- B: min(∞, 0 + 5) = 5
- C: min(∞, 0 + 2) = 2

**Distanzen nach Schritt 1:**

- A: 0 (besucht)
- B: 5
- C: 2
- Unbesuchte: {B, C}

---

### Schritt 2: Verarbeitung von Knoten C

**Aktueller Knoten:** C (Distanz: 2, kleinste unbesuchte Distanz)

**Distanzen nach Schritt 2:**

- A: 0 (besucht)
- B: 5
- C: 2 (besucht) ← **FALSCH! Sollte -5 sein**
- Unbesuchte: {B}

Dijkstras Algorithmus funktioniert nicht mit Graphen, die negative Kanten enthalten, 
weil er davon ausgeht, dass der gefundene kürzeste Weg zu einem Knoten endgültig ist und nicht nachträglich revidiert wird. 
Diese Annahme gilt für Graphen mit nicht-negativen Kanten