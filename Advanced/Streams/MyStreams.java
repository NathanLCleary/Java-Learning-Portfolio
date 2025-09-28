package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyStreams {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(9, 10, 13, 76, 8, -9);
		
		int num = list.stream().filter(i -> i > 10).mapToInt(i -> i).sum();
		
		//System.out.println(num);
		
		List<String> names = Arrays.asList("Andrew", "Brian", "Charlie", "Aaron", "Ed"); 
		char a = 'a';
		
		long counter = names.stream()
				.map(s -> s.toUpperCase())
				.filter(s -> s.charAt(0) == 'A')
				.count();
		
		//System.out.println(counter);
		
		List<Purchase> purchases = Arrays.asList(
				new Purchase("Shirt", 100.1),
				new Purchase("Shoes", 149.9),
				new Purchase("Jumper", 90.3)
		);
		
		double average = purchases.stream()
				.mapToDouble(p -> p.price)
				.filter(d -> d < 200 && d > 100)
				.average().getAsDouble();
		
		System.out.println(average);
	}
}
