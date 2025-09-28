package BasicJava.JavaObjectExample.Account;

public class AccountDetails {

	public static void main(String[] args) {
		Account d = new Account("John", 12345678, 1000);
		System.out.println(d.getBalance());
		d.lodge(200);
		System.out.println(d.getBalance());
	}

}
