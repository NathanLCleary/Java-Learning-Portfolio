package BasicJava.StringsAndFileInOut;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Lab3_Q1_and_Q2 {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("C://Users/13nat/IdeaProjects/softwareDev/src/lab.txt");
        Scanner myReader = new Scanner(f);
        String words = "";
        int countWords = 0;
        int countVowels = 0;

        while(myReader.hasNext()){
            words = words +" " + myReader.next();
            countWords++;
        }

        for (int i = 0; i < words.length(); i++)
        {
            if (words.charAt(i) == 'a' || words.charAt(i) == 'e' || words.charAt(i) == 'i'
                    || words.charAt(i) == 'o' || words.charAt(i) == 'u')
            {
                countVowels++;
            }
        }
        //System.out.println(words);
        System.out.println("Words in the file: " +countWords);
        System.out.println("Vowels in the file: " +countVowels);
        System.out.println("Average vowels per word: " +(countVowels/countWords));
    }
}
