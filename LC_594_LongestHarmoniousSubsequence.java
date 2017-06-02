import java.util.HashMap;
import java.util.Map;

/**
 * Created by monkeyzxr on 2017/6/1.
 *
 We define a harmonious array is an array where the difference between its maximum value and its minimum value is exactly 1.

 Now, given an integer array, you need to find the length of its longest harmonious subsequence among all its possible subsequences.

 Example 1:
 Input: [1,3,2,2,5,2,3,7]
 Output: 5

 Explanation: The longest harmonious subsequence is [3,2,2,2,3].
 Note: The length of the input array will not exceed 20,000.
 *
 */

//http://blog.csdn.net/mine_song/article/details/72758104
//使用map,记录数组中数字出现的次数，连续两个数字(此时的差值为1)出现次数的和即为harmonious subsequence。选出最大的来。
public class LC_594_LongestHarmoniousSubsequence {
    public static int findLHS(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();  //用接口来定义好

        for (int i = 0; i < nums.length; i++){  //构建map，key是array的element，value是element的出现次数。
            if (map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i])+1);
            }
            else
                map.put(nums[i],1);
        }


        int maxLength = 0;

        ////keySet() Returns a Set view of the keys contained in this map.
        for (int k : map.keySet()){  //这个循环要历遍已经构建的map的key set
            if (map.containsKey(k+1)){
                int tmpLength = map.get(k) + map.get(k+1);  // 求连续的两个数字（如2和3）出现的次数之和。
                maxLength = Math.max(tmpLength, maxLength);   // 递归的思路！求max！
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] test1 = {1,3,2,2,5,2,3,7};
        System.out.println(findLHS(test1));
    }
}
