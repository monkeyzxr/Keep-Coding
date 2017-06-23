import java.util.Arrays;

/**
 * Created by monkeyzxr on 2017/6/22.
 *
 Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
 Return the sum of the three integers. You may assume that each input would have exactly one solution.

 For example, given array S = {-1 2 1 -4}, and target = 1.

 The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 *
 */

/*
15. 3sum问题的变种。一样的遍历每个数，对剩余数组进行双指针扫描。区别仅仅在于当：
sum = A[left] + A[right]
(1) sum = target时直接返回
(2) sum != target时，在相应移动left/right指针之前，先计算abs(sum-target)的值，并更新结果。

 */
//http://www.programcreek.com/2013/02/leetcode-3sum-closest-java/
    //http://bangbingsyb.blogspot.com/2014/11/leetcode-3sum-closest.html
public class LC_16_3SumClosest {
    public static int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3)
            return -1;

        int minDiff = Integer.MAX_VALUE;
        int result = 0;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length-2; i++){
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right){
                int currSum = nums[i] + nums[left] + nums[right];
                int currDiff = Math.abs(currSum - target);

                if (currDiff == 0)
                    return currSum;

                else if (currDiff < minDiff){
                      minDiff = currDiff;
                      result = currSum;
                }

                //如何移动指针：
                if (currSum <= target)
                    left++;
                else
                    right--;
            }

        }

        return result;



    }

    public static void main(String[] args) {
        int[] test = {-1, 2, 1, -4};
        System.out.println(threeSumClosest(test, 2));

    }
}
