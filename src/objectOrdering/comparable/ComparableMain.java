package objectOrdering.comparable;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 * This class demonstrates the implementation aspects of Comparable interface.
 * Comparable allows the natural object ordering of the class.
 * By implementing a Comparable, we can sort any Object in its natural order.
 * <p>
 * In the below mentioned example, Comparable is implemented on Population of countries.
 */
public class ComparableMain {
  public static void main(String[] args) {
    Country india = new Country(4, "India", 500);
    Country china = new Country(1, "China", 700);
    Country japan = new Country(7, "Japan", 100);
    Country usa = new Country(2, "USA", 200);

    List<Country> listOfCountries = new ArrayList<Country>();
    listOfCountries.add(india);
    listOfCountries.add(china);
    listOfCountries.add(japan);
    listOfCountries.add(usa);

    System.out.println("\nBefore Sorting: ");
    for (int i = 0; i < listOfCountries.size(); i++) {
      Country country = listOfCountries.get(i);
      System.out.println("Country Id: " + country.getCountryId() + "||" + "Country name:"
          + country.getCountryName() + " || " + country.getCountryPopulation());
    }

    /**
     * By doing Collections.sort(listOfCountries), the Comparable will
     * compare the objects based on the specified attributes according to
     * natural ordering of the objects. Here, the compareTo() method sorts
     * the listOfCountries list according to CountryPopulation attribute.
     */
    System.out.println("\nAfter sorting Population wise using Comparable:");

    Collections.sort(listOfCountries);

    for (Country country : listOfCountries) {
      Country c1 = (Country) country;
      System.out.println("Country Id: " + c1.getCountryId() + " || " + "Country name: "
          + c1.getCountryName() + " || " + c1.getCountryPopulation());
    }
  }
}
