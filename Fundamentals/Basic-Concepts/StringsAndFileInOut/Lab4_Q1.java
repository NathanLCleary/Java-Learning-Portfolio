package BasicJava.StringsAndFileInOut;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

public class Lab4_Q1 {
    public static void main(String[] args) throws FileNotFoundException {
        /*
            tested out a new way of doing things using a vector instead of an array

            create a vector of initial capacity of 10 but will grow in size to fit the amount of words in the text file
            print out every 5th index of the vector
         */
        File f = new File("C://Users/13nat/IdeaProjects/softwareDev/src/lab.txt");
        Scanner myReader = new Scanner(f);

        Vector words = new Vector(10);

        while(myReader.hasNext()){
            words.add(myReader.next());
        }

        for(int i = 0; i < words.size(); i = i +5){
            System.out.print(words.elementAt(i) + " ");
        }

    }
}
