package graph.problems;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BFSAdjacencyMatrix {
    private final Deque<Node> queue;
    private final static List<Node> nodes = new ArrayList<>();

    static class Node {
        int data;
        boolean visited;

        Node(int data) {
            this.data = data;
        }
    }

    BFSAdjacencyMatrix() {
        queue = new LinkedList<>();
    }

    // find neighbors of node using adjacency matrix
    // if adjacency_matrix[i][j]==1, then nodes at index i and index j are connected
    private List<Node> findNeighbours(int[][] adjacency_matrix, Node x) {
        int nodeIndex = nodes.indexOf(x);
        List<Node> neighbours = new ArrayList<>();
        if (nodeIndex != -1) {
            for (int j = 0; j < adjacency_matrix[nodeIndex].length; j++) {
                if (adjacency_matrix[nodeIndex][j] == 1) {
                    neighbours.add(nodes.get(j));
                }
            }
        }
        return neighbours;
    }

    void bfs(int[][] adjacency_matrix, Node node) {
        node.visited = true;
        queue.add(node);
        while (!queue.isEmpty()) {
            Node element = queue.remove();

            System.out.print(element.data + " ");

            List<Node> neighbours = findNeighbours(adjacency_matrix, element);
            for (Node n : neighbours) {
                if (n != null && !n.visited) {
                    n.visited = true;
                    queue.add(n);
                }
            }
        }
    }

    public static void main(String[] args) {
        Node node40 = new Node(40);
        Node node10 = new Node(10);
        Node node20 = new Node(20);
        Node node30 = new Node(30);
        Node node60 = new Node(60);
        Node node50 = new Node(50);
        Node node70 = new Node(70);

        nodes.add(node40);
        nodes.add(node10);
        nodes.add(node20);
        nodes.add(node30);
        nodes.add(node60);
        nodes.add(node50);
        nodes.add(node70);

        int[][] adjacency_matrix = {
            {0, 1, 1, 0, 0, 0, 0}, // Node 1: 40
            {0, 0, 0, 1, 0, 0, 0}, // Node 2 :10
            {0, 1, 0, 1, 1, 1, 0}, // Node 3: 20
            {0, 0, 0, 0, 1, 0, 0}, // Node 4: 30
            {0, 0, 0, 0, 0, 0, 1}, // Node 5: 60
            {0, 0, 0, 0, 0, 0, 1}, // Node 6: 50
            {0, 0, 0, 0, 0, 0, 0}, // Node 7: 70
        };

        System.out.println("The BFS traversal of the graph is ");

        BFSAdjacencyMatrix bfs = new BFSAdjacencyMatrix();
        bfs.bfs(adjacency_matrix, node40);
    }
}
