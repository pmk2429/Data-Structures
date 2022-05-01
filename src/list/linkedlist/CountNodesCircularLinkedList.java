package list.linkedlist;

/**
 * Count nodes in Circular linked list
 */
public class CountNodesCircularLinkedList {

    static class Node {
        int data;
        Node next;

        public Node() {
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private static Node push(Node head, int data) {
        Node first = new Node();
        Node temp = head;
        first.next = head;
        first.data = data;

        /* If linked list is not null then set the next of last node */
        if (head != null) {
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = first;
        }
        else {
            first.next = first; /* Circular list - For the first node */
        }

        head = first;
        return head;
    }

    /* Function to print nodes in a given Circular linked list */
    private static int countNodes(Node head) {
        Node temp = head;
        int count = 0;
        if (head != null) {
            do {
                temp = temp.next;
                count++;
            } while (temp != head);
        }

        return count;
    }

    public static void main(String[] args) {
        Node head = null;
        head = push(head, 12);
        head = push(head, 56);
        head = push(head, 2);
        head = push(head, 11);

        System.out.printf("%d", countNodes(head));
    }
}
