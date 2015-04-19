package objectOrdering;

/**
 * This class implements both Comparable and Comparator
 */

import java.util.*;

public class ComparableAndComparator {
	public static void main(String[] args) {
		List<Dog> listOfDogs = new LinkedList<Dog>();
		listOfDogs.add(new Dog("Labrador", 1));
		listOfDogs.add(new Dog("German Shepherd", 7));
		listOfDogs.add(new Dog("Alsation", 5));
		listOfDogs.add(new Dog("Golden Retriever", 2));
		listOfDogs.add(new Dog("Pug", 4));
		listOfDogs.add(new Dog("St. Bernard", 6));

		// Sorting the Dogs by Name:
		System.out.println("Sorting dogs by Name");
		Collections.sort(listOfDogs);
		for (int i = 0; i < listOfDogs.size(); i++) {
			Dog dog = listOfDogs.get(i);
			System.out.println(dog.getName() + " : " + dog.getAge()
					+ " years old");
		}

		// Sorting the Dogs by Name:
		System.out.println("\nSorting dogs by Age:");
		Collections.sort(listOfDogs, new Dog());
		for (int i = 0; i < listOfDogs.size(); i++) {
			Dog dog = listOfDogs.get(i);
			System.out.println(dog.getAge() + " : " + dog.getName());
		}

	}
}

class Dog implements Comparator<Dog>, Comparable<Dog> {

	private String name;
	private int age;

	public Dog() {
	}

	public Dog(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	// Overriding the compareTo() method to sort all dogs by name by
	// implementing Comparable
	@Override
	public int compareTo(Dog dog) {
		return (this.name).compareTo(dog.getName());
		/**
		 * OR return(this.name < dog.name) ? -1 : (this.name > dog.name) ? 1 :
		 * 0;
		 */
	}

	// Overriding the compare() method to sort dogs by age by implementing
	// Comparator interface
	@Override
	public int compare(Dog dog1, Dog dog2) {
		return (dog1.getAge() < dog2.getAge()) ? -1 : (dog1.getAge() > dog2
				.getAge()) ? 1 : 0;
	}

}
