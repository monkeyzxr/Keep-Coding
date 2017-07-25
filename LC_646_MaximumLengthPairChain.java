import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by monkeyzxr on 2017/7/24.
 *
 You are given n pairs of numbers. In every pair, the first number is always smaller than the second number.

 Now, we define a pair (c, d) can follow another pair (a, b) if and only if b < c.
 Chain of pairs can be formed in this fashion.

 Given a set of pairs, find the length longest chain which can be formed. You needn't use up all the given pairs.
 You can select pairs in any order.

 Example 1:
 Input: [[1,2], [2,3], [3,4]]
 Output: 2
 Explanation: The longest chain is [1,2] -> [3,4]

 Note:
 The number of given pairs will be in the range [1, 1000].
 *
 */

//DP：

    //https://discuss.leetcode.com/topic/96824/java-solution-10-lines-dp
    //http://www.geeksforgeeks.org/dynamic-programming-set-20-maximum-length-chain-of-pairs/

    /*
    This problem is a variation of standard Longest Increasing Subsequence problem. Following is a simple two step process.
1) Sort given pairs in increasing order of first (or smaller) element.
2) Now run a modified LIS process where we compare the second element of already finalized LIS with the first element of new LIS being constructed.
     */
public class LC_646_MaximumLengthPairChain {
    public static int findLongestChain(int[][] pairs) {

        Arrays.sort(pairs, new Comparator<int[]>() {  //Sort given pairs in increasing order of first (or smaller) element.
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];  //每个array的第一个元素，按照升序排列
            }
        });

        int n = pairs.length;
        int[] dp = new int[n];   // dp[i] stores the maximum chain length ending with pair i

        int max = 0;

        for (int i = 0; i < n; i++){
            dp[i] = 1; //Initialize MCL (max chain length) values for all indexes
        }


        for (int i  = 0; i < n; i++){
            for (int j = 0; j < i; j++){  //如果第i个array的第0个数，大于，第j个array的第1个数
                if (pairs[i][0] > pairs[j][1] && dp[i] < dp[j]+1)
                    dp[i] = dp[j] +1;
            }
        }

        for (int i = 0; i < n; i++){
            if (max < dp[i])
                max = dp[i];
        }

        return max;
    }

    public static void main(String[] args) {
        int[][]pairs1 = {{1,2},{2,3},{3,4}};
        System.out.println(findLongestChain(pairs1));

        int[][]pairs2 = {{3,4},{1,2},{2,3}};
        System.out.println(findLongestChain(pairs2));

    }
}
