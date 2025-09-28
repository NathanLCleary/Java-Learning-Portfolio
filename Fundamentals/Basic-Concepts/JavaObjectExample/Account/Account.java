package BasicJava.JavaObjectExample.Account;

public class Account {
	private String accountHolder;
	private long accountNumber;
	private double balance; 
	
	public Account(){
		
	}
	
	public Account(String holder, long num, double bal) {
		this.accountHolder = holder;
		this.accountNumber = num;
		this.balance = bal;
	}
	
	public double getBalance() {
		return this.balance;
	}
	
	public void lodge(double cash) {
		this.balance = this.balance + cash;
	}
	public void withdraw(double cash) {
		this.balance = this.balance - cash;
	}
}
