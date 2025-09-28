package BasicJava.StringsAndFileInOut;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Lab3_Q3 {
    public static void main(String[] args) throws FileNotFoundException {

        // setting up variables to be used
        File f = new File("C://Users/13nat/IdeaProjects/softwareDev/src/lab.txt");
        Scanner myReader = new Scanner(f);
        String words = "";
        char [] charArray;
        int i = 0;

        // Read in the words of the txt file. Store them as a string. Remove punctuation.
        // Put each word into a char array and pass it through the swap method
        while(myReader.hasNext()){
            words = myReader.next();
            words = words.replace("'", "");
            words = words.replace(",", "");
            words = words.replace(";", "");
            words = words.replace(".", "");
            words = words.replace(":", "");
            words = words.replace("!", "");

            charArray = words.toCharArray();
            swap(charArray);
            i++;
        }
    }

    public static void swap(char [] word) {
        // for each letter of the word swap it with another random letter in the word
        // the first and last letter DO NOT get swapped (i and random index is never 0 or the last index)
        for(int i = 1; i < word.length - 1; i++){
            int randomIndex = (int) (Math.random() * (word.length - 2) + 1);
            char temp = word[i];
            word[i] = word[randomIndex];
            word[randomIndex] = temp;
        }
        System.out.println(word);
    }
}
