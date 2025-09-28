package BasicJava.StringsAndFileInOut;

public class Lab2_Q2 {
    public static void FindChar(char [][] myArray, char toFind){
        /*
            search through each index of the array to look for the letter (toFind)
         */
        for (int i = 0; i < myArray.length; i++) {
            for(int j = 0; j < myArray[i].length; j++){
                if (myArray[i][j] == toFind) {
                    System.out.println("Char " +toFind + " was found at index " +i +", " +j);
                }
            }
        }
    }

    public static void main(String[] args) {
        char[][] test = {
                {'a', 'b', 'c', 'd'},
                {'e', 'd', 'd', 'h'}
        };
        FindChar(test, 'd');
    }
}
