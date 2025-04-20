package stepik;

public class Tutorium1 {
    public static boolean teilbarkeit_3(int betrag) {
        // TODO: dividor of 3 and 73 without using %==0
        return true;
    }

    public static boolean divide_3(int betrag) {
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
            while (i * 3 <= sum) {
                if (i * 3 == sum) {
                    return true;
                }
                i++;
            }
            return false;
        }
        return true;
    }

    public static boolean divide_73(int number) {
        int[] weights = {73, -7373, 7373};
        int sum = 0;
        int weightIndex = 0;
        while (number > 0) {
            sum += number % 10 * weights[weightIndex % weights.length];
            number /= 10;
            weightIndex++;
        }
        sum = Math.abs(sum);
        int i = 0;
        while (i * 73 <= sum) {
            if (i * 73 == sum) return true;
            i++;
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(teilbarkeit_3(9));
    }
}
