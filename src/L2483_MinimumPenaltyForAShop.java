package src;

/**
 * You are given the customer visit log of a shop represented by a
 * 0-indexed string customers consisting only of characters 'N' and 'Y':
 *
 *     if the ith character is 'Y', it means that customers come at the ith hour
 *     whereas 'N' indicates that no customers come at the ith hour.
 *
 * If the shop closes at the jth hour (0 <= j <= n), the penalty is calculated as follows:
 *
 *     For every hour when the shop is open and no customers come, the penalty increases by 1.
 *     For every hour when the shop is closed and customers come, the penalty increases by 1.
 *
 * Return the earliest hour at which the shop must be closed to incur a minimum penalty.
 *
 * Note that if a shop closes at the jth hour, it means the shop is closed at the hour j.
 *
 *
 *
 * Example 1:
 *
 * Input: customers = "YYNY"
 * Output: 2
 * Explanation:
 * - Closing the shop at the 0th hour incurs in 1+1+0+1 = 3 penalty.
 * - Closing the shop at the 1st hour incurs in 0+1+0+1 = 2 penalty.
 * - Closing the shop at the 2nd hour incurs in 0+0+0+1 = 1 penalty.
 * - Closing the shop at the 3rd hour incurs in 0+0+1+1 = 2 penalty.
 * - Closing the shop at the 4th hour incurs in 0+0+1+0 = 1 penalty.
 * Closing the shop at 2nd or 4th hour gives a minimum penalty. Since 2 is earlier, the optimal closing time is 2.
 *
 * Example 2:
 *
 * Input: customers = "NNNNN"
 * Output: 0
 * Explanation: It is best to close the shop at the 0th hour as no customers arrive.
 *
 * Example 3:
 *
 * Input: customers = "YYYY"
 * Output: 4
 * Explanation: It is best to close the shop at the 4th hour as customers arrive at each hour.
 *
 *
 *
 * Constraints:
 *
 *     1 <= customers.length <= 105
 *     customers consists only of characters 'Y' and 'N'.
 */

public class L2483_MinimumPenaltyForAShop {
    public int bestClosingTime(String customers) {
        if(customers.equals("N")){ // this is the base case
            return 0;
        }
        int sumN = 0;
        if(customers.charAt(0) == 'N'){ // base case
            sumN = 1;
        }
        int sumY = 0;
        for(int i = 0;i<customers.length();i++){ // counting all the Y in the String
            if(customers.charAt(i) == 'Y'){
                sumY += 1;
            }
        }
        int res=sumY; // when the shop get close at hour 0, its obvious penalty will be sumY and that time resi = 0

        int resi=0; // this is hour index

        int i = 1; // this i is getting use in the future , after completing the for loop so, initialized outside the for loop
        for(;i<customers.length();i++){ // here 4 cases will arise
            if(customers.charAt(i-1) == 'Y' && customers.charAt(i) == 'Y'){ // case 1
                if(res>sumY-1+sumN){ // if penalty is grater than the current penalty
                    res = sumY - 1 + sumN; // then change the penalty
                    resi = i; // change the hour index of the lowest penalty
                }
                sumY -= 1;
            }else if(customers.charAt(i-1) == 'Y' && customers.charAt(i) == 'N'){ // case 2
                if(res>sumY-1+sumN){ // if penalty is grater than the current penalty
                    res = sumY - 1 + sumN; // then change the penalty
                    resi = i; // change the hour index of the lowest penalty
                }
                sumY -= 1; // then decreasing sumY by 1, bcz all the indexes before this present index for Y there will be no penalty
                sumN += 1; // increasing sumN by 1, bcz we reached the index where which have N
            }else if(customers.charAt(i-1) == 'N' && customers.charAt(i) == 'Y'){ // case 3
                if(res>sumY + sumN){
                    res = sumY + sumN;
                    resi = i;
                }
            }else if(customers.charAt(i-1) == 'N' && customers.charAt(i) == 'N'){ // case 4
                if(res>sumY + sumN){
                    res = sumY + sumN;
                    resi = i;
                }
                sumN += 1;
            }
        }
        if(res>sumY-1+sumN){
            res = sumY-1+sumN;
            resi = i;
        }
        return resi;
    }
}
