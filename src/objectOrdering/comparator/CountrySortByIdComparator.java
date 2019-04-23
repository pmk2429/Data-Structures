package objectOrdering.comparator;

import java.util.Comparator;

public class CountrySortByIdComparator implements Comparator<Country> {
  public int compare(Country country1, Country country2) {
    return Integer.compare(country1.getCountryId(), country2.getCountryId());
  }
}
