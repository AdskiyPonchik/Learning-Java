package aud.hashmap;
import java.util.Random;
public class HashLinQuad {
    private int[] table_;
    private int size;
    private int capacity_;

    public HashLinQuad(int capacity_) {
        this.capacity_ = capacity_;
        this.table_ = new int[capacity_];
        this.size = 0;
    }

    protected int getCapacity() {
        return capacity_;
    }

    protected int getSize() {
        return size;
    }

    public int addLin(int obj) {
        int hash = obj % getCapacity();
        int index = hash;
        int collision = 0;
        while (table_[index] != 0) {
            index = (index + 1) % getCapacity();
            collision++;
            if (index == hash) break;
        }
        table_[index] = obj;
        size++;
        return collision;
    }

    public int addQuad(int obj) {
        int hash = obj % getCapacity();
        int index = hash;
        int step = 1;
        int collision = 0;
        while (table_[index] != 0) {
            index = (hash + step * step) % getCapacity();
            step++;
            collision++;
            if (index == hash) break;
        }
        table_[index] = obj;
        size++;
        return collision;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < getCapacity(); i++) {
            String str = i + ": " + (table_[i] != 0 ? table_[i] : "null") + "\n";
            result.append(str);
        }
        return result.toString();
    }


    public static void main(String[] args) {
        int capacity = 1249;
        int numberOfElements = 1000;

        Random rand = new Random();
        int[] randomValues = new int[numberOfElements];
        for (int i = 0; i < numberOfElements; i++) {
            randomValues[i] = rand.nextInt(Integer.MAX_VALUE - 1) + 1;
        }

        // Linear
        HashLinQuad hashLin = new HashLinQuad(capacity);
        int linCollisions = 0;
        for (int i = 0; i < numberOfElements; i++) {
            linCollisions += hashLin.addLin(randomValues[i]);
        }
        // Quadratisch
        HashLinQuad hashQuad = new HashLinQuad(capacity);
        int quadCollisions = 0;
        for (int i = 0; i < numberOfElements; i++) {
            quadCollisions += hashQuad.addQuad(randomValues[i]);
        }

        //System.out.println("Kollisionen mit linearem Probing: " + linCollisions);
        //System.out.println("Kollisionen mit quadratischem Probing: " + quadCollisions);
        //System.out.println(hashQuad.toString()); //danger!
    }
}
