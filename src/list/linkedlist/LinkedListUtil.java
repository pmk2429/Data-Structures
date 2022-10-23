package list.linkedlist;

public class LinkedListUtil {

    public static void display(ListNode head) {
        ListNode temp = head;
        if (head == null) {
            System.out.print("null\n");
            return;
        }
        while (temp != null) {
            System.out.printf("%d --> ", temp.data);
            temp = temp.next;
        }
        System.out.print("null\n");
    }

    public static ListNode newNode(int val) {
        return new ListNode(val, null);
    }

    public static ListNode create() {
        ListNode head = newNode(1);
        head.next = newNode(2);
        head.next.next = newNode(3);
        head.next.next.next = newNode(4);
        head.next.next.next.next = newNode(5);
        head.next.next.next.next.next = newNode(6);
        head.next.next.next.next.next.next = newNode(7);
        head.next.next.next.next.next.next.next = newNode(8);
        head.next.next.next.next.next.next.next.next = newNode(9);
        head.next.next.next.next.next.next.next.next.next = newNode(10);

        return head;
    }

    public static ListNode createSmall() {
        ListNode head = newNode(1);
        head.next = newNode(2);
        head.next.next = newNode(3);
        head.next.next.next = newNode(4);
        head.next.next.next.next = newNode(5);

        return head;
    }

    public static ListNode createWithDuplicates() {
        ListNode head = newNode(1);
        head.next = newNode(2);
        head.next.next = newNode(3);
        head.next.next.next = newNode(4);
        head.next.next.next.next = newNode(5);
        head.next.next.next.next.next = newNode(6);
        head.next.next.next.next.next.next = newNode(4);
        head.next.next.next.next.next.next.next = newNode(7);
        head.next.next.next.next.next.next.next.next = newNode(4);
        head.next.next.next.next.next.next.next.next.next = newNode(8);

        return head;
    }
}
