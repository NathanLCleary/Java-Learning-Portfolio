package BasicJava.fibonaccinumbers;

public class FibonacciGenerator {
	

	public int validateN(int number)
	{
		// Valid range is 1 to 46
		if (number <= 0 || number > 46)
		{
			return -99;
		}
		else
		{
			return number;
		}
	}
	
	public int calculateNthValue(int number)
	{
		//Validating the number
		int n = validateN(number);
		
		if (n == number)
		{
			 int f1 = 0;
			 int f2 = 1; 
			 int finNum = 0;     
			  
			 if (n == 1)
			 {
				 finNum = f2;
			 }
			 else 
			 {
				 for(int i = 2; i <= n; ++i)    
				 {    
					 finNum = f1 + f2;    
					 f1 = f2;    
					 f2 = finNum;    
				 }   
			 }
			  
			 return finNum;
		}
		else
		{
			return n;
		}
		
	}
}
