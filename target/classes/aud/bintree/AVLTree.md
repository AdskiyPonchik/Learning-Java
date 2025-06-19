## AVL-Baum

Ein **AVL-Baum** ist ein selbstbalancierender binärer Suchbaum, 
bei dem für jeden Knoten die Höhen der linken und rechten Teilbäume sich höchstens um 1 unterscheiden dürfen.

### Warum muss man binäre Bäume ausgleichen?

Ohne Ausgleich können binäre Suchbäume bei ungünstigen Einfügereihenfolgen **degenerieren** (z.B. zu einer Liste), 
was zu einer **linearen Laufzeit** von Such-, Einfüge- und Löschoperationen führt. 
Durch das Ausbalancieren bleibt die **Höhe logarithmisch** und somit die **Laufzeit O(log n)**.
