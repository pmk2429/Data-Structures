package tree.api;

import java.util.*;//for convenience, we incluce all from util package

public class TreeLevelPrint {
  // now we create a test case
  public static void main(String[] args) {
    // Let's create a binary tree
    // 1
    // 2 3
    // 4 5 6 7
    Tree myTree = new Tree(11);
    myTree.left = new Tree(6);
    myTree.right = new Tree(19);
    myTree.left.left = new Tree(4);
    myTree.left.right = new Tree(8);
    myTree.right.left = new Tree(17);
    myTree.right.right = new Tree(43);
    myTree.left.left.right = new Tree(5);
    myTree.left.right.right = new Tree(10);
    myTree.right.right.left = new Tree(31);
    myTree.right.right.right = new Tree(49);

    System.out.print("Queue-based method - 4th Level is ");
    PrintTreeLevel(myTree, 3);// let's try to print 3rd level with index 2
    // (start level 0)

    // now let's test the recursive method
    System.out.print("\nRecursion method - 4th Level is ");
    PrintTreeLevel(myTree, 0, 3);// Notice to call this method, we need
    // define an intial currentLevel=0
  }

  // now we try to implement 2nd method using recursion
  // it's ok we define method with same name but with different method
  // signature! Overload
  public static void PrintTreeLevel(Tree t, int currentLevel, int desire) {
    // firstly check if currentLevel>desire or the current tree is empty,
    // then return without going further
    if (t == null || currentLevel > desire)
      return;
    // now check if current==desire
    if (currentLevel == desire)
      System.out.print(t.value + " ");
    else {
      // proceed to its left and right sub-trees
      PrintTreeLevel(t.left, currentLevel + 1, desire);// do not forget to
      // update the
      // current level
      PrintTreeLevel(t.right, currentLevel + 1, desire);//
    }
  }

  // method 1, use Queue, so need to include java.util.Queue and LinkedList
  public static void PrintTreeLevel(Tree t, int desire)
  // no need to keep track current level for queue method
  {
    // firstly check if desire level is valid
    if (desire < 0)
      return;
    // now define two queues, one to store tree nodes, the other for current levels
    // note in java, Queue is an interface which can be inherited by
    // LinkedList!
    Queue<Tree> trees = new LinkedList<Tree>();
    Queue<Integer> levels = new LinkedList<Integer>();

    // start by pushing root node in the queue
    trees.add(t);
    levels.add(0);// start level is 0
    // now define a loop to continue while the queue is not empty
    while (!trees.isEmpty()) {
      Tree temp = trees.poll();// poll method is same as the conceptual
      // deque() method
      int currentLevel = levels.poll();// get the associated level
      if (temp == null)
        return;// before proceeding if current tree node is null, stop
      else if (currentLevel == desire)// we find a matched element in the
        // tree
        System.out.print(temp.value + " ");
      else// need continue to its child tree nodes
      {
        trees.add(temp.left);
        levels.add(currentLevel + 1);
        trees.add(temp.right);
        levels.add(currentLevel + 1);
      }
    }
  }
}

class Tree {
  public int value;
  public Tree left;
  public Tree right;

  public Tree(int a) {
    value = a;
    left = right = null;
  }
}
