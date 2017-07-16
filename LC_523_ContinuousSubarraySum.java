import java.util.HashMap;
import java.util.Map;

/**
 * Created by monkeyzxr on 2017/7/15.
 *
 Given a list of non-negative numbers and a target integer k,
 write a function to check if the array has a continuous subarray of size at least 2 that sums up to the multiple of k,
 that is, sums up to n*k where n is also an integer.

 Example 1:
 Input: [23, 2, 4, 6, 7],  k=6
 Output: True
 Explanation: Because [2, 4] is a continuous subarray of size 2 and sums up to 6.

 Example 2:
 Input: [23, 2, 6, 4, 7],  k=6
 Output: True
 Explanation: Because [23, 2, 6, 4, 7] is an continuous subarray of size 5 and sums up to 42.

 Note:
 The length of the array won't exceed 10,000.
 You may assume the sum of all the numbers is in the range of a signed 32-bit integer.
 *
 */

//这道题给了我们一个数组和一个数字k，让我们求是否存在这样的一个连续的子数组，该子数组的数组之和可以整除k。
    //遇到除法问题，我们肯定不能忘了除数为0的情况等处理

    //简单思路：求出每个子数组，逐个比较
    //http://www.cnblogs.com/grandyang/p/6504158.html
    /*
public class LC_523_ContinuousSubarraySum {
    public static boolean checkSubarraySum(int[] nums, int k) {
        for(int i = 0; i < nums.length; i++){
            int currSum = nums[i];
            //因为要求子数组个数至少是2，所以从i+1开始循环
            for (int j = i+1; j < nums.length; j++){
                currSum += nums[j];
                if (currSum == k)  //验证
                    return true;
                if (k != 0 && currSum%k == 0) //验证
                    return true;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        int[] nums = {23, 2, 4, 6, 7};
        System.out.println(checkSubarraySum(nums, 6));


    }
}
*/

//另一个思路： 用hashset
//定理：若数字a和b分别除以数字c，若得到的余数相同，那么(a-b)必定能够整除c。
//建立余数和当前位置之间的映射

//http://www.cnblogs.com/grandyang/p/6504158.html
//https://discuss.leetcode.com/topic/80793/java-o-n-time-o-k-space/2
public class LC_523_ContinuousSubarraySum {
    public static boolean checkSubarraySum(int[] nums, int k) {
        //建立map， key存放 sum除以k的 余数， value存放 位置
        Map<Integer, Integer> map  = new HashMap<>();

        map.put(0, -1);  //余数为零的情况, 若为零，则一定是正确的，即存在符合条件的子序列,即子序列的sum除以k，余数为0

        int curSum = 0;
        for (int i = 0; i < nums.length; i++){
            curSum += nums[i];
            //int remainder = -1; //初始化
           // if (k != 0)
            //    remainder = curSum % k;
            int remainder = (k == 0) ? curSum : (curSum%k);

            //看看之前map里是否存在这个remainder
            if (map.containsKey(remainder)){
                if (i - map.get(remainder) >= 2)
                    return true;
            }
            else
                map.put(remainder, i);
        }
        return false;


    }

    public static void main(String[] args) {
        int[] nums = {23, 2, 4, 6, 7};
        System.out.println(checkSubarraySum(nums, 6));


    }
}