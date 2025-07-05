# Binomialkoeffizient mit Pascalschem Dreieck

## 1. Pseudocode + Illustration + Komplexität

Zur Berechnung vom Binomialkoeffizienten kann man die Formel benutzen:

(n über k) = (n-1 über k-1) + (n-1 über k)  
und (n über 0) = (n über n) = 1

Damit baut man einfach das Pascalsche Dreieck Schritt für Schritt auf.  
Die Tabelle wird von oben nach unten gefüllt. Für jeden Wert braucht man nur zwei vorherige.

Die Komplexität ist O(n·k), weil man für jeden Eintrag im Dreieck genau einmal rechnen muss.

Tabelle für n = 7, k = 5:

| n \ k | 0 | 1 | 2 | 3 | 4 | 5 |
|------:|--:|--:|--:|--:|--:|--:|
| 0     | 1 |
| 1     | 1 | 1 |
| 2     | 1 | 2 | 1 |
| 3     | 1 | 3 | 3 | 1 |
| 4     | 1 | 4 | 6 | 4 | 1 |
| 5     | 1 | 5 |10 |10 | 5 | 1 |
| 6     | 1 | 6 |15 |20 |15 | 6 |
| 7     | 1 | 7 |21 |35 |35 |21 |

---

## 3. Reduzierung der Rechenschritte

Man kann die Anzahl der Schritte optimieren, indem man weniger speichert. (Look MyBinom)
Statt die ganze Tabelle, kann man nur eine Zeile benutzen, weil man immer nur die vorherige Zeile braucht.  
Wenn man von rechts nach links rechnet, wird nix überschrieben. So spart man Speicherplatz und Zeit.

---

## 4. Vergleich mit rekursiver Lösung

Die rekursive Lösung braucht viel mehr Zeit, weil sie immer wieder das gleiche neu ausrechnet.  
Die Anzahl der Aufrufe wächst extrem schnell → exponentiell.  
Ohne Zwischenspeicherung ist das ineffizient. Die dynamische Lösung mit Tabelle ist viel schneller.

Die Rekursion hat also O(2^n) Aufwand, während dynamische Lösung O(n·k) braucht.
