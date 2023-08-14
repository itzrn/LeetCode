package src;

import java.util.ArrayList;
import java.util.List;

public class L118_PascalTriangle {

    public List<List<Integer>> generate(int numRows){
        List<List<Integer>> dp = new ArrayList<>();
        List<Integer> curr;
        for(int i = 0;i<numRows;i++){  // this loop says the number of lines to be generated
            curr = new ArrayList<>();
            for(int j =  0;j<=i;j++){  // this loop says the number of elements should be in each line

                if(j == 0 || j == i){ // as we know, the first and the last element will be 1, therefore at index 0 and j==i(which iss the last element of the line) putting 1
                    curr.add(1);
                }else {
                    int a = dp.get(i-1).get(j);  // accessing the element of previous generated list
                    int b = dp.get(i-1).get(j-1); //  accessing the element of previous generated list
                    curr.add(a+b);  // doing summation and adding in the list

                    // the below line is the one line solution of above three lines
                    // curr.add(dp.get(i-1).get(j) + dp.get(i-1).get(j-1));
                }
            }
            dp.add(curr);
        }

        return dp;
    }

    public void pascalTriangleUsingArray(int numRows){
        int[][] arr = new int[numRows][numRows];
        for(int i = 0;i<numRows;i++){
            for (int  j = 0;j<=i;j++){
                if(j ==0 || j == i){
                    arr[i][j] = 1;
                }else {
                    arr[i][j] = arr[i-1][j] + arr[i-1][j-1];
                }
            }
        }

        for(int i = 0;i<numRows;i++){
            for (int j = 0;j<=i;j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        L118_PascalTriangle test = new L118_PascalTriangle();
        System.out.println(test.generate(10));
    }
}
