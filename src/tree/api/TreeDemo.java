package tree.api;

/**
 * Created by Pavitra on 10/18/2015.
 */
public class TreeDemo {
    public static void main(String[] args) {
        Integer[] a = {1, 5, 2, 7, 4};
        BinaryTree<Integer> bst = new BinaryTree<>();
        for (Integer n : a) bst.add(n);

        bst.preOrderTraversal();
        System.out.println();
    }
}
