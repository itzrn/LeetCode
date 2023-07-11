package src;

/*
To Find the length of The Longest word in the given sentence/String
 */


import java.util.Scanner;

public class L58_Variation {

    int big = 0;
    String word = "";
    public int longestWord(String string, int i) {// i initial value will be 0
        if (i == string.length()){
            if (big<word.length()){
                big = word.length();
            }
            return big;
        }
        if (string.charAt(i) == ' '){
            if (big < word.length()){
                big = word.length();
            }
            word = "";
            return longestWord(string,++i);
        }
        word = word + string.charAt(i);
        return longestWord(string,++i);
    }

}
