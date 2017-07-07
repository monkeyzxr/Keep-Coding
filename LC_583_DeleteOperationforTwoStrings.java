/**
 * Created by monkeyzxr on 2017/7/6.
 *
 Given two words word1 and word2,
 find the minimum number of steps required to make word1 and word2 the same,
 where in each step you can delete one character in either string.

 Example 1:
 Input: "sea", "eat"
 Output: 2

 Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".

 Note:
 The length of given words won't exceed 500.
 Characters in given words can only be lower-case letters.
 *
 */

/*
动态规划
实际上是找最长公共子序列
建立一个二维数组，dp[i][j]保存 (想象一个指针)到word1第i位和word2第j位时 最长公共的子序列的长度 .

思路：
实际上就是求两个字符串的相同部分，再用两个字符串的长度减去公共部分的长度，加和即为需要改变的次数。

简单的字符串编辑距离变种。
由于字符串只能有一种操作（删除）。所以实际上也就是求两个字符串最长相同子串（不要求连续，因为删除操作可以在任意位置）的长度。
动态转移方程为：(1) word1[i]=word2[j], dp[i][j]=dp[i-1][j-1]+1
             (2) word[i]!=word[j], dp[i][j]=max(dp[i-1][j],dp[i][j-1])。
 时间复杂度为o(n^2)。
 */

//http://www.itdadao.com/articles/c15a1361320p0.html
    //http://www.itdadao.com/articles/c15a1442748p0.html

public class LC_583_DeleteOperationforTwoStrings {
    public static int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();

        int[][] dp = new int[len1+1][len2+1];  //构造数组。动态规划的数组， 长度貌似都要比结果加1？？？
             //因为比较max的长度，一直要比较到最后一位，即第n-1位。所以要用比n-1位多一位的，来存放结果

        for (int i  = 0; i <= len1; i++){
            for (int j = 0; j <= len2; j++){
                //初始化
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else {
                    if (word1.charAt(i-1) == word2.charAt(j-1))
                        dp[i][j] = dp[i-1][j-1] + 1;

                    else
                        dp[i][j] =  Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return len1+len2 - dp[len1][len2]*2;   // 两个String的长度和 减去公共序列长度的2倍


    }

    public static void main(String[] args) {
        System.out.println(minDistance("sea", "eat"));


    }
}
