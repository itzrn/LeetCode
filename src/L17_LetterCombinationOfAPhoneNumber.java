package src;
/*
 digits -> "23"
 taking about c
 a -> ad (added, backtrack) -> a
 a -> ae (added, backtrack) -> a
 a -> af (added, backtrack) -> a
 backtrack( at this point, c="")
 b -> bd(added, backtrack) -> b
 b -> be(added, backtrack) -> b
 b -> bf(added, backtrack) -> b
 backtrack( at this point, c="")
 c -> cd(added, backtrack) -> c
 c -> ce(added, backtrack) -> c
 c -> cf(added, backtrack) -> c
 backtrack( at this point, c="")

 on every backtrack, the last character of c getting remove(for that using substring)
 */


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class L17_LetterCombinationOfAPhoneNumber {
    HashMap<String, String> map;  // declared a HashMap to keep the mapping data
    public void mapping(){
        // this function is making the hashmap ready
        map = new HashMap<>();
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");
    }

    List<String> list;
    String c = "";
    public void combination(String digits, int a){
        if(Objects.equals(digits, "")){
            return;
        }else if(a == digits.length()){
            return;
        }
        String d = map.get(""+digits.charAt(a));  // d is storing mapped data, like for 2->abc
        for(int i = 0;i<d.length();i++){  // for every character of d making recursion
            c = c + d.charAt(i);
            combination(digits, a+1);  // this making compiler to enter the recursion for next sets of key value
            if(c.length() == digits.length()){
                list.add(c);
                c = c.substring(0, c.length() - 1); // while 1 step back tracking removing the last character
            }
        }
        if(c.length()!=0){  // this is kept in condition bcz it can be possible length of c be zero, so at that point this
            // condition stopping error
            // this also, while 1 step back tracking removing the last character.
            c = c.substring(0, c.length() - 1);
        }
    }

    public List<String> letterCombinations(String digits) {
        mapping();  // calling the mapping function to map all the data
        list = new ArrayList<>();  // initializing the list in which all the combination will get store
        combination(digits, 0);
        return list;

    }


    /* another way
     public List<String> letterCombinations(String digits) {
        mapping();
        if(digits.equals("")){
            return list;
        }
        recursion(digits.toCharArray(), 0, digits.length(), "");
        return list;
    }

    Map<Integer, String> map;
    public void mapping(){
        map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
    }
    List<String> list = new ArrayList<>();
    public void recursion(char[] digit, int index, int n, String str){
        if(index == n){
            list.add(str);
            return;
        }

        for(char i:map.get(digit[index]-'0').toCharArray()){
            recursion(digit, index+1, n, str+i);
        }
    }
     */
}
