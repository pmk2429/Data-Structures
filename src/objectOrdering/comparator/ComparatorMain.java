package objectOrdering.comparator;

import java.util.*;

public class ComparatorMain {
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

		System.out.println("Before Sorting countries");
		for (int i = 0; i < listOfCountries.size(); i++) {
			Country country = listOfCountries.get(i);
			System.out.println("Country ID: " + country.getCountryId() + " || "
					+ "Country Name: " + country.getCountryName());
		}

		// sort by ID
		System.out.println("\nAfter Sort by id: ");
		Collections.sort(listOfCountries, new CountrySortByIdComparator());
		for (int i = 0; i < listOfCountries.size(); i++) {
			Country country = (Country) listOfCountries.get(i);
			System.out.println("Country Id: " + country.getCountryId() + "|| "
					+ "Country name: " + country.getCountryName());
		}

		// Sort by country name
		System.out.println("\nAfter Sorting countries by Name:");
		Collections.sort(listOfCountries, new Comparator<Country>() {
			@Override
			public int compare(Country country1, Country country2) {
				return country1.getCountryName().compareTo(
						country2.getCountryName());
			}
		});
		for (int i = 0; i < listOfCountries.size(); i++) {
			Country country = (Country) listOfCountries.get(i);
			System.out.println("Country ID: " + country.getCountryId()
					+ " || Country Name: " + country.getCountryName() + " || "
					+ country.getPopulation());
		}

		// Sort by Country Population
		System.out.println("\nSorting the countries by Population:");
		Collections.sort(listOfCountries, new CountrySortByPopulation());
		for (int i = 0; i < listOfCountries.size(); i++) {
			Country country = listOfCountries.get(i);
			System.out.println("Country ID: " + country.getCountryId()
					+ " || Country Name: " + country.getCountryName() + " || "
					+ country.getPopulation());
		}

		// Comparator Definition
		Comparator<Country> comparator = new Comparator<Country>() {
			public int compare(Country o1, Country o2) {
				if (o1.countryName.equals(o2.countryName)) {
					return o1.countryName.compareTo(o2.countryName);
				}
				return o1.countryName.compareTo(o2.countryName);
			}
		};

	}
}
