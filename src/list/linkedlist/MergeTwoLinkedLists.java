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

    private static Node merge(Node listHead1, Node listHead2) {
        Node dummyHead = new Node(0);
        Node p = dummyHead;

        while (listHead1 != null && listHead2 != null) {
            if (listHead1.data < listHead2.data) {
                p.next = listHead1;
                listHead1 = listHead1.next;
            }
            else if (listHead2.data < listHead1.data) {
                p.next = listHead2;
                listHead2 = listHead2.next;
            }
            p = p.next;
        }
        if (listHead1 != null) {
            p.next = listHead1;
        }
        if (listHead2 != null) {
            p.next = listHead2;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {

    }
}

