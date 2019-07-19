package list.linkedlist;

public class InsertInCyclicalList {

  static class Node {
    int val;
    Node next;

    public Node(int _val) {
      this.val = _val;
    }

    public Node(int _val, Node _next) {
      val = _val;
      next = _next;
    }
  }

  private static Node insert(Node head, int val) {
    if (head == null) {
      return new Node(val, null);
    }

    Node curr = head;
    while (val < curr.val) {
      curr = curr.next;
    }
    Node nodeToInsert = new Node(val);
    nodeToInsert.next = curr.next;
    curr.next = nodeToInsert;

    return head;
  }

  public static void main(String[] args) {
    Node n3 = new Node(3);
    Node n4 = new Node(4);
    Node n1 = new Node(1);
    n3.next = n4;
    n4.next = n1;
    n1.next = n3;

    Node head = insert(n3, 2);

    System.out.println(head.val);
  }
}
