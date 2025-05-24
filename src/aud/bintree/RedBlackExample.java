package aud.bintree;

import aud.util.SingleStepper;
import aud.util.DotViewer;
import aud.bintree.AVLTree;
import aud.bintree.BinarySearchTree;

public class RedBlackExample {

    public static void main(String[] args) {

        // to change tree type
        BinarySearchTree<Integer, Object> tree = new AVLTree<>();
        //BinarySearchTree<Integer, Object> tree = new RedBlackTree<>();

        SingleStepper stepper = new SingleStepper("Tree Viewer");
        DotViewer viewer = DotViewer.displayWindow((String)null, "Tree Viewer");

        stepper.halt("Start");
        viewer.display(tree);

        tree.insert(6, null); stepper.halt("Inserted 6"); viewer.display(tree);
        tree.insert(7, null); stepper.halt("Inserted 7"); viewer.display(tree);
        tree.insert(3, null); stepper.halt("Inserted 3"); viewer.display(tree);
        tree.insert(4, null); stepper.halt("Inserted 4"); viewer.display(tree);
        tree.insert(2, null); stepper.halt("Inserted 2"); viewer.display(tree);
        tree.insert(1, null); stepper.halt("Inserted 1"); viewer.display(tree);

        stepper.halt("FERTIG");
        System.exit(0);
    }
}
