package list.linkedlist;

/**
 * {@link LinkedListMain} class in Ocean jar.
 *
 * @author Pavitra
 */
public class LinkedListMain {
    // reference to the head node.
    private Node head;
    private int listCount;

    // LinkedList constructor
    private LinkedListMain() {
        // this is an empty list, so the reference to the head node
        // is set to a new node with no data
        head = new Node(null);
        listCount = 0;
    }

    private void add(Object data)
    // post: appends the specified element to the end of this list.
    {
        Node temp = new Node(data);
        Node current = head;
        // starting at the head node, crawl to the end of the list
        while (current.getNext() != null) {
            current = current.getNext();
        }
        // the last node's "next" reference set to our new node
        current.setNext(temp);
        listCount++;// increment the number of elements variable
    }

    private void add(Object data, int index)
    // post: inserts the specified element at the specified position in this
    // list.
    {
        Node temp = new Node(data);
        Node current = head;
        // crawl to the requested index or the last element in the list,
        // whichever comes first
        for (int i = 1; i < index && current.getNext() != null; i++) {
            current = current.getNext();
        }
        // set the new node's next-node reference to this node's next-node
        // reference
        temp.setNext(current.getNext());
        // now set this node's next-node reference to the new node
        current.setNext(temp);
        listCount++;// increment the number of elements variable
    }

    private Object get(int index)
    // post: returns the element at the specified position in this list.
    {
        // index must be 1 or higher
        if (index <= 0) {
            return null;
        }

        Node current = head.getNext();
        for (int i = 1; i < index; i++) {
            if (current.getNext() == null) {
                return null;
            }
            current = current.getNext();
        }
        return current.getData();
    }

    private boolean remove(int index)
    // post: removes the element at the specified position in this list.
    {
        // if the index is out of range, exit
        if (index < 1 || index > size())
            return false;

        Node current = head;
        for (int i = 1; i < index; i++) {
            if (current.getNext() == null) {
                return false;
            }
            current = current.getNext();
        }
        current.setNext(current.getNext().getNext());
        listCount--; // decrement the number of elements variable
        return true;
    }

    private int size() { // post: returns the number of elements in this list.
        return listCount;
    }

    public String toString() {
        Node current = head.getNext();
        String output = "";
        while (current != null) {
            output += "[" + current.getData().toString() + "]";
            current = current.getNext();
        }
        return output;
    }

    private Node getHead() {
        return this.head;
    }

    public Node removeDuplicates(Node head) {
        Node returnNode = null;
        Node previous = head.next;
        if (previous.getData() == null) {
            System.out.println("NULL");
        }
        Node current = previous.next;
        while (current != null) {
            Node runner = head.next;
            while (runner != current) {
                if (runner.getData() == current.getData()) {
                    Node temp = current.next;
                    previous.next = temp;
                    current = temp;
                    returnNode = temp;
                    break;
                }
                runner = runner.next;
                return returnNode;
            }
            if (runner == current) {
                previous = current;
                current = current.next;
            }
        }
        return returnNode;

    }

    private class Node {
        // reference to the next node in the chain,
        // or null if there isn't one.
        Node next;
        // data carried by this node.
        // could be of any type you need.
        Object data;

        // Node constructor
        private Node(Object _data) {
            next = null;
            data = _data;
        }

        // another Node constructor if we want to
        // specify the node to point to.
        private Node(Object _data, Node _next) {
            next = _next;
            data = _data;
        }

        // these methods should be self-explanatory
        private Object getData() {
            return data;
        }

        private void setData(Object _data) {
            data = _data;
        }

        private Node getNext() {
            return next;
        }

        private void setNext(Node _next) {
            next = _next;
        }

    }
}
