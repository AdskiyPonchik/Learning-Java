package aud.bintree;
//package aud.bintree;
import aud.util.DotViewer;
import aud.util.SingleStepper;

public class AVLExample {

    public static void main(String[] args){
        int[] sequence = {14,15,17,7,5,10,16};
        AVLTree<Integer, Integer> tree = new AVLTree<>();
        SingleStepper stepper = new SingleStepper("AVL tree");
        DotViewer viewer = DotViewer.displayWindow(tree, "AVL tree");
        for(int i = 0; i < sequence.length; i++){
            stepper.halt("Inserting elem with key: " + i + " and value: " + sequence[i]);
            tree.insert(i, sequence[i]);
            viewer.display(tree);
        }
        stepper.halt("Completed.");
    }
}
