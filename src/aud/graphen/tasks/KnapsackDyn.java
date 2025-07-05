package aud.graphen.tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KnapsackDyn {

    static class Item {
        int weight;
        int price;

        Item(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }

        @Override
        public String toString() {
            return "Item(w=" + weight + ", p=" + price + ")";
        }
    }

    static class KnapsackSolver {
        List<Item> items;
        int maxWeight;
        int[][] A;

        KnapsackSolver(List<Item> items, int maxWeight) {
            this.items = items;
            this.maxWeight = maxWeight;
        }

        List<Integer> solve() {
            int n = items.size();
            A = new int[n + 1][maxWeight + 1];

            for (int k = 0; k <= n; k++) {
                for (int s = 0; s <= maxWeight; s++) {
                    if (k == 0 || s == 0) {
                        A[k][s] = 0;
                    } else {
                        Item item = items.get(k - 1);
                        if (s >= item.weight) {
                            A[k][s] = Math.max(A[k - 1][s],
                                    A[k - 1][s - item.weight] + item.price);
                        } else {
                            A[k][s] = A[k - 1][s];
                        }
                    }
                }
            }

            return traceResult(n, maxWeight);
        }

        private List<Integer> traceResult(int k, int s) {
            List<Integer> result = new ArrayList<>();
            while (k > 0 && s > 0) {
                if (A[k][s] != A[k - 1][s]) {
                    result.add(0, k);
                    s -= items.get(k - 1).weight;
                }
                k--;
            }
            return result;
        }

        int getMaxValue() {
            return A[items.size()][maxWeight];
        }
    }

    // main
    public static void main(String[] args) {
        List<Item> items = Arrays.asList(
                new Item(3, 3),
                new Item(4, 5),
                new Item(6, 8),
                new Item(7, 9)
        );

        int maxWeight = 15;

        KnapsackSolver solver = new KnapsackSolver(items, maxWeight);
        List<Integer> result = solver.solve();

        System.out.println("Optimal content of backpack:");
        for (int index : result) {
            Item item = items.get(index - 1);
            System.out.println("Item " + index + ": " + item);
        }

        System.out.println("Maximum value: " + solver.getMaxValue());
    }
}
