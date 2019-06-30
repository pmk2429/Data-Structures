package graph.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DFSStackAndRecursion {

  static class Node {
    int data;
    boolean visited;
    List<Node> neighbours;

    Node(int value) {
      data = value;
      visited = false;
      neighbours = new ArrayList<>();
    }

    void addNeighbors(Node neighbourNode) {
      neighbours.add(neighbourNode);
    }

    List<Node> getNeighbours() {
      return neighbours;
    }

    void setNeighbours(List<Node> neighbours) {
      this.neighbours = neighbours;
    }
  }

  // Recursive DFS
  void dfs(Node node) {
    System.out.print(node.data + " ");
    List<Node> neighbours = node.getNeighbours();
    node.visited = true;
    for (Node n : neighbours) {
      if (n != null && !n.visited) {
        dfs(n);
      }
    }
  }

  // Iterative DFS using stack
  void dfsUsingStack(Node node) {
    Stack<Node> stack = new Stack<>();
    node.visited = true;
    System.out.print(node.data + " ");
    stack.push(node);

    while (!stack.isEmpty()) {
      Node element = stack.pop();
      List<Node> neighbours = element.getNeighbours();
      for (Node n : neighbours) {
        if (n != null && !n.visited) {
          n.visited = true;
          System.out.print(n.data + " ");
          stack.add(n);
        }
      }
    }
  }

  public static void main(String arg[]) {

    Node node40 = new Node(40);
    Node node10 = new Node(10);
    Node node20 = new Node(20);
    Node node30 = new Node(30);
    Node node60 = new Node(60);
    Node node50 = new Node(50);
    Node node70 = new Node(70);

    node40.addNeighbors(node10);
    node40.addNeighbors(node20);
    node10.addNeighbors(node30);
    node20.addNeighbors(node10);
    node20.addNeighbors(node30);
    node20.addNeighbors(node60);
    node20.addNeighbors(node50);
    node30.addNeighbors(node60);
    node60.addNeighbors(node70);
    node50.addNeighbors(node70);

    DFSStackAndRecursion dfs = new DFSStackAndRecursion();

    System.out.println("The DFS traversal of the graph using stack ");
    dfs.dfsUsingStack(node40);

    System.out.println();

    // Resetting the visited flag for nodes
    node40.visited = false;
    node10.visited = false;
    node20.visited = false;
    node30.visited = false;
    node60.visited = false;
    node50.visited = false;
    node70.visited = false;


    System.out.println("The DFS traversal of the graph using recursion ");
    dfs.dfs(node40);
  }
}