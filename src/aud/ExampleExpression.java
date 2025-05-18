package aud;
import aud.example.expr.ExpressionParser;
import aud.example.expr.ExpressionTree;
import aud.example.expr.Number;
import aud.example.expr.Plus;
import aud.example.expr.Times;
import aud.util.DotViewer;
import javax.swing.JFrame;

public class ExampleExpression {
    public static void main(String[] args) {
        String[] expressions = {"2+3*4-5", "(2+3)*(4-5)"};
        ExpressionParser parser = new ExpressionParser();
        for (String expr : expressions) {
            processExpression(parser, expr);
        }
        displayManualTree();
    }

    private static void processExpression(ExpressionParser parser, String expr) {
        System.out.println("\n=== Processing expression: '" + expr + "' ===");
        try {
            ExpressionTree tree = parser.parse(expr);
            displayExpressionInfo(tree);
            visualizeTree(tree, "Expression Tree: " + expr);
        } catch (Exception e) {
            System.err.println("Error processing expression '" + expr + "': " + e.getMessage());
        }
    }

    private static void displayExpressionInfo(ExpressionTree tree) {
        System.out.println("Infix notation: " + tree);
        System.out.println("Postfix notation: " + tree.postorder());

        StringBuilder preorder = new StringBuilder();
        preorderTraversal(tree, preorder);
        System.out.println("Prefix notation: " + preorder);

        try {
            System.out.println("Value: " + tree.getValue());
        } catch (UnsupportedOperationException e) {
            System.out.println("Cannot calculate - expression contains variables");
        }
    }

    private static void visualizeTree(ExpressionTree tree, String title) {
        JFrame frame = new JFrame(title);
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        DotViewer viewer = new DotViewer(frame);
        viewer.display(tree.toDot());
        frame.setVisible(true);
    }

    private static void displayManualTree() {
        System.out.println("\n=== Creating expression tree manually ===");

        ExpressionTree manualTree = createManualExpressionTree();
        System.out.println("Expression: " + manualTree);
        System.out.println("Value: " + manualTree.getValue());

        visualizeTree(manualTree, "Manually Created Tree: (2+3)*4");
    }

    private static void preorderTraversal(ExpressionTree tree, StringBuilder sb) {
        if (tree == null) return;

        sb.append(tree.getData()).append(" ");
        preorderTraversal((ExpressionTree)tree.getLeft(), sb);
        preorderTraversal((ExpressionTree)tree.getRight(), sb);
    }

    private static ExpressionTree createManualExpressionTree() {
        ExpressionTree left = new ExpressionTree(
                new Plus(),
                new ExpressionTree(new Number(2)),
                new ExpressionTree(new Number(3))
        );
        ExpressionTree right = new ExpressionTree(new Number(4));
        return new ExpressionTree(new Times(), left, right);
    }
}