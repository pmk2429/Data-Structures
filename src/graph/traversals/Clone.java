package graph.traversals;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
 */
public class Clone {

  private GraphNode cloneGraph(GraphNode vertex) {
    if (vertex == null) {
      return null;
    }
    Map<GraphNode, GraphNode> edgeMap = new HashMap<>();
    Queue<GraphNode> gQueue = new LinkedList<>();
    gQueue.add(vertex);
    GraphNode graphCopy = new GraphNode(vertex.label);
    edgeMap.put(vertex, graphCopy);

    while (!gQueue.isEmpty()) {
      GraphNode currNode = gQueue.poll();
      for (GraphNode neighbor : currNode.neighbors) {
        if (!edgeMap.containsKey(neighbor)) {
          GraphNode neighborCopy = new GraphNode(neighbor.label);
          edgeMap.put(neighbor, neighborCopy);
          gQueue.add(neighbor);
        } else {
          // add the neighbor as neighbor of clone node
          edgeMap.get(neighbor).neighbors.add(edgeMap.get(neighbor));
        }
      }
    }
    return graphCopy;
  }
}
