package BasicJava.JavaObjectExample.Person;

public class PersonTest {

	public static void main(String[] args) {
		person p1 = new person();
		person p2 = new person("Mary");
		person p3 = new person("John", "Westmeath");
		
		p1.setName("Claire");
		p1.setAge(19);
		p1.setAddress("Dublin");
		
		p2.setAge(30);
		p2.setAddress("Galway");
		
		p3.setAge(24);
		
		System.out.println( p1.getName() + ", " + p1.getAge() +", " +p1.getAddress());
		System.out.println( p2.getName() + ", " + p2.getAge() +", " +p2.getAddress());
		System.out.println( p3.getName() + ", " + p3.getAge() +", " +p3.getAddress());
	}

}
