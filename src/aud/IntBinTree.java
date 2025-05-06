package aud;

import aud.*;               //to use BinaryTree<T>
import aud.util.*;          //to use DotViewer, SingleStepper

import java.util.Iterator;

import aud.BinaryTree;

public class IntBinTree extends BinaryTree<Integer> {
    //---------------------------------------------------------------//
    public IntBinTree(int data) {
        super(data);
    }

    //---------------------------------------------------------------//
    public IntBinTree(int data, IntBinTree left, IntBinTree right) {
        super(data, left, right);
    }

    //---------------------------------------------------------------//
    public int height() {
        // TODO: implement to return the height of the current (sub-)tree
        int leftHeight = (left_ != null) ? getLeft().height() : 0;
        int rightHeight = (right_ != null) ? right_.height() : 0;
        return Math.max(leftHeight, rightHeight) + 1;
    }

    //---------------------------------------------------------------//
    public int maxSum() {
        // TODO: implement to return bigger sum of the left/right subtree
        return 0;
    }

    //---------------------------------------------------------------//
    public int maxPath() {
        // TODO: implement to return the maximum sum of all possible paths
        return 0;
    }

    //---------------------------------------------------------------//
    public static void main(String[] args) {
        // Test 1: Single Node Tree
        IntBinTree tree1 = new IntBinTree(10);
        System.out.println("Height of tree1 (single node): " + tree1.height());  // Expected output: 1

        // Test 2: Balanced Tree (3 nodes)
        IntBinTree tree2 = new IntBinTree(10);
        IntBinTree left2 = new IntBinTree(5);
        IntBinTree right2 = new IntBinTree(15);
        tree2.setLeft(left2);
        tree2.setRight(right2);
        System.out.println("Height of tree2 (balanced): " + tree2.height());  // Expected output: 2

        // Test 3: Unbalanced Tree (4 nodes)
        IntBinTree tree3 = new IntBinTree(10);
        IntBinTree left3 = new IntBinTree(5);
        IntBinTree leftLeft3 = new IntBinTree(2);
        tree3.setLeft(left3);
        left3.setLeft(leftLeft3);
        System.out.println("Height of tree3 (unbalanced): " + tree3.height());  // Expected output: 3

        // Test 4: Larger Balanced Tree (5 nodes)
        IntBinTree tree4 = new IntBinTree(10);
        IntBinTree left4 = new IntBinTree(5);
        IntBinTree right4 = new IntBinTree(15);
        IntBinTree leftLeft4 = new IntBinTree(3);
        IntBinTree rightRight4 = new IntBinTree(20);
        tree4.setLeft(left4);
        tree4.setRight(right4);
        left4.setLeft(leftLeft4);
        right4.setRight(rightRight4);
        System.out.println("Height of tree4 (larger balanced): " + tree4.height());  // Expected output: 3

        // Test 5: Empty Tree (null)
        IntBinTree tree5 = null;
        if (tree5 != null) {
            System.out.println("Height of tree5 (empty): " + tree5.height());  // Expected output: 0 (this should not happen)
        } else {
            System.out.println("Tree5 is null, no height calculation.");
        }
    }
}