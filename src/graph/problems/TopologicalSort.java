package graph.problems;

import java.util.LinkedList;
import java.util.Stack;

public class TopologicalSort {
    private final int V;  // No. of vertices
    private final LinkedList<Integer>[] adj; // Adjacency List

    private TopologicalSort(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList<>();
        }
    }

    // Function to add an edge into the graph
    private void addEdge(int v, int w) {
        adj[v].add(w);
    }

    // A recursive function used by topologicalSort
    private void topologicalSortUtil(int v, boolean[] visited, Stack<Integer> stack) {
        // Mark the current node as visited.
        visited[v] = true;
        Integer i;

        // Recur for all the vertices adjacent to this vertex
        for (Integer integer : adj[v]) {
            i = integer;
            if (!visited[i]) {
                topologicalSortUtil(i, visited, stack);
            }
        }

        // Push current vertex to stack which stores result
        stack.push(v);
    }

    // The function to do Topological Sort. It uses recursive topologicalSortUtil()
    private void topologicalSort() {
        Stack<Integer> stack = new Stack<>();
        // Mark all the vertices as not visited
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            visited[i] = false;
        }

        // Call the recursive helper function to store Topological Sort starting from all vertices one by one
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                topologicalSortUtil(i, visited, stack);
            }
        }

        // Print contents of stack
        while (!stack.empty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    public static void main(String[] args) {
        TopologicalSort sort = new TopologicalSort(6);
        sort.addEdge(5, 2);
        sort.addEdge(5, 0);
        sort.addEdge(4, 0);
        sort.addEdge(4, 1);
        sort.addEdge(2, 3);
        sort.addEdge(3, 1);

        System.out.println("Following is a Topological sort of the given graph: ");
        sort.topologicalSort();
    }
}
