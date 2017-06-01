/**
 * Created by monkeyzxr on 2017/5/31.
 *
 Say you have an array for which the ith element is the price of a given stock on day i.

 If you were only permitted to complete at most one transaction
 (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

 Example 1:
 Input: [7, 1, 5, 3, 6, 4]
 Output: 5
 max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)

 Example 2:
 Input: [7, 6, 4, 3, 1]
 Output: 0
 In this case, no transaction is done, i.e. max profit = 0.
 *
 */

//在看每個項目的時候會做兩種動作，
// 一個是看看這個值是不是目前的最小值，是的話就assign新的最小值，
// 不是的話就那這個值扣掉最小值跟目前最大差距做比較，是目前最大的差距的話就assign新的最大差。
// 這個方式的複雜度是O(n)，因為它只要跑過一輪就能找出所求的最大差距。
// http://blog.csdn.net/DERRANTCM/article/details/47651235
//https://hankliu5.github.io/leetcode/2016/06/26/Best-Time-to-Buy-and-Sell-Stock.html

public class LC_121_BestTimeBuySellStock {
    public static int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0)
            return 0;

        int minPrice = prices[0];
        int profit = 0;

        for (int i = 1; i < prices.length; i++){
            //找到最低价
            if (minPrice > prices[i])
                minPrice = prices[i];

            else{ //如果当天价格高于最低价
                if (profit < prices[i]-minPrice)  //如果当前利润小于差值
                    profit = prices[i] - minPrice;    //更新利润，使利润最大
            }
        }

        return profit;
    }

    public static void main(String[] args) {
        int[] test1 ={7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(test1));

        int[] test2 = {7, 6, 4, 3, 1};
        System.out.println(maxProfit(test2));

        int[] test3 = {7, 6, 8, 3, 1};
        System.out.println(maxProfit(test3));
    }
}
