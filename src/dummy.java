package src;

import java.util.*;

public class dummy {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        String str = (new Scanner(System.in)).nextLine();
        Set<Character>[] set = new HashSet[26];
        set[1].size();

        List<Integer> list = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
//        map.putAll(map);

        Map<Integer,Integer> mapw = new HashMap<>(map);
//        List<Integer>[] graph = new ArrayList<Integer>[10];

        PriorityQueue<int[]> p = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        map.put(1,0);
        map.put(2,0);
//        Set<Integer> t= ;
//        System.out.println(t);

//        pq.add(1);
//        pq.add(2);
//        pq.add(3);
//        pq.add(4);
//        System.out.println(pq);
//        pq.remove(3);
//        System.out.println(pq);

        Map<Integer, int[]> m = new HashMap<>();
        ArrayList<int[]>[] graph = new ArrayList[10];
        int t=(new Scanner(System.in)).nextInt();
        switch (t){
            case 1 : {
                System.out.println(1);
            }

            case 2 :{System.out.println(""); System.out.println("Ar"); System.out.println("p");}

        }
        int a = 'P';
        char c = 97;
    }

    PriorityQueue<Character> pq = new PriorityQueue<>();
    public String recursion(String s, int index){
        if(index == -1){
            return "";
        }
        char temp = s.charAt(index);
        if(isVowel(temp)){
            pq.offer(temp);
        }

        return recursion(s, index-1);
    }

    public boolean isVowel(char temp){
        return temp == 'A' || temp == 'E' || temp == 'I' || temp == 'O' || temp == 'U' || temp == 'a' || temp == 'e' || temp == 'i' || temp == 'o' || temp == 'u';
    }
}
