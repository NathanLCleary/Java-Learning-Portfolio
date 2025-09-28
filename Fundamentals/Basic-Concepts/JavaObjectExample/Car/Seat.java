package BasicJava.JavaObjectExample.Car;

import java.util.Scanner;

public class Seat {
    public static void main(String[] args) {
        boolean full;
        boolean [][] seat = new boolean[40][20];
        for (int i = 0; i < 40; i++){
            for (int j = 0; j < 20; j++){
                double temp = Math.random();
                if(temp < 0.5){
                    seat[i][j] = true;
                }
                else
                    seat[i][j] = false;
            }
        }

        Scanner in = new Scanner(System.in);
        System.out.println("Please enter row: ");
        int row = in.nextInt();
        System.out.println("Please enter column: ");
        int col = in.nextInt();

        if (seat[row][col] == true){
            System.out.println("That seat is booked");
        }
        else
            System.out.println("Car.Seat is free");
    }
}
