package tree.api;

import tree.api.core.BinarySearchTree;
import tree.api.core.Node;
import tree.api.exceptions.BoundaryViolationException;
import tree.api.exceptions.InvalidNodeException;

public class TreeDemo {
    public static void main(String[] args) throws BoundaryViolationException, InvalidNodeException {
        Integer[] a = {5, 1, 8, 6, 3, 9, 7, 2, 4, 15, 10};
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for (Integer n : a) bst.add(n);
        System.out.println();

        boolean check = bst.isRoot(5);

        int height = bst.height(9);
        System.out.println("height: " + height);

        Node<Integer> parent = bst.parent(5);

        System.out.println("Total leaves in Tree: " + bst.countLeaves());

        System.out.println();
        bst.preOrderTraversal();
        System.out.println();
//        bst.delete(1);
//        bst.deleteMin();
        bst.deleteMax();
        System.out.println("Again rearranged");
        bst.preOrderTraversal();

    }
}


class Animal implements Comparable<Animal> {
    String name;
    int age;

    public Animal() {
    }

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Animal o) {
        return 0;
    }
}