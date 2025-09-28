package BasicJava.EasterCalculator;

import java.util.Scanner;
public class Easter {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int a, b, c, d, e, g, h, j, k, m, r, n, p= 0;
		int y = 0;
		System.out.println("Find out what date of BasicJava.EasterCalculator.Easter Sunday of a certain year");
		System.out.println("Enter the year: ");
		y = in.nextInt();
		a = y%19;
		b = y/100;
		c = y%100;
		d = b/4;
		e = b%4;
		g = (8 * b +13)/25;
		h = (19 * a + b - d - g + 15)%30;
		j = c/4;
		k = c%4;
		m = (a + 11 * h)/319;
		r = (2 * e + 2 * j - k - h + m + 32)%7;
		n = (h - m + r + 90)/25;
		p = (h - m + r + n + 19)%32;
		System.out.println("BasicJava.EasterCalculator.Easter Sunday is/was on the " +p +"/" +n +"/" +y);
	}

}
