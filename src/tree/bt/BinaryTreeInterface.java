package tree.bt;

public interface BinaryTreeInterface {
  Node addNode(int key, String name);

  Node deleteNode();

  void search();

  int height();

  int depth();

  int maximum();

  Node findMaximum();

  Node findMinimum();

  boolean hasLeft(Node node);

  boolean hasRight(Node node);

}
