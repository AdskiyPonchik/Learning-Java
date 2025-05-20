package aud.bintree;

//-----------------------------------------------------------------//
public class SimpleTree<T extends Comparable<T>> {
    //---------------------------------------------------------------//
    public class Node {
        // TODO: implement node class
        T value;
        Node left;
        Node right;
        public Node(T value){
            this.value = value;
            this.left =null;
            this.right = null;
        }
    }

    //---------------------------------------------------------------//
    private Node root_;

    //---------------------------------------------------------------//
    public SimpleTree() {
        // TODO: implementation
        root_ = null;
    }

    //---------------------------------------------------------------//
    public void add(T obj) {
        root_ = add_recursive(root_, obj);
    }
    private Node add_recursive(Node current, T obj){
        if(current == null){return new Node(obj);}
        if(obj.compareTo(current.value) < 0){
            current.left = add_recursive(current.left, obj);
        }else if(obj.compareTo(current.value) > 0){
            current.right = add_recursive(current.right, obj);
        }
        return current;
    }

    //---------------------------------------------------------------//
    public boolean contains(T obj) {
        return contains_recursive(root_, obj);
    }
    private boolean contains_recursive(Node current, T obj){
        if(current == null){return false;}
        if(obj.compareTo(current.value) == 0){return true;}
        return obj.compareTo(current.value) < 0 ?
                contains_recursive(current.left, obj)
                : contains_recursive(current.right, obj);
    }
    //---------------------------------------------------------------//
    public String toString() {
        StringBuilder sb = new StringBuilder();
        recursive_output(root_, sb);
        return sb.toString();
    }
    private void recursive_output(Node current, StringBuilder sb){
        if(current!= null){
            recursive_output(current.left, sb);
            sb.append(current.value).append(" ");
            recursive_output(current.right, sb);
        }
    }

    //---------------------------------------------------------------//
    public static void main(String[] args) {
        SimpleTree<Integer> tree = new SimpleTree<>();
        tree.add(5);
        tree.add(3);
        tree.add(7);
        tree.add(4);

        System.out.println("tree: " + tree);
        System.out.println("3? " + tree.contains(3));
        System.out.println("10? " + tree.contains(10));
    }
}