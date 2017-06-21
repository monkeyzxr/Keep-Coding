/**
 * Created by monkeyzxr on 2017/6/20.
 *
 Follow up for "Find Minimum in Rotated Sorted Array":
 What if duplicates are allowed?

 Would this affect the run-time complexity? How and why?
 Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 Find the minimum element.

 The array may contain duplicates.
 *
 */

/*

和Search in Rotated Sorted Array II这题换汤不换药。同样当A[mid] = A[end]时，无法判断min究竟在左边还是右边。

3 1 2 3 3 3 3
3 3 3 3 1 2 3

但可以肯定的是可以排除A[end]：因为即使min = A[end]，由于A[end] = A[mid]，排除A[end]并没有让min丢失。所以增加的条件是：

A[mid] = A[end]：搜索A[start : end-1]
 */
public class LC_154_FindMinimumRotatedSortedArray_II {
    public static int findMin(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        while (start < end){
            int mid = start + (end - start)/2;

            if (nums[mid] < nums[end])
                end = mid;

            else if (nums[mid] > nums[end])
                start = mid + 1;

            else
                end--;
        }
        return nums[start];
    }

    public static void main(String[] args) {
        int[]test = {4,5,6,7,0,1,2,3,3,0};
        System.out.println(findMin(test));
    }
}
