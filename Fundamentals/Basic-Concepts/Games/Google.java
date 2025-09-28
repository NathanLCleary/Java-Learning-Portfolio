package BasicJava.Games;

import java.util.Scanner;
public class Google 
{
	public static void main(String[] args)
	{
		Scanner user = new Scanner(System.in);
		int pile = (int)(Math.random()*100);
		int playedNum = 0;
		System.out.println("The size of the pile is "+pile);
		int turn = (int)(Math.random()+.5); // 1 is computer
		int smart = (int)(Math.random()+.5); //0 = computer is dumb
		while(pile > 0)
		{
			while (turn == 0) //player turn
			{
				System.out.println("Pick a number to take from the pile");
				playedNum = user.nextInt();
				if (playedNum <= pile/2 && playedNum != 0)
				{
					pile = pile - playedNum;
					System.out.println("The size of the pile is " +pile);
					turn++;
				}
				else 
				{
					System.out.println("The number must be less than half the remaining marbles");
				}
			}
			while (turn == 1) //computer turn
			{
				if (smart == 0) //dumb computer
				{
					playedNum = (int)(Math.random()*100);
					if (playedNum <= pile/2 && playedNum != 0)
					{
						pile = pile - playedNum;
						System.out.println("The computer played " +playedNum);
						System.out.println("The size of the pile is " +pile);
						turn--;
					}
				}
				else //smart computer
				{
					if (pile > 63)
					{
						pile = 63;
					}
					else if (pile > 31)
					{
						pile = 31;
					}
					else if (pile > 15)
					{
						pile = 15;
					}
					else if (pile > 7)
					{
						pile = 7;
					}
					else if (pile > 3)
					{
						pile = 3;
					}
					else 
					{
						pile = 1;
					}
				}
				
			}
			if (pile == 1)
	        {
	            if (turn == 0)
	            {
	                System.out.println ("You Win!");
	            }  
	            else
	            {
	                System.out.println ("You're horrible...you lost to a computer.");
	            }  
	        }
		}
	}

}
