package heap.impl;

import java.util.Scanner;

public class BinaryHeapRun {

  public static void main(String[] args) {
    MinBinaryHeapInt heap = new MinBinaryHeapInt(10);
    heap.insert(3);
    heap.insert(5);
    heap.insert(9);
    heap.insert(6);
    heap.insert(7);
    heap.insert(10);
    heap.insert(16);
    heap.insert(12);
    heap.insert(14);
    heap.insert(8);

    heap.printHeap();

    System.out.println("3rd smallest element - " + heap.kthSmallest(3));

    System.out.println("Min Child of Node 6 - " + heap.get(heap.minChildIndex(3)));
    System.out.println("Max Child of Node 3 - " + heap.get(heap.maxChildIndex(3)));

    System.out.println("Max Element in this heap: " + heap.findMax());
//    heap.delete(1);
//    heap.printHeap();
//
//    System.out.println(heap.isMinHeap());
//    System.out.println(heap.isMaxHeap());
  }

  public static void demo() {
    Scanner scan = new Scanner(System.in);
    System.out.println("Binary Heap Test\n\n");
    System.out.println("Enter size of Binary heap");

    /** Make object of BinaryHeap **/
    MinBinaryHeapInt bh = new MinBinaryHeapInt(scan.nextInt());

    char ch;
    /** Perform Binary Heap operations **/
    do {
      System.out.println("\nBinary Heap Operations\n");
      System.out.println("1. insert ");
      System.out.println("2. delete getMin");
      System.out.println("3. check full");
      System.out.println("4. check empty");
      System.out.println("5. clear");

      int choice = scan.nextInt();
      switch (choice) {
        case 1:
          try {
            System.out.println("Enter integer element to insert");
            bh.insert(scan.nextInt());
          } catch (Exception e) {
            System.out.println(e.getMessage());
          }
          break;
        case 2:
          try {
            System.out.println("Min Element : " + bh.extractMin());
          } catch (Exception e) {
            System.out.println(e.getMessage());
          }
          break;
        case 3:
          System.out.println("Full status = " + bh.isFull());
          break;
        case 4:
          System.out.println("Empty status = " + bh.isEmpty());
          break;
        case 5:
          bh.makeEmpty();
          System.out.println("Heap Cleared\n");
          break;
        default:
          System.out.println("Wrong Entry \n ");
          break;
      }
      /** Display heap **/
      bh.printHeap();

      System.out.println("\nDo you want to continue (Type y or n) \n");
      ch = scan.next().charAt(0);
    } while (ch == 'Y' || ch == 'y');
  }
}
