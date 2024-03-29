package tree.problems;

import java.util.*;

public class AllOrderTraversal {

    public void preorder(TreeNode root, List<Integer> nums) {
        if (root == null) return;
        nums.add(root.data);
        preorder(root.left, nums);
        preorder(root.right, nums);
    }

    public void inorder(TreeNode root, List<Integer> nums) {
        if (root == null) return;
        inorder(root.left, nums);
        nums.add(root.data);
        inorder(root.right, nums);
    }

    public void postorder(TreeNode root, List<Integer> nums) {
        if (root == null) return;
        postorder(root.left, nums);
        postorder(root.right, nums);
        nums.add(root.data);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if (root == null) return result;
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            if (curr != null) {
                result.add(curr.data);
                stack.push(curr.right);
                stack.push(curr.left);
            }
        }
        return result;
    }

    // In Order
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            }
            else {
                list.add(stack.peek().data);
                root = stack.pop().right;
            }
        }
        return list;
    }

    // Post Order
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            if (curr != null) {
                result.add(curr.data);
                stack.push(curr.left);
                stack.push(curr.right);
            }
        }
        return result;
    }

    /**
     * Uses Queue to perform Level Order
     */
    public List<List<Integer>> levelOrderTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> currentLevelNodes = new ArrayList<>();
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                TreeNode node = queue.poll();
                currentLevelNodes.add(node.data);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(currentLevelNodes);
        }
        return res;
    }

    /**
     * Same as above except the Level Order stores the {@link TreeNode} and not just Integer.
     */
    public static List<List<TreeNode>> levelOrderTraversalTreeNode(TreeNode root) {
        List<List<TreeNode>> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<TreeNode> currentLevelNodes = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                currentLevelNodes.add(node);

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(currentLevelNodes);
        }
        return res;
    }

    public void levelHelper(List<List<Integer>> res, TreeNode root, int height) {
        if (root == null) return;
        if (height >= res.size()) {
            res.add(new LinkedList<>());
        }
        res.get(height).add(root.data);
        levelHelper(res, root.left, height + 1);
        levelHelper(res, root.right, height + 1);
    }

    /**
     * Level Order Traversal using DFS
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        levelHelper(res, root, 0);
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.createUnusualTree();
        System.out.println(levelOrderTraversalTreeNode(root));
    }
}
