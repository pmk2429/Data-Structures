package tree.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ColumnOrder {

    // Utility function to store vertical order in map 'm'
    // 'hd' is horizontal distance of current node from root.
    // 'hd' is initially passed as 0
    private static void buildVerticalOrder(Node root, int horizontalDist, TreeMap<Integer, List<Integer>> columnMap) {
        // Base case
        if (root == null) {
            return;
        }

        // get the vector list at 'hd'
        List<Integer> res = columnMap.get(horizontalDist);

        // Store current node in map 'm'
        if (res == null) {
            res = new ArrayList<>();
        }
        res.add(root.data);
        columnMap.put(horizontalDist, res);

        // Store nodes in left subtree
        buildVerticalOrder(root.left, horizontalDist - 1, columnMap); // left go -1

        // Store nodes in right subtree
        buildVerticalOrder(root.right, horizontalDist + 1, columnMap); // right go +1
    }

    // The main function to print vertical oder of a binary tree with given root
    private static void printVerticalOrder(Node root) {
        // Create a map and store vertical oder in map using function getVerticalOrder()
        TreeMap<Integer, List<Integer>> m = new TreeMap<>();
        int hd = 0;
        buildVerticalOrder(root, hd, m);

        // Traverse the map and print nodes at every horizontal distance (hd)
        for (Map.Entry<Integer, List<Integer>> entry : m.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);
        root.right.right.right = new Node(9);
        System.out.println("Vertical Order traversal is");
        printVerticalOrder(root);
    }
}
