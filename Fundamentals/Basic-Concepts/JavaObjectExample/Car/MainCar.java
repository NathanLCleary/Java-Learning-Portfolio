package BasicJava.JavaObjectExample.Car;

public class MainCar {

	public static void main(String[] args) {
		
		Cars c1 = new Cars();
		Cars c2 = new Cars();
		Cars c3 = new Cars();
		Cars c4 = new Cars("ford", "focus", 2010, "michael");
		Cars c5 = new Cars("nissan", "xtrail", 2019, "billy");
		Cars c6 = new Cars("tayota", "corolla", 2004, "mary");
		
		c1.printDetails();
		System.out.println();
		
		c2.printDetails();
		System.out.println();
		
		c3.printDetails();
		System.out.println();

		System.out.println(c4.getMake() + " " +c4.getModel() + " " +c4.getYear() +" " + c4.getOwner());
		System.out.println(c5.getMake() + " " +c5.getModel() + " " +c5.getYear() +" " + c5.getOwner());
		System.out.println(c6.getMake() + " " +c6.getModel() + " " +c6.getYear() +" " + c6.getOwner());

	}

}
