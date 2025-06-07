package aud.hashmap;

public class Food {

    //---------------------------------------------------------------//
    // TODO: attributes and constructor
    private String oberbegriff;
    private String bezeichnung;

    public Food(String oberbegriff, String bezeichnung) {
        this.oberbegriff = oberbegriff;
        this.bezeichnung = bezeichnung;
    }

    //---------------------------------------------------------------//
    @Override
    public int hashCode() {
        // TODO: implementation
        // hmhm........
        int result = 17;  // Начальное значение
        result = 31 * result + (oberbegriff != null ? oberbegriff.hashCode() : 0); // Хеш-код Oberbegriff
        result = 31 * result + (bezeichnung != null ? bezeichnung.hashCode() : 0); // Хеш-код Bezeichnung
        return Math.abs(result);
    }

    //---------------------------------------------------------------//
    public String toString() {
        return "HashCode: " + this.hashCode() + "\n" +
                "Oberbegriff: " + oberbegriff + "\n" +
                "Bezeichnung: " + bezeichnung;
    }
}
