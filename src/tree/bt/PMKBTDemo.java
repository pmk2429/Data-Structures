package tree.bt;

import java.util.LinkedList;
import java.util.List;

public class PMKBTDemo {
  public static void main(String[] args) {
    BinaryTreeImpl binaryTree = new BinaryTreeImpl();

    Node a = new Node(3, "PMK");
    Node b = new Node(1, "MMK");
    Node c = new Node(6, "RMK");
    Node d = new Node(2, "MDK");
    Node e = new Node(7, "KPK");

    binaryTree.add(a);
    binaryTree.add(b);
    binaryTree.add(c);
    binaryTree.add(d);
    binaryTree.add(e);

    binaryTree.printTree();

    System.out.println(binaryTree.height(e));
    System.out.println(binaryTree.depth());

    System.out.println(binaryTree.parent(d).value);

    System.out.println(binaryTree.getLevel(d));

  }
}
