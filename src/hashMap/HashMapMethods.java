package hashMap;

/**
 * Override only hashCode
 * 
 * MyClass first = new MyClass("a","first"); MyClass second = new
 * MyClass("a","second");
 * 
 * If you only override hashCode then when you call myMap.put(first,someValue)
 * it takes first, calculates its hashCode and stores it in a given bucket. Then
 * when you call myMap.put(second,someOtherValue) it should replace first with
 * second as per the Map Documentation because they are equal (according to our
 * definition).
 * 
 * But the problem is that equals was not redefined, so when the map hashes
 * second and iterates through the bucket looking if there is an object k such
 * that second.equals(k) is true it won't find any as second.equals(first) will
 * be false.
 * 
 * Override only equals
 * 
 * If only equals is overriden, then when you call myMap.put(first,someValue)
 * first will hash to some bucket and when you call
 * myMap.put(second,someOtherValue) it will hash to some other bucket (as they
 * have a different hashCode). So, although they are equal, as they don't hash
 * to the same bucket, the map can't realize it and both of them stay in the
 * map.
 * 
 * 
 * @author Pavitra
 *
 */

public class HashMapMethods {

	private final String importantField;
	private final String anotherField;

	public HashMapMethods(final String equalField, final String anotherField) {
		this.importantField = equalField;
		this.anotherField = anotherField;
	}

	public String getEqualField() {
		return importantField;
	}

	public String getAnotherField() {
		return anotherField;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((importantField == null) ? 0 : importantField.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final HashMapMethods other = (HashMapMethods) obj;
		if (importantField == null) {
			if (other.importantField != null)
				return false;
		} else if (!importantField.equals(other.importantField))
			return false;
		return true;
	}

}