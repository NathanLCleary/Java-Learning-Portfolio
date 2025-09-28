package BasicJava.JavaObjectExample.Car;

public class Cars {
	
	private String make;
	private String model;
	private int year;
	private String owner;
	

	public Cars() {
		make = "Unknown make";
		model = "Unknown model";
		year = 0;
		owner = "Unknown owner";
	}
	
	public Cars(String make, String model, int year, String owner) {
		this.make = make;
		this.model = model;
		this.owner = owner;
		this.year = year;
	}
	
	public String getMake() {
		return this.make;
	}
	
	public String getModel() {
		return this.model;
	}
	
	public int getYear() {
		return this.year;
	}
	
	public String getOwner() {
		return this.owner;
	}
	
	public void setMake(String make) {
		this.make = make;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public void printDetails() {
		System.out.println(this.make);
		System.out.println(this.model);
		System.out.println(this.year);
		System.out.println(this.owner);
	}
	
}
