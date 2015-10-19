package tree.api;

/**
 * Created by Pavitra on 10/18/2015.
 */
// internal Node class.
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