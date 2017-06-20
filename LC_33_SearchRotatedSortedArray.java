/**
 * Created by monkeyzxr on 2017/6/19.
 *
 Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 You are given a target value to search. If found in the array return its index, otherwise return -1.

 You may assume no duplicate exists in the array.
 *
 */

//http://bangbingsyb.blogspot.com/2014/11/leetcode-search-in-rotated-sorted-array.html
/*
原数组：0 1 2 4 5 6 7

情况1：  6 7 0 1 2 4 5    起始元素0在中间元素的左边
情况2：  2 4 5 6 7 0 1    起始元素0在中间元素的右边

最终总结的规律是：   总是 mid的数和end的数比较，来确定target再哪半边！！！！！！

A[mid] =  target, 返回mid，否则

(1) A[mid] < A[end]: A[mid+1 : end] sorted
A[mid] < target <= A[end]  右半，否则左半。

(2) A[mid] > A[end] : A[start : mid-1] sorted
A[start] <= target < A[mid] 左半，否则右半。

*/

public class LC_33_SearchRotatedSortedArray {
    public static int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;

        while (start <= end){
            int mid = start + (end-start)/2;

            if (nums[mid] == target)
                return mid;

            if (nums[mid] < nums[end]){ // right half sorted
                if (target > nums[mid] && target <= nums[end]){
                    start = mid + 1;
                }
                else
                    end = mid - 1;
            }

            else { // left half sorted
                if (target >= nums[start] && target < nums[mid]){
                    end = mid - 1;
                }
                else
                    start = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] test1 = {4,5,6,7,0,1,2};
        System.out.println(search(test1, 0));

    }
}
