package BasicJava.StringsAndFileInOut;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Lab4_Q2 {
    public static void main(String[] args) throws IOException {
        /*
            create 5 text files (filename(1-5))
            if those files already exist in the directory dont create them and skip

         */


        for(int i = 1; i <= 5; i++) {
            File myObj = new File("Test Files/filename" + i + ".txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        }
        /*

            count all the words in the file f
            divide the total number of words by 6 to split the words into 5 equal parts
            go through the file word by word and put the word into one of the strings words1, words2, words3, words4 or words5
            if it reaches a multiple of the fifths then write to the next string
            write each string into the corresponding file (words1 into filename1 ect.)
         */

        File f = new File("C://Users/13nat/IdeaProjects/softwareDev/src/lab.txt");

        Scanner myReader = new Scanner(f);
        int countWords = 0;
        while(myReader.hasNext()){
            myReader.next();
            countWords++;
        }

        int fifth = (countWords / 6);

        String words1 = "";
        String words2 = "";
        String words3 = "";
        String words4 = "";
        String words5 = "";

        System.out.println(fifth);
        int find = 0;
        Scanner myPrinter = new Scanner(f);

        while(myPrinter.hasNext()) {
            find++;
            if(find < (fifth * 2)){
                words1 = words1 + " " + myPrinter.next();
            }else if(find < (fifth * 3)){
                words2 = words2 + " " + myPrinter.next();
            }else if(find < (fifth * 4)){
                words3 = words3 + " " + myPrinter.next();
            }else if(find < (fifth * 5)){
                words4 = words4 + " " + myPrinter.next();
            }else{
                words5 = words5 + " " + myPrinter.next();
            }
        }
        PrintWriter first = new PrintWriter("C://Users/13nat/IdeaProjects/softwareDev/StringsAndFileInOut.Test Files/filename1.txt");
        first.println(words1);
        first.close();

        PrintWriter second = new PrintWriter("C://Users/13nat/IdeaProjects/softwareDev/StringsAndFileInOut.Test Files/filename2.txt");
        second.println(words2);
        second.close();

        PrintWriter third = new PrintWriter("C://Users/13nat/IdeaProjects/softwareDev/StringsAndFileInOut.Test Files/filename3.txt");
        third.println(words3);
        third.close();

        PrintWriter fourth = new PrintWriter("C://Users/13nat/IdeaProjects/softwareDev/StringsAndFileInOut.Test Files/filename4.txt");
        fourth.println(words4);
        fourth.close();

        PrintWriter fifthWriter = new PrintWriter("C://Users/13nat/IdeaProjects/softwareDev/StringsAndFileInOut.Test Files/filename5.txt");
        fifthWriter.println(words5);
        fifthWriter.close();
    }

}
