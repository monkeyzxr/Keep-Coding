/**
 * Created by monkeyzxr on 2017/7/11.
 *
 In the computer world, use restricted resource you have to generate maximum benefit is what we always want to pursue.

 For now, suppose you are a dominator of m 0s and n 1s respectively. On the other hand, there is an array with strings consisting of only 0s and 1s.

 Now your task is to find the maximum number of strings that you can form with given m 0s and n 1s. Each 0 and 1 can be used at most once.

 Note:
 The given numbers of 0s and 1s will both not exceed 100
 The size of given string array won't exceed 600.

 Example 1:
 Input: Array = {"10", "0001", "111001", "1", "0"}, m = 5, n = 3
 Output: 4
 Explanation: This are totally 4 strings can be formed by the using of 5 0s and 3 1s, which are “10,”0001”,”1”,”0”

 Example 2:
 Input: Array = {"10", "0", "1"}, m = 1, n = 1
 Output: 2
 Explanation: You could form "10", but then you'd have nothing left. Better form "0" and "1".
 *
 */

//题目大意：给定一组01字符串strs。求用m个0和n个1最多可以组成多少个strs中的字符串。

//思路： 建立一个二位的DP数组，
// 其中dp[i][j]表示有i个0和j个1时能组成的最多字符串的个数

//对于当前遍历到的字符串，我们统计出其中0和1的个数为zeros和ones，
// 然后dp[i - zeros][j - ones]表示当前的i和j减去zeros和ones之前能拼成字符串的个数，
// 那么加上当前的zeros和ones就是当前dp[i][j]可以达到的个数，我们跟其原有数值对比取较大值即可，所以递推式如下：
//dp[i][j] = max(dp[i][j], dp[i - zeros][j - ones] + 1);

    //http://www.cnblogs.com/grandyang/p/6188893.html
    //http://blog.csdn.net/mebiuw/article/details/53610396

    //好好想想 比较难懂
public class LC_474_OnesandZeroes {
    public static int findMaxForm(String[] strs, int m, int n) {
        int [][] dp = new int[m+1][n+1];

        for (String str : strs){
            int zeros = 0;
            int ones = 0;

            //统计当前String的0，1个数
            for (int i = 0; i < str.length(); i++){
                if (str.charAt(i) == '0')
                    zeros++;
                else
                    ones++;
            }

            //0,1个数 从最多个，递减，到当前String的个数。 得出dp的最大值。
            for (int i = m; i >= zeros; i--){ //i要大于等于 当前String中的 零的个数
                for (int j = n; j >= ones; j--){
                    /**
                     * dp表示以当前的能用的0和1 的组合，能获得的最大情况
                     * */
                    dp[i][j] = Math.max(dp[i][j], dp[i-zeros][j-ones] + 1);

                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        String[] test = {"10", "0001", "111001", "1", "0"};
        System.out.println(findMaxForm(test, 5, 3));

    }
}
