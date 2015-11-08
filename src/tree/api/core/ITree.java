package tree.api.core;


import tree.api.exceptions.BoundaryViolationException;
import tree.api.exceptions.EmptyTreeException;
import tree.api.exceptions.InvalidNodeException;

/**
 * ITree is a generic Interface which exhibits all the possible behavior of the Tree Data Structure. Implementing this
 * interface will provide the calling class to follow the default behavior of the Tree Data Structure. ITree is a
 * Generic  interface and hence it provides a generic type checking for all the implementing classes which are
 * parameterized over custom types.
 * <p>
 * Created by Pavitra on 10/17/2015.
 */
public interface ITree<T> {

    /**
     * This method is used to Add a {@link Node} to the BinaryTree. It takes a Generic data type as an
     * argument and then internally calls another method add(Node, data) to insert the data into the BinaryTree.
     * Accepts <tt>Comparable </tt> type class.
     *
     * @param data
     */
    void add(T data);

    /**
     * Method to delete the Node from the Tree.
     *
     * @param data
     * @return
     */
    Node delete(T data);

    /**
     * Method to delete the Minimum element( found in the Tree.
     *
     * @param root
     */
    void deleteMin(Node<T> root);


    /**
     * Returns whether the given Node is root or not. This method checks for the parent of the Node to determine
     * whether there is any parent available or not.
     *
     * @param node
     * @return
     */
    boolean isRoot(Node<T> node);

    /**
     * Method to delete the Maximum element found in the tree.
     *
     * @param root
     */
    void deleteMax(Node<T> root);

    /**
     * Method to return the root node of the Tree. This method throws an exception if the tree is empty.
     *
     * @return
     * @throws EmptyTreeException
     */
    Node<T> getRoot() throws EmptyTreeException;

    /**
     * Method to replace the element at a specific Node with another element.
     *
     * @param originalNode
     * @param replacementNode
     * @return
     */
    public T replace(Node<T> originalNode, T replacementNode);

    /**
     * Method to get the Data in the Node. Returns the Generic bound data.
     *
     * @param node
     * @return
     */
    T getData(Node<T> node);

    /**
     * Returns <tt>true</tt> if this Tree contains the specified element.
     * More formally, returns <tt>true</tt> if and only if this list contains
     * at least one element <tt>e</tt> such that
     * <tt>(o==null&nbsp;?&nbsp;e==null&nbsp;:&nbsp;o.equals(e))</tt>.
     *
     * @param data
     * @return
     */
    boolean contains(T data);


    /**
     * Returns the height of the Node in the Tree
     *
     * @param node
     * @return
     */
    int height(Node node);

    /**
     * Returns the depth of a specific node in the Tree. Depth defines the total number of ancestors of a specific
     * Node. For the root Node, the depth is 0.
     *
     * @param node
     * @return
     */
    int depth(Node node);

    /**
     * Method to get the total number of leaf in a particulat tree/subtree. This method takes root of tree/subtree as
     * an input param.
     *
     * @param root
     * @return
     */
    int getTotalLeaf(Node<T> root);

    /**
     * Method to find the Maximum Node from the Tree. This method takes in the root of the tree/subtree of the param
     * and returns the Node with the Highest value in the corresponding Tree/Subtree.
     *
     * @param root
     * @return Node
     */
    Node findMaximum(Node root);

    /**
     * Method to find the Minimum Node from the Tree. This method takes in the root of the tree/subtree of the param
     * and returns the Node with the Highest value in the corresponding Tree/Subtree.
     *
     * @param root
     * @return Node
     */
    Node findMinimum(Node root);

    /**
     * Method to find the predecessor of the given Node.
     *
     * @param node
     * @return
     */
    Node getPredecessor(Node<T> node);


    /**
     * Returns a parent of a given Node.
     *
     * @param data
     * @return
     * @throws InvalidNodeException, BoundaryViolationException
     */
    Node<T> parent(T data) throws InvalidNodeException, BoundaryViolationException;


    /**
     * Returns whether a given node is internal or not
     *
     * @param node
     * @return
     * @throws InvalidNodeException
     */
    boolean isInternal(Node<T> node) throws InvalidNodeException;

    /**
     * Returns whether a given node is external or not
     *
     * @param node
     * @return
     * @throws InvalidNodeException
     */
    boolean isExternal(Node<T> node) throws InvalidNodeException;

    /**
     * Method to check whether the given Node has left Node or not.
     *
     * @param node
     * @return
     */
    boolean hasLeft(Node<T> node);

    /**
     * Method to check whether the given Node has right Node or not.
     *
     * @param node
     * @return
     */
    boolean hasRight(Node<T> node);

    /**
     * Method to check that whether the Node has a Child or not.
     *
     * @param node
     * @return
     */
    boolean hasChild(Node<T> node);

    /**
     * Method to return the total number of Child for a given Node.
     *
     * @param node
     * @return
     */
    int getTotalChild(Node<T> node);

    /**
     * Method to check whether the Tree is empty or not.
     *
     * @return
     */
    boolean isEmpty();

    /**
     * Returns the total
     *
     * @return
     */
    int size();

}