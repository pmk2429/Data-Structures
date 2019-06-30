package tree.problems;

import java.util.*;

public class BottomView {

  Node root; //root node of tree

  public BottomView() {
  }

  // Parameterized tree constructor
  private BottomView(Node node) {
    root = node;
  }

  private void bottomView() {
    if (root == null) {
      return;
    }

    int hd;

    // TreeMap which stores key value pair sorted on key value
    Map<Integer, Integer> map = new TreeMap<>();

    // Queue to store tree nodes in level order traversal
    Queue<Node> queue = new LinkedList<>();

    // Assign initialized horizontal distance value to root
    // node and add it to the queue.
    queue.add(root);

    // Loop until the queue is empty (standard level order loop)
    while (!queue.isEmpty()) {
      Node temp = queue.poll();

      // Extract the horizontal distance value from the
      // dequeued tree node.
      hd = temp.hd;

      // Put the dequeued tree node to TreeMap having key
      // as horizontal distance. Every time we find a node
      // having same horizontal distance we need to replace
      // the data in the map.
      map.put(hd, temp.data);

      // If the dequeued node has a left child add it to the
      // queue with a horizontal distance hd-1.
      if (temp.left != null) {
        temp.left.hd = hd - 1;
        queue.add(temp.left);
      }

      // If the dequeued node has a left child add it to the
      // queue with a horizontal distance hd+1.
      if (temp.right != null) {
        temp.right.hd = hd + 1;
        queue.add(temp.right);
      }
    }
    
    // Traverse the map elements using the iterator.
    for (Map.Entry<Integer, Integer> me : map.entrySet()) {
      System.out.print(me.getValue() + " ");
    }
  }

  public static void main(String[] args) {
    Node root = new Node(20);
    root.left = new Node(8);
    root.right = new Node(22);
    root.left.left = new Node(5);
    root.left.right = new Node(3);
    root.right.left = new Node(4);
    root.right.right = new Node(25);
    root.left.right.left = new Node(10);
    root.left.right.right = new Node(14);
    BottomView tree = new BottomView(root);

    System.out.println("Bottom view of the given binary tree:");
    tree.bottomView();
  }
}
