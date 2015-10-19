package tree.api;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * Created by Pavitra on 10/17/2015.
 */
public class BinaryTree<T extends Comparable<T>> implements TreeInterface<T>, Iterable<T> {

    private Node<T> root;
    private Comparator<T> comparator;

    public BinaryTree() {
        root = null;
        comparator = null;
    }

    public BinaryTree(Comparator<T> comp) {
        this.comparator = comp;
    }

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

        /**
         * if a or b is itself the root, then the root itself is the LCA
         */
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

    private int compare(T x, T y) {
        if (comparator == null) return x.compareTo(y);
        else
            return comparator.compare(x, y);
    }


    @Override
    public void add(T data) {
        root = add(root, data);
    }


    private Node add(Node<T> root, T data) {
        if (root == null) {
            return new Node(data);
        }
        if (compare(data, root.data) == 0)
            return root;

        if (compare(data, root.data) < 0) {
            root.left = add(root.left, data);
        } else {
            root.right = add(root.right, data);
        }

        return root;
    }


    @Override
    public Node delete(Node node) {
        return null;
    }

    @Override
    public void search() {

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
    public Node findMaximum(Node root) {
        return null;
    }

    @Override
    public Node findMinimum(Node root) {
        return null;
    }

    @Override
    public boolean hasLeft(Node node) {
        return false;
    }

    @Override
    public boolean hasRight(Node node) {
        return false;
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
}
