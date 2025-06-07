package aud.hashmap;

public class IceBox {
    //---------------------------------------------------------------//
    // TODO: attributes and constructor
    private Food[] table;
    private int size;
    private int capacity_;

    public IceBox(int capacity_) {
        this.capacity_ = capacity_;
        this.table = new Food[capacity_];
        this.size = 0;
    }

    protected int getCapacity() {
        return capacity_;
    }

    protected int getSize() {
        return size;
    }

    //---------------------------------------------------------------//
    public void add(Food obj) {
        if (size > getCapacity() * 0.8) {
            resize();
        }
        int hash = obj.hashCode() % getCapacity();
        int index = hash;
        int step = 1;
        while (table[index] != null) {
            index = (hash + step * step) % getCapacity();
            step++;
            if (index == hash) break;
        }
        table[index] = obj;
        size++;
    }

    public void resize() {
        capacity_ *= 2;
        Food[] newtable = new Food[getCapacity()];
        Food[] oldtable = table;
        table = newtable;
        for (Food obj : oldtable) {
            if (obj != null) add(obj);
        }
    }

    //---------------------------------------------------------------//
    public boolean contains(Food obj) {
        int hash = obj.hashCode() % getCapacity();
        int index = hash;
        int i = 1;
        while(table[index] != null){
            if(table[index].equals(obj)){return true;}
            index = (index + i*i) % getCapacity();
            i++;
        }
        return false;
    }

    //---------------------------------------------------------------//
    public static void main(String[] args) {
        IceBox iceBox = new IceBox(5);
        Food apple = new Food("Fruit", "Apple");
        Food banana = new Food("Fruit", "Banana");
        Food orange = new Food("Fruit", "Orange");
        iceBox.add(apple);
        iceBox.add(banana);
        iceBox.add(orange);
        System.out.println("Contains Apple: " + iceBox.contains(apple));
        System.out.println("Contains Banana: " + iceBox.contains(banana));
        System.out.println("Contains Orange: " + iceBox.contains(orange));
        Food pear = new Food("Fruit", "Pear");
        System.out.println("Contains Pear: " + iceBox.contains(pear));
    }

}
