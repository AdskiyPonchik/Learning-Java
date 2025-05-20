package aud.bintree;
import aud.util.DotViewer;

import javax.swing.*;

public class BuildBinTree {
    public static void main(String[] args) {
        BinaryTree<Integer> root = new BinaryTree<>(-8);
        BinaryTree<Integer> node1 = new BinaryTree<>(4);
        BinaryTree<Integer> node2 = new BinaryTree<>(5);
        BinaryTree<Integer> node3 = new BinaryTree<>(1);
        BinaryTree<Integer> node4 = new BinaryTree<>(-11);
        BinaryTree<Integer> node5 = new BinaryTree<>(6);
        BinaryTree<Integer> node6 = new BinaryTree<>(7);

        root.setLeft(node1);
        root.setRight(node3);
        node1.setLeft(node5);
        node1.setRight(node4);
        node3.setLeft(node2);
        node3.setRight(node6);

        System.out.println("Preorder: " + root.preorder());
        System.out.println("Inorder: " + root.inorder());
        System.out.println("Postorder: " + root.postorder());
        System.out.println("Levelorder: " + root.levelorder());

        System.out.println("DOT representation:");
        System.out.println(root.toDot());

        String dotRepresentation = root.toDot();

        SwingUtilities.invokeLater(() -> {
            DotViewer dotViewer = new DotViewer(new JFrame());
            dotViewer.display(dotRepresentation);
            JFrame frame = new JFrame("DotViewer");
            frame.setSize(800, 600);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

