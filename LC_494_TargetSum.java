/**
 * Created by monkeyzxr on 2017/6/27.
 *
 You are given a list of non-negative integers, a1, a2, ..., an, and a target, S.
 Now you have 2 symbols + and -.
 For each integer, you should choose one from + and - as its new symbol.

 Find out how many ways to assign symbols to make sum of integers equal to target S.

 Example 1:
 Input: nums is [1, 1, 1, 1, 1], S is 3.
 Output: 5

 Explanation:

 -1+1+1+1+1 = 3
 +1-1+1+1+1 = 3
 +1+1-1+1+1 = 3
 +1+1+1-1+1 = 3
 +1+1+1+1-1 = 3

 There are 5 ways to assign symbols to make the sum of nums be target 3.
 Note:
 The length of the given array is positive and will not exceed 20.
 The sum of elements in the given array will not exceed 1000.
 Your output answer is guaranteed to be fitted in a 32-bit integer.
 *
 */

//https://zhangyuzhu13.github.io/2017/02/13/LeetCode之494.%20Target%20Sum思路/
//https://discuss.leetcode.com/topic/76243/java-15-ms-c-3-ms-o-ns-iterative-dp-solution-using-subset-sum-with-explanation

    /*
    往0-1背包问题上想一想，每个数字为正或为负，同时增一倍，则变为了，每个数字不选，或选2倍。
    这就靠到0-1背包上了。则基数就不再是0，而是nums数组中所有数字之和为基数，在此基础上进行选2倍或不选，目标数字S也相应变为S+Sum。
    依靠数学公式推论为：设最后选择为正的之和为in，为负的之和为out,
    则有公式：
in - out = S
in + out = sum
推出：2*in = S + sum
则我们需要的就是把目标改为S+sum,把每个数字改为原来的2倍，从中选择数字，使之和为S+sum。
因此，DP解之
     */

public class LC_494_TargetSum {
    public static int findTargetSumWays(int[] nums, int S) {
        int sum = 0;

        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            nums[i] *= 2;
        }

        if(sum < S ) return 0;

        int target = sum + S;

        int[] dp = new int[target+1];
        dp[0] = 1;  //能使和为零，只有1种选择方式

        for(int i = 0; i < nums.length; i++){
            for(int j = target; j >= 0; j--){
                if(j >= nums[i]){
                    dp[j] += dp[j-nums[i]];
                }
            }
        }
        return dp[target];

    }

    public static void main(String[] args) {
        int[] test = {1,1,1,1,1};
        System.out.println(findTargetSumWays(test, 3));

    }
}

/*
https://discuss.leetcode.com/topic/76243/java-15-ms-c-3-ms-o-ns-iterative-dp-solution-using-subset-sum-with-explanation
 public int findTargetSumWays(int[] nums, int s) {
        int sum = 0;
        for (int n : nums)
            sum += n;
        return sum < s || (s + sum) % 2 > 0 ? 0 : subsetSum(nums, (s + sum) >>> 1);
    }

    public int subsetSum(int[] nums, int s) {  //计算有多少方式选择nums，使和为s
        int[] dp = new int[s + 1];
        dp[0] = 1;
        for (int n : nums)
            for (int i = s; i >= n; i--)
                dp[i] += dp[i - n];
        return dp[s];
    }
 */