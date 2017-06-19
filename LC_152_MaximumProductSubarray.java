/**
 * Created by monkeyzxr on 2017/6/18.
 *
 Find the contiguous subarray within an array (containing at least one number) which has the largest product.

 For example, given the array [2,3,-2,4],
 the contiguous subarray [2,3] has the largest product = 6.

 */


//When iterating the array, each element has two possibilities:
// positive number or negative number.
// We need to track a minimum value, so that when a negative number is given, it can also find the maximum value.
// We define two local variables, one tracks the maximum and the other tracks the minimum.

    //http://www.programcreek.com/2014/03/leetcode-maximum-product-subarray-java/
   // http://www.jiuzhang.com/solutions/maximum-product-subarray/
    //http://www.geeksforgeeks.org/maximum-product-subarray/

public class LC_152_MaximumProductSubarray {
    public static int maxProduct(int[] nums) {
        int[] currMax = new int[nums.length];
        int[] currMin = new int[nums.length];

        currMax[0] = nums[0];
        currMin[0] = nums[0];

        int res = nums[0];

        for (int i = 1; i < nums.length; i++){ //从1开始递归
            if (nums[i] > 0){
                currMax[i] = Math.max(nums[i], currMax[i-1]*nums[i]);
                currMin[i] = Math.min(nums[i], currMin[i-1]*nums[i]);
            }
            else if (nums[i] <= 0){
                currMax[i] = Math.max(nums[i], currMin[i-1]*nums[i]);
                currMin[i] = Math.min(nums[i], currMax[i-1]*nums[i]);
            }

            res = Math.max(res, currMax[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] test = {2,3,-2,4};
        System.out.println(maxProduct(test));

    }
}

/*
idx:        0         1        2         3
nums:       2         3        -2        4
---------------------------------------
curMax:    2         6         -2       4
curMin:    2         6         -12      -48


 */
