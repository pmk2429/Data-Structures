package objectOrdering.comparator;

import java.util.Comparator;

public class CountrySortByPopulation implements Comparator<Country> {

  @Override
  public int compare(Country country1, Country country2) {
    return Long.compare(country1.getPopulation(), country2.getPopulation());
  }

}
