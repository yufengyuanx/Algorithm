package tools;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {
  public int value;
  public List<GraphNode> neighbors;

  public GraphNode(int value) {
    this.value = value;
    neighbors = new ArrayList<GraphNode>();
  }
}
