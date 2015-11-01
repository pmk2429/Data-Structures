package map.hashMap.main;

public abstract class LivingBeing {
	int age;
	String type, name, gender;
	int weight;
	
	public abstract int countTotalLivingBeings();
	
	public abstract String determineBonding();
	
}
