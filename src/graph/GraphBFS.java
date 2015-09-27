package graph;

/**
 * Created by Pavitra on 9/27/2015.
 */

import java.util.*;
import java.util.Queue;

public class GraphBFS {
    /* ------------------------------------------
       Data structure used to represent a graph
       ------------------------------------------ */
    int[][] adjMatrix;
    int rootNode = 0;
    int NNodes;

    boolean[] visited;

    /* -------------------------------
       Construct a graph of N nodes
       ------------------------------- */
    GraphBFS(int N) {
        NNodes = N;
        adjMatrix = new int[N][N];
        visited = new boolean[N];
    }

    GraphBFS(int[][] mat) {
        int i, j;

        NNodes = mat.length;

        adjMatrix = new int[NNodes][NNodes];
        visited = new boolean[NNodes];


        for (i = 0; i < NNodes; i++)
            for (j = 0; j < NNodes; j++)
                adjMatrix[i][j] = mat[i][j];
    }


    public void bfs() {
        // BFS uses Queue data structure


        Queue<Integer> q = new LinkedList<>();
        q.add(rootNode);
        visited[rootNode] = true;

        printNode(rootNode);

        while (!q.isEmpty()) {
            int n, child;

            n = (q.peek()).intValue();

            child = getUnvisitedChildNode(n);

            if (child != -1) {
                visited[child] = true;

                printNode(child);

                q.add(child);
            } else {
                q.remove();
            }
        }

        clearVisited();      //Clear visited property of nodes
    }


    int getUnvisitedChildNode(int n) {
        int j;

        for (j = 0; j < NNodes; j++) {
            if (adjMatrix[n][j] > 0) {
                if (!visited[j])
                    return (j);
            }
        }

        return (-1);
    }

    void clearVisited() {
        int i;

        for (i = 0; i < visited.length; i++)
            visited[i] = false;
    }

    void printNode(int n) {
        System.out.println(n);
    }
}

