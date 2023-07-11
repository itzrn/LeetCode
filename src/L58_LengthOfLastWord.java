package src;
/*

Given a string s consisting of words and spaces, return the length of the last word in the string.
A word is a maximal substring consisting of non-space characters only.


Example 1:
Input: s = "Hello World"
Output: 5
Explanation: The last word is "World" with length 5.

Example 2:
Input: s = "luffy is still joyboy"
Output: 6
Explanation: The last word is "joyboy" with length 6.

Hidden TestCases----
Input: s = "   fly me   to   the moon  "
Output: 4
Explanation: The last word is "moon" with length 4.

Input: s = "Here   Coders   Come To Code  "
Output: 4
Explanation: the last word is "code" with length 4



Constraints:
    1 <= s.length <= 104
    s consists of only English letters and spaces ' '.
    There will be at least one word in s.


 */


import java.util.LinkedList;

public class L58_LengthOfLastWord {
    LinkedList<String> list = new LinkedList<>();
    String word = "";
    public void allWords(String string, int i){
        if (string.length() == i){
            if (word.length()>0){
                list.add(word);
            }
            return;
        }
        if (string.charAt(i) == ' '){
            if (word.length() > 0){
                list.add(word);
                word = "";
            }
            allWords(string,++i);
            return;
        }

        word = word + string.charAt(i);
        allWords(string,++i);
    }


    public int lengthOfLastWord(String s) {
        allWords(s, 0);
        return list.get(list.size()-1).length();
    }
}
