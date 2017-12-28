package advancedII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import tools.GraphNode;

public class DeepCopyUGraph {
  public List<GraphNode> copy(List<GraphNode> graph) {
    if (graph == null) {
      return null;
    }
    HashMap<GraphNode, GraphNode> map = new HashMap<>();
    for (GraphNode node : graph) {
      if (!map.containsKey(node)) {
        map.put(node, new GraphNode(node.value));
        DFS(node, map);
      }
    }
    return new ArrayList<GraphNode>(map.values());
  }

  private void DFS(GraphNode seed, HashMap<GraphNode, GraphNode> map) {
    GraphNode copy = map.get(seed);
    for (GraphNode nei : seed.neighbors) {
      if (!map.containsKey(nei)) {
        map.put(nei, new GraphNode(nei.value));
        DFS(nei, map);
      }
      copy.neighbors.add(map.get(nei));
    }
  }
}
