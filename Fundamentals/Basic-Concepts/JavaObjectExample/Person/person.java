package BasicJava.JavaObjectExample.Person;

public class person {
	private String name;
	private String address;
	private int age;
	
	public person() {
		this.name = null;
		this.address = null;
		this.age = 0;
	}

	public person(String newName) {
		this.name = newName;
	}
	
	public person(String newName, String add) {
		this.name = newName;
		this.address = add;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public String getAddress() {
		return this.address;
	}
	
	public void setName(String newName) {
		this.name = newName;
	}
	
	public void setAge(int newAge) {
		this.age = newAge;
	}
	
	public void setAddress(String add) {
		this.address = add;
	}
	
	
}
	
	
	

