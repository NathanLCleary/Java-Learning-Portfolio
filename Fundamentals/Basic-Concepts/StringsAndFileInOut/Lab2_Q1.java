package BasicJava.StringsAndFileInOut;

public class Lab2_Q1 {
    public static void FindChar(char [] myArray, char toFind){
        /*
            search through each index of the array to look for the letter (toFind)
         */
        for (int i = 0; i < myArray.length - 1; i++) {
            if (myArray[i] == toFind) {
                System.out.println("Char " +toFind + " was found at index " +i);
            }
        }
    }
    public static void main(String[] args) {
        char[] test = {'a', 'b', 'c', 'd'};
        FindChar(test, 'c');
    }
}
