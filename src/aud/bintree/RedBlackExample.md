**Was ist ein Rot-Schwarz-Baum? Welche Eigenschaften hat er?**
- Ein Rot-Schwarz-Baum ist ein spezieller binärer Suchbaum, 
der sich selbst balanciert, um im Worst-Case logarithmische Laufzeiten für Einfügen,
Suchen und Löschen zu garantieren.
- Solche Eigenschaften:
    - Jeder Knoten ist rot oder schwarz.
    - Die Wurzel ist immer schwarz.
    - Jeder Blattknoten ist schwarz.
    - Rote Knoten haben nur schwarze Kinder (keine zwei roten Knoten hintereinander).
    - Jeder Pfad von einem Knoten zu seinen Blättern enthält gleich viele schwarze Knoten (Black-Height).
  
**Welche Korrespondenzen existieren zwischen Rot-Schwarz und 2-3-4 bäume?**
- Rot-schwarz-Bäume wurden von Bayer unter dem Namen symmetric binary B-trees als binäre Darstellung von 2-3-4-Bäumen entwickelt. 
In einem Rot-schwarz-Baum werden die 3- und die 4-Knoten durch kleine Binärbäume repräsentiert, 
die aus einer schwarzen Wurzel und ein oder zwei roten Hilfsknoten bestehen.