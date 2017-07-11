/**
 * Created by monkeyzxr on 2017/7/9.
 *
 Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

 Note: You can only move either down or right at any point in time.
 */

//动态规划
//设dp[i][j]为从(0,0)到(i,j)的路径和最小值
//dp[i][j] = MIN(dp[i - 1][j], dp[i][j - 1]) + matrix[i][j]

    //http://www.jiuzhang.com/solutions/minimum-path-sum/
//http://fisherlei.blogspot.com/2012/12/leetcode-minimum-path-sum.html
//http://www.programcreek.com/2014/05/leetcode-minimum-path-sum-java/
public class LC_64_MinimumPathSum {
    public static int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0)
            return 0;

        int m = grid.length;  //行数
        int n = grid[0].length;  //列数
        int [][]sum = new int[m][n];
        sum[0][0] = grid[0][0];

        //初始化第一层
        for (int i = 1; i < n; i++){
            sum[0][i] = sum[0][i-1] + grid[0][i];
        }

        //初始化第一列
        for (int i = 1; i < m; i++){
            sum[i][0] = sum[i-1][0] + grid[i][0];
        }

        for (int i = 1; i < m ; i ++){
            for (int j = 1; j < n; j++){
                sum[i][j] = Math.min(sum[i-1][j], sum[i][j-1]) + grid[i][j];
            }
        }

        return sum[m-1][n-1];

    }

    public static void main(String[] args) {
        int[][] grid = {
                {11,21,25,34},
                {2,32,46,5},
                {30,4,50,6}
        };

        System.out.println(minPathSum(grid));

    }
}
