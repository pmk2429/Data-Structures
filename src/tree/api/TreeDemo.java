package tree.api;

import tree.api.core.BinarySearchTree;
import tree.api.core.Node;
import tree.api.exceptions.BoundaryViolationException;
import tree.api.exceptions.InvalidNodeException;

public class TreeDemo {
  public static void main(String[] args) throws BoundaryViolationException, InvalidNodeException {
    Integer[] a = {5, 1, 8, 6, 3, 9, 7, 2, 4, 15, 10};
    BinarySearchTree<Integer> bst = new BinarySearchTree<>();
    for (Integer n : a) bst.add(n);
    System.out.println();

    boolean check = bst.isRoot(5);

    int height = bst.height(9);
    System.out.println("height: " + height);

    System.out.println("Parent of 8: " + bst.parent(8));
    System.out.println("Total leaves in Tree: " + bst.countLeaves());

    Node<Integer> minimum = bst.minimum();
    Node<Integer> max = bst.maximum();
    System.out.println("Minimum: " + minimum.getData());
    System.out.println("Maximum: " + max.getData());

    System.out.println("Size of Tree: " + bst.size());

    System.out.println("Tree contains 6? " + bst.contains(4));

    Node<Integer> node = bst.maximum();
    System.out.println("Node has child? " + node.hasChild());

  }
}


class Animal implements Comparable<Animal> {
  String name;
  int age;

  public Animal() {
  }

  public Animal(String name, int age) {
    this.name = name;
    this.age = age;
  }

  @Override
  public int compareTo(Animal o) {
    return 0;
  }
}