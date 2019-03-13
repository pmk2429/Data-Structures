package ADTs;

public class ListADT implements ListInterface {

  private static final int MAX_SIZE = 50;
  private Object items[]; //an array of list items
  private int numOfItems;

  public ListADT() {
    items = new Object[MAX_SIZE];
    numOfItems = 0;
  }

  public boolean isEmpty() {
    return (numOfItems == 0);
  }

  public int size() {
    return numOfItems;
  }

  public void removeAtIndex(int index) throws IndexOutOfBoundsException {

    if (index >= 1 && index <= numOfItems) {
      for (int pos = index + 1; pos <= size(); pos++) {
        items[translate(pos - 1)] = items[translate(pos)];
      }
      numOfItems--;
    } else {
      throw new IndexOutOfBoundsException();
    }

  }

  public void removeAll() {
    items = new Object[MAX_SIZE];
    numOfItems = 0;
  }

  /**
   * Add INTEGER method to add Integer, String Items to LIST.
   */
  public void add(int index, Object item) throws IndexOutOfBoundsException {

    if (numOfItems > MAX_SIZE) {
      System.out.println("exception caught...");
    }

    if (index >= 1 && index <= numOfItems + 1) {
      for (int pos = numOfItems; pos >= index; pos--) {
        items[translate(pos + 1)] = items[translate(pos)];
      }
      items[translate(index)] = item;
      numOfItems++;
    } else {
      System.out.println("Index out of Bounds");
    }
  }


  private void add(int index, int item) {

    if (numOfItems > MAX_SIZE) {
      System.out.println("exception caught...");
    }

    if (index >= 1 && index <= numOfItems + 1) {
      for (int pos = numOfItems; pos >= index; pos--) {
        items[translate(pos + 1)] = items[translate(pos)];
      }

      items[translate(index)] = Integer.valueOf(item); // converting Integer to Object.
      numOfItems++;
    } else {
      System.out.println("Index out of Bounds");
    }

  }


  private int translate(int pos) {
    return pos - 1;
  }


  public Object get(int index) throws IndexOutOfBoundsException {

    if (index >= 1 && index <= numOfItems) {
      return items[translate(index)];
    } else {
      throw new IndexOutOfBoundsException("Index out of range");
    }

  }

  //Main method
  public static void main(String[] args) {

    ListADT list = new ListADT();
    String dataItem;
    int intItem;

    System.out.println(list);

  }
}
