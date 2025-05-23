package Stack_Pali;
//import aud.list.Stack;
public class ForwardList<T> implements Iterable<T>{
    //-----------------------------------------------------------------//
    //------------- !!Do not change the following lines!! -------------//
    public String toString() {
        if (is_empty())
            return "[]";
        String rv = "[";
        Node node = head_;
        do {
            rv += node.data_.toString();
            if (node.next_ != head_)
                rv += ",";
            node = node.next_;
        } while(node != null);
        rv += "]";
        return rv;
    }

    //-----------------------------------------------------------------//
    //---------------- !!Insert your solution below!! -----------------//
    // A Node is a single element in the list
    public class Node {
        //---------------------------------------------------------------//
        //    !!! Do not change the existing lines in class Node!!!      //
        //            !!! It is allowed to add new content !!!           //
        //       !!! It is not allowed to add a previous pointer !!!     //
        //---------------------------------------------------------------//
        public T data_;
        public Node next_ = null;

        public Node(T data, Node next) {
            data_ = data;
            next_ = next;
        }
    }

    //-----------------------------------------------------------------//
    public Node head_ = null;

    //-----------------------------------------------------------------//
    public ForwardList()
    {
    }

    //-----------------------------------------------------------------//
    public void push_front(T obj) {
        // TODO: implement adding elements to the front of the list
        head_ = new Node(obj, head_);
    }

    //-----------------------------------------------------------------//
    public boolean is_empty() {
        // TODO: should return `true` if the list is empty else `false`
        return head_ == null;
    }

    //-----------------------------------------------------------------//
    public void backTraverse() {
        backTreverseRecursion(head_);
    }
    private void backTreverseRecursion(Node node){
        if(node == null){return;}
        backTreverseRecursion(node.next_);
        System.out.println(node.data_ + " ");
    }

    //-----------------------------------------------------------------//
    public class BackIterator implements java.util.Iterator<T> {
        // TODO: implement an iterator that provides a reveres iteration
        private Stack<Node> stack_;

        public BackIterator() {
            stack_ = new Stack<>();
            Node current = head_;
            while(current!=null){
                stack_.push(current);
                current = current.next_;
            }
        }
        @Override
        public boolean hasNext(){
            return !stack_.is_empty();
        }
        @Override
        public T next(){
            return stack_.pop().data_;
        }

    }

    //-----------------------------------------------------------------//
    public BackIterator iterator() {
        // TODO: return an instance of the iterator
        return new BackIterator();
    }

    //-----------------------------------------------------------------//
    public static void main(String[] args) {
        // TODO: test your code with appropriate examples
    }
}