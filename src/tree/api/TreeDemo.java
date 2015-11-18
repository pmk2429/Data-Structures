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
//
//        BinarySearchTree<Animal> zoo = new BinarySearchTree<>();
//        Animal dog = new Animal("Tyson", 4);
//        Animal cat = new Animal("Kittie", 3);
//        Animal horse = new Animal("Seabiscuit", 6);
//
//
//        Node<Animal> node = zoo.parent(dog);
//
//
//        int depth = bst.depth(dog);

        boolean check = bst.isRoot(5);
        //System.out.println("is root: " + check);


        //System.out.println("Depth: " + bst.depth(9));
        int height = bst.height(9);
        System.out.println("height: " + height);

        Node<Integer> parent = bst.parent(5);
        //System.out.println(parent.toString());

        //bst.preOrderTraversal();
        //System.out.println();
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