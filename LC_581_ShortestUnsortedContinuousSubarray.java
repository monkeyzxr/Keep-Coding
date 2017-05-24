import java.util.Arrays;

/**
 * Created by monkeyzxr on 2017/5/22.
 *
 Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order,
 then the whole array will be sorted in ascending order, too.

 You need to find the shortest such subarray and output its length.

 Example 1:
 Input: [2, 6, 4, 8, 10, 9, 15]
 Output: 5
 Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.

 Note:
 Then length of the input array is in range [1, 10,000].
 The input array may contain duplicates, so ascending order here means <=.
 *
 */

//这道题给了我们一个数组，让我们求最短的无序连续子数组，根据题目中的例子也不难分析出来是让我们找出数组中的无序的部分。
// 那么我最开始的想法就是要确定无序子数组的起始和结束位置，这样就能知道子数组的长度了。

public class LC_581_ShortestUnsortedContinuousSubarray {
    public static int findUnsortedSubarray(int[] nums) {
       // int[] sorted = nums;  不能这么写，这样 sorted array指向nums，是同一个内存！

        int[] sorted = Arrays.copyOf(nums, nums.length);  // 用这个来 copy array！
        Arrays.sort(sorted);
        int beginIndex = 0;
        int endIndex = nums.length - 1;

        //从左端，找原始array和sorted array开始不一样的number的index。
        for(int i = 0; i < nums.length; i++){
            if(sorted[i] != nums[i]){
                break;  //终止这个loop
            }
            beginIndex++;
        }

        //从最右端，找原始array和sorted array开始不一样的那个number的index。
        for(int i = nums.length - 1; i > 0; i--){
            if(sorted[i] != nums[i]){
                break;
            }
            endIndex--;
        }

        if (endIndex <= beginIndex)   // 如果原始array已经是排序好的，直接返回0
            return 0;
        else
            return  endIndex - beginIndex + 1;
    }

    public static void main(String[] args) {
        int[]test = {2, 6, 4, 8, 10, 9, 15};
        System.out.println(findUnsortedSubarray(test));

    }
}
