package tree.api.core;


import tree.api.exceptions.BoundaryViolationException;
import tree.api.exceptions.EmptyTreeException;
import tree.api.exceptions.InvalidNodeException;

import java.util.List;

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
public interface ITree<T> {

    /**
     * This method is used to Add a {@link Node} to the BinarySearchTree. It takes a Generic data type as an
     * argument and then internally calls another method add(Node, data) to insert the data into the BinarySearchTree.
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
    void delete(T data);

    /**
     * Method to delete the Minimum element( found in the Tree.
     *
     * @return
     * @throws InvalidNodeException
     */
    void deleteMin() throws InvalidNodeException;


    /**
     * Method to delete the Maximum element found in the tree. Internally calls the <tt>maximum()</tt> method to find
     * the Max element in a given Tree or Subtree and then deletes the found {@link Node}.
     */
    void deleteMax() throws InvalidNodeException;

    /**
     * Returns whether the given Node is root or not. This method checks for the parent of the Node to determine
     * whether there is any parent available or not.
     *
     * @param node
     * @return
     */
    boolean isRoot(T node) throws InvalidNodeException, BoundaryViolationException;

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
    public T replace(T originalNode, T replacementNode);

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
     * Returns an iterable container holding the children of Node of type T
     *
     * @param node
     * @return
     */
    Iterable<T> children(T node);

    /**
     * Returns the height of the Node in the Tree
     *
     * @param node
     * @return
     */
    int height(T node);

    /**
     * Returns the depth of a specific node in the Tree. Depth defines the total number of ancestors of a specific
     * Node. For the root Node, the depth is 0.
     *
     * @param node
     * @return
     */
    int depth(T node) throws InvalidNodeException, BoundaryViolationException;

    /**
     * Method to get the total number of leaf in a particulat tree/subtree. This method takes root of tree/subtree as
     * an input param.
     *
     * @return
     */
    int getTotalLeaf();

    /**
     * Method to find the Maximum Node from the Tree. This method takes in the root of the tree/subtree of the param
     * and returns the Node with the Highest value in the corresponding Tree/Subtree.
     *
     * @return Node
     */
    Node maximum();

    /**
     * Method to find the Minimum Node from the Tree. This method takes in the root of the tree/subtree of the param
     * and returns the Node with the Highest value in the corresponding Tree/Subtree.
     *
     * @return Node
     */
    Node minimum();

    /**
     * Method to find the predecessor of the given Node.
     *
     * @param node
     * @return
     */
    Node getPredecessor(T node);


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
    boolean isInternal(T node) throws InvalidNodeException;

    /**
     * Returns whether a given node is external or not
     *
     * @param node
     * @return
     * @throws InvalidNodeException
     */
    boolean isExternal(T node) throws InvalidNodeException;

    /**
     * Method to check that whether the Node has a Child or not.
     *
     * @param node
     * @return
     */
    boolean hasChild(T node);

    /**
     * Method to return the total number of Child for a given Node.
     *
     * @param node
     * @return
     */
    int getTotalChild(T node);


    /**
     * Returns if the Tree is Empty or not.
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

    /**
     * Returns the Null node when no Node is found. The Null node
     */
    Node<T> getNullNode();


    /**
     * Searches for a given Node in the Tree.
     *
     * @param node
     * @return
     */
    Node<T> search(T node);

    /**
     * Counts the number of Leaf Nodes in a given Tree.
     *
     * @return
     */
    int countLeaves();

    /**
     * Returns number of nodes on the longest path between two leaves in a Tree.
     *
     * @return
     */
    int diameter();

    /**
     * Returns the List of Nodes at a specific level
     *
     * @param level Level at which the List of Node is to be retrieved
     * @return List of Nodes<T>
     */
    List<Node<T>> getNodesAtLevel(int level);
}