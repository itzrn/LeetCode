package src;

import java.util.List;

public class L139_WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        // dp[i] = true, identify, the word in the dictionary starting with s.charAt(i) is in the string, and we can break the string at i
        // dp[i] = false, identify that the word in the dictionary starting with s.charAt(i) is not in the string, where we can break the string
        boolean[] dp = new boolean[s.length()+1]; // making boolean dp array of length s.length()+1
        dp[s.length()] = true; // initializing dp[s.length()] = true

        // why we are initializing dp[s.length()] = true?, bcz when we start checking from index 0 and when we reach at index s.length()+1, then this index should be true,
        // which identifies the string s got broke fully on the basis of dictionary

        for(int i = s.length()-1;i>=0;i--){ // traversing back from s.length()-1 to 0, bcz if we can properly break the string, we will get d[0] = true

            for(String j : wordDict){ // this loop is like n nodes for every index of string
                if(i+j.length()<=s.length() && s.substring(i,i+j.length()).equals(j)){
                    dp[i] = dp[i+j.length()];
                }
                if(dp[i]){ // this condition is to make compiler know, that we already got the word starting from s.charAt(i) in the dictionary,
                    // no need to search for other words in the dictionary
                    break;
                }
            }

        }

        return dp[0]; // if dp[0] = true means we have successfully broke the word, else if dp[0] = false means the string can not be break on the basis of dictionary
    }
}
