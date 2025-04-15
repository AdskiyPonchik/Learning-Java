//package Filter;

import java.util.LinkedList;

public class LinkedNode<T> {
    T data_ = null;
    LinkedNode<T> next_ = null;

    // TODO: constructors
    public LinkedNode(T data) {
        this.data_ = data;
        this.next_ = null;
    }

    // TODO: getters and setters
    public T getData_() {
        return this.data_;
    }

    public void setData_(T data) {
        this.data_ = data;
    }

    public LinkedNode<T> getNext_() {
        return this.next_;
    }

    public void setNext_(LinkedNode<T> next) {
        this.next_ = next;
    }

    // Provide String-representation for list beginning at `this` node.
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        LinkedNode<T> current = this;
        while (current != null) {
            result.append(current.data_);
            if(current.next_!=null)result.append(" -> ");
            current = current.next_;
        }
        return result.toString();
    }

    // You must provide a main() method!
    public static void main(String[] args) {
        // TODO: Test
        LinkedNode<String> day1 = new LinkedNode<String>("Montag");
        LinkedNode<String> day2 = new LinkedNode<String>("Dienstag");
        LinkedNode<String> day3 = new LinkedNode<String>("Mittwoch");
        LinkedNode<String> day4 = new LinkedNode<String>("Donnerstag");
        LinkedNode<String> day5 = new LinkedNode<String>("Freitag");
        LinkedNode<String> day6 = new LinkedNode<String>("Samstag");
        LinkedNode<String> day7 = new LinkedNode<String>("Sonntag");
        day1.setNext_(day4);
        day4.setNext_(day5);
        System.out.println("Before: " + day1.toString());
        day2.setNext_(day1.getNext_());
        day1.setNext_(day2);
        day3.setNext_(day2.getNext_());
        day2.setNext_(day3);
        day5.setNext_(day6);
        day6.setNext_(day7);
        System.out.println("After: " + day1.toString());
    }
}
