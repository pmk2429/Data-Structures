package tree.api;

import tree.api.core.BinaryTree;
import tree.api.core.Node;
import tree.api.exceptions.BoundaryViolationException;
import tree.api.exceptions.InvalidNodeException;

/**
 * Created by Pavitra on 10/18/2015.
 */
public class TreeDemo {
    public static void main(String[] args) throws BoundaryViolationException, InvalidNodeException {
//        Integer[] a = {1, 5, 2, 7, 4};
        Integer[] a = {5, 1, 8, 6, 3, 9};
        BinaryTree<Integer> bst = new BinaryTree<>();
        for (Integer n : a) bst.add(n);

        Node<Integer> parent = bst.parent(6);
        System.out.println(parent);

        bst.preOrderTraversal();
        System.out.println();
    }
}


class Animal implements Comparable<Animal> {
    String name;
    int age;

    public Animal() {
    }

    @Override
    public int compareTo(Animal o) {
        return 0;
    }
}