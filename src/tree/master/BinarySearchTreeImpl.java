package tree.master;

import java.util.*;

/**
 * Implementation of BST and all its APIs.
 */
public class BinarySearchTreeImpl implements IBinaryTreeApi {

    private Node root = null;
    private int count = 0;

    // Utility helper method to add new Node to Binary Tree
    private Node add(Node root, Node newNode) {
        if (root == null) {
            root = newNode;
        }

        if (newNode.data < root.data) {
            root.left = root.left != null ? add(root.left, newNode) : newNode;
        }
        else if (newNode.data > root.data) {
            root.right = root.right != null ? add(root.right, newNode) : newNode;
        }

        return root;
    }

    @Override
    public void add(Node node) {
        root = add(root, node);
        count++;
    }

    @Override
    public void delete(Node node) {

    }

    @Override
    public Node search(int key) {
        if (root == null) {
            return null;
        }

        if (root.data == key) {
            return root;
        }

        Node searchNode = root;

        while (searchNode != null) {
            if (key < searchNode.data) {
                searchNode = searchNode.left;
            }
            else if (key > searchNode.data) {
                searchNode = searchNode.right;
            }
            else {
                return searchNode;
            }
        }

        // in this case, the key is not equal to Root and yet searchNode was traversed indicating mismatch
        if (searchNode == null) {
            return getNullNode();
        }

        return searchNode;
    }

    @Override
    public boolean contains(Node node) {
        return false;
    }

    /**
     * Utility method to deduce the height of a specific Node of BST.
     *
     * @param node
     * @return
     */
    private int deduceHeight(Node node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = deduceHeight(node.left);
        int rightHeight = deduceHeight(node.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    @Override
    public int height() {
        return deduceHeight(root);
    }

    @Override
    public int height(Node node) {
        return deduceHeight(node);
    }

    private int deduceMaxDepth(Node node) {
        int ld;
        int rd;

        if (root == null) {
            return -1;
        }

        if (root == node) {
            return 1;
        }

        ld = deduceMaxDepth(root.left);
        rd = deduceMaxDepth(root.right);

        return Math.max(ld, rd) + 1;
    }

    @Override
    public int maxDepth() {
        return deduceMaxDepth(root);
    }

    @Override
    public int maxDepth(Node node) {
        return deduceMaxDepth(node);
    }

    /**
     * Note that the previous approach traverses all the nodes even for a highly unbalanced tree.
     * In fact, we could optimize this scenario by doing a breadth-first traversal (also known as level-order traversal).
     * When we encounter the first leaf node, we immediately stop the traversal.
     * We also keep track of the current depth and increment it when we reach the end of level.
     * We know that we have reached the end of level when the current node is the right-most node.
     * Compared to the recursion approach, the breadth-first traversal works well for highly unbalanced tree because
     * it does not need to traverse all nodes. The worst case is when the tree is a full binary tree with a total of
     * n nodes. In this case, we have to traverse all nodes. The worst case space complexity is O(n), due to the
     * extra space needed to store current level nodes in the queue.
     *
     * @param root
     * @return
     */
    private int deduceMinDepthBFS(Node root) {
        if (root == null) {
            return 0;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        Node rightMost = root;
        int depth = 1;

        while (!q.isEmpty()) {
            Node node = q.poll();
            if (node.left == null && node.right == null) break;
            if (node.left != null) q.add(node.left);
            if (node.right != null) q.add(node.right);
            if (node == rightMost) {
                depth++;
                rightMost = (node.right != null) ? node.right : node.left;
            }
        }
        return depth;
    }

    private int deduceMinDepth(Node node) {
        if (node == null) {
            return -1;
        }

        if (node == root) {
            return 1;
        }

        if (root.left == null) {
            return deduceMinDepth(root.right);
        }

        if (root.right == null) {
            return deduceMinDepth(root.left);
        }

        int lmd = deduceMinDepth(root.left);
        int rmd = deduceMinDepth(root.right);

        return Math.min(lmd, rmd) + 1;
    }

    @Override
    public int minDepth() {
        return deduceMinDepth(root);
    }

    @Override
    public int minDepth(Node node) {
        return deduceMinDepth(node);
    }

    @Override
    public int width() {
        return 0;
    }

    private Node findMaximum(Node node) {
        if (node == null) {
            return null;
        }

        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    @Override
    public Node maximum() {
        return findMaximum(root);
    }

    @Override
    public Node maximum(Node node) {
        return findMaximum(node);
    }

    private Node findMinimum(Node node) {
        if (node == null) {
            return null;
        }

        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    @Override
    public Node minimum() {
        return findMinimum(root);
    }

    @Override
    public Node minimum(Node node) {
        return findMinimum(node);
    }

    @Override
    public boolean hasLeft(Node node) {
        return node.left != null;
    }

    @Override
    public boolean hasRight(Node node) {
        return node.right != null;
    }

    // Helper function for getLevel()
    private int getLevelUtil(Node root, Node node, int level) {
        if (node == null) {
            return 0;
        }

        if (node.data == root.data) {
            return level;
        }

        int downlevel = getLevelUtil(root.left, node, level + 1);

        if (downlevel != 0) {
            return downlevel;
        }

        downlevel = getLevelUtil(root.right, node, level + 1);

        return downlevel;
    }

    @Override
    public int getLevel(Node node) {
        return getLevelUtil(root, node, 1);
    }

    @Override
    public List<List<Node>> getNodesAtLevel(int level) {
        List<List<Node>> lists = new ArrayList<>();
        List<Node> list = new LinkedList<>();

        int i = 0;
        while (i < maxDepth(root)) {
            LinkedList<Node> s = new LinkedList<>(list);
            lists.add(i, s);
            list.clear();
            i++;
        }

        return lists;
    }

    @Override
    public int size() {
        return count;
    }

    private int countTotalLeaves(Node node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return 1;
        }

        return countTotalLeaves(node.left) + countTotalLeaves(node.right);
    }

    @Override
    public int countLeaves() {
        return countTotalLeaves(root);
    }

    @Override
    public int countLeaves(Node node) {
        return countTotalLeaves(node);
    }

    @Override
    public void deleteMin() {

    }

    @Override
    public void deleteMax() {

    }

    @Override
    public Node getRoot() {
        return root;
    }

    @Override
    public boolean isRoot(Node node) {
        return this.root.equals(node);
    }

    private Node getParent(Node root, Node node) {
        if (isRoot(node) || root == null) {
            return getNullNode();
        }
        else {
            if (root.left == node || root.right == node) {
                return root;
            }

            if (compare(root, node) < 0) {
                return getParent(root.right, node);
            }
            else {
                return getParent(root.left, node);
            }
        }
    }

    @Override
    public Node parent(Node node) {
        return getParent(root, node);
    }

    @Override
    public boolean hasChild(Node node) {
        return (node.left != null || node.right != null);
    }

    private int deduceTotalChild(Node node) {
        if (node == null) {
            return -1;
        }

        if (node == root) {
            return count - 1;
        }

        if (node.right == null || node.left == null) {
            return 1;
        }
        else {
            return deduceTotalChild(node.right) + deduceTotalChild(node.left);
        }
    }

    @Override
    public int totalChild() {
        return deduceTotalChild(root);
    }

    @Override
    public int totalChild(Node node) {
        return deduceTotalChild(node);
    }

    private Node findPredecessor(Node node) {
        // max value in left subtree
        if (node == null) {
            return getNullNode();
        }

        if (node.left == null) {
            return getNullNode();
        }

        Node leftRoot = node.left;

        return maximum(leftRoot);
    }

    @Override
    public Node predecessor() {
        return findPredecessor(root);
    }

    @Override
    public Node predecessor(Node node) {
        return findPredecessor(node);
    }

    private Node findSuccessor(Node node) {
        // getMin value in right sub tree
        if (node == null) {
            return getNullNode();
        }

        if (node.right == null) {
            return getNullNode();
        }

        Node rightRoot = node.right;

        return minimum(rightRoot);
    }

    @Override
    public Node successor() {
        return findSuccessor(root);
    }

    @Override
    public Node successor(Node node) {
        return findSuccessor(node);
    }

    @Override
    public List<Node> immediateSuccessors(Node node, int n) {

        if (node == null) {
            return null;
        }

        // build the list using inorder traversal
        List<Node> inorder = inOrderTraversal();

        if (n < inorder.size()) {
            if (inorder.contains(node)) {
                int startIndex = inorder.indexOf(node) + 1;
                // now get the element starting 5 until n
                return inorder.subList(startIndex, startIndex + n);
            }
        }

        return null;
    }

    @Override
    public List<List<Node>> levelOrder() {
        List<List<Node>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Deque<Node> nodeQueue = new LinkedList<>();
        Deque<Integer> levelQueue = new LinkedList<>();

        nodeQueue.offer(root);
        levelQueue.offer(1); //start from 1

        while (!nodeQueue.isEmpty()) {
            Node node = nodeQueue.poll();
            int level = levelQueue.poll();

            // get the most recent level to add the node to that list
            List<Node> temp;
            if (result.size() < level) {
                temp = new ArrayList<>();
                result.add(temp);
            }
            else {
                temp = result.get(level - 1);
            }

            // add the node to current level list
            temp.add(node);

            // check for left node
            if (node.left != null) {
                nodeQueue.offer(node.left);
                levelQueue.offer(level + 1);
            }

            // check for right node
            if (node.right != null) {
                nodeQueue.offer(node.right);
                levelQueue.offer(level + 1);
            }
        }

        return result;
    }

    @Override
    public void printLevelOrder() {
        if (root == null) {
            return;
        }

        Node currNode = root;
        LinkedList<Node> nodesQ = new LinkedList<>();
        nodesQ.add(currNode);

        while (!nodesQ.isEmpty()) {
            // print the current node
            System.out.println(nodesQ.peek().value);

            if (currNode.left != null) {
                nodesQ.add(currNode.left);
            }

            if (currNode.right != null) {
                nodesQ.add(currNode.right);
            }

            nodesQ.remove();
            currNode = nodesQ.peek();
        }

    }

    private Node getLowestCommonAncestor(Node root, Node a, Node b) {
        Node left;
        Node right;

        // base case to return the function
        if (root == null) {
            return null;
        }

        // if a or b is itself the root, then the root itself is the LCA
        if (a == root || b == root) {
            return root;
        }

        // If Node a and Node b lie in the leftChild, their Lowest Common Ancestor is in the leftChild.
        left = getLowestCommonAncestor(root.left, a, b);

        // If Node a and Node b lie in the right,their Lowest Common Ancestor is in the right.
        right = getLowestCommonAncestor(root.right, a, b);

        // Otherwise, root is the Lowest common ancestor.
        if (left != null && right != null) {
            return root;
        }

        return (left != null) ? left : right;
    }

    @Override
    public Node getLowestCommonAncestor(Node a, Node b) {
        if (root == null) {
            return null;
        }

        return getLowestCommonAncestor(root, a, b);
    }

    private List<Node> iterativeInorderTraversal() {
        List<Node> result = new ArrayList<>();
        Stack<Node> stack = new Stack<>();

        Node p = root;
        while (p != null) {
            stack.push(p);
            p = p.left;
        }

        while (!stack.isEmpty()) {
            Node t = stack.pop();
            result.add(t);

            t = t.right;
            while (t != null) {
                stack.push(t);
                t = t.left;
            }
        }

        return result;
    }

    private void buildInorderTraversal(Node node, List<Node> inorder) {
        if (node != null) {
            if (node.left != null) {
                buildInorderTraversal(node.left, inorder);
            }
            inorder.add(node);
            if (node.right != null) {
                buildInorderTraversal(node.right, inorder);
            }
        }
    }

    @Override
    public List<Node> inOrderTraversal() {
        if (root == null) {
            return null;
        }
        List<Node> inorder = new ArrayList<>();
        buildInorderTraversal(root, inorder);
        return inorder;
    }

    /**
     * Verify that whether the current traversal is preorder or not.
     * <p>
     * [5,2,6,1,3] -> false
     * [5,2,1,3,6] -> true
     */
    public boolean verifyPreOrder(int[] preorder) {
        int low = Integer.MIN_VALUE;
        Stack<Integer> path = new Stack();
        for (int p : preorder) {
            if (p < low) {
                return false;
            }
            while (!path.empty() && p > path.peek()) {
                low = path.pop();
            }
            path.push(p);
        }
        return true;
    }

    private void buildPreOrderTraversal(Node node, List<Node> preOrder) {
        if (node != null) {
            preOrder.add(node);
            if (node.left != null) {
                buildPreOrderTraversal(node.left, preOrder);
            }
            if (node.right != null) {
                buildPreOrderTraversal(node.right, preOrder);
            }
        }
    }

    @Override
    public List<Node> preOrderTraversal() {
        if (root == null) {
            return null;
        }

        List<Node> preOrder = new ArrayList<>();
        buildPreOrderTraversal(root, preOrder);

        return preOrder;
    }

    private void buildPostOrderTraversal(Node node, List<Node> postOrder) {
        if (node != null) {
            if (node.left != null) {
                buildPostOrderTraversal(node.left, postOrder);
            }
            if (node.right != null) {
                buildPostOrderTraversal(node.right, postOrder);
            }
            postOrder.add(node);
        }
    }

    @Override
    public List<Node> postOrderTraversal() {
        if (root == null) {
            return null;
        }

        List<Node> postOrder = new ArrayList<>();
        buildPostOrderTraversal(root, postOrder);

        return postOrder;
    }

    private Node getNullNode() {
        Node node = new Node(0, "Node Unavailable");
        return node;
    }

    // Util method to check if the current tree is complete or not.
    private boolean isComplete(Node root) {
        // Base Case: An empty tree is complete Binary Tree
        if (root == null) {
            return true;
        }

        // Create an empty queue
        Queue<Node> queue = new LinkedList<>();

        // Create a flag variable which will be set true
        // when a non full node is seen
        boolean flag = false;

        // Do level order traversal using queue.
        queue.add(root);
        while (!queue.isEmpty()) {
            Node temp_node = queue.poll();

            /* Check if left child is present*/
            if (temp_node.left != null) {
                // If we have seen a non full node, and we see a node
                // with non-empty left child, then the given tree is not a complete Binary Tree
                if (flag) {
                    return false;
                }

                // Enqueue Left Child
                queue.add(temp_node.left);
            }
            // If this a non-full node, set the flag as true
            else {
                flag = true;
            }

            /* Check if right child is present*/
            if (temp_node.right != null) {
                // If we have seen a non full node, and we see a node
                // with non-empty right child, then the given tree is not
                // a complete Binary Tree
                if (flag) {
                    return false;
                }

                // Enqueue Right Child
                queue.add(temp_node.right);

            }
            // If this a non-full node, set the flag as true
            else {
                flag = true;
            }
        }
        // If we reach here, then the tree is complete Bianry Tree
        return true;
    }


    @Override
    public boolean isComplete() {
        return isComplete(root);
    }

    private boolean isFullTree(Node node) {
        boolean isFull = false;

        // empty tree is a full BT
        if (node == null) {
            return true;
        }

        if (node.left == null && node.right == null) {
            return true;
        }

        // a full binary tree always has odd number of nodes
        if (count % 2 == 0) {
            return false;
        }

        if ((node.left != null) && (node.right != null)) {
            isFull = (isFullTree(node.left) && isFullTree(node.right));
        }

        return isFull;
    }

    @Override
    public boolean isFull() {
        return isFullTree(root);
    }

    @Override
    public boolean isLeaf(Node node) {
        return node.right == null && node.left == null;
    }

    private void reverseTree(Node root) {
        if (root == null) {
            return;
        }

        // swap nodes
        Node temp = root.right;
        root.right = root.left;
        root.left = temp;

        // reverse left tree
        reverseTree(root.left);

        // reverse right tree
        reverseTree(root.right);
    }

    @Override
    public void reverse() {
        reverseTree(root);
    }

    @Override
    public boolean isLevelOrderSorted() {
        boolean isSorted = true;

        Node currNode = root;

        // to store maximum value of previous level
        int prevMax = Integer.MIN_VALUE;

        // to store minimum value of current level
        int minVal;

        // to store maximum value of current level
        int maxVal;

        // to store number of nodes in current level
        int levelSize;

        // queue to perform level order traversal.
        Queue<Node> q = new LinkedList<>();
        q.add(currNode);

        while (!q.isEmpty()) {

            // find number of nodes in current level
            levelSize = q.size();

            minVal = Integer.MAX_VALUE;
            maxVal = Integer.MIN_VALUE;

            // traverse current level and find minimum and maximum value of this level
            while (levelSize > 0) {
                currNode = q.poll();

                levelSize--;

                minVal = Math.min(minVal, currNode.data);
                maxVal = Math.max(maxVal, currNode.data);

                if (currNode.left != null) {
                    q.add(currNode.left);
                }

                if (currNode.right != null) {
                    q.add(currNode.right);
                }
            }

            // if minimum value of this level is not greater than maximum
            // value of previous level then given tree is not level sorted.
            if (minVal <= prevMax) {
                isSorted = false;
            }

            // maximum value of this level is
            // previous maximum value for
            // next level.
            prevMax = maxVal;
        }

        return isSorted;
    }

    private int kthCount = 0;

    private Node kthLargestUtil(Node node, int k, int count) {
        Node kthNode = getNullNode();

        if (node == null || kthCount >= k) {
            return kthNode;
        }

        // Follow reverse inorder traversal so that the largest element is visited first
        kthLargestUtil(node.right, k, kthCount);

        // Increment count of visited nodes
        kthCount++;

        // If kthCount becomes k now, then this is the k'th largest
        if (count == k) {
            System.out.println(k + "th largest element is " + node.data);
            kthNode = node;
        }

        // Recur for left subtree
        kthLargestUtil(node.left, k, count);

        return kthNode;
    }

    @Override
    public Node kthLargest() {
        return kthLargestUtil(root, 3, kthCount);
    }

    private boolean isBalanced(Node root) {
        int lh;
        int rh;

        if (root == null) {
            return true;
        }

        lh = height(root.left);
        rh = height(root.right);

        return Math.abs(lh - rh) <= 1 && isBalanced(root.left) && isBalanced(root.right);

    }

    @Override
    public boolean isBalanced() {
        return isBalanced(root);
    }

    /**
     * Manages height of each subtree - only used for calculating diameter purposes
     */
    private class Height {
        int value;
    }

    private int diameterUtil(Node root, Height height) {
        if (root == null) {
            height.value = 0;
            return 0;
        }

        Height rh = new Height();
        Height lh = new Height();

        int leftDiameter = diameterUtil(root.left, lh);
        int rightDiameter = diameterUtil(root.right, rh);

        height.value = Math.max(lh.value, rh.value) + 1;

        return Math.max(lh.value + rh.value + 1, Math.max(leftDiameter, rightDiameter));
    }

    @Override
    public int diameter() {
        Height h = new Height();
        return diameterUtil(root, h);
    }

    private boolean isValidBSTUtil(Node node, Integer low, Integer high) {
        if (node == null) {
            return true;
        }

        return ((low == null || node.data > low)
            && (high == null || node.data < high)
            && (isValidBSTUtil(node.left, low, node.data))
            && (isValidBSTUtil(node.right, node.data, high)));
    }

    @Override
    public boolean isValidBST() {
        return isValidBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    @Override
    public boolean isValidBST(Node node) {
        return isValidBSTUtil(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    // In order printing of tree
    public void printTree() {
        printTree(root);
        System.out.println();
    }

    private void printTree(Node node) {
        if (node == null) {
            return;
        }
        printTree(node.left);
        System.out.println(node.data + "  " + node.value);
        printTree(node.right);
    }

    private int compare(Node a, Node b) {
        return Integer.compare(a.data, b.data);
    }
}
