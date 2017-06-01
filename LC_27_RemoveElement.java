import java.util.Arrays;

/**
 * Created by monkeyzxr on 2017/5/31.
 *
 Given an array and a value, remove all instances of that value in place and return the new length.

 Do not allocate extra space for another array, you must do this in place with constant memory.

 The order of elements can be changed. It doesn't matter what you leave beyond the new length.

 Example:
 Given input array nums = [3,2,2,3], val = 3

 Your function should return length = 2, with the first two elements of nums being 2.

 */


//http://c1rew.github.io/2015/06/23/Leetcode-27-Remove-Element/
//给定一个整型数组 A 和一个整型数 v，删除 A 中所有与 v 相等的元素，并返回新的数组长度；
// 元素的顺序可以更改，这并不影响你返回新的数组长度的大小。

 //与26题类似：还是双指针，一个（慢指针）帮忙记录length，外加替换不是elem的值，一个（快指针）帮忙往前找。
public class LC_27_RemoveElement {
    public static int removeElement(int[] nums, int val) {
        if(nums == null || nums.length == 0)
            return 0;

        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++){
            if (nums[fast] == val){
                continue;
            }
            else if (nums[fast] != val){
                nums[slow] = nums[fast];
                slow++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return slow;
    }

    public static void main(String[] args) {
        int[] test1 = {3,2,2,3};
        System.out.println(removeElement(test1, 3));

        int[] test2 = {3,1,2,3,4,5,3,3,2,2,3};
        System.out.println(removeElement(test2, 3));

       // [1, 2, 4, 5, 2, 2, 3, 3, 2, 2, 3]
       // 6  (前6个为目标元素，为去除val后剩下的元素)


    }
}
