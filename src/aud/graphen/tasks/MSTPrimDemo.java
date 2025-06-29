package aud.graphen.tasks;
import aud.graphen.example.graph.MyNode;
import aud.graphen.example.graph.MyGraph;
import aud.graphen.example.graph.MyEdge;
import aud.graphen.example.graph.PrimMinimumSpanningTree;
import aud.graphen.example.graph.TraversalExample;
import aud.graphen.example.graph.Traversal;
import aud.util.SimpleDecorator;

public class MSTPrimDemo {

    public static void main(String[] args) {
        MyGraph g = new MyGraph(false);
        MyNode[] nodes = new MyNode[6];
        for (int i = 0; i < nodes.length; ++i) {
            nodes[i] = g.addNode();
        }
        MyEdge e;

        e = g.addEdge(nodes[0], nodes[1]); e.setWeight(2.0); // 0–1
        e = g.addEdge(nodes[0], nodes[2]); e.setWeight(5.0); // 0–2
        e = g.addEdge(nodes[0], nodes[3]); e.setWeight(3.0); // 0–3
        e = g.addEdge(nodes[1], nodes[3]); e.setWeight(4.0); // 1–3
        e = g.addEdge(nodes[2], nodes[3]); e.setWeight(1.0); // 2–3
        e = g.addEdge(nodes[2], nodes[4]); e.setWeight(7.0); // 2–4
        e = g.addEdge(nodes[3], nodes[5]); e.setWeight(6.0); // 3–5
        e = g.addEdge(nodes[4], nodes[5]); e.setWeight(9.0); // 4–5
        e = g.addEdge(nodes[2], nodes[5]); e.setWeight(8.0); // 2–5

        TraversalExample app = new TraversalExample();

        Traversal algorithm = new PrimMinimumSpanningTree(g);
        algorithm.singlestepper = app;
        algorithm.nsteps = 1;
        algorithm.verbose = 0;
        app.traversal = algorithm;
        MyNode start = nodes[0];
        app.halt("Prim-MinimumSpanningTree from " + start);
        algorithm.start(start);
        app.halt("DONE");

        ((SimpleDecorator) g.getDecorator()).highlightNode(null);
        ((SimpleDecorator) g.getDecorator()).highlightEdge(null);
        System.out.println(g);

        System.exit(0);
    }
}
