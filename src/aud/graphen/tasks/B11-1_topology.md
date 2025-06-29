Um den Graphen azyklisch zu machen und eine topologische Sortierung durchzuführen, müssen **mindestens 5 Kanten** entfernt werden.

### Grund:
Der Graph enthält Zyklen, die die topologische Sortierung verhindern. 
Um die Zyklen zu entfernen, müssen wir mindestens eine Kante aus jedem Zyklus entfernen. Nach Entfernen dieser Kanten wird der Graph azyklisch und kann topologisch sortiert werden.

### Beispiel Lösung (beginnend bei "Scissors"):

1. **Start mit der Kante Scissors → Papier**:
    - Gehe von "Scissors" zu "Papier".

2. **Papier -> Stein**:
    - Gehe von "Paper" zu "Rock" (Paper besiegt Rock).

3. **Stein -> Lizard**:
    - Gehe von "Stein" zu "Lizard".

4. **Lizard -> Paper** (Zyklus entdeckt!):
    - Ein Zyklus wurde gefunden (Lizard -> Paper -> Rock -> Lizard).
    - Entferne eine Kante, um den Zyklus zu brechen. Zum Beispiel, entferne die Kante **Papier -< Stein**.

Wiederhole diesen Prozess für alle anderen Zyklen im Graphen, indem du jeweils eine Kante entfernst, die einen Zyklus bildet.
