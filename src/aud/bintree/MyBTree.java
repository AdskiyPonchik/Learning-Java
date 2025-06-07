//package aud.bintree;
import java.util.Random;
import aud.bintree.KTreeNode;
import aud.bintree.BTree;
import aud.util.DotViewer;

public class MyBTree<Key extends Comparable<Key>> extends BTree<Key> {

    public MyBTree(int m) {
        super(m);
    }

   /*
   @Override(or not) function getHeight();
    */

    public int getHeight() {
        return getHeightRecursive(this.root());
    }

    private int getHeightRecursive(KTreeNode<Key> node) {
        if (node == null) {
            return 0;
        }
        boolean isLeaf = true;
        for (int i = 0; i < node.getK(); i++) {
            if (node.getChild(i) != null) {
                isLeaf = false;
                break;
            }
        }
        if (isLeaf) {
            return 1;
        }
        KTreeNode<Key> child = null;
        for (int i = 0; i < node.getK(); i++) {
            if (node.getChild(i) != null) {
                child = node.getChild(i);
                break;
            }
        }
        return 1 + getHeightRecursive(child);
    }

    public static void main(String[] args) {
        Random random = new Random();
        MyBTree<Integer> tree = new MyBTree<>(2);
        int[] arr = {6, 18, 22, 3, 11, 16, 7, 10, 1, 8, 12};
        for (int i : arr) {
            tree.insert(i);
            System.out.println("Inserted: " + i);
        }
        DotViewer.displayWindow(tree.toDot(), "Tree");
        System.out.println(tree.getHeight());

        for (int i = 0; i < 1000000; i++) {
            int number = random.nextInt(Integer.MAX_VALUE);
            tree.insert(number);

            // show progress every 100_000 iter.
            if ((i + 1) % 100000 == 0) {
                System.out.printf("Inserted %,d numbers, Height: %d\n",
                        i + 1, tree.getHeight());
            }
        }

        System.out.println("\n=== FINAL HEIGHT ===");
        System.out.printf("%d\n", tree.getHeight());
        //DotViewer.displayWindow(tree.toDot(), "Tree"); function doesn't work. Or maybe works too long?
    }
}
