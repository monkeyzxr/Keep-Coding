import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by monkeyzxr on 2017/6/22.
 *
 Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
 Find all unique triplets in the array which gives the sum of zero.

 Note: The solution set must not contain duplicate triplets.

 For example, given array S = [-1, 0, 1, 2, -1, -4],

 A solution set is:
 [
 [-1, 0, 1],
 [-1, -1, 2]
 ]
 *
 */

/*

To avoid duplicate, we can take advantage of sorted arrays, i.e., move pointers by >1 to use same element only once.

思路：这道题目的难点在于处理duplicate，给的数组可能会出现duplicate。
先sort下这个歌数组，时间复杂度为O(nlogn)。
把3sum的问题拆分为2sum问题， 可以遍历数组的时候，指针i指向的为target=nums[i]， 那么剩下就是再找两个元素的和为-target的问题。
由于存在重复元素，用hashmap做起来很不方便，可以用两指针来从两端往中间找。
注意边界条件的判定跟duplicate。 时间复杂度为O(nlogn) + O(n2)
 */

//https://dyang2016.wordpress.com/2016/10/09/15-3sum/
//http://www.programcreek.com/2012/12/leetcode-3sum/

public class LC_15_3Sum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums == null || nums.length < 3)
            return result;

        Arrays.sort(nums);   // 排序，为了两端两个指针的移动

        for (int i = 0; i < nums.length; i++){  // 这里i<nums.length-2更好
            if (i != 0 && nums[i] == nums[i-1])
                continue;   // 略过重复的数

            int target = -nums[i];
            int left = i+1;
            int right = nums.length-1;

            while(left < right){  //不能写等于，因为lef=right的时候，对应的数可能只有一个，不能num【left】 + num【right】
                if (nums[left] + nums[right] < target)
                    left++;

                else if (nums[left] + nums[right] > target)
                    right--;

                else {  //若相等
                    List<Integer> l = new ArrayList<>();
                    l.add(nums[i]);
                    l.add(nums[left]);
                    l.add(nums[right]);
                    result.add(l);

                    while (left < right && nums[left] == nums[left+1])  //处理左端若有重复的数
                        left++;

                    while (left < right && nums[right] == nums[right-1])  //处理右端若有重复的数
                        right--;

                    left++;
                    right--;
                }

            }
        }
        return result;



    }

    public static void main(String[] args) {
        int[] test = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(test));

    }
}
