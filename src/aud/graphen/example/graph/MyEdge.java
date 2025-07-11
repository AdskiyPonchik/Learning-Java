package aud.graphen.example.graph;

import aud.graphen.graph.SimpleEdge;

/** edge with all possible attributes that we require ;-) */
public class MyEdge extends SimpleEdge {
  @Override public MyEdge create() { // DON'T FORGET THIS !!!
    return new MyEdge();
  }

  /** color as string */
  public String color = null;

  /** width for visualization (ignored if {@code <0}) */
  public double penwidth = -1.0;
}
