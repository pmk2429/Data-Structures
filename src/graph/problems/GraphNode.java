package graph.problems;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {
    String label;
    int degree;
    int value;
    List<GraphNode> neighbors;

    public GraphNode(String label) {
        this.label = label;
        this.neighbors = new ArrayList<>();
    }
}
