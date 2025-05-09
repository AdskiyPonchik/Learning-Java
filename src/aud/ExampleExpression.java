package aud;
import aud.example.expr.ExpressionParser;
import aud.example.expr.ExpressionTree;
import aud.example.expr.Number;
import aud.example.expr.Plus;
import aud.example.expr.Times;
import aud.util.DotViewer;
import aud.util.SingleStepper;
import javax.swing.JFrame;

/**
 * Example class demonstrating the usage of ExpressionParser and ExpressionTree
 * for parsing, calculating, and visualizing arithmetic expressions.
 */
public class ExampleExpression {
    public static void main(String[] args) {
        // Create some example expressions
        String[] expressions = {
                "2+3*4-5",
                "(2+3)*(4-5)",
                "2*3+4/2",
                "-5+7*2",
                "1+2*(3+4)"
        };

        ExpressionParser parser = new ExpressionParser();

        // Process each expression
        for (String expr : expressions) {
            System.out.println("\n=== Processing expression: '" + expr + "' ===");

            try {
                // Parse the expression into a tree
                ExpressionTree tree = parser.parse(expr);

                // Display the expression in different orders
                System.out.println("Inorder (normal): " + tree.toString());
                System.out.println("Postorder: " + tree.postorder().toString());

                // For preorder, we can reconstruct it from the tree traversal
                StringBuilder preorder = new StringBuilder();
                preorderTraversal(tree, preorder);
                System.out.println("Preorder: " + preorder.toString());

                // Calculate the value of the expression
                try {
                    double value = tree.getValue();
                    System.out.println("Value: " + value);
                } catch (UnsupportedOperationException e) {
                    System.out.println("Cannot calculate value - expression contains variables.");
                }

                // Visualize the expression tree
                System.out.println("Visualizing the expression tree...");
                // Create a JFrame for the DotViewer
                JFrame frame = new JFrame("Expression Tree Viewer");
                frame.setSize(800, 600);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                // Create DotViewer with the frame
                DotViewer viewer = new DotViewer(frame);
                viewer.display(tree.toDot());

                // Make the frame visible
                frame.setVisible(true);

                // Pause between expressions
                System.out.println("Press Enter to continue to the next expression...");
                //SingleStepper.pause();

                // Dispose the frame before moving to next expression
                frame.dispose();

            } catch (Exception e) {
                System.err.println("Error processing expression '" + expr + "': " + e.getMessage());
            }
        }

        // Manual creation of an expression tree example
        System.out.println("\n=== Creating expression tree manually ===");
        ExpressionTree manualTree = createManualExpressionTree();
        System.out.println("Manual tree: " + manualTree.toString());
        System.out.println("Value: " + manualTree.getValue());

        // Visualize the manually created tree
        JFrame manualFrame = new JFrame("Manual Expression Tree Viewer");
        manualFrame.setSize(800, 600);
        manualFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        DotViewer manualViewer = new DotViewer(manualFrame);
        manualViewer.display(manualTree.toDot());

        // Make the frame visible
        manualFrame.setVisible(true);
    }

    /**
     * Helper method to perform preorder traversal of the expression tree
     */
    private static void preorderTraversal(ExpressionTree tree, StringBuilder sb) {
        if (tree == null) return;

        // Visit the node
        sb.append(tree.getData().toString()).append(" ");

        // Visit left subtree
        preorderTraversal((ExpressionTree)tree.getLeft(), sb);

        // Visit right subtree
        preorderTraversal((ExpressionTree)tree.getRight(), sb);
    }

    /**
     * Creates a manual expression tree for (2+3)*4
     */
    private static ExpressionTree createManualExpressionTree() {
        // Create the tree for (2+3)*4
        ExpressionTree left = new ExpressionTree(
                new Plus(),
                new ExpressionTree(new Number(2)),
                new ExpressionTree(new Number(3))
        );

        ExpressionTree right = new ExpressionTree(new Number(4));

        return new ExpressionTree(new Times(), left, right);
    }
}