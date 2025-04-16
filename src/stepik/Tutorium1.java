package stepik;

public class Tutorium1 {
    public static boolean teilbarkeit_3(int betrag) {
        betrag = Math.abs(betrag);
        int sum = 0;
        while (betrag > 0) {
            sum += betrag % 10;
            betrag /= 10;
        }
        int i = 0;
        while (i * 3 <= sum) {
            if (i * 3 == sum) {
                return true;
            }
            i++;
        }
        return false;
    }

    public static boolean teilbarkeit_73(int betrag) {
        betrag = Math.abs(betrag);
        int multiple = 0;
        while (multiple <= betrag) {
            if (multiple == betrag) {
                return true;
            }
            multiple += 73;
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(teilbarkeit_3(9));
        System.out.println(teilbarkeit_73(146));
    }
}
