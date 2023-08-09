package src;

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a
 * different day in the future to sell that stock.
 *
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 */
public class L121_BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {

        //try 1
        // int min = prices[0];
        // int i=1;
        // for(;i<prices.length;i++){
        //     if(prices[i]<min){
        //         min = prices[i];
        //         if (i== prices.length-1){
        //             break;
        //         }
        //     }else{
        //         i--;
        //         break;
        //     }
        // }
        // int max = prices[i];
        // i++;
        // for(;i<prices.length;i++){
        //     if(prices[i]>max){
        //         max = prices[i];
        //     }
        // }
        // return max - min;


        //try 2
        // int min=prices[0];
        // int i =0;
        // for(;i<prices.length-1;i++){
        //     if(prices[i]>=prices[i+1]){
        //         min = prices[i+1];
        //     }else{
        //         break;
        //     }
        // }

        // int max=prices[i];
        // for(;i<prices.length-1;i++){
        //     if(prices[i]<=prices[i+1]){
        //         max=prices[i+1];
        //     }
        // }
        // // System.out.println(min);
        // // System.out.println(max);
        // return max-min;

        int min = prices[0];  // initially keeping min and max same
        int max = prices[0];
        int result=0;  // keeping the record of the SP(selling price)
        for(int i = 1;i<prices.length;i++){
            if(prices[i]<min){  // if we get the new min which is less than the previous min, then we will restart the search of max
                min = prices[i];
                max = prices[i];
            }else if(prices[i]>max){  // after start/restart or max, we will search for the possible max in future
                max = prices[i];
            }
            if(result<max-min){  // keeping the result(SP), so in future if the SP get less,
                // then we will not change the result, means the previous SP is better than the current
                result=max-min;
            }
        }
        return result;
    }
}
