import java.util.IntSummaryStatistics;

/**
 * Created by monkeyzxr on 2017/6/21.
 *
 Given an array of n positive integers and a positive integer s,
 find the minimal length of a contiguous subarray of which the sum ≥ s.
 If there isn't one, return 0 instead.

 For example, given the array [2,3,1,2,4,3] and s = 7,
 the subarray [4,3] has the minimal length under the problem constraint.

 More practice:
 If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
 *
 */


//用 滑动窗口的思路， 双指针指左右 不用sort array
//定义两个指针left和right，分别记录子数组的左右的边界位置，
// 然后我们让right向右移，直到子数组和大于等于给定值或者right达到数组末尾，此时我们更新最短距离，
// 并且将left像右移一位，然后再sum中减去移去的值，然后重复上面的步骤，直到right到达末尾，且left到达临界位置，即要么到达边界，要么再往右移动，和就会小于给定值
    //// O(n)

    //http://www.jiuzhang.com/solutions/minimum-size-subarray-sum/
    //http://www.cnblogs.com/grandyang/p/4501934.html

public class LC_209_MinimumSizeSubarraySum {
    public static int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int left = 0;
        int right = 0;
        int curSum = 0;
        int result = Integer.MAX_VALUE;  // 找最小的len，初始化 为一个较大的值

        for (left = 0; left < nums.length; left++){  //left指针为最外层的循环
            while (right < nums.length && curSum < s){
                curSum += nums[right];
                right++;  // 当left固定在某一位置时，right一直向右走，直到sum >= s 或right出界了
            }
            if (curSum >= s){
                result = Math.min(result, right-left);  // 更新result
            }

            curSum = curSum - nums[left];  // sum减去当前left的值，然后进入left的下一个循环
        }


        if (result == Integer.MAX_VALUE)  //如果result没有更新过，即无结果，返回0
            result = 0;

        return result;


    }

    public static void main(String[] args) {
        int[] test = {2,3,1,2,4,3};
        System.out.println(minSubArrayLen(7, test));

    }
}
