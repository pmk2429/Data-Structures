package graph.demos;

class Queue {
    private final int SIZE = 20;
    private int[] queArray;
    private int front;
    private int rear;

    public Queue()            // constructor
    {
        queArray = new int[SIZE]; 
        front = 0;
        rear = -1;
    }

    public void insert(int j) // put item at rear of queue
    {
        if (rear == SIZE - 1)
            rear = -1;
        queArray[++rear] = j;
    }

    public int remove()       // take item from front of queue
    {
        int temp = queArray[front++];
        if (front == SIZE)
            front = 0;
        return temp;
    }

    public boolean isEmpty()  // true if queue is empty
    {
        return (rear + 1 == front || (front + SIZE - 1 == rear));
    }

    public int get() {
        return queArray[front];
    }
}  // end class Queue


class Vertex {
    public char label;        // label (e.g. 'A')
    public boolean wasVisited;

    public Vertex(char lab)   // constructor
    {
        label = lab;
        wasVisited = false;
    }
}  // end class Vertex

class Graph {
    private final int MAX_VERTS = 20;
    private Vertex vertexList[]; // list of vertices
    private int adjMat[][];      // adjacency matrix
    private int nVerts;          // current number of vertices
    private Queue theQueue;

    // initialize the VertexList, Queue and Adjacency Matrix.
    public Graph() {
        // initialize the vertexList.
        vertexList = new Vertex[MAX_VERTS];
        // adjacency matrix
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        for (int j = 0; j < MAX_VERTS; j++)      // set adjacency
            for (int k = 0; k < MAX_VERTS; k++)   //    matrix to 0
                adjMat[j][k] = 0;
        theQueue = new Queue();
    }  // end constructor

    public void addVertex(char lab) {
        vertexList[nVerts++] = new Vertex(lab);
    }

    public void addEdge(int start, int end) {
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    public void displayVertex(int v) {
        System.out.print(vertexList[v].label);
    }

    public void bfs()                   // breadth-first search
    {                                // begin at vertex 0
        vertexList[0].wasVisited = true; // mark it
        displayVertex(0);                // display it
        theQueue.insert(0);              // insert at tail
        int v2;

        // loop until the Queue us Empty to traverse all the Vertices in the Graph.
        while (!theQueue.isEmpty()) {
            // remove vertex at head
            int v1 = theQueue.remove();
            // loop until the Adjacent of the current vertex is all visited.
            while ((v2 = getAdjUnvisitedVertex(v1)) != -1) {
                vertexList[v2].wasVisited = true;  // mark it
                displayVertex(v2);                 // display it
                theQueue.insert(v2);               // insert it
            }   // end while
        }  // end while(queue not empty)

        // Queue is empty.
        for (int j = 0; j < nVerts; j++)             // reset flags
            vertexList[j].wasVisited = false;
    }

    /**
     * returns an Unvisited vertex of 'v'.
     */

    public int getAdjUnvisitedVertex(int v) {
        for (int j = 0; j < nVerts; j++) {
            if (adjMat[v][j] == 1 && vertexList[j].wasVisited == false) {
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
        theGraph.bfs();             // breadth-first search
        System.out.println();
    }  // end main()
}  // end class BFSMain
