package graph.problems;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * BFSAdjacencyList using AdjacencyList
 */
public class BFSAdjacencyList {

    private final Deque<Node> queue;

    static class Node {
        int data;
        boolean visited;
        List<Node> neighbours;

        Node(int value) {
            data = value;
            visited = false;
            neighbours = new ArrayList<>();
        }

        void addNeighbours(Node neighbourNode) {
            neighbours.add(neighbourNode);
        }

        List<Node> getNeighbours() {
            return neighbours;
        }

        void setNeighbours(List<Node> neighbours) {
            this.neighbours = neighbours;
        }
    }

    BFSAdjacencyList() {
        queue = new ArrayDeque<>();
    }

    void bfs(Node node) {
        node.visited = true;
        System.out.print(node.data + " ");
        queue.add(node);

        while (!queue.isEmpty()) {
            Node element = queue.poll();
            // get neighbors
            List<Node> neighbours = element.getNeighbours();
            for (Node n : neighbours) {
                if (n != null && !n.visited) {
                    n.visited = true;
                    System.out.print(n.data + " ");
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

        node40.addNeighbours(node10);
        node40.addNeighbours(node20);
        node10.addNeighbours(node30);
        node20.addNeighbours(node10);
        node20.addNeighbours(node30);
        node20.addNeighbours(node60);
        node20.addNeighbours(node50);
        node30.addNeighbours(node60);
        node60.addNeighbours(node70);
        node50.addNeighbours(node70);

        System.out.println("The BFSAdjacencyList traversal of the graph using Adjacency List is: ");

        BFSAdjacencyList bfsExample = new BFSAdjacencyList();
        bfsExample.bfs(node40);
    }
}
