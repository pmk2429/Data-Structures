package objectOrdering.comparable;

public class Country implements Comparable<Country> {

  private int countryId;
  private String countryName;
  private long countryPopulation;

  Country(int countryId, String countryName, long countryPopulation) {
    this.countryId = countryId;
    this.countryName = countryName;
    this.countryPopulation = countryPopulation;
  }

  public int getCountryId() {
    return countryId;
  }

  public void setCountryId(int countryId) {
    this.countryId = countryId;
  }

  public String getCountryName() {
    return countryName;
  }

  public void setCountryName(String countryName) {
    this.countryName = countryName;
  }

  public long getCountryPopulation() {
    return countryPopulation;
  }

  public void setCountryPopulation(long countryPopulation) {
    this.countryPopulation = countryPopulation;
  }

  @Override
  public int compareTo(Country country) {
    return Long.compare(this.countryPopulation, country.countryPopulation);
  }

}
