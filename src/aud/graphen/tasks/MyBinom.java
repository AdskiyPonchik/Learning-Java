package aud.graphen.tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Supplier;

public class MyBinom {
    public static void timer(Supplier<Integer> func) {
        long startTime = System.nanoTime();
        int result = func.get();
        long duration = System.nanoTime() - startTime;
        System.out.println("Time of execution(in ns.): " + duration);
        System.out.println("Output: " + result);
    }

    public static int binom(int n, int k) {
        int[][] result = new int[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= Math.min(i, k); j++) {
                if (j == 0 || i == j) {
                    result[i][j] = 1;
                } else {
                    result[i][j] = result[i - 1][j - 1] + result[i - 1][j];
                }
            }
        }
        return result[n][k];
    }

    public static int binom_opti(int n, int k) {//wir konnen nur 1 reihe hinschreiben
        int[] result = new int[k + 1];
        result[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = Math.min(i, k); j > 0; j--) {
                result[j] = result[j] + result[j - 1];
            }
        }
        return result[k];
    }

    public static int binom_rekursion_hilfe(int n, int k, int[][] result) {
        if (k == 0 || n == k) {
            return 1;
        }
        if (result[n][k] != -1) return result[n][k];
        result[n][k] = binom_rekursion_hilfe(n - 1, k - 1, result) + binom_rekursion_hilfe(n - 1, k, result);
        return result[n][k];
    }

    public static int binom_rekursion(int n, int k) {
        int[][] result = new int[n + 1][k + 1];
        for (int[] row : result) {
            Arrays.fill(row, -1);
        }
        return binom_rekursion_hilfe(n, k, result);
    }

    public static void main(String[] agrs) {
        timer(() -> binom_opti(7, 5));
    }
}
