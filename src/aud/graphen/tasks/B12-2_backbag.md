# Rucksackproblem am Beispiel

Gegeben sind 4 Objekte mit Größe und Wert. Ziel ist es, möglichst viel Wert in einen Rucksack der Größe 15 zu packen.

| Objekt | Größe | Wert |
|--------|-------|------|
| a₁     | 3     | 3    |
| a₂     | 4     | 5    |
| a₃     | 6     | 8    |
| a₄     | 7     | 9    |

---

## 1. Greedy-Prinzip

Ich wähle das Kriterium **"Wert pro Größe"** (value/size), also berechne ich:

- a₁ → 3/3 = 1.0
- a₂ → 5/4 = 1.25
- a₃ → 8/6 = 1.33
- a₄ → 9/7 = 1.29

Also nehme ich zuerst a₃, dann a₄, dann a₂ wenn noch Platz ist. Prüfen:

- a₃ (6), a₄ (7) = 13 → passt
- bleibt 2 Platz → nichts mehr passt

→ Gesamtwert: 8 + 9 = **17**

Ist das optimal?  
Nicht ganz sicher ohne Vergleich, aber klingt ziemlich gut.  
Man müsste mit dynamischer Programmierung überprüfen ob es noch besser geht.

---

## 2. Dynamische Programmierung

Bei dynamischer Programmierung macht man eine Tabelle, wo für jede mögliche Kapazität und Objekt-Kombination der maximale Wert berechnet wird.
Man baut Schritt für Schritt auf:  
Für jedes Objekt prüft man, ob man es nehmen kann oder nicht. Wenn ja, nimmt man das Maximum vom alten Wert und dem neuen Wert mit dem Objekt drin.
So findet man garantiert die optimale Lösung, weil alle Möglichkeiten berücksichtigt werden.  
Ist aber natürlich langsamer als Greedy.

