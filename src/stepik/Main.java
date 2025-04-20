//comments in Java
package stepik;

import java.util.Arrays;

public class Main {

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
        // TODO complete the task
        return false;
    }

    public static int rentalCarCost(int d) {
        int result = d * 40;
        if (d >= 7) {
            result -= 50;
        } else if (d >= 3) {
            result -= 20;
        }
        return result;
    }
    public static int[] reverse(int n){
        int[] result = new int[n];
        int counter = 0;
        for(int i = n; i > 0; i--){
            result[n-i] = i;
        }
        return result;
    }
    static String toCamelCase(String s){

        return "";
    }
    public static void main(String[] args) throws Exception {
//        System.out.println(teilbarkeit_3(9));
//        System.out.println(teilbarkeit_73(146));
        //System.out.println(smash("hello", "world", "this", "is", "great"));
        System.out.println(Arrays.toString(reverse(5)));
    }
}
