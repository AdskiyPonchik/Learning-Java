package aud.DoppelList;

public class MyCircle<T> {
    //-----------------------------------------------------------------//
    //------------- !!Do not change the following lines!! -------------//
    //A Node is a single element in the ring
    class Node {
        T data_ = null;
        Node next_ = null;
        Node prev_ = null;

        Node(T obj, Node prv, Node nxt) {
            data_ = obj;
            prev_ = prv;
            next_ = nxt;
        }
    }

    //--- class members
    protected Node head_ = null;

    //--- class methods
    public   MyCircle() { head_ = null; }
    public T front()    { return head_.data_; }
    public String toString() {
        if (empty())
            return "[]";
        String rv = "[";
        Node node = head_;
        do {
            rv += node.data_.toString();
            if (node.next_ != head_)
                rv += ",";
            node = node.next_;
        } while(node != head_);
        rv += "]";
        return rv;
    }

    //-----------------------------------------------------------------//
    //---------------- !!Insert your solution below!! -----------------//
    public int size() {
        if (empty())return 0;
        int count = 1;
        Node node = head_.next_;
        while(node != head_){
            count++;
            node = node.next_;
        }
        return count;
    }

    //-----------------------------------------------------------------//
    public boolean empty() {
        return head_ == null;
    }

    //-----------------------------------------------------------------//
    public void push_back(T obj) {
        if(empty()){
            head_ = new Node(obj, null, null);
            head_.next_ = head_;
            head_.prev_ = head_;
        }
        else{
            Node tail = head_.prev_;
            Node newNode = new Node(obj, tail, head_);
            tail.next_ = newNode;
            head_.prev_ = newNode;
        }
    }

    //-----------------------------------------------------------------//
    public void pop_front() {
        if(empty())return;
        if(head_ == head_.next_){
            head_ = null;
        }
        else{
            Node prev = head_.prev_;
            Node next = head_.next_;
            prev.next_ = next;
            next.prev_ = prev;
            head_ = next;
        }
    }

    //-----------------------------------------------------------------//
    public static void main(String[] args) {
        // TODO: test your code with appropriate examples
    }
}