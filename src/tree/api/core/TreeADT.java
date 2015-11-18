package tree.api.core;

import java.util.Comparator;

/**
 * ITree is a generic Interface which exhibits all the possible behavior of the Tree Data Structure. Implementing this
 * interface will provide the calling class to follow the default behavior of the Tree Data Structure. ITree is a
 * Generic  interface and hence it provides a generic type checking for all the implementing classes which are
 * parameterized over custom types.
 * <p>
 * Binary tree: Tree where each node has up to two leaves
 * <p>
 * &nbsp;&nbsp;1 <br/>
 * &nbsp;/ \ <br/>
 * 2   3<br/>
 * <b>Binary search tree:</b> Used for searching. A binary tree where the left child contains only nodes with values
 * less than the parent node, and where the right child only contains nodes with values greater than or equal to the parent.
 * <p>
 * 2
 * / \
 * 1   3
 * Created by Pavitra on 10/17/2015.
 */

public abstract class TreeADT<T extends Comparable<T>> {

    private static String INVALID_NODE_MESSAGE = "Invalid Node in Tree";
    private static String INVALID_NODE_ERROR_CODE = "Invalid_Node";
    private Node<T> root;
    private Comparator<T> comparator;

    // Default constructor.
    public TreeADT() {
        root = null;
        comparator = null;
    }

    // default constructor to initialize the Comparator
    public TreeADT(Comparator<T> comp) {
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
     * Method to Add a {@link Node} to the Tree. It takes a Generic data type as an
     * argument and then internally calls another method add(Node, data) to insert the data into the BinarySearchTree.
     * Accepts <tt>Comparable </tt> type class.
     *
     * @param data
     */
    public void add(T data) {
        root = add(root, data);
    }

    private Node<T> add(Node<T> root, T data) {
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
     * Method to Traverse the Tree using PreOrder Traversal Algorithm.
     */
    public void preOrderTraversal() {
        preOrderHelper(root);
    }

    /**
     * Helper method for PreOrder Traversal Algorithm
     *
     * @param r
     */
    private void preOrderHelper(Node r) {
        if (r != null) {
            System.out.print(r + " ");
            preOrderHelper(r.left);
            preOrderHelper(r.right);
        }
    }

    /**
     * Method to delete the Node from the Tree.
     *
     * @param data
     * @return
     */
//    Node delete(T data);
//
//    /**
//     * Method to delete the Minimum element( found in the Tree.
//     *
//     * @param root
//     */
//    void deleteMin(Node<T> root);
//
//
//    /**
//     * Returns whether the given Node is root or not. This method checks for the parent of the Node to determine
//     * whether there is any parent available or not.
//     *
//     * @param node
//     * @return
//     */
//    boolean isRoot(T node) throws InvalidNodeException, BoundaryViolationException;
//
//    /**
//     * Method to delete the Maximum element found in the tree.
//     *
//     * @param root
//     */
//    void deleteMax(Node<T> root);
//
//    /**
//     * Method to return the root node of the Tree. This method throws an exception if the tree is empty.
//     *
//     * @return
//     * @throws EmptyTreeException
//     */
//    Node<T> getRoot() throws EmptyTreeException;
//
//    /**
//     * Method to replace the element at a specific Node with another element.
//     *
//     * @param originalNode
//     * @param replacementNode
//     * @return
//     */
//    public T replace(Node<T> originalNode, T replacementNode);
//
//    /**
//     * Method to get the Data in the Node. Returns the Generic bound data.
//     *
//     * @param node
//     * @return
//     */
//    T getData(Node<T> node);
//
//    /**
//     * Returns <tt>true</tt> if this Tree contains the specified element.
//     * More formally, returns <tt>true</tt> if and only if this list contains
//     * at least one element <tt>e</tt> such that
//     * <tt>(o==null&nbsp;?&nbsp;e==null&nbsp;:&nbsp;o.equals(e))</tt>.
//     *
//     * @param data
//     * @return
//     */
//    boolean contains(T data);
//
//
//    /**
//     * Returns the height of the Node in the Tree
//     *
//     * @param node
//     * @return
//     */
//    int height(T node);
//
//    /**
//     * Returns the depth of a specific node in the Tree. Depth defines the total number of ancestors of a specific
//     * Node. For the root Node, the depth is 0.
//     *
//     * @param node
//     * @return
//     */
//    int depth(T node) throws InvalidNodeException, BoundaryViolationException;
//
//    /**
//     * Method to get the total number of leaf in a particulat tree/subtree. This method takes root of tree/subtree as
//     * an input param.
//     *
//     * @param root
//     * @return
//     */
//    int getTotalLeaf(Node<T> root);
//
//    /**
//     * Method to find the Maximum Node from the Tree. This method takes in the root of the tree/subtree of the param
//     * and returns the Node with the Highest value in the corresponding Tree/Subtree.
//     *
//     * @return Node
//     */
//    Node maximum();
//
//    /**
//     * Method to find the Minimum Node from the Tree. This method takes in the root of the tree/subtree of the param
//     * and returns the Node with the Highest value in the corresponding Tree/Subtree.
//     *
//     * @return Node
//     */
//    Node minimum();
//
//    /**
//     * Method to find the predecessor of the given Node.
//     *
//     * @param node
//     * @return
//     */
//    Node getPredecessor(Node<T> node);
//
//
//    /**
//     * Returns a parent of a given Node.
//     *
//     * @param data
//     * @return
//     * @throws InvalidNodeException, BoundaryViolationException
//     */
//    Node<T> parent(T data) throws InvalidNodeException, BoundaryViolationException;
//
//
//    /**
//     * Returns whether a given node is internal or not
//     *
//     * @param node
//     * @return
//     * @throws InvalidNodeException
//     */
//    boolean isInternal(Node<T> node) throws InvalidNodeException;
//
//    /**
//     * Returns whether a given node is external or not
//     *
//     * @param node
//     * @return
//     * @throws InvalidNodeException
//     */
//    boolean isExternal(Node<T> node) throws InvalidNodeException;
//
//    /**
//     * Method to check whether the given Node has left Node or not.
//     *
//     * @param node
//     * @return
//     */
//    boolean hasLeft(Node<T> node);
//
//    /**
//     * Method to check whether the given Node has right Node or not.
//     *
//     * @param node
//     * @return
//     */
//    boolean hasRight(Node<T> node);
//
//    /**
//     * Method to check that whether the Node has a Child or not.
//     *
//     * @param node
//     * @return
//     */
//    boolean hasChild(Node<T> node);
//
//    /**
//     * Method to return the total number of Child for a given Node.
//     *
//     * @param node
//     * @return
//     */
//    int getTotalChild(Node<T> node);
//
//    /**
//     * Method to check whether the Tree is empty or not.
//     *
//     * @return
//     */
//    boolean isEmpty();
//
//    /**
//     * Returns the total
//     *
//     * @return
//     */
//    int size();
//
//    /**
//     * Returns the Null node when no Node is found. The Null node
//     */
//    Node<T> getNullNode();
//
//
//    Node<T> search(T node);

}

