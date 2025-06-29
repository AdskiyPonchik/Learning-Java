package aud.graphen.example.graph;

import aud.graphen.graph.AbstractEdge;
import aud.graphen.graph.AbstractGraph;
import aud.graphen.graph.AbstractNode;
import aud.util.*;
import java.io.File;
import aud.graphen.graph.GraphAM;
import aud.graphen.example.graph.MyNode;

/** graph based on {@link aud.graphen.GraphAM}
    @see MyNode
    @see MyEdge
 */
public class MyGraph extends GraphAM<MyNode,MyEdge> {

  MyDecorator decorator_ = new MyDecorator(this);

  /** create empty graph */
  public MyGraph(boolean directed) {
    super(new MyNode(),new MyEdge(),directed);
  }
  /** read graph from file using {@link GraphParser} */
  public MyGraph(boolean directed,File filename) {
    this(directed);
    String text=Sys.readFile(filename);
    new GraphParser(getAbstractGraph()).parse(text);
  }

  /** view this graph as an {@link AbstractGraph} */
  @SuppressWarnings("unchecked")
  public AbstractGraph<AbstractNode, AbstractEdge>
  getAbstractGraph() {
    // require weird cast -- java generics suck!
    return (AbstractGraph< AbstractNode,AbstractEdge>) (Object) this;
  }

  @Override public GraphvizDecorator getDecorator() {
    return decorator_;
  }
}
