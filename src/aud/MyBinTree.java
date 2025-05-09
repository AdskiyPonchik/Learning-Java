package aud;

import aud.util.*;        //to use DotViewer, SingleStepper
import aud.BinaryTree;    //to use BinaryTree<T>
import aud.Queue;         //to use Queue<T>

//------------------------------------------------------------------//
public class MyBinTree<T> extends BinaryTree<T> {
    //----------------------------------------------------------------//
    public MyBinTree(T data) {
        super(data);
    }

    //----------------------------------------------------------------//
    public MyBinTree(T data, MyBinTree<T> left, MyBinTree<T> right) {
        super(data, left, right);
    }

    //----------------------------------------------------------------//
    public int maxWidth() {
        // TODO:
        if (this == null) {
            return 0;
        }
        Queue<MyBinTree<T>> queue = new Queue<>();
        queue.enqueue(this);
        int maxWidth = 0;
        while (!queue.is_empty()) {
            int levelSize = queueSize(queue);
            maxWidth = Math.max(maxWidth, levelSize);
            for (int i = 0; i < levelSize; i++) {
                MyBinTree<T> currentNode = queue.dequeue();
                MyBinTree<T> left = (MyBinTree<T>) currentNode.getLeft();
                MyBinTree<T> right = (MyBinTree<T>) currentNode.getRight();
                if (left != null) {
                    queue.enqueue(left);
                }
                if (right != null) {
                    queue.enqueue(right);
                }
            }
        }
        return maxWidth;
    }

    private int queueSize(Queue<MyBinTree<T>> queue) {
        int size = 0;
        Queue<MyBinTree<T>> tempQueue = new Queue<>();
        while (!queue.is_empty()) {
            tempQueue.enqueue(queue.dequeue());
            size++;
        }
        while (!tempQueue.is_empty()) {
            queue.enqueue(tempQueue.dequeue());
        }
        return size;
    }

    //---------------------------------------------------------------//
    public static void main(String[] args) {
        // Создаем экземпляры MyBinaryTree
        MyBinTree<String> a = new MyBinTree<>("A");
        MyBinTree<String> b = new MyBinTree<>("B");
        MyBinTree<String> c = new MyBinTree<>("C");
        MyBinTree<String> d = new MyBinTree<>("D");

        // Строим дерево
        a.setLeft(b);
        a.setRight(c);
        c.setLeft(d);

        // Выводим максимальную ширину дерева
        System.out.println("Максимальная ширина дерева: " + a.maxWidth());
    }
}