package tree.problems;

import java.util.ArrayDeque;
import java.util.Deque;

public class NodeExists {

    /**
     * Binary String represents the path from root to the node, where '1' means going right and '0' means going left.
     * For example, 4 = "100", starting from the index 1, we go from root = 1, going left --> 2, going left --> 4;
     * 7 = "111", starting from index 1, we go from root = 1, going right --> 3, going right --> 7.
     * Similar to {@link BinaryTreeIndexExists}.
     */
    public boolean nodeExists(Node root, int index) {
        if (index <= 0) {
            return false;
        }

        char[] binary = Integer.toBinaryString(index).toCharArray();

        for (int i = 1; i < binary.length; i++) {
            if (root == null) {
                return false;
            }
            if (binary[i] == '0') {
                root = root.left;
            }
            else {
                root = root.right;
            }
        }
        return root != null;
    }

    private static boolean ifNodeExists(TreeNode root, int key) {
        if (root == null) {
            return false;
        }

        if (root.data == key) {
            return true;
        }

        // then recur on left subtree
        boolean leftExists = ifNodeExists(root.left, key);

        // node found, no need to look further
        if (leftExists) return true;

        // node is not found in left,  so recur on right subtree /
        boolean rightExists = ifNodeExists(root.right, key);

        return rightExists;
    }


    //----------------------------------------------------------------------
    //------------------------------ Approach 2 ----------------------------
    //----------------------------------------------------------------------
    private static final int ROOT = 1;

    // The parent of any node N > 0 in such an array will always be at index (N-1)/2.
    private static int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    private static Deque<Integer> getPathFromRootTo(int target) {
        Deque<Integer> path = new ArrayDeque<>();
        while (target != ROOT) {
            path.push(target); // add to start of Queue
            target = getParentIndex(target);
        }
        return path;
    }

    private static boolean verifyPath(Node node, Deque<Integer> path) {
        while (!path.isEmpty()) {
            node = path.pop() % 2 == 0 ? node.left : node.right; // even index on left and odd index on right
            if (node == null) {
                return false;
            }
        }
        return true;
    }

    private static boolean doesNodeExist(Node root, int target) {
        if (root == null) {
            return false;
        }
        Deque<Integer> path = getPathFromRootTo(target);
        return verifyPath(root, path);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.right = new Node(3);
        root.right.left = new Node(6);

        System.out.println(doesNodeExist(root, 5)); // false
        System.out.println(doesNodeExist(root, 7)); // false
        System.out.println(doesNodeExist(root, 20)); // false
        System.out.println(doesNodeExist(null, 1)); // false
        System.out.println(doesNodeExist(root, 1)); // true
        System.out.println(doesNodeExist(root, 2)); // true
        System.out.println(doesNodeExist(root, 3)); // true
        System.out.println(doesNodeExist(root, 4)); // true
        System.out.println(doesNodeExist(root, 6)); // true
    }
}
