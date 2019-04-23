package tree.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Check if a triplet with given sum exists in BST
 * Given a Binary Search Tree and a SUM. The task is to check if there exists any triplet(group of 3 elements)
 * in the given BST with the given SUM.
 * <p>
 * Examples:
 * ---------
 * Input : SUM = 21
 * Output : YES
 * There exists a triplet (7, 3, 11) in the
 * above given BST with sum 21.
 * <p>
 * Input : SUM = 101
 * Output : NO
 */
public class TripletSum {

  private static void inOrderTraversal(Node root, List<Integer> nodes) {
    if (root == null) {
      return;
    }

    inOrderTraversal(root.left, nodes);
    nodes.add(root.data);
    inOrderTraversal(root.right, nodes);
  }

  private static int[] findTripletSum(int[] nodesArr, int sum) {
    int[] tripletSum = new int[3];
    // Now, check if any triplet with given sum exists in the BST or not
    int l, r;

    // Now fix the first element one by one and find the other two elements
    for (int i = 0; i < nodesArr.length - 2; i++) {
      // To find the other two elements, start two index
      // variables from two corners of the array and move
      // them toward each other
      l = i + 1; // index of the first element in the remaining elements

      // index of the last element
      r = nodesArr.length - 1;
      tripletSum[0] = nodesArr[i];
      while (l < r) {
        if (nodesArr[i] + nodesArr[l] + nodesArr[r] == sum) {
          tripletSum[1] = nodesArr[l];
          tripletSum[2] = nodesArr[r];
          return tripletSum;
        } else if (nodesArr[i] + nodesArr[l] + nodesArr[r] < sum) {
          l++;
        } else {
          // vec[i] + vec[l] + vec[r] > sum
          r--;
        }
      }
    }
    return tripletSum;
  }

  public static void main(String[] args) {
    List<Integer> nodes = new ArrayList<>();

    Node root = new Node(19);
    // second level
    root.left = new Node(7);
    root.right = new Node(21);
    // third level
    root.left.left = new Node(3);
    root.left.right = new Node(11);
    // fourth level
    root.left.right.left = new Node(9);
    root.left.right.right = new Node(14);

    inOrderTraversal(root, nodes);

    int[] nodesArr = nodes.stream().mapToInt(i -> i).toArray();

    int sum = 21;
    System.out.println(Arrays.toString(findTripletSum(nodesArr, sum)));
    int sum1 = 101;
    System.out.println(Arrays.toString(findTripletSum(nodesArr, sum1)));
  }
}
