package src;

import java.util.HashMap;

public class L1189_MaximumNumberOfBalloon {
    public int maxNumberOfBalloons(String text) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(char i:text.toCharArray()){
            if(i=='b'||i=='a'||i=='l'||i=='o'||i=='n'){
                map.put(i,map.getOrDefault(i,0)+1);
            }
        }

        //who appers only once
        int m1=Math.min(map.getOrDefault('b',0),Math.min(map.getOrDefault('a',0),map.getOrDefault('n',0)));
        //for those who appers twice
        int m2=Math.min(map.getOrDefault('o',0),map.getOrDefault('l',0));
        //min one will decide how many balloons are there
        return Math.min(m2/2,m1);

    }
}
