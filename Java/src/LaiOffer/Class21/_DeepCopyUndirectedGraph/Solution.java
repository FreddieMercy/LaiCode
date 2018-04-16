package LaiOffer.Class21._DeepCopyUndirectedGraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class GraphNode {
    public int key;
    public List<GraphNode> neighbors;
    public GraphNode(int key)
    {
        this.key = key;
        this.neighbors = new ArrayList<GraphNode>();
    }
}

public class Solution {
    public List<GraphNode> copy(List<GraphNode> graph) {
        List<GraphNode> ans = new ArrayList<>();
        HashMap<GraphNode, GraphNode> match = new HashMap<>();
        copy(graph, ans, match);
        return ans;
    }
    private void copy(List<GraphNode> graph, List<GraphNode> ans, HashMap<GraphNode, GraphNode> match){
        if (graph==null){
            return;
        }
        for(GraphNode g : graph){
            if(match.get(g) == null){
                match.put(g, new GraphNode(g.key));
                copy(g.neighbors, match.get(g).neighbors, match);
            }

            ans.add(match.get(g));
        }
    }
}