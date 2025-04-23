package stepik;

public class Tutorium1 {
    private int value;
    private String stringValue;
    public static boolean usewords = false;

    public Tutorium1(int value, String stringValue) {
        this.value = value;
        this.stringValue = stringValue;
    }

    private static final String[] digitWords = {
            "null", "eins", "zwei", "drei", "vier", "fünf",
            "sechs", "sieben", "acht", "neun", "zehn", "elf"
    };
    private static final char[] digitChars = {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'X', 'E'
    };

    private int[] toDuoDecimal() {
        if (value == 0) {
            return new int[]{0};
        }
        int[] temp = new int[32];
        int i = 0;
        int n = this.value;
        while (n > 0) {
            temp[i++] = n % 12;
            n /= 12;
        }

        int[] result = new int[i];
        for (int j = 0; j < i; j++) {
            result[j] = temp[i - j - 1];
        }
        return result;
    }
    public int fromStringtoInt(){
        String[] parts = this.stringValue.split("\\s+");
        int number = 0;
        for(String part : parts){
            for(int i = 0; i< digitWords.length;i++){
                if(digitWords[i].equals(part)){
                    number = number*10 + i;
                    break;
                }
            }
        }
        return number;
    }

    @Override
    public String toString() {
        int[] digits = toDuoDecimal();
        StringBuilder text = new StringBuilder();
        for (int d : digits) {
            if (usewords) {
                text.append(digitWords[d]).append(" ");
            } else {
                text.append(digitChars[d]);
            }
        }
        if (usewords) {
            text.setLength(text.length() - 1);
        }
        return text.toString();
    }

    ;

    //    public static boolean divide_73(int number) {
//        int[] weights = {73, -7373, 7373};
//        int sum = 0;
//        int weightIndex = 0;
//        while (number > 0) {
//            sum += number % 10 * weights[weightIndex % weights.length];
//            number /= 10;
//            weightIndex++;
//        }
//        sum = Math.abs(sum);
//        int i = 0;
//        while (i * 73 <= sum) {
//            if (i * 73 == sum) return true;
//            i++;
//        }
//        return false;
//    }
//    public static boolean divide_73(int number) {
//        number = Math.abs(number);
//        while(number>0){number-=73;}
//        return number == 0;
//    }
    public static boolean divide_13(int number) { // accepts in duodezimal
        int result = 0;
        int quotient = 1;
        while(number > 0){
            int ziffer = number % 10;
            number /=10;
            result = result+ (ziffer * quotient);
            quotient*=-1;
        }
        return result == 0;
    }
    public static void main(String[] args){
        Tutorium1 d = new Tutorium1(145,"zwei null eins" );
        Tutorium1.usewords = true;
        System.out.println(d);
        System.out.println(Tutorium1.divide_13(11));
        System.out.println(d.fromStringtoInt());
    }
}

