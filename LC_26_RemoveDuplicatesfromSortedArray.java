import java.util.Arrays;

/**
 * Created by monkeyzxr on 2017/5/31.
 *
 Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

 Do not allocate extra space for another array, you must do this in place with constant memory.

 For example,
 Given input array nums = [1,1,2],

 Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 It doesn't matter what you leave beyond the new length.
 */

//我的思路：因为已经排序了，若是相同的元素，则相临的差值是0。数有多少个差值0。用总数减去，就是结果。

//这么写，返回的长度是对的。
// 但是原题要求array的元素也要是non duplicates,即，return的array的前几个元素必须就是目标元素，后面是啥没关系。
// 所以不能这么写。
    /*
public class LC_26_RemoveDuplicatesfromSortedArray {
    public static int removeDuplicates(int[] nums) {
        int count = 0;
        for (int i = 1; i < nums.length; i++){
            int diff = nums[i] - nums[i-1];
            if (diff == 0)
                count++;
        }
        return nums.length - count;
    }
    public static void main(String[] args) {
        int[] test1 = {1,1,2};
        System.out.println(removeDuplicates(test1));

        int[] test2 = {1,1,1,2,2,2,3,4};
        System.out.println(removeDuplicates(test2));

        int[] test3 = {0,0,0,0};
        System.out.println(removeDuplicates(test3));
    }
}
*/

//重新写：https://leetcode.com/articles/remove-duplicates-sorted-array/
//思路： 用两个指针指向array的index。一个跑的快，一个跑的慢。
    // 快指针如果和慢指针的元素值相等，则什么也不做，快指针继续往下跑。
    // 如果快指针开始和慢指针元素不相等，则慢指针往下走一个位置，并且把快指针的值赋给慢指针。
    //一直跑完循环。慢指针的值，就是已经去除重复的值。


public class LC_26_RemoveDuplicatesfromSortedArray {
    public static int removeDuplicates(int[] nums) {
       if (nums == null || nums.length == 0)
           return 0;

       int p_slow = 0;

       for (int p_fast = 1; p_fast < nums.length; p_fast++){
           if (nums[p_fast] == nums[p_slow])
               continue;

           else if (nums[p_fast] != nums[p_slow]){
               p_slow++;
               nums[p_slow] = nums[p_fast];
           }
       }
       return p_slow+1;  //index是从0开始，所以返回的个数要加1
    }

    public static void main(String[] args) {
        int[] test1 = {1,1,2};
        System.out.println(removeDuplicates(test1));
        System.out.println(Arrays.toString(test1));


        int[] test2 = {1,1,1,2,2,2,3,4};
        System.out.println(removeDuplicates(test2));
        System.out.println(Arrays.toString(test2));


        int[] test3 = {0,0,0,0};
        System.out.println(removeDuplicates(test3));
        System.out.println(Arrays.toString(test3));

    }
}