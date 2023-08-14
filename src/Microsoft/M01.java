package src.Microsoft;

/**
 * You are given an Array A consisting N numbers. In one move you can delete either the first two, last two or the first and the last
 * elements of A.No move can be performed if the length of Array is smaller than 2. The result of each move is the sum of deleted elements.
 *
 * write a function
 *       int solution(int[] A, int N)
 * that gives an array A of N integers, return the maximum number of moves that can be performed on A, such that all performed moves have the same result.
 *
 * Ex ->
 * A -> [3,1,5,3,3,4,2] the function should return 3
 * the first move should delete two last element(4 and 2 with sum = 6), then A =[3,1,5,3,3] the second move may delete fist and the last elements,
 * (3 and 3 with sum 6) then, A =[1,5,3]. the third move may delete first two elements(1 and 5 with sum = 6), then A=[3]
 * moves taken ->3
 */
public class M01 {
    public int solution(int[]A, int N){
        if(A.length <=2){
            return 1;
        }

        // firstly with which sum we have to move forward, will get decide by the three sum's given bellow.
        int sum1 = A[0] + A[1];
        int sum2 = A[A.length-1] + A[A.length-2];
        int sum3 = A[0] + A[A.length-1];

        // so, using the above three sum we will calculate how many deletion can be done, and then we will return the largest count
        int count1 = sum(A, sum1);
        int count2 = sum(A, sum2);
        int count3 = sum(A, sum3);

        //calculating max of above three count
        int max = Math.max(count1,count2);
        if(count3>max){
            max=count3;
        }
        return max;
    }

    public int sum(int[]arr, int s){
        int a = 0;
        int b = arr.length-1;
        int sum1;
        int sum2;
        int sum3;
        int count = 0;

        // using two pointers to get the solution
        while (a<b){
            sum1 = arr[a] + arr[b];
            sum2 = arr[a] + arr[a+1];
            sum3 = arr[b] + arr[b-1];

            if(s == sum1){
                a++;
                b--;
                count++;
            }else if(s == sum2){
                a+=2;
                count++;
            }else if(s == sum3){
                b-=2;
                count++;
            }else {
                break;
            }

        }
        return count;
    }
}
