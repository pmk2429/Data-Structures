package dsprac;

import java.util.*;

public class HashTableDemo {

	public static void main(String[] args) {
		Hashtable<DogTable, Integer> hTable = new Hashtable<DogTable, Integer>();

        DogTable d1 = new DogTable("red", 1);
        DogTable d2 = new DogTable("black", 2);
        DogTable d3 = new DogTable("white", 3);
        DogTable d4 = new DogTable("orange", 4);
        DogTable d5 = new DogTable("yellow", 5);
        DogTable d6 = new DogTable("gray", 6);
        DogTable d7 = new DogTable("white", 7);

		hTable.put(d1, 10);
        hTable.put(d2, 15);
        hTable.put(d3, 25);
        hTable.put(d4, 5);
        hTable.put(d5, 50);
        hTable.put(d6, 20);
        hTable.put(d7, 1);

        System.out.println("HashTable : Default Insertion order: ");
        System.out.println();
        Set setTable = hTable.entrySet();
		Iterator iter = setTable.iterator();
		while (iter.hasNext()) {
			Map.Entry mapTable = (Map.Entry) iter.next();
			System.out.println(mapTable.getKey() + " : " + mapTable.getValue());
        }


		System.out.println("\nSorting HashTable by values using Enumeration");
		Enumeration et = hTable.elements();
		while(et.hasMoreElements()){
			System.out.println(et.nextElement());
		}
		


	}
}

/**
 * Here, DogTable overrides hashCode() and equals() method for the Country sizwe
 * We can override equals() and hashCode() for Country color as well.
 */
class DogTable {
    String color;
    int size;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    DogTable(String c, int s) {
        color = c;
        size = s;

    }

    public boolean equals(Object o) {
        return ((DogTable) o).size == this.size;
        //return ((DogTable) o).color == this.color;
    }

    public int hashCode() {
        /**for Country color:
         * return color.length();
         */

        return size;
    }

    public String toString() {
        return color + " dog (size: " + getSize() + ") ";
    }
}