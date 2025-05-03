package aud;
import java.util.NoSuchElementException;

public class MySList implements Iterable<Integer> {
    //-----------------------------------------------------------------//
    //------------- !!Do not change the following lines!! -------------//
    public String toString() {
        if (empty())
            return "[]";
        String rv = "[";
        Node node = head_;
        do {
            rv += node.data_;
            if (node.next_ != null)
                rv += ",";
            node = node.next_;
        } while (node != null);
        rv += "]";
        return rv;
    }

    //-----------------------------------------------------------------//
    //---------------- !!Insert your solution below!! -----------------//

    /**
     * Node represents a single element in the list.
     */
    class Node {
        int data_;                         //!! Do not change this line !!
        Node next_ = null;

        Node(int obj, Node nxt) {
            this.data_ = obj;
            this.next_ = nxt;
        }
    }

    //----------------------------------------------------------------//
    Node head_ = null;
    Node tail_ = null;

    //----------------------------------------------------------------//
    public MySList() {
        head_ = null;
        tail_ = null;
    }

    //-----------------------------------------------------------------//
    public boolean empty() {
        return head_ == null;
    }

    //-----------------------------------------------------------------//
    public void push_back(int obj) {
        Node newNode = new Node(obj, null);
        if (empty()) {
            head_ = newNode;
            tail_ = newNode;
        } else {
            tail_.next_ = newNode;
            tail_ = newNode;
        }
    }


    //----------------------------------------------------------------//
    // TODO: implement (at least) a function to insert an element
    //       into MySList

    //----------------------------------------------------------------//

    /**
     * Iterator is used to traverse odd elements in a list.
     */
    public class Iterator implements java.util.Iterator<Integer> {
        // TODO: implement the Iterator, which walks over odd elements
        Node node_ = null;

        Iterator(Node node) {
            node_ = node;
        }

        @Override
        public boolean hasNext() {
            Node current = node_;
            while (current != null) {
                if (current.data_ % 2 != 0) {
                    return true;
                }
                current = current.next_;
            }
            return false;
        }

        public Integer next() {
            while (node_ != null) {
                Node current = node_;
                node_ = node_.next_;
                if (current.data_ % 2 != 0) {
                    return current.data_;
                }
            }
            throw new NoSuchElementException();
        }
    }

    //----------------------------------------------------------------//
    public Iterator iterator() {
        // TODO: implement this method, which returns a new iterator instance
        return new Iterator(head_);
    }

    //----------------------------------------------------------------//
    public static void main(String[] args) {

    }
}