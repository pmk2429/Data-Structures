package tree.api;

import java.util.*;
import java.util.function.Consumer;

/**
 * BinaryTree class provides a Generic Class to implement the Binary Tree DS. This class provides the
 * concrete implementation of the behavior specified in the ITree. Binary Tree class extends the
 * Comparable Interface for comparing the data based on
 * <p>
 * Created by Pavitra on 10/17/2015.
 */
public class BinaryTree<T extends Comparable<T>> implements ITree<T>, Iterable<T> {

    private Node<T> root;
    private Comparator<T> comparator;


    // Default constructor.
    public BinaryTree() {
        root = null;
        comparator = null;
    }

    // default constructor to initialize the Comparator
    public BinaryTree(Comparator<T> comp) {
        this.comparator = comp;
    }

    // Method to compare two objects of calling type T based on the Comparable compareTo() method.
    private int compare(T x, T y) {
        if (comparator == null) {
            return x.compareTo(y);
        } else {
            return comparator.compare(x, y);
        }
    }

    /**
     * This method is used to Add a {@link Node} to the BinaryTree. It takes a Generic data type as an
     * argument and then internally calls another method add(Node, data) to insert the data into the BinaryTree
     *
     * @param data
     */
    @Override
    public void add(T data) {
        root = add(root, data);
    }


    // Helper method used to add the type specific data to the Tree based on the index.
    private Node add(Node<T> root, T data) {
        if (root == null) {
            return new Node(data);
        }
        if (compare(data, root.data) == 0)
            return root;

        // if the data to be inserted is less than the root data, insert to left of child.
        if (compare(data, root.data) < 0) {
            root.left = add(root.left, data);
        }
        // if the data to be inserted is greater than the root data, insert to right of child.
        else {
            root.right = add(root.right, data);
        }

        return root;
    }


    /**
     * This method is used to delete the node from the BinaryTree.
     *
     * @param data
     * @return
     */
    @Override
    public Node<T> delete(T data) {
        root = delete(root, data);

        return null;
    }

    // helper method to delete the data using the root Node.
    private Node<T> delete(Node<T> root, T data) {
        if (root == null) {
            throw new RuntimeException("Cannot delete");
        }
        // if the desired element to be deleted is less than the current node.
        else if (compare(data, root.data) < 0) {
            root.left = delete(root.left, data);
        }
        // if the desired element to be deleted is greater than the current node.
        else if (compare(data, root.data) > 0) {
            root.right = delete(root.right, data);
        }
        // if the node to be deleted is not found.
        else {
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;
            else {
                // get the data from the right most node in the left subtree.
                root.data = getData(root.left);
                // delete the rightmost node in the left subtree.
                root.left = delete(root.left, root.data);
            }
        }
        return null;
    }

    @Override
    public void deleteMin(Node<T> root) {

    }

    @Override
    public void deleteMax(Node<T> root) {

    }

    @Override
    public Node<T> getRoot() {
        return root;
    }


    @Override
    public void search() {

    }

    @Override
    public T getData(Node<T> node) {
        return node.data;
    }

    @Override
    public Node getRight(Node<T> node) {
        return node.right;
    }

    @Override
    public Node getLeft(Node<T> node) {
        return node.left;
    }

    @Override
    public int getPosition(Node node) {
        return 0;
    }

    @Override
    public int height(Node node) {
        return 0;
    }

    @Override
    public int depth(Node node) {
        return 0;
    }

    @Override
    public int maximum() {
        return 0;
    }

    @Override
    public int getTotalLeaf(Node<T> root) {
        return 0;
    }

    @Override
    public Node findMaximum(Node root) {
        return null;
    }

    @Override
    public Node findMinimum(Node root) {
        return null;
    }

    @Override
    public Node getPredecessor(Node<T> root) {
        return null;
    }

    @Override
    public Node getSuccessor(Node<T> root) {
        return null;
    }

    @Override
    public boolean hasLeft(Node node) {
        return (node.left != null);
    }

    @Override
    public boolean hasRight(Node node) {
        return (node.right != null);
    }

    @Override
    public boolean hasChild(Node node) {
        return false;
    }

    @Override
    public int getTotalChild(Node node) {
        return 0;
    }

    @Override
    public boolean isBinaryTree(Node root) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return size(root);
    }

    // TODO: helper method for getting size of the root.
    private int size(Node<T> root) {
        if (root == null)
            return 0;

        return 0;
    }


    @Override
    public boolean contains(T data) {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super T> action) {

    }

    @Override
    public Spliterator<T> spliterator() {
        return null;
    }

    public void preOrderTraversal() {
        preOrderHelper(root);
    }

    private void preOrderHelper(Node r) {
        if (r != null) {
            System.out.print(r + " ");
            preOrderHelper(r.left);
            preOrderHelper(r.right);
        }
    }

    // Other basic features of the BinaryTree.

    /**
     * This method provides the Recursive approach to find the <tt>Lowest Common Ancestor</tt>.
     * <p>
     * <b>Conditions for LCA in Binary Tree</b>
     * <ul>
     * <li>If the binary tree itself is null, you don’t have any common ancestor. This is an error condition.</li>
     * <li>If one of the two nodes is the root, then the root itself is the common ancestor.</li>
     * <li>Otherwise, recursively start finding the ancestor on the leftChild node and right node.</li>
     * </ul>
     * <p>
     * If Node a and Node b lie in the leftChild, their Lowest Common Ancestor is in the leftChild.
     * If Node a and Node b lie in the right,their Lowest Common Ancestor is in the right.
     * Otherwise, root is the Lowest common ancestor.
     *
     * @return
     */
    public Node getLowestCommonAncestor(Node root, Node a, Node b) {

        Node left = null;
        Node right = null;

        if (root == null) {
            return null;
        }

        //if a or b is itself the root, then the root itself is the LCA
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
}
