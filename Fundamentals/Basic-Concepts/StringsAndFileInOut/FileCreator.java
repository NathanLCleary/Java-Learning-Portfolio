package BasicJava.StringsAndFileInOut;

import java.io.File;
import java.io.IOException;

public class FileCreator {
    public static void main(String[] args) throws IOException {

        for(int i = 1; i <= 5; i++){
            File myObj = new File("filename" + i + ".txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        }

    }
}
