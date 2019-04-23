package list.linkedlist;

public class MergeTwoLinkedLists {

  private static class Node {
    int data;
    Node next;

    Node(int data) {
      this.data = data;
      this.next = null;
    }
  }

  private static Node merge(Node l1, Node l2) {
    Node dummyHead = new Node(0);
    Node p = dummyHead;

    while (l1 != null && l2 != null) {
      if (l1.data < l2.data) {
        p.next = l1;
        l1 = l1.next;
      } else if (l2.data < l1.data) {
        p.next = l2;
        l2 = l2.next;
      }
      p = p.next;
    }
    if (l1 != null) {
      p.next = l1;
    }
    if (l2 != null) {
      p.next = l2;
    }
    return dummyHead.next;
  }

  public static void main(String[] args) {

  }
}

