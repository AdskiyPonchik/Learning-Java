### Initialisierung

- Startknoten: `0`
- MST = ∅
- Baum enthält: `{0}`

---

### Schritt 1

Mögliche Kanten von 0:

- 0 — 1 (Gewicht 2) 
- 0 — 2 (Gewicht 5)
- 0 — 3 (Gewicht 3)

➡️ **Wähle Kante 0 — 1 (Gewicht 2)**  
➡️ MST: `{0—1}`  
➡️ Baumknoten: `{0, 1}`

---

### Schritt 2

Kandidaten aus {0, 1}:

- 0 — 2 (5)
- 0 — 3 (3)
- 1 — 3 (4)

➡️ **Wähle Kante 0 — 3 (Gewicht 3)**  
➡️ MST: `{0—1, 0—3}`  
➡️ Baumknoten: `{0, 1, 3}`

---

### Schritt 3

Kandidaten aus {0, 1, 3}:

- 3 — 2 (1) 
- 0 — 2 (5)
- 1 — 3 (4)
- 3 — 5 (6)

➡️ **Wähle Kante 3 — 2 (Gewicht 1)**  
➡️ MST: `{0—1, 0—3, 3—2}`  
➡️ Baumknoten: `{0, 1, 2, 3}`

---

### Schritt 4

Kandidaten aus {0, 1, 2, 3}:

- 2 — 4 (7)
- 3 — 5 (6) 
- 1 — 5 (4)

➡️ **Wähle Kante 1 — 5 (Gewicht 4)**  
➡️ MST: `{0—1, 0—3, 3—2, 1—5}`  
➡️ Baumknoten: `{0, 1, 2, 3, 5}`

---

### Schritt 5

Noch fehlend: Knoten 4. Mögliche Kanten:

- 2 — 4 (7) 
- 5 — 4 (9)

➡️ **Wähle Kante 2 — 4 (Gewicht 7)**  
➡️ Finaler MST:
- 0 — 1 (2)
- 0 — 3 (3)
- 3 — 2 (1)
- 3 — 5 (6)
- 2 — 4 (7)

---

### Ergebnis

**Summe der Kantengewichte im MST:**
2 + 3 + 1 + 4 + 7 = 17
---
