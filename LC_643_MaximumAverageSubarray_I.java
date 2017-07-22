/**
 * Created by monkeyzxr on 2017/7/21.
 *
 Given an array consisting of n integers,
 find the contiguous subarray of given length k that has the maximum average value.
 And you need to output the maximum average value.

 Example 1:
 Input: [1,12,-5,-6,50,3], k = 4
 Output: 12.75
 Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75

 Note:
 1 <= k <= n <= 30,000.
 Elements of the given array will be in the range [-10,000, 10,000].
 *
 */

//http://blog.csdn.net/shuramos/article/details/75287743
//滑窗统计k个数的和，同时保留最大和，结果返回最大和/k
public class LC_643_MaximumAverageSubarray_I {
    public static double findMaxAverage(int[] nums, int k) {
        double currSum = 0.0;
        for (int i = 0; i < k; i++){
            currSum += nums[i];
        }

        double maxSum = currSum;
        for (int i = k; i < nums.length; i++){   //  0   1   2   3   4   5
            currSum = currSum + nums[i] - nums[i-k]; //右侧加一个数，左侧减一个数，维持滑块大小为k
            maxSum = Math.max(maxSum, currSum);
        }

        return maxSum/k;

    }

    public static void main(String[] args) {
        int[] nums = {1,12,-5,-6,50,3};
        System.out.println(findMaxAverage(nums, 4));

    }
}
