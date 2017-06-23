import java.util.HashMap;
import java.util.Map;

/**
 * Created by monkeyzxr on 2017/6/22.
 *
 Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.

 Example 1:
 Input: [0,1]
 Output: 2
 Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.

 Example 2:
 Input: [0,1,0]
 Output: 2
 Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
 Note: The length of the given binary array will not exceed 50,000.
 *
 */


//就是给定array 里面只存0和1。 找一个连续的子序列，使其含有的0和1的个数相等，找出这个子序列的最大长度。

    /*
    The idea is to change 0 in the original array to -1.
    Thus, if we find SUM[i, j] == 0 then we know there are even number of -1 and 1 between index i and j.
    Also put the sum to index mapping to a HashMap to make search faster.
     */

    //http://www.cnblogs.com/liujinhong/p/6472580.html
    //http://massivealgorithms.blogspot.com/2017/02/leetcode-525-contiguous-array.html
public class LC_525_ContiguousArray {
    public static int findMaxLength(int[] nums) {
        if (nums == null || nums.length < 2)
            return 0;
                                                           //  index       0    1   2  3 4 5   6  7   8
        for (int i = 0; i < nums.length; i++){   // 0 0 0 1 1 1 0 1 0  ->  -1, -1, -1, 1,1,1, -1, 1, -1
            if (nums[i] == 0)
                nums[i] = -1;  //0 全部改成-1
        }

        int sum = 0;
        int result = 0;

        Map<Integer, Integer> map = new HashMap<>();   // key是当前的sum，value是刚加入的数的index

        map.put(0, -1);  ////?????

        for (int i  = 0; i < nums.length; i++){
            sum += nums[i];
            if (map.containsKey(sum))
                result = Math.max(result, i-map.get(sum));
            else
                map.put(sum, i);  // map(-1, 0) (-2, 1) (-3, 2)
                              // 再加1，sum= -2， map有-2的key， result= 3 - map.get(-2) = 3 - 1 = 2


        }

        return result;

    }

    public static void main(String[] args) {
        int[] test = {0,1,0};
        System.out.println(findMaxLength(test));

    }
}
