package Practice;


import java.util.*;

public class HashMapDemo {
	Car car = new Car();
	public static Map carList;
	public static void main(String[]args){
		carList = new HashMap<Integer, Car>();
		
		carList.put(1, new Car(4, "hatchback", "black", "Toyota"));
		carList.put(2, new Car(5, "pickup", "red", "Chrysler"));
		carList.put(3, new Car(6, "SUV", "white", "Audi"));
		carList.put(4, new Car(7, "coupe", "grey", "Mercedez"));
		carList.put(5, new Car(8, "roadster", "Yellow", "Tesla"));
		
		
		Collection<Car> values = carList.values();
		for(Car c : values){
			System.out.println(c.getMake() + " of " + c.getColor() + " color");
		}
}

			
		
		
}



class Car{
	int numOfGears;
	String type;
	String color;
	String make;
	
	public Car(){
		numOfGears = 5;
		type = "Sedan";
		color = "White";
		make = "Ford";
	}
	
	public Car(int numOfGears, String type, String color, String make){
		this.numOfGears = numOfGears;
		this.type = type;
		this.color = color;
		this.make = make;
	}
	
	public int getNumOfGears() {
		return numOfGears;
	}

	public void setNumOfGears(int numOfGears) {
		this.numOfGears = numOfGears;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}
}