/**
 * Created by monkeyzxr on 2017/5/31.
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.

 Design an algorithm to find the maximum profit.
 You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times).
 However, you may not engage in multiple transactions at the same time
 (ie, you must sell the stock before you buy again).

 网上列子：
 // 4 7 8 2 8
 最大利润很明显是 （8 - 4） + （8 - 2） = 10
 就因为这个式子让我想复杂了：首先要找到一个极小值4，然后找到极大值8；然后找到极小值2，然后找到极大值8；balabala……

 其实换一种思路，（7 - 4) + (8 - 7) + (8 - 2)
 区别在于，直接将后一个数减前一个数就好了呀，只不过如果后一个数比前一个数小的话就不考虑而已。
 *
 */


//http://cwind.iteye.com/blog/2255604
//https://leetcode.com/articles/best-time-buy-and-sell-stock-ii/
//http://blog.unieagle.net/2012/12/04/leetcode题目：best-time-to-buy-and-sell-stock-ii/

//贪心算法：在对问题求解时，总是做出在当前看来最好的选择。
// 即：不从整体上最优加以考虑，只求局部最优解。
// 对于此题情境，获得可能的最大利润的手段为：买入后的次日，只要股价上涨就卖出。同时如果后一天股价下跌则前一天不买入。
public class LC_122_BestTimeBuySellStockII {
    public static int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0)
            return 0;

        int profit = 0;
        for (int i = 1 ; i < prices.length; i++){
            int diff = prices[i] - prices[i-1];
            if(diff > 0)
                profit += diff;
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

        int[] test4 = {4,7,8,2,8};
        System.out.println(maxProfit(test4));
    }


}
