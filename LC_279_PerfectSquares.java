import java.util.Arrays;

/**
 * Created by monkeyzxr on 2017/7/14.
 *
 Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

 For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.
 *
 */

/*https://discuss.leetcode.com/topic/26400/an-easy-understanding-dp-solution-in-java

dp[n] indicates that the perfect squares count of the given n, and we have:

dp[0] = 0
dp[1] = dp[0]+1 = 1
dp[2] = dp[1]+1 = 2
dp[3] = dp[2]+1 = 3
dp[4] = Min{ dp[4-1*1]+1, dp[4-2*2]+1 }
      = Min{ dp[3]+1, dp[0]+1 }
      = 1
dp[5] = Min{ dp[5-1*1]+1, dp[5-2*2]+1 }
      = Min{ dp[4]+1, dp[1]+1 }
      = 2
						.
						.
						.
dp[13] = Min{ dp[13-1*1]+1, dp[13-2*2]+1, dp[13-3*3]+1 }
       = Min{ dp[12]+1, dp[9]+1, dp[4]+1 }
       = 2
						.
						.
						.
dp[n] = Min{ dp[n - i*i] + 1 },  n - i*i >=0 && i >= 1
 */


/*
http://bookshadow.com/weblog/2015/09/09/leetcode-perfect-squares/

动态规划（Dynamic Programming）

时间复杂度：O(n * sqrt n)

初始化将dp数组置为无穷大；令dp[y * y] = 1，其中：y * y <= n

状态转移方程：

dp[x + y * y] = min(dp[x + y * y], dp[x] + 1)

其中：dp [i] 表示凑成i所需的平方和数字的最小个数，并且 x + y * y <= n

 */

//题意： 给定一个整数n，找到最少的完全平方数使得他们的和为n


    //http://blog.csdn.net/happyaaaaaaaaaaa/article/details/51584790
    //没看懂啊！
public class LC_279_PerfectSquares {
    public static int numSquares(int n) {
        int dp[] = new int[n+1];

        Arrays.fill(dp, Integer.MAX_VALUE);

        for (int i = 1; i * i <= n; i++){
            dp[i*i] = 1;
        }

        for (int i = 1; i <=n; i++){
            for (int j = 1; i + j*j <= n; j++){
                dp[i+j*j] = Math.min(dp[i]+1, dp[i+j*j]);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(numSquares(6));
        System.out.println(numSquares(13));


    }
}
