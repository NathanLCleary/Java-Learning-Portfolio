package BasicJava.StringsAndFileInOut;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Lab4_Q3 {
    public static void main(String[] args) throws FileNotFoundException {
        /*
                get all files in the test file directory and store them into an array
                for all the files in the array, get a random number and swap said file with the random index file (swap)
         */
        File dir = new File("C://Users/13nat/IdeaProjects/softwareDev/StringsAndFileInOut.Test Files");

        File [] files = dir.listFiles();

        for(int i = 0; i < files.length; i++){
            int random = (int)(Math.random() * (files.length - 1));
            swap(files, i, random);
        }
    }

    public static void swap(File[] f, int i, int j) throws FileNotFoundException {
        /*
            read in the text from the first file and store it as a string (file1)
            read in the text from the second file and store it as a string(file2)

            write string file1 into the first file
            write string file2 into the second file
         */
        Scanner sc = new Scanner(f[i]);
        Scanner sc2 = new Scanner(f[j]);

        String file1 = "";
        String file2 = "";

        while(sc.hasNext()){
            file1 = file1 + " " + sc.next();
        }
        while(sc2.hasNext()){
            file2 = file2 + " " + sc2.next();
        }
        PrintWriter pw = new PrintWriter(f[i]);
        PrintWriter pw2 = new PrintWriter(f[j]);

        pw.println(file2);
        pw2.println(file1);

        pw.close();
        pw2.close();
    }

}
