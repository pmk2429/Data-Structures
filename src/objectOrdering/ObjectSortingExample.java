package objectOrdering;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * Java program to test Object sorting in Java. This Java program
 * test Comparable and Comparator implementation provided by Order
 * class by sorting list of Order object in ascending and descending order.
 * Both in natural order using Comparable and custom Order using Comparator in Java
 *
 * @author http://java67.blogspot.com
 */
public class ObjectSortingExample {

    public static void main(String args[]) {
      
        //Creating Order object to demonstrate Sorting of Object in Java
        Order ord1 = new Order(101,2000, "Sony");
        Order ord2 = new Order(102,4000, "Hitachi");
        Order ord3 = new Order(103,6000, "Philips");
      
        //putting Objects into Collection to sort
        List<Order> orders = new ArrayList<Order>();
        orders.add(ord3);
        orders.add(ord1);
        orders.add(ord2);
      
        //printing unsorted collection
        System.out.println("Unsorted Collection : " + orders);
      
        //Sorting Order Object on natural order - ascending
        Collections.sort(orders);
      
        //printing sorted collection
        System.out.println("List of Order object sorted in natural order : " + orders);
      
        // Sorting object in descending order in Java
        Collections.sort(orders, Collections.reverseOrder());
        System.out.println("List of object sorted in descending order : " + orders);
              
        //Sorting object using Comparator in Java
        Collections.sort(orders, new Order.OrderByAmount());
        System.out.println("List of Order object sorted using Comparator - amount : " + orders);
      
        // Comparator sorting Example - Sorting based on customer
        Collections.sort(orders, new Order.OrderByCustomer());
        System.out.println("Collection of Orders sorted using Comparator - by customer : " + orders);
    }
}

/*
 * Order class is a domain object which implements
 * Comparable interface to provide sorting on natural order.
 * Order also provides copule of custom Comparators to
 * sort object based uopn amount and customer
 */
class Order implements Comparable<Order> {

    private int orderId;
    private int amount;
    private String customer;

    /*
     * Comparator implementation to Sort Order object based on Amount
     */
    public static class OrderByAmount implements Comparator<Order> {

        @Override
        public int compare(Order o1, Order o2) {
            return o1.amount > o2.amount ? 1 : (o1.amount < o2.amount ? -1 : 0);
        }
    }

    /*
     * Another implementation or Comparator interface to sort list of Order object
     * based upon customer name.
     */
    public static class OrderByCustomer implements Comparator<Order> {

        @Override
        public int compare(Order o1, Order o2) {
            return o1.customer.compareTo(o2.customer);
        }
    }

    public Order(int orderId, int amount, String customer) {
        this.orderId = orderId;
        this.amount = amount;
        this.customer = customer;
    }

  
    public int getAmount() {return amount; }
    public void setAmount(int amount) {this.amount = amount;}

    public String getCustomer() {return customer;}
    public void setCustomer(String customer) {this.customer = customer;}

    public int getOrderId() {return orderId;}
    public void setOrderId(int orderId) {this.orderId = orderId;}

    /*
     * Sorting on orderId is natural sorting for Order.
     */
    @Override
    public int compareTo(Order o) {
        return this.orderId > o.orderId ? 1 : (this.orderId < o.orderId ? -1 : 0);
    }
  
    /*
     * implementing toString method to print orderId of Order
     */
    @Override
    public String toString(){
        return String.valueOf(orderId);
    }
}
