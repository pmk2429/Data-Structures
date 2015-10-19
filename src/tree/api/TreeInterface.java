package tree.api;


/**
 * Interface to
 * Created by Pavitra on 10/17/2015.
 */
public interface TreeInterface<T> {

    public void add(T data);

    public Node delete(Node node);

    public void search();

    public int getPosition(Node node);

    public int height(Node node);

    public int depth(Node node);

    public int maximum();

    public Node findMaximum(Node root);

    public Node findMinimum(Node root);

    public boolean hasLeft(Node node);

    public boolean hasRight(Node node);

    public boolean hasChild(Node node);

    public int getTotalChild(Node node);

    public boolean isBinaryTree(Node root);
}