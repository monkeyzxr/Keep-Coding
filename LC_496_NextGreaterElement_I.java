import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by monkeyzxr on 2017/7/21.
 *
 You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2.
 Find all the next greater numbers for nums1's elements in the corresponding places of nums2.

 The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2.
 If it does not exist, output -1 for this number.

 Example 1:
 Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
 Output: [-1,3,-1]
 Explanation:
 For number 4 in the first array, you cannot find the next greater number for it in the second array, so output -1.
 For number 1 in the first array, the next greater number for it in the second array is 3.
 For number 2 in the first array, there is no next greater number for it in the second array, so output -1.

 Example 2:
 Input: nums1 = [2,4], nums2 = [1,2,3,4].
 Output: [3,-1]
 Explanation:
 For number 2 in the first array, the next greater number for it in the second array is 3.
 For number 4 in the first array, there is no next greater number for it in the second array, so output -1.

 Note:
 All elements in nums1 and nums2 are unique.
 The length of both nums1 and nums2 would not exceed 1000.
 *
 */

//http://www.cnblogs.com/grandyang/p/6399855.html
//这道题给了我们一个数组，又给了该数组的一个子集合，让我们求集合中每个数字在原数组中右边第一个较大的数字。
    /*
public class LC_496_NextGreaterElement_I {
    public static int[] nextGreaterElement(int[] findNums, int[] nums) {
        int[] result = new int[findNums.length];

        for (int i = 0; i < findNums.length; i++){
            int j = 0;  //j和k必须放 小循环 外，因为 小循环结束后要用到 j和k 所对应的位置
            int k = 0;
            for (; i < nums.length; j++){
                if (nums[j] == findNums[i])
                    break;
            }
            for (k = j+1; k < nums.length; k++){
                if (nums[k] > nums[j]){
                    result[i] = nums[k];
                    break;  //得到结果，就跳出小循环
                }
            }
            if (k == nums.length)  //如果k一直走到nums数组的最后，即走到了nums.length-1的下一位
                result[i] = -1;     //说明中途没有break，没有找到对应的结果
        }

        return result;

    }

    public static void main(String[] args) {
        int[] findNums = {4, 1, 2};
        int[] nums = {1, 3, 4, 2};
        System.out.println(Arrays.toString(nextGreaterElement(findNums, nums)));

    }
}
*/



//https://discuss.leetcode.com/topic/77916/java-10-lines-linear-time-complexity-o-n-with-explanation/2
/*
Key observation:
Suppose we have a decreasing sequence followed by a greater number
For example [5, 4, 3, 2, 1, 6] then the greater number 6 is the next greater element for all previous numbers in the sequence

We use a stack to keep a decreasing sub-sequence, whenever we see a number x greater than stack.peek() we pop all elements less than x and for all the popped ones, their next greater element is x
For example [9, 8, 7, 3, 2, 1, 6]
The stack will first contain [9, 8, 7, 3, 2, 1] and then we see 6 which is greater than 1 so we pop 1 2 3 whose next greater element should be 6
 */

//非常巧妙的办法。用stack
/*http://www.cnblogs.com/grandyang/p/6399855.html
    建立每个数字和其右边第一个较大数之间的映射，没有的话就是-1。
    我们遍历原数组中的所有数字，如果此时栈不为空，且栈顶元素小于当前数字，说明当前数字就是栈顶元素的右边第一个较大数，
    那么建立二者的映射，并且去除当前栈顶元素，最后将当前遍历到的数字压入栈。
    当所有数字都建立了映射，那么最后我们可以直接通过哈希表快速的找到子集合中数字的右边较大值
     */


public class LC_496_NextGreaterElement_I {
    public static int[] nextGreaterElement(int[] findNums, int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();  // map from x to next greater element of x
        Stack<Integer> stack = new Stack<>();
        for (int num : nums){
            while (!stack.isEmpty() && stack.peek() < num){
                int leftVal = stack.pop();  //得到所有小于当前num的值
                map.put(leftVal, num); //建立map，小值 对应 比他大的大值。只有存在比左值大的值，才能建立起map。有的数不能建立map。如[9, 8, 7, 3, 2, 1, 6]里的9，8，7
            }
            stack.push(num);
        }

        int[] result = new int[findNums.length];
        for (int i = 0; i < findNums.length; i++){
            if (map.containsKey(findNums[i]))
                result[i] = map.get(findNums[i]);
            else
                result[i] = -1;
            //或者：
            // findNums[i] = map.getOrDefault(findNums[i], -1);
            //Returns the value to which the specified key is mapped, or defaultValue if this map contains no mapping for the key.
        }

        return result;



    }

    public static void main(String[] args) {
        int[] findNums = {4, 1, 2};
        int[] nums = {1, 3, 4, 2};
        System.out.println(Arrays.toString(nextGreaterElement(findNums, nums)));

    }
}