package src;

/**
 * Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.
 *
 * Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abciiidef", k = 3
 * Output: 3
 * Explanation: The substring "iii" contains 3 vowel letters.
 * Example 2:
 *
 * Input: s = "aeiou", k = 2
 * Output: 2
 * Explanation: Any substring of length 2 contains 2 vowels.
 * Example 3:
 *
 * Input: s = "leetcode", k = 3
 * Output: 2
 * Explanation: "lee", "eet" and "ode" contain 2 vowels.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 * s consists of lowercase English letters.
 * 1 <= k <= s.length
 */

public class L1456_MaximumNumberOfVowelsInASubstringOfGivenLength {
    public int maxVowels(String s, int k) {
        int[] vowel = new int[6];
        int i = 0;
        while(i<k){
            vowel[identifyVowel(s.charAt(i))]++;
            i++;
        }

        int max = vowel[1] + vowel[2] + vowel[3] + vowel[4] + vowel[5];
        int j = 0;
        while(i<s.length()){
            vowel[identifyVowel(s.charAt(i++))]++;
            vowel[identifyVowel(s.charAt(j++))]--;
            max = Math.max(max, vowel[1] + vowel[2] + vowel[3] + vowel[4] + vowel[5]);
        }

        return max;
    }

    public int identifyVowel(char c){
        if(c == 'a'){
            return 1;
        }else if(c == 'e'){
            return 2;
        }else if(c == 'i'){
            return 3;
        }else if(c == 'o'){
            return 4;
        }else if(c == 'u'){
            return 5;
        }

        return 0;
    }
}
