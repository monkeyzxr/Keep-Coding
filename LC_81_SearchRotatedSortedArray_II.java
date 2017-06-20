/**
 * Created by monkeyzxr on 2017/6/19.
 *
 Follow up for "Search in Rotated Sorted Array":
 What if duplicates are allowed?

 Would this affect the run-time complexity? How and why?
 Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 Write a function to determine if a given target is in the array.

 The array may contain duplicates.
 */

/*
http://bangbingsyb.blogspot.com/2014/11/leetcode-search-in-rotated-sorted-array.html

当有重复数字，会存在A[mid] = A[end]的情况。此时右半序列A[mid-1 : end]可能是sorted，也可能并没有sorted，如下例子。

3 1 2 3 3 3 3
3 3 3 3 1 2 3

所以当A[mid] = A[end] != target时，无法排除一半的序列，而只能排除掉A[end]：

A[mid] = A[end] != target时：搜寻A[start : end-1]

正因为这个变化，在最坏情况下，算法的复杂度退化成了O(n)：
序列 2 2 2 2 2 2 2 中寻找target = 1。
 */

//和第33题做比较！

public class LC_81_SearchRotatedSortedArray_II {
    public static boolean search(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;

        while(start <= end){
            int mid = start + (end - start)/2;
            if (nums[mid] == target)
                return true;

            if (nums[mid] < nums[end]){  //总是 nums【mid】和nums【end】做比较，找哪半段
                if (target > nums[mid] && target <= nums[end])
                    start = mid + 1;
                else
                    end = mid - 1;
            }

            else if (nums[mid] > nums[end]){
                if (target >= nums[start] && target < nums[mid])
                    end = mid - 1;
                else
                    start = mid + 1;
            }

            else if (nums[mid] == nums[end]){   //A[mid] = A[end] != target时：搜寻A[start : end-1]
                end = end - 1;
            }
        }

        return false;

    }

    public static void main(String[] args) {
        int[]test1 = {1,2,2,2,2,3,3,3,3};
        System.out.println(search(test1, 3));
        System.out.println(search(test1, 4));


    }
}
