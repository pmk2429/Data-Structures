package queue;

public class QueueArray {
  private static final int CAPACITY = 20;
  private final int[] QUEUE_ARR;
  private int front;
  private int rear;
  private int size;

  QueueArray() {
    QUEUE_ARR = new int[CAPACITY];
    front = -1;
    rear = -1;
    size = 0;
  }

  void push(int element) {
    if (rear == -1) {
      front = 0;
      rear = 0;
      QUEUE_ARR[rear] = element;
      size++;
    } else if (rear + 1 >= CAPACITY) {
      throw new IndexOutOfBoundsException("Overflow");
    } else if (rear + 1 < CAPACITY) {
      QUEUE_ARR[rear++] = element;
      size++;
    }
  }

  private boolean isEmpty() {
    return front == -1;
  }

  private void resetQueue() {
    front = -1;
    rear = -1;
  }

  // remove first element from the Array
  private int pop() {
    if (isEmpty()) {
      throw new IndexOutOfBoundsException("Empty Array");
    }
    size--;
    int keyElement = QUEUE_ARR[rear];
    // no element in array
    if (front == rear) {
      resetQueue();
    } else {
      front++;
    }
    return keyElement;
  }

  private int peek() {
    if (isEmpty()) {
      throw new IndexOutOfBoundsException("Array out of bounds");
    }

    return QUEUE_ARR[rear];
  }

  private void display() {
    if (front >= rear) {
      System.out.println("\nQueue : ");
      for (int i = front; i <= rear; i++) {
        System.out.print(QUEUE_ARR[i] + " ");
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    QueueArray queueDemo = new QueueArray();
    queueDemo.pop();
    queueDemo.push(23);
    queueDemo.push(2);
    queueDemo.push(73);
    queueDemo.push(21);
    queueDemo.push(58);
    queueDemo.push(16);
    queueDemo.pop();
    queueDemo.pop();
  }

}
