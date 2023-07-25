package list.linkedlist;

/**
 * All things LinkedList implementation.
 *
 * @author Pavitra
 */
public class LinkedListMain {
    private final Node head;
    private int listCount;

    // LinkedList constructor
    private LinkedListMain() {
        // this is an empty list, so the reference to the head node
        // is set to a new node with no data
        head = new Node(null);
        listCount = 0;
    }

    /**
     * Appends the specified element to the end of this list.
     */
    private void add(Object data) {
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

    /**
     * Inserts the specified element at the specified position in this
     */
    private void add(Object data, int index) {
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

    /**
     * Returns the element at the specified position in this list.
     */
    private Object get(int index) {
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

    /**
     * Removes the element at the specified position in this list.
     */
    private boolean remove(int index) {
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

    private int size() {
        return listCount;
    }

    public String toString() {
        Node current = head.getNext();
        StringBuilder output = new StringBuilder();
        while (current != null) {
            output.append("[").append(current.getData().toString()).append("]");
            current = current.getNext();
        }
        return output.toString();
    }

    private Node getHead() {
        return this.head;
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
