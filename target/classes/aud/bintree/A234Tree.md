# 2–3–4-Baum (2–4-Baum)

Ein **2–3–4-Baum** ist eine selbstbalancierende Datenstruktur, 
die zur effizienten Implementierung von Wörterbüchern und Suchbäumen verwendet wird. 
Jeder Knoten kann zwei, drei oder vier Kindknoten haben, entsprechend als 2-Knoten, 3-Knoten oder 4-Knoten bezeichnet.

## Eigenschaften

- **Knotentypen**:
    - **2-Knoten**: Enthält ein Datenelement und hat zwei Kindknoten.
    - **3-Knoten**: Enthält zwei Datenelemente und hat drei Kindknoten.
    - **4-Knoten**: Enthält drei Datenelemente und hat vier Kindknoten.

- **Balanciertheit**: Alle Blätter befinden sich auf derselben Tiefe, was eine ausgeglichene Struktur gewährleistet.
- **Sortierte Ordnung**: Die Datenelemente sind innerhalb der Knoten und im gesamten Baum sortiert angeordnet.
- **Leistung**: Such-, Einfüge- und Löschoperationen haben eine Zeitkomplexität von O(log n).

