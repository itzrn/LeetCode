package src;

/**
 * Given an array of strings words and an integer k, return the k most frequent strings.
 *
 * Return the answer sorted by the frequency from highest to lowest. Sort the words with the same frequency by their lexicographical order.
 *
 *
 *
 * Example 1:
 *
 * Input: words = ["i","love","leetcode","i","love","coding"], k = 2
 * Output: ["i","love"]
 * Explanation: "i" and "love" are the two most frequent words.
 * Note that "i" comes before "love" due to a lower alphabetical order.
 * Example 2:
 *
 * Input: words = ["the","day","is","sunny","the","the","the","sunny","is","is"], k = 4
 * Output: ["the","is","sunny","day"]
 * Explanation: "the", "is", "sunny" and "day" are the four most frequent words, with the number of occurrence being 4, 3, 2 and 1 respectively.
 *
 *
 * Constraints:
 *
 * 1 <= words.length <= 500
 * 1 <= words[i].length <= 10
 * words[i] consists of lowercase English letters.
 * k is in the range [1, The number of unique words[i]]
 *
 *
 * Follow-up: Could you solve it in O(n log(k)) time and O(n) extra space?
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class L692_TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {

        HashMap<String  , Integer> mp = new HashMap<>();
        for(String s : words){
            mp.put(s,mp.getOrDefault(s,0)+1);
        }

        PriorityQueue<L692_pair> pq = new PriorityQueue<>((p1, p2)->{ // this is the way to use lambda functions with conditions comparison
            if(p1.val==p2.val){
                return p1.s.compareTo(p2.s);
            }else{
                return p2.val-p1.val;
            }
        });

        for(String s : mp.keySet()){
            pq.add(new L692_pair(s,mp.get(s)));
        }

        List<String>ans = new ArrayList<>();
        while(k-- > 0){
            ans.add(pq.poll().s);
        }

        return ans;
    }
}

class L692_pair {
    String s ;
    int val;
    L692_pair(String s , int val) {
        this.s =s;
        this.val = val;
    }
}
