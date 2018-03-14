package LaiOffer.Class05._Bipartite;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class GraphNode {
 public int value;
  public List<GraphNode> neighbors;
  public GraphNode(int v){
      value=v;
  }
};
public class Solution {

    private boolean dfsCheckAllNeighborsAndFlipFlop(List<GraphNode> graph, Set<GraphNode> G1, Set<GraphNode> G2) {

        for (GraphNode g : graph) {
            if (G1.add(g)) {
                if (!dfsCheckAllNeighborsAndFlipFlop(g.neighbors, G2, G1)) {
                    return false;
                }
            }

            if (G1.contains(g) && G2.contains(g)) {
                return false;
            }
        }

        return true;
    }

    public boolean isBipartite(List<GraphNode> graph) {
        // Write your solution here
        if (graph == null || graph.isEmpty()) {
            return true;
        }

        Set<GraphNode> G1 = new HashSet<>();
        Set<GraphNode> G2 = new HashSet<>();

        G1.add(graph.get(0));

        for (GraphNode g : graph) {
            if (G1.contains(g)) {
                if (!dfsCheckAllNeighborsAndFlipFlop(g.neighbors, G2, G1)) {
                    return false;
                }
            } else if (G2.contains(g)) {
                if (!dfsCheckAllNeighborsAndFlipFlop(g.neighbors, G1, G2)) {
                    return false;
                }
            }
        }

        return true;
    }
}