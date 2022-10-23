package objectOrdering;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * This class implements both Comparable and Comparator
 */
class ComparableAndComparator {
    static void main(String[] args) {
        List<Dog> listOfDogs = new LinkedList<>();
        listOfDogs.add(new Dog("Labrador", 1));
        listOfDogs.add(new Dog("German Shepherd", 7));
        listOfDogs.add(new Dog("Alsation", 5));
        listOfDogs.add(new Dog("Golden Retriever", 2));
        listOfDogs.add(new Dog("Pug", 4));
        listOfDogs.add(new Dog("St. Bernard", 6));

        // Sorting the Dogs by Name:
        System.out.println("Sorting dogs by Name");
        Collections.sort(listOfDogs);
        for (Dog dog : listOfDogs) {
            System.out.println(dog.getName() + " : " + dog.getAge() + " years old");
        }

        // Sorting the Dogs by Name:
        System.out.println("\nSorting dogs by Age:");
        listOfDogs.sort(new Dog());
        for (Dog dog : listOfDogs) {
            System.out.println(dog.getAge() + " : " + dog.getName());
        }

    }
}

class Dog implements Comparator<Dog>, Comparable<Dog> {

    private String name;
    private int age;

    Dog() {
    }

    Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    int getAge() {
        return age;
    }

    void setAge(int age) {
        this.age = age;
    }

    // Overriding the compareTo() method to sort all dogs by name by
    @Override
    public int compareTo(Dog dog) {
        return (this.name).compareTo(dog.getName());
    }

    @Override
    public int compare(Dog dog1, Dog dog2) {
        return Integer.compare(dog1.getAge(), dog2.getAge());
    }

}
