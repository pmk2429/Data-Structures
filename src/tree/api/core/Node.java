package tree.api.core;

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

    @Override
    public String toString() {
        return "" + data;
    }
}