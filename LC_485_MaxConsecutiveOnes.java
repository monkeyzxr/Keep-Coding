import java.util.HashMap;

/**
 * Created by monkeyzxr on 2017/5/23.
 *
 Given a binary array, find the maximum number of consecutive 1s in this array.

 Example 1:
 Input: [1,1,0,1,1,1]
 Output: 3

 Explanation: The first two digits or the last three digits are consecutive 1s.
 The maximum number of consecutive 1s is 3.

 Note:
 The input array will only contain 0 and 1.
 The length of input array is a positive integer and will not exceed 10,000
 *
 */

//遍历一遍数组，用一个计数器cnt来统计1的个数，方法是如果当前数字为0，那么cnt重置为0，如果不是0，cnt自增1，然后每次更新结果res即可.

public class LC_485_MaxConsecutiveOnes {
    public static int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int result = 0;  //刚开始，没有1
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0)
                count = 0;  //reset count when 0 is found

            else if(nums[i] == 1){
                count++;             // If 1 is found, increment count
                result = Math.max(result,count);   //update result if count becomes more
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[]test1 = {1,1,0,1,1,1};
        System.out.println(findMaxConsecutiveOnes(test1));

        int[]test2 = {1,1,0,1,1,1,0,0,1,0,1,1,1,1};
        System.out.println(findMaxConsecutiveOnes(test2));
    }
}
