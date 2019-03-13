package dsprac;

import java.util.*;

/**
 * Created by Pavitra on 10/19/2014.
 */
public class HashMapDemo2 {
        public static void main(String[] args) {
            HashMap<DogTable2, Integer> hTable = new HashMap<DogTable2, Integer>();

            DogTable2 d1 = new DogTable2("red", 1);
            DogTable2 d2 = new DogTable2("black", 2);
            DogTable2 d3 = new DogTable2("white", 3);
            DogTable2 d4 = new DogTable2("orange", 4);
            DogTable2 d5 = new DogTable2("yellow", 5);
            DogTable2 d6 = new DogTable2("gray", 6);
            DogTable2 d7 = new DogTable2("white", 7);

            hTable.put(d1, 10);
            hTable.put(d2, 15);
            hTable.put(d3, 25);
            hTable.put(d4, 5);
            hTable.put(d5, 50);
            hTable.put(d6, 20);
            hTable.put(d7, 1);

            System.out.println("Insertion order not maintained: ");
            Set setTable = hTable.entrySet();
            Iterator iter = setTable.iterator();

            while (iter.hasNext()) {

                Map.Entry mapTable = (Map.Entry) iter.next();
                System.out.println(mapTable.getKey() + " : " + mapTable.getValue());
            }
            System.out.println("\nGetting Size by using enhanced For loop");
            for(DogTable2 dg2 : hTable.keySet()){
                int size = dg2.getSize();
                System.out.println("Size: " + size);
            }

            /**
             * While applying Collections on the HashMap, we need to make sure that
             * the Collection must be applied for either of Key or Value in HashMap
             * and like wise the HashMap method should be called
             *
             * for eg.:
             * 1) Consider HashMap<Dog, Integer> hMap= new HashMap<Dog,Integer>();
             * ---> For Key in Collection:
             *              Collection<Dog> dgCol = hTable.keySet();
             *
             *
             * 2) Consider HashMap<Integer, Dog> hMap= new HashMap<Integer,Dog>();
             * ---> For Values in Collection:
             *              Collection<Dog> dgCol = hTable.values();
             *
             * So it should be taken care of while calling appropriate Values
             * or Key method in HashMap for applying Collection.
             */
            System.out.println("\nGetting the DOG Object defined as Key in HashMap using COLLECTION<E>");
            Collection<DogTable2> dgCol = hTable.keySet();
            for(DogTable2 dg2 : dgCol){
                System.out.println(dg2.getSize() + " for " + dg2.getColor());
            }

            System.out.println("\nIterator over HashMap");
            Iterator<Integer> valueSetIterator = hTable.values().iterator();

            while(valueSetIterator.hasNext()){
                Integer value = valueSetIterator.next();
                System.out.println("Values: " + value);
            }


        }
    }

    class DogTable2 {
        String color;
        int size;

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        DogTable2(String c, int s) {
            color = c;
            size = s;

        }

        public String toString() {
            return color + " dog";
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }
    }

