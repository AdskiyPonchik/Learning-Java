package aud;

import aud.*;               //to use BinaryTree<T>
import aud.util.*;          //to use DotViewer, SingleStepper

import javax.swing.*;
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
        int leftsum = gothrough((IntBinTree) this.getLeft());
        int rightsum = gothrough((IntBinTree) this.getRight());
        return Math.max(leftsum, rightsum);
    }

    private int gothrough(IntBinTree root) {
        if(root == null){return 0;}
        int leftsubtree = gothrough((IntBinTree)root.getLeft());
        int rightsubtree = gothrough((IntBinTree)root.getRight());
        return leftsubtree + rightsubtree + root.getData();
    }

    //---------------------------------------------------------------//
    public int maxPath() {
        return maxDepth(this);
    }

    private int maxDepth(IntBinTree root) {
        if (root == null)
            return Integer.MIN_VALUE; // исключаем пустые ветки

        if (root.getLeft() == null && root.getRight() == null)
            return root.getData(); // дошли до листа

        int left = maxDepth((IntBinTree) root.getLeft());
        int right = maxDepth((IntBinTree) root.getRight());
        return Math.max(left, right) + root.getData();
    }

    //---------------------------------------------------------------//
    public static void main(String[] args) {
        IntBinTree root = new IntBinTree(-44);

        // Первый уровень
        IntBinTree n39 = new IntBinTree(39);
        IntBinTree n19 = new IntBinTree(19);
        root.setLeft(n39);
        root.setRight(n19);

        // Второй уровень
        IntBinTree n59 = new IntBinTree(59);
        IntBinTree n6 = new IntBinTree(6);
        n39.setLeft(n59);
        n39.setRight(n6);

        IntBinTree n_25 = new IntBinTree(-25);
        IntBinTree n14 = new IntBinTree(14);
        n19.setLeft(n_25);
        n19.setRight(n14);

        // Третий уровень
        IntBinTree n47 = new IntBinTree(47);
        IntBinTree n_14 = new IntBinTree(-14);
        n59.setLeft(n47);
        n59.setRight(n_14);

        IntBinTree n9 = new IntBinTree(9);
        IntBinTree n21 = new IntBinTree(21);
        n6.setLeft(n9);
        n6.setRight(n21);

        IntBinTree n43 = new IntBinTree(43);
        IntBinTree n16 = new IntBinTree(16);
        n_25.setLeft(n43);
        n_25.setRight(n16);

        IntBinTree n32a = new IntBinTree(32);
        IntBinTree n56 = new IntBinTree(56);
        n14.setLeft(n32a);
        n14.setRight(n56);

        // Далее
        IntBinTree n66 = new IntBinTree(66);
        IntBinTree n23a = new IntBinTree(23);
        n47.setLeft(n66);
        n47.setRight(n23a);

        IntBinTree n19b = new IntBinTree(19);
        n_14.setRight(n19b);

        IntBinTree n34 = new IntBinTree(34);
        n16.setLeft(n34);

        IntBinTree n26a = new IntBinTree(26);
        n32a.setRight(n26a);

        IntBinTree n_24 = new IntBinTree(-24);
        IntBinTree n_2 = new IntBinTree(-2);
        n66.setLeft(n_24);
        n66.setRight(n_2);

        IntBinTree n_26 = new IntBinTree(-26);
        n_24.setRight(n_26);

        IntBinTree n_10 = new IntBinTree(-10);
        n_2.setRight(n_10);

        IntBinTree n_27a = new IntBinTree(-27);
        n34.setRight(n_27a);

        IntBinTree n32b = new IntBinTree(32);
        n26a.setLeft(n32b);

        IntBinTree n27 = new IntBinTree(27);
        IntBinTree n17 = new IntBinTree(17);
        n_27a.setLeft(n27);
        n_27a.setRight(n17);

        IntBinTree n_27b = new IntBinTree(-27);
        n32b.setLeft(n_27b);

        IntBinTree n_14b = new IntBinTree(-14);
        n27.setLeft(n_14b);

        IntBinTree n23b = new IntBinTree(23);
        n_27b.setRight(n23b);

        IntBinTree n_37 = new IntBinTree(-37);
        IntBinTree n_27c = new IntBinTree(-27);
        n_14b.setLeft(n_37);
        n_14b.setRight(n_27c);

        IntBinTree n_22 = new IntBinTree(-22);
        n23b.setLeft(n_22);

        IntBinTree n11 = new IntBinTree(11);
        IntBinTree n_43 = new IntBinTree(-43);
        n_37.setLeft(n11);
        n_37.setRight(n_43);

        IntBinTree n3 = new IntBinTree(3);
        n_27c.setRight(n3);

        IntBinTree n_33 = new IntBinTree(-33);
        n_22.setRight(n_33);

        IntBinTree n31 = new IntBinTree(31);
        n11.setLeft(n31);

        IntBinTree n_12 = new IntBinTree(-12);
        n3.setLeft(n_12);

        // --- Проверка
        System.out.println("Дерево создано вручную.");
        System.out.println("Максимальный путь от корня к листу: " + root.maxPath());
        System.out.println("Максимальная сумма поддерева: " + root.maxSum());
        //System.out.println(root.toDot());
    }

}