package tree.api.core;

import tree.api.exceptions.BoundaryViolationException;
import tree.api.exceptions.InvalidNodeException;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * A Generic implementation of the Binary Tree. This class provides the concrete implementation of the behavior
 * specified in the ITree. Binary Tree class extends the Comparable Interface for comparing the data based
 * <p>
 * Created by Pavitra on 10/17/2015.
 */
public class BinarySearchTree<T extends Comparable<T>> implements ITree<T>, Iterable<T> {

    private static String INVALID_NODE_MESSAGE = "Invalid Node in Tree";
    private static String INVALID_NODE_ERROR_CODE = "Invalid_Node";
    private Node<T> root;
    private Comparator<T> comparator;

    // Default constructor.
    public BinarySearchTree() {
        root = null;
        comparator = null;
    }

    // default constructor to initialize the Comparator
    public BinarySearchTree(Comparator<T> comp) {
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

    @Override
    public void add(T data) {
        root = add(root, data);
    }

    // Helper method used to add the type specific data to the Tree based on the index.
    private Node add(Node<T> root, T data) {
        // if root is null, create root.
        if (root == null) {
            return new Node(data);
        }

        // if the data to be inserted is same as root, return the root.
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
     * This method is used to delete the node from the BinarySearchTree.
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
                root.data = (T) getData(root.left);
                // delete the rightmost node in the left subtree.
                root.left = delete(root.left, root.data);
            }
        }
        return null;
    }

    /**
     * Method to return whether the input Tree is BinarySearchTree or not.
     *
     * @param root
     * @return
     */
    public boolean isBinaryTree(Node root) {
        return false;
    }

    @Override
    public boolean isRoot(T node) throws BoundaryViolationException, InvalidNodeException {
        // check if the current node is parent or not
        if (this.root.data == node) {
            return true;
        } else {
            return false;
        }
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
    public T replace(Node<T> originalNode, T replacementNode) {
        return null;
    }


    @Override
    public T getData(Node<T> node) {
        return node.data;
    }


    /**
     * Method to get the Right node of the Node.
     *
     * @param node
     * @return
     */
    public Node getRight(Node<T> node) {
        return node.right;
    }


    /**
     * Method to get the Left node of the Node.
     *
     * @param node
     * @return
     */
    public Node getLeft(Node<T> node) {
        return node.left;
    }

    /**
     * Returns the position of the Node in the Tree.
     *
     * @param node
     * @return
     */
    public int getPosition(Node node) {
        return 0;
    }

    @Override
    public int height(T node) {
        if (node == null) {
            return -1;
        } else {
            Node currentNode = search(node);
            return currentNode != null ? heightMain(currentNode) : -1;
        }
    }


    /**
     * Helper method to find the Height of a specific Node in BinarySearchTree.
     *
     * @param node
     * @param node
     * @return
     */
    private int heightMain(Node node) {
        if (node != null) {
            return Math.max(heightMain(node.getLeft()), heightMain(node.getRight())) + 1;
        } else {
            return -1;
        }
    }

    @Override
    public Node<T> search(T node) {
        if (node == null) {
            return null;
        } else {
            return search(root, node);
        }
    }

    /**
     * Helper method to find the desired Node in a Tree.
     *
     * @param root
     * @param node
     * @return
     */
    private Node<T> search(Node<T> root, T node) {
        System.out.println(root.getData() + " : " + node);
        if (root != null) {
            // if both are same
            if (compare(root.data, node) == 0) {
                return root;
            } else {
                Node foundNode = null;
                if (compare(node, (T) root.left.data) < 0) {
                    foundNode = search(root.left, node);
                } else {
                    foundNode = search(root.right, node);
                }
                return foundNode;
            }
        } else {
            return null;
        }
    }


    @Override
    public int depth(T node) throws InvalidNodeException, BoundaryViolationException {
        if (isRoot(node)) {
            return 0;
        } else {
            try {
                return 1 + depth(this.parent(node).data);
            } catch (InvalidNodeException e) {
                e.getMessage();
            } catch (BoundaryViolationException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override
    public int getTotalLeaf(Node<T> root) {
        return 0;
    }

    @Override
    public Node maximum() {

        return maximum(root);
    }

    /**
     * Helper method to find the Maximum element in a Tree or SubTree.
     *
     * @param root
     * @return
     */
    private Node maximum(Node<T> root) {

        return null;
    }

    @Override
    public Node minimum() {
        return null;
    }

    @Override
    public Node getPredecessor(Node<T> root) {
        return null;
    }

    @Override
    public Node<T> parent(T data) throws InvalidNodeException, BoundaryViolationException {
        if (data == null) {
            throw new InvalidNodeException(INVALID_NODE_MESSAGE, INVALID_NODE_ERROR_CODE);
        } else {
            return parent(root, data);
        }
    }

    /**
     * Helper method to find the Parent of a specific Node in a Tree
     *
     * @param root
     * @param data
     * @return
     */
    private Node<T> parent(Node<T> root, T data) throws BoundaryViolationException, InvalidNodeException {
        // Root does not have any parent.
        if (isRoot(data) || root == null) {
            return getNullNode();
        } else {
            // if the root's left or right is root itself, return root.
            if (root.left.data == data || root.right.data == data) {
                return root;
            } else {
                // if the data in root is less than data in given Node
                if (root.data.compareTo(data) < 0) {
                    return parent(root.right, data);
                } else {
                    return parent(root.left, data);
                }
            }
        }
    }

    @Override
    public boolean isInternal(Node<T> node) throws InvalidNodeException {
        return false;
    }

    @Override
    public boolean isExternal(Node<T> node) throws InvalidNodeException {
        return false;
    }


    /**
     * Method to find the successor of the given Node.
     *
     * @param root
     * @return
     */
    public Node getSuccessor(Node<T> root) {
        return null;
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
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return size(root);
    }

    @Override
    public Node<T> getNullNode() {

        Node<T> nullNode = new Node<>((T) "NAN");
        return nullNode;
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

    // Other basic features of the BinarySearchTree.

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
