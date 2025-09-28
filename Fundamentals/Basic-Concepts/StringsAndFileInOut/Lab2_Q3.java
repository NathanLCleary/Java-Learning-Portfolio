package BasicJava.StringsAndFileInOut;

public class Lab2_Q3 {
    public static void FindChar(String word1, String word2){
        /*
            find the common letter that appears in both of the words and storage the position of that letter
         */
        int i = 0;
        int j = 0;
        boolean found = false;
        while(!found && i < word1.length()){
            j = 0;
            while(!found && j < word2.length()){
                if(word1.charAt(i)== word2.charAt(j)){
                    //System.out.println("found");
                    found = true;
                    break;
                }
                    j++;
            }
            if(!found) {
                i++;
            }
        }

        char[][] words = new char[word1.length()+1][word2.length()+1];

        /*
            input the first word into the array to the correct column at which the common letter is (j)
         */
        for (int k = 0; k < (word1.length()); k++){
            words[k][j] = word1.charAt(k);
        }

        /*
            input the second word into the array to the correct row at which the common letter is (i)
         */
        for (int k = 0; k < (word2.length()); k++){
            words[i][k] = word2.charAt(k);
        }

        /*
            print out the array
         */
        for(char[] word : words) {
            for (int l = 0; l < words[0].length; l++) {
                System.out.print(word[l]);
            }
            System.out.println();
        }

        //System.out.println("Found in word1 at " +i +" and in word2 at " +j);
    }

    public static void main(String[] args) {
        FindChar("toll", "road");
    }
}
