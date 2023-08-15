package graph.problems;

import java.util.*;

/**
 * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
 */
public class Clone {

    private GraphNode cloneGraph(GraphNode vertex) {
        if (vertex == null) {
            return null;
        }

        Map<GraphNode, GraphNode> edgeMap = new HashMap<>();
        Queue<GraphNode> queue = new ArrayDeque<>();
        queue.add(vertex);

        GraphNode graphCopy = new GraphNode(vertex.label);
        edgeMap.put(vertex, graphCopy);

        while (!queue.isEmpty()) {
            GraphNode currNode = queue.poll();
            for (GraphNode neighbor : currNode.neighbors) {
                if (!edgeMap.containsKey(neighbor)) {
                    GraphNode neighborCopy = new GraphNode(neighbor.label);
                    edgeMap.put(neighbor, neighborCopy);
                    queue.add(neighbor);
                }
                else {
                    // add the neighbor as neighbor of clone node
                    edgeMap.get(neighbor).neighbors.add(edgeMap.get(neighbor));
                }
            }
        }
        return graphCopy;
    }
}
