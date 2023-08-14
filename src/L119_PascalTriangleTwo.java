package src;

/**
 * Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.
 *
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class L119_PascalTriangleTwo {

    public List<Integer> getRow(int rowIndex) {
        Queue<List<Integer>> queue = new LinkedList<>();
        List<Integer> l = new ArrayList<>();
        l.add(1);
        queue.add(l);
        for(int i = 1;i<=rowIndex;i++){
            List<Integer> list = new ArrayList<>();
            for(int j = 0;j<=i;j++){
                if(j == 0 || j == i){
                    list.add(1);
                }else{
                    list.add(queue.peek().get(j)+ queue.peek().get(j-1));
                }
            }
            queue.add(list);
            queue.remove();
        }

        return queue.remove();
    }
}
