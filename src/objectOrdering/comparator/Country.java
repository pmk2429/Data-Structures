package objectOrdering.comparator;

public class Country {
  int countryId;
  String countryName;
  long population;

  Country(int countryId, String countryName, long population) {
    super();
    this.countryId = countryId;
    this.countryName = countryName;
    this.population = population;
  }

  int getCountryId() {
    return countryId;
  }

  long getPopulation() {
    return population;
  }

  void setPopulation(long population) {
    this.population = population;
  }

  void setCountryId(int countryId) {
    this.countryId = countryId;
  }

  String getCountryName() {
    return countryName;
  }

  void setCountryName(String countryName) {
    this.countryName = countryName;
  }

}
