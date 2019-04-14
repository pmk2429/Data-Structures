package graph.traversals;

import java.util.LinkedList;
import java.util.Queue;

class Vertex {
  char label;
  boolean visited;

  Vertex(char lab) {
    label = lab;
    visited = false;
  }
}

class Graph {
  private final int MAX_VERTEX = 10;
  private Vertex[] vertexList; // list of vertices
  private int[][] adjMat; // adjacency matrix
  private int vertices; // current number of vertices
  private Queue graphQueue;

  // initialize the VertexList, Queue and Adjacency Matrix.
  Graph() {
    // initialize the vertexList
    vertexList = new Vertex[MAX_VERTEX];
    // adjacency matrix
    adjMat = new int[MAX_VERTEX][MAX_VERTEX];
    vertices = 0;
    // set adjacency
    for (int j = 0; j < MAX_VERTEX; j++) {
      for (int k = 0; k < MAX_VERTEX; k++) {
        // matrix to 0
        adjMat[j][k] = 0;
      }
    }

    graphQueue = new LinkedList<>();
  }

  void addVertex(char vert) {
    vertexList[vertices++] = new Vertex(vert);
  }

  void addEdge(int start, int end) {
    adjMat[start][end] = 1;
    adjMat[end][start] = 1;
  }

  void displayVertex(int v) {
    System.out.print(vertexList[v].label);
  }

  Vertex[] allVertices() {
    return vertexList;
  }

  /**
   * 1 - begin at vertex 0
   * 2 - mark it visited
   * 3 - display it
   * 4 - insert into Queue (FIFO)
   * 5 - Find all unvisited adjacent vertices of the current Node
   * 6 - Repeat steps 1..5
   */
  void bfs() {
    vertexList[0].visited = true; // mark it
    displayVertex(0); // display it
    graphQueue.add(0); // insert at tail
    int v2;

    // loop until the Queue us Empty to traverse all the Vertices in the Graph.
    while (!graphQueue.isEmpty()) {
      // remove vertex at head
      int v1 = (int) graphQueue.poll();
      // loop until the Adjacent of the current vertex is all visited.
      while ((v2 = getUnvisitedAdjacentVertices(v1)) != -1) {
        vertexList[v2].visited = true; // mark it
        displayVertex(v2); // display it
        graphQueue.add(v2); // insert it
      }
    }

    // reset flags
    for (int j = 0; j < vertices; j++) {
      vertexList[j].visited = false;
    }
  }

  /**
   * returns an Unvisited vertex of 'v'.
   */

  private int getUnvisitedAdjacentVertices(int v) {
    for (int j = 0; j < vertices; j++) {
      if (adjMat[v][j] == 1 && !vertexList[j].visited) {
        return j;
      }
    }
    return -1;
  }
}

public class BFSMain {
  public static void main(String[] args) {
    Graph theGraph = new Graph();
    theGraph.addVertex('A');    // 0  (start for bfs)
    theGraph.addVertex('B');    // 1
    theGraph.addVertex('C');    // 2
    theGraph.addVertex('D');    // 3
    theGraph.addVertex('E');    // 4
    theGraph.addVertex('F');    // 5
    theGraph.addVertex('G');    // 6
    theGraph.addVertex('H');    // 7

    theGraph.addEdge(0, 1);     // AB
    theGraph.addEdge(1, 2);     // BC
    theGraph.addEdge(0, 3);     // AD
    theGraph.addEdge(3, 4);     // DE
    theGraph.addEdge(3, 5);     // EF
    theGraph.addEdge(4, 6);     // EG
    theGraph.addEdge(5, 6);     // FG
    theGraph.addEdge(6, 7);     // GH


    System.out.print("Visits: ");
    theGraph.bfs();
    System.out.println();
  }
}
