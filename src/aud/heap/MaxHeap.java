package aud.heap;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxHeap<T extends Comparable<T>> {
    private final ArrayList<T> list;
    public MaxHeap(){
        list = new ArrayList<>();
    }

    public MaxHeap(T[] arr) {
        list = new ArrayList<>(arr.length);
        list.addAll(Arrays.asList(arr));

        // we'll do correct heap
        for (int i = (list.size() - 2) / 2; i >= 0; i--) {
            downHeap(i);
        }
    }


    public ArrayList<T> getHeap() { // then what is this method for?
        return new ArrayList<>(list);
    }

    @Override
    public String toString() { // lol tests just want it?
        return list.toString();
    }


    public int getSize() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    private void swap(int i, int j) {
        T temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    private void downHeap(int n) {
        int size = list.size();
        T value = list.get(n); // current node
        while (true) {
            int left = 2 * n + 1;  // left kid
            int right = 2 * n + 2; // right kid
            int largest = n;       // root
            // compare to left kid
            if (left < size && list.get(left).compareTo(list.get(largest)) > 0) {
                largest = left;
            }
            // compare to right kid
            if (right < size && list.get(right).compareTo(list.get(largest)) > 0) {
                largest = right;
            }
            // if largest not parent - swap
            if (largest != n) {
                swap(n, largest);
                n = largest;
            } else {
                break;
            }
        }
    }


    private void upHeap(int i) {
        T value = list.get(i);
        while (i > 0) {
            int parent = (i - 1) / 2;
            if (list.get(parent).compareTo(value) >= 0) {
                break;
            }
            list.set(i, list.get(parent));
            i = parent;
        }
        list.set(i, value);
    }


    public void insert(T obj) {
        list.add(obj);
        upHeap(this.getSize() - 1);
    }

    public static void main(String[] args) {
        MaxHeap<Integer> newheap = new MaxHeap<>(new Integer[]{ 8, 3, 7, 1, 5, 6, 18, 9});
        System.out.println(newheap);
    }
}
