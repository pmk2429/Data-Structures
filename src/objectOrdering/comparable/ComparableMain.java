package objectOrdering.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
			System.out.println("Country Id: " + country.getCountryId() + "||"
					+ "Country name:" + country.getCountryName() + " || "
					+ country.getCountryPopulation());
		}

		/**
		 * By doing Collections.sort(listOfCountries), the Comparable will
		 * compare the objects based on the specified attributes according to
		 * natural ordering of the objects. Here, the compareTo() method sorts
		 * the listOfCountries list according to CountryPopulation attribute.
		 */
		System.out.println("\nAfter sorting Population wise using Comparable:");

		Collections.sort(listOfCountries);

		for (int i = 0; i < listOfCountries.size(); i++) {
			Country country = (Country) listOfCountries.get(i);
			System.out.println("Country Id: " + country.getCountryId() + " || "
					+ "Country name: " + country.getCountryName() + " || "
					+ country.getCountryPopulation());
		}
	}
}
