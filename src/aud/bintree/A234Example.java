package aud.bintree;
import aud.util.SingleStepper;
import aud.util.DotViewer;

//-----------------------------------------------------------------//
public class A234Example {
    //---------------------------------------------------------------//

    public static void show_topdown(int[] sequence) {
        A234Tree<Integer> tree_topdown = new A234Tree<>(true);  // top-down
        SingleStepper stepperTOP = new SingleStepper("Insert with Top-Down");
        DotViewer viewer = DotViewer.displayWindow(tree_topdown, "Insertion with Top-Down");
        for (int val : sequence) {
            stepperTOP.halt("Inserting element: " + val);
            tree_topdown.insert(val);
            viewer.display(tree_topdown);
        }
        stepperTOP.halt("Top-down completed");
    }

    public static void show_bottomup(int[] sequence) {
        // ------- bottom-up-------------
        A234Tree<Integer> bottom_up_tree = new A234Tree<>(false);
        SingleStepper stepperBottom = new SingleStepper("Bottom-Up Insertion");
        DotViewer viewer = DotViewer.displayWindow(bottom_up_tree, "Insertion with Bottom-UP");
        for (int val : sequence) {
            stepperBottom.halt("Inserting element: " + val);
            bottom_up_tree.insert(val);
            viewer.display(bottom_up_tree);
        }
        stepperBottom.halt("Bottom-Up completed");
    }

    public static void main(String[] args) {
        // TODO: Test your example with DotViewer and SingleStepper
        int[] sequence1 = {3, 7, 5, 15, 17, 9, 13, 21, 11, 19};
        int[] sequence2 = {3, 5, 7, 9, 11, 13, 15, 17, 19, 21};
        //show_topdown(sequence1);
        //show_bottomup(sequence1);
        show_topdown(sequence2);
        show_bottomup(sequence2);
    }
}