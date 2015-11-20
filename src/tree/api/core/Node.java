package tree.api.core;

import java.util.ArrayList;
import java.util.List;

/**
 * A Node is the building block of the Tree Data Structure. This provides an efficient and easy way to add
 * type specific data to the Node be it {@link String}, {@link Integer} or any other custom data type.
 * <p>
 * The Node class provide contains the basic properties of a Tree namely Data, Left and Right where Data is
 * the type of Node being called upon by the calling class and Left, Right are the pointers to the
 * Left and Right child of the Node.
 * <p>
 * Created by Pavitra on 10/18/2015.
 */
public class Node<T> {
    // Nested Node class
    Node left, right;
    T data;

    public Node() {
        left = null;
        right = null;
        data = null;
    }

    public Node(T data) {
        left = null;
        right = null;
        this.data = data;
    }

    public Node(T data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    /**
     * Return the children of Node<T>. The Tree<T> is represented by a single root Node<T> whose children are
     * represented by a List<Node<T>>. Each of these Node<T> elements in the List can have children.
     * The getChildren() method will return the children of a Node<T>.
     *
     * @return the children of Node<T>
     */
    public List<Node<T>> getChildren() {
        if (this.children == null) {
            return new ArrayList<Node<T>>();
        }
        return this.children;
    }

    public void setChildren(List<Node<T>> children) {
        this.children = children;
    }

    /**
     * Returns the number of immediate children of this Node<T>.
     *
     * @return the number of immediate children.
     */
    public int getNumberOfChildren() {
        if (children == null) {
            return 0;
        }
        return children.size();
    }

    /**
     * Adds a child to the list of children for this Node<T>. The addition of
     * the first child will create a new List<Node<T>>.
     *
     * @param child a Node<T> object to set.
     */
    public void addChild(Node<T> child) {
        if (children == null) {
            children = new ArrayList<Node<T>>();
        }
        children.add(child);
    }

    List<Node<T>> children;

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    /**
     * Returns <tt>true</tt> if there it a Left node to current Node else <tt>false</tt>
     *
     * @return
     */
    public boolean hasLeft() {
        return this.left != null;
    }

    /**
     * Returns <tt>true</tt> if there is a Right Node to current Node else <tt>false</tt>.
     *
     * @return
     */
    public boolean hasRight() {
        return this.right != null;
    }

    @Override
    public String toString() {
        return "" + data;
    }
}