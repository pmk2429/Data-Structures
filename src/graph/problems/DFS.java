package graph.problems;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Stack;

public class DFS {
    private final Stack<Integer> stack;

    public DFS() {
        stack = new Stack<>();
    }

    public static void main(String... arg) {
        int number_of_nodes, source;
        Scanner scanner = null;
        try {
            System.out.println("Enter the number of nodes in the graph");
            scanner = new Scanner(System.in);
            number_of_nodes = scanner.nextInt();

            int[][] adjacencyMatrix = new int[number_of_nodes + 1][number_of_nodes + 1];
            System.out.println("Enter the adjacency matrix");
            for (int i = 1; i <= number_of_nodes; i++)
                for (int j = 1; j <= number_of_nodes; j++)
                    adjacencyMatrix[i][j] = scanner.nextInt();

            System.out.println("Enter the source for the graph");
            source = scanner.nextInt();

            System.out.println("The DFS Traversal for the graph is given by ");
            DFS dfs = new DFS();
            dfs.dfs(adjacencyMatrix, source);
        } catch (InputMismatchException inputMismatch) {
            System.out.println("Wrong Input format");
        }
        scanner.close();
    }

    private void dfs(int[][] adjacencyMatrix, int source) {
        int numberOfNodes = adjacencyMatrix[source].length - 1;

        int[] visited = new int[numberOfNodes + 1];
        int element = source;
        int i;
        System.out.print(element + "\t");
        visited[source] = 1;
        stack.push(source);

        while (!stack.isEmpty()) {
            element = stack.peek();
            i = element;
            while (i <= numberOfNodes) {
                if (adjacencyMatrix[element][i] == 1 && visited[i] == 0) {
                    visited[i] = 1;
                    stack.push(i);
                    element = i;
                    i = 1;
                    System.out.print(element + "\t");
                    continue;
                }
                i++;
            }
            stack.pop();
        }
    }
}