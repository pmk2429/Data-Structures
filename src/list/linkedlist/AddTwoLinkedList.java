package list.linkedlist;

import java.util.LinkedList;
import java.util.List;

public class AddTwoLinkedList {
  public static void main(String[] args) {
    List<Integer> list1 = new LinkedList<>();
    List<Integer> list2 = new LinkedList<>();
    AddTwoLinkedList addListObj = new AddTwoLinkedList();

    list1.add(3);
    list1.add(5);
    list1.add(9);

    list2.add(5);
    list2.add(9);
    list2.add(8);
    // 3 -> 5 -> 9
    //
    // 5 -> 9 -> 8
    LinkedList<Integer> listSum;
    listSum = addListObj.addLinkedList(list1, list2);
    System.out.println(listSum);

  }

  public LinkedList<Integer> addLinkedList(List<Integer> list1, List<Integer> list2) {
    LinkedList<Integer> listSum = new LinkedList<Integer>();
    int length = list1.size();
    int remainder = 0, temp = 0, carry = 0;
    for (int i = 0; i < length; i++) {
      temp = list1.get(i) + list2.get(i);
      if (temp > 9) {
        remainder = temp - 10;
        temp = remainder + carry;
        carry = 1;
      } else {
        temp = list1.get(i) + list2.get(i) + carry;
      }
      listSum.add(temp);
    }
    return listSum;
  }
}
