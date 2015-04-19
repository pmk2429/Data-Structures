package objectOrdering.comparator;

public class Country {
	int countryId;
	String countryName;
	long population;

	public Country(int countryId, String countryName, long population) {
		super();
		this.countryId = countryId;
		this.countryName = countryName;
		this.population = population;
	}

	public int getCountryId() {
		return countryId;
	}

	public long getPopulation() {
		return population;
	}

	public void setPopulation(long population) {
		this.population = population;
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

}
