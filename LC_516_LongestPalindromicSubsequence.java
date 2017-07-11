/**
 * Created by monkeyzxr on 2017/7/10.
 *
 Given a string s, find the longest palindromic subsequence's length in s.
 You may assume that the maximum length of s is 1000.

 Example 1:
 Input:

 "bbbab"
 Output:
 4
 One possible longest palindromic subsequence is "bbbb".

 Example 2:
 Input:

 "cbbd"
 Output:
 2
 One possible longest palindromic subsequence is "bb".

 *
 */

/*
这道题给了我们一个字符串，让我们求最大的回文子序列，子序列和子字符串不同，不需要连续。
而关于回文串的题之前也做了不少，处理方法上就是老老实实的两两比较吧。
像这种有关极值的问题，最应该优先考虑的就是贪婪算法和动态规划，这道题显然使用DP更加合适。
我们建立一个二维的DP数组，其中dp[i][j]表示[i,j]区间内的字符串的最长回文子序列，
那么对于递推公式我们分析一下，
如果s[i]==s[j]，那么i和j就可以增加2个回文串的长度，我们知道中间dp[i + 1][j - 1]的值，那么其加上2就是dp[i][j]的值。
如果s[i] != s[j]，那么我们可以去掉i或j其中的一个字符，然后比较两种情况下所剩的字符串谁dp值大，就赋给dp[i][j]，那么递推公式如下：

              /  dp[i + 1][j - 1] + 2                       if (s[i] == s[j])

dp[i][j] =

              \  max(dp[i + 1][j], dp[i][j - 1])        if (s[i] != s[j])
 */

//http://blog.jerkybible.com/2017/02/27/LeetCode-516-Longest-Palindromic-Subsequence/
    //http://www.cnblogs.com/grandyang/p/6493182.html
    //http://www.programcreek.com/2013/12/leetcode-solution-of-longest-palindromic-substring-java/
public class LC_516_LongestPalindromicSubsequence {
    public static int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0)
            return 0;

        //dp[i][j]表示[i,j]区间内的字符串的最长回文子序列
        int[][] dp = new int[s.length()][s.length()];

        for (int i = s.length()-1; i >= 0; i--){
            dp[i][i] = 1;

            for (int j = i+1; j < s.length(); j++){
                if (s.charAt(i) == s.charAt(j))
                    dp[i][j] = dp[i+1][j-1] + 2;
                else
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
            }

        }

        return dp[0][s.length()-1];  //从起始到最后一位 区间内的 最长回文序列
    }

    public static void main(String[] args) {
        System.out.println(longestPalindromeSubseq("bbbab"));
    }
}
