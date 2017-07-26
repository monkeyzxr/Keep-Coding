/**
 * Created by monkeyzxr on 2017/7/25.
 *
 You are given coins of different denominations and a total amount of money amount.
 Write a function to compute the fewest number of coins that you need to make up that amount.
 If that amount of money cannot be made up by any combination of the coins, return -1.

 Example 1:
 coins = [1, 2, 5], amount = 11
 return 3 (11 = 5 + 5 + 1)

 Example 2:
 coins = [2], amount = 3
 return -1.

 Note:
 You may assume that you have an infinite number of each kind of coin.

 *
 */

//DP:
/*
思路：
dp，设dp[i] 为兑换目标i最少的硬币数。
则有：dp[i + coins[j] ] = min(dp[i + coins[j] ] , dp[i] + 1）
或者 dp[i] = min(dp[i – coins[j]] + 1,dp[i])
     */

//https://www.hrwhisper.me/leetcode-coin-change/
//http://www.programcreek.com/2015/04/leetcode-coin-change-java/

/*
Let dp[v] to be the minimum number of coins required to get the amount v.
dp[i+a_coin] = min(dp[i+a_coin], dp[i]+1) if dp[i] is reachable.
dp[i+a_coin] = dp[i+a_coin] if dp[i] is not reachable.
We initially set dp[i] to be MAX_VALUE.
 */

public class LC_322_CoinChange {
    public static int coinChange(int[] coins, int amount) {
        if (amount == 0)
            return 0;

        int[] dp = new int[amount+1];
        dp[0] = 0; // do not need any coin to get 0 amount

        for (int i = 1; i <= amount; i++){
            dp[i] = Integer.MAX_VALUE;    //初始化。求最小的dp，就初始化为最大值？？？ 总结一下！
        }


        for (int i = 0; i <= amount; i++){
           for (int j = 0; j< coins.length; j++){  //if里必须要判断 coin[j]不能等于Max_VALUE
               if (coins[j] != Integer.MAX_VALUE && i + coins[j] <= amount && dp[i]!= Integer.MAX_VALUE)
                   dp[i + coins[j]] = Math.min(dp[i + coins[j]], dp[i] + 1);
           }
        }


        if (dp[amount] >= Integer.MAX_VALUE)  //  2,147,483,647 = 0x7FFFFFFF
            return -1;

        return dp[amount];
    }

    public static void main(String[] args) {
        int[] coins1 = {1,2,5};
        System.out.println(coinChange(coins1, 11));

        int[] coins2 = {2};
        System.out.println(coinChange(coins2, 3));

        int[] coins3 = {2147483647};
        System.out.println(coinChange(coins3, 2));

        int[] coins4 = {1, 2147483647};
        System.out.println(coinChange(coins4, 2));



    }

}

