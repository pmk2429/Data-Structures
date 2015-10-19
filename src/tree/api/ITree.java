package tree.api;


/**
 * Interface to Generic behavior of the Tree Data Structure. Implementing this interface will provide the
 * calling class to follow the default behavior of the Tree Data Structure.l
 * <p>
 * Created by Pavitra on 10/17/2015.
 */
public interface ITree<T> {

    void add(T data);

    Node delete(T data);

    void deleteMin(Node<T> root);

    void deleteMax(Node<T> root);

    Node<T> getRoot();

    void search();

    T getData(Node<T> node);

    Node getRight(Node<T> node);

    Node getLeft(Node<T> node);

    int getPosition(Node node);

    int height(Node node);

    int depth(Node node);

    int maximum();

    int getTotalLeaf(Node<T> root);

    Node findMaximum(Node root);

    Node findMinimum(Node root);

    Node getPredecessor(Node<T> root);

    Node getSuccessor(Node<T> root);

    boolean hasLeft(Node node);

    boolean hasRight(Node node);

    boolean hasChild(Node node);

    int getTotalChild(Node node);

    boolean isBinaryTree(Node root);

    boolean isEmpty();

    int size();

    boolean contains(T data);

}