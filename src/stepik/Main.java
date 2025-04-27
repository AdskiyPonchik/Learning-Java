//comments in Java
package stepik;
import java.math.BigInteger;
import java.util.function.DoubleUnaryOperator;
/**
 * Ебать хуйня а не док строка
*/
public class Main {
    public static void main(String[] args) {
        System.out.println(getCallerClassAndMethodName());
    }
    public static String getCallerClassAndMethodName() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if(stackTrace.length > 3){return stackTrace[3].getClassName() + "#" + stackTrace[3].getMethodName();}
        return null;
    }
}


/*
    public static int leapYearCount(int year) {
        if (year == 1) {
            return 0;
        } //0x0bp3
        return (year / 4) - year / 100 + year / 400;
    }

    public static boolean doubleExpression(double a, double b, double c) {
        return Math.abs((a + b) - c) < 0.0001;
    }

    public static int flipBit(int value, int bitIndex) {
        return value ^ (1 << bitIndex - 1);
    }

    public static char charExpression(int a) {
        return (char) ((int) '\\' + a);
    }

    public static boolean isPowerOfTwo(int value) {
        return (Math.abs(value) & (Math.abs(value) - 1)) == 0; // you implementation here
    }

    public static boolean isPalindrome(String text) {
        StringBuilder resultstring = new StringBuilder(text.toLowerCase().replaceAll("[^a-zA-Z0-9]", ""));
        return resultstring.toString().equals(resultstring.reverse().toString());
    }

    public static BigInteger factorial(int value) {
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= value; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    public static int[] mergeArrays(int[] a1, int[] a2) {
        int[] result = new int[a1.length + a2.length];
        int i = 0, j = 0;
        for (int k = 0; k < result.length; k++) {
            if (i > a1.length - 1) {
                int a = a2[j];
                result[k] = a;
                j++;
            } else if (j > a2.length - 1) {
                int a = a1[i];
                result[k] = a;
                i++;
            } else if (a1[i] < a2[j]) {
                int a = a1[i];
                result[k] = a;
                i++;
            } else {
                int b = a2[j];
                result[k] = b;
                j++;
            }
        }
        return result;
    }

    public static double integrate(DoubleUnaryOperator f, double a, double b) {
        double h = (b-a)/1e7;
        double result = 0;
        for(int i=0; i < 1e7; i++){
            result+=f.applyAsDouble(a+h/2+i*h);
        }
        result *=h;
        return result;
    }
}
*/
