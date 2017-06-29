import java.util.Arrays;

/**
 * Created by monkeyzxr on 2017/6/28.
 *
 Given a string s, find the longest palindromic substring in s.
 You may assume that the maximum length of s is 1000.

 Example:

 Input: "babad"

 Output: "bab"

 Note: "aba" is also a valid answer.

 Example:

 Input: "cbbd"

 Output: "bb"

 *
 */

//原始方法：一步一步的找最长的回文序列
//正确
    /*
public class LC_5_LongestPalindromicSubstring {
    public static String longestPalindrome(String s) {
        if (s == null)
            return null;
        if (s.length() == 1)
            return s;

        String longestStr = s.substring(0,1); //初始化为首字母，最短

        for (int i = 0; i < s.length(); i++){

            // get longest palindrome with center of i
            String tmp = getCurrLongest(s, i, i);  //这是在找回文序列是奇数个的情况
            if (tmp.length() > longestStr.length())
                longestStr = tmp;

            // get longest palindrome with center of i, i+1
            tmp = getCurrLongest(s, i, i+1); //这是在找回文序列是偶数个的情况
            if(tmp.length() > longestStr.length())
                longestStr = tmp;

        }

        return longestStr;

    }

    //给定一个中心字母，可能是一个字母（奇数长度），可能是两个字母（偶数长度），往其左右延伸，找最长的回文序列。
    public static String getCurrLongest(String s, int begin, int end){
        while (begin >= 0 && end <= s.length()-1 ){
            if (s.charAt(begin) == s.charAt(end)){
                begin--;
                end++;
            }
            else //一旦遇见两端不相等，就不是回文序列了，就跳出循环，这个是终止循环的条件， 必须写。不然无限循环。
                break;
        }

        //index: 0 1 2 3 4 5 6 7 8 9
         //      c a b b b b b b q u
        return s.substring(begin + 1, end); //为毛begin+1？ 因为循环到当前回文序列的两端时，while还会再进行一次循环，
                                           // 使begin和end都在当前回文序列的外扩的index上，
                                           // 所以substring的begin要加1，substring的end index不包括进去，不用加1
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abccd"));
        System.out.println(longestPalindrome("babad"));

    }
}
*/

//使用动态规划:
//维护一个二维数组dp，其中dp[i][j]表示字符串区间[i, j]是否为回文串
//当i = j时，只有一个字符，肯定是回文串，
// 如果i = j + 1，说明是相邻字符，此时需要判断s[i]是否等于s[j]，
// 如果i和j不相邻，即i - j >= 2时，除了判断s[i]和s[j]相等之外，dp[j + 1][i - 1]若为真，就是回文串
/*
dp[i, j]  =        1                                           if i == j

           =      s[i] == s[j]                                if j = i + 1

           =        s[i] == s[j] && dp[i + 1][j - 1]          if j > i + 1
*/

public class LC_5_LongestPalindromicSubstring {
    public static String longestPalindrome(String s) {
        if (s == null || s.length() <= 1)
            return s;

        boolean[][] dp = new boolean[s.length()][s.length()];
        for (boolean[] row : dp)
            Arrays.fill(row, false);

        int left = 0;
        int right = 0;
        int maxLen = 0;

        char[] arr = s.toCharArray();

        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < i; j++){

                if (i == j+1){
                    dp[j][i] = (arr[i] == arr[j]);
                }
                else if (i > j+1){
                    dp[j][i] = ((arr[j]==arr[i]) && (dp[j+1][i-1]));
                }

               // dp[j][i] = (s.charAt(i) == s.charAt(j) && (i - j < 2 || dp[j + 1][i - 1]));
                if (dp[j][i] && maxLen < i-j+1){
                    maxLen = i-j+1;
                    left = j;
                    right = i;
                }
            }

            dp[i][i] = true;
        }

        return s.substring(left, right-left+1);

    }


    public static void main(String[] args) {

        System.out.println(longestPalindrome("abccd"));
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cccc"));


    }
}
