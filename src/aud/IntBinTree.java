package aud;

import aud.*;               //to use BinaryTree<T>
import aud.util.*;          //to use DotViewer, SingleStepper

import java.util.Iterator;

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
        // Если текущий узел пустой (null), высота равна 0
        if (this == null) {
            return 0;
        }
        IntBinTree leftchild = (IntBinTree) this.getLeft();
        IntBinTree rightchild = (IntBinTree) this.getRight();
        int leftHeight = (leftchild != null) ? leftchild.height() : 0;
        int rightHeight = (rightchild != null) ? rightchild.height() : 0;
        return Math.max(leftHeight, rightHeight) + 1;
    }


    //---------------------------------------------------------------//
    public int maxSum() {
        return maxPathSum(this);
    }

    int maxPathSum(IntBinTree root) {
        if (root == null) {
            return 0;
        }
        int maxleftPath = maxPathSum((IntBinTree) root.getLeft());
        int maxrightPath = maxPathSum((IntBinTree) root.getRight());
        return Math.max(maxleftPath, maxrightPath) + root.getData();
    }

    //---------------------------------------------------------------//
    public int maxPath() {
        return maxDepth(this);
    }

    private int maxDepth(IntBinTree root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth((IntBinTree) root.getLeft());
        int right = maxDepth((IntBinTree) root.getRight());
        return Math.max(left, right) + root.getData();
    }

    //---------------------------------------------------------------//
    public static void main(String[] args) {
// Создаем корень дерева
        IntBinTree root = new IntBinTree(-92);
        root.setLeft(new IntBinTree(31));
        root.setRight(new IntBinTree(-18));
        root.getLeft().setLeft(new IntBinTree(28));
        root.getLeft().setRight(new IntBinTree(66));
        root.getRight().setLeft(new IntBinTree(-23));
        root.getRight().setRight(new IntBinTree(18));
        root.getLeft().getLeft().setLeft(new IntBinTree(9));
        root.getLeft().getLeft().setRight(new IntBinTree(67));
        root.getLeft().getRight().setLeft(new IntBinTree(-5));
        root.getLeft().getRight().setRight(new IntBinTree(4));
        root.getRight().getLeft().setLeft(new IntBinTree(52));
        root.getRight().getLeft().setRight(new IntBinTree(42));
        root.getRight().getRight().setLeft(new IntBinTree(17));
        root.getRight().getRight().setRight(new IntBinTree(22));
        root.getLeft().getLeft().getLeft().setLeft(new IntBinTree(4));
        root.getLeft().getLeft().getLeft().setRight(new IntBinTree(40));
        root.getLeft().getLeft().getRight().setRight(new IntBinTree(19));
        root.getLeft().getRight().getLeft().setLeft(new IntBinTree(-34));
        root.getLeft().getRight().getLeft().setRight(new IntBinTree(-15));
        root.getRight().getRight().getRight().setRight(new IntBinTree(-30));
        root.getLeft().getLeft().getLeft().getRight().setLeft(new IntBinTree(35));
        root.getLeft().getRight().getLeft().getLeft().setRight(new IntBinTree(18));
        root.getLeft().getRight().getLeft().getRight().setLeft(new IntBinTree(24));
        root.getLeft().getLeft().getLeft().getRight().getLeft().setLeft(new IntBinTree(-50));
        root.getLeft().getRight().getLeft().getRight().getLeft().setLeft(new IntBinTree(35));

        System.out.println("Бинарное дерево создано:");
        System.out.println("Корень: " + root.getData());

        // Тестирование методов
        System.out.println("Высота дерева: " + root.height());
        System.out.println("Максимальная сумма поддерева: " + root.maxSum());
        System.out.println("Максимальный путь: " + root.maxPath());
        System.out.println(root.toDot());
    }
}