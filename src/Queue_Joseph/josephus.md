Lösungsidee
---

**TODO**

Beispiel: Lösung für 13 Personen und 7 Silben im Abzählreim
---

**TODO**
Lösungsidee für das Josephus-Problem
Ziel ist es, alle Personen, die im Kreis stehen, mithilfe einer Queue so lange abzuzählen, bis nur noch eine bestimmte Anzahl übrig bleibt.
Vorgehensweise:
Alle Personen aus dem Eingabearray persons werden in eine Queue eingefügt, damit die Reihenfolge erhalten bleibt.
Dann beginnt man mit dem Abzählen:
Man geht k-1 Personen weiter, indem man sie jeweils aus der Queue entfernt und wieder hinten anhängt.
Die k-te Person wird aus der Queue entfernt und in eine Ergebnis-Queue eingefügt.
Dies wiederholt man so lange, bis alle Personen „ausgezählt“ wurden.
Die Ergebnis-Queue enthält dann alle Personen in der Reihenfolge ihres Ausscheidens.
Diese Methode ermöglicht es, die genaue Position der Personen zu berechnen, die am Ende übrig bleiben.

Ich nutze die namen um alles zu probieren:

String[] deutscheNamen = {
    "Lukas",
    "Sophia",
    "Leon",
    "Emma",
    "Finn",
    "Hannah",
    "Maximilian",
    "Mia",
    "Paul",
    "Lina",
    "Jonas",
    "Anna",
    "Felix"
};
Antwort: Felix<Lukas<Leon<Hannah<Lina<Finn<Sophia<Emma<Paul<Jonas<Anna<Maximilian<