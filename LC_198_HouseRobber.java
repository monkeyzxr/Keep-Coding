/**
 * Created by monkeyzxr on 2017/6/27.
 *
 You are a professional robber planning to rob houses along a street.
 Each house has a certain amount of money stashed,
 the only constraint stopping you from robbing each of them is that adjacent houses have security system connected
 and it will automatically contact the police if two adjacent houses were broken into on the same night.

 Given a list of non-negative integers representing the amount of money of each house,
 determine the maximum amount of money you can rob tonight without alerting the police.
 */

//http://www.programcreek.com/2014/03/leetcode-house-robber-java/
    //http://www.qiujiawei.com/leetcode-problem-198/
    //http://blog.csdn.net/geekmanong/article/details/50320009

//用动态规划:The key is to find the relation dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i]).
public class LC_198_HouseRobber {
    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        if (nums.length == 1)
            return nums[0];
                                            // 0, 1, 2, 3, 4, 5, 6, 7, 8, 9
        int[] dp = new int [nums.length];  //创一个数组，放结果，即：存放前i个房间的最大值

        dp[0] = nums[0];  //打劫第一个房间，只能一个选择
        dp[1] = Math.max(nums[0], nums[1]);  //打劫前2个房间，找前2个房间的最大值

        for(int i = 2; i < nums.length; i++){
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i]); //打劫第i个房间时，要么打劫过之前的i-1号房间，当前i不打劫；
                                                              // 要么打劫之前的i-2号房间，并打劫当前的i房间
        }

        return dp[nums.length-1];  //返回数组里的最后一个值，就是打劫了nums数组的最大值

    }

    public static void main(String[] args) {
        int[]test = {20, 1, 2, 30};
        System.out.println(rob(test));

    }
}
