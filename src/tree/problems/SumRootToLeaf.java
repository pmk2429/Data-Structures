package tree.problems;

import java.util.ArrayList;
import java.util.List;

public class SumRootToLeaf {

    private static int mergeRootToLeafPath(int[] path, int pathLen) {
        int mergedPath = 0;
        for (int i = 0; i < pathLen; i++) {
            mergedPath = mergedPath * 10 + path[i];
        }
        return mergedPath;
    }

    private static boolean isLeafNode(Node root) {
        return root.left == null && root.right == null;
    }

    private static void buildRootToLeafPath(Node root, int[] path, int pathLen, List<Integer> rootToLeafPaths) {
        if (root == null) {
            return;
        }

        path[pathLen++] = root.data;

        if (isLeafNode(root)) {
            int mergedPath = mergeRootToLeafPath(path, pathLen);
            rootToLeafPaths.add(mergedPath);
        }
        else {
            buildRootToLeafPath(root.left, path, pathLen, rootToLeafPaths);
            buildRootToLeafPath(root.right, path, pathLen, rootToLeafPaths);
        }
    }

    private static int sumNumbers(Node root) {
        List<Integer> allPaths = new ArrayList<>();

        int[] path = new int[1000];
        int pathLen = 0;

        buildRootToLeafPath(root, path, pathLen, allPaths);

        int sum = 0;
        for (Integer val : allPaths) {
            sum += val;
        }
        return sum;
    }

    public static void main(String[] args) {
        Node root = Node.createBT();
        System.out.println(sumNumbers(root));
    }
}
