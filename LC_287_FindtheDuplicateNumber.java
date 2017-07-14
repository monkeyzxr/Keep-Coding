/**
 * Created by monkeyzxr on 2017/7/13.
 *
 Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive),
 prove that at least one duplicate number must exist.
 Assume that there is only one duplicate number, find the duplicate one.

 Note:
 You must not modify the array (assume the array is read only).
 You must use only constant, O(1) extra space.  //不能用HashSet了
 Your runtime complexity should be less than O(n2).
 There is only one duplicate number in the array, but it could be repeated more than once.
 */
/*
题目要求我们不能改变原数组，即不能给原数组排序，又不能用多余空间，那么哈希表神马的也就不用考虑了，
又说时间小于O(n2)，也就不能用brute force的方法，
那我们也就只能考虑用二分搜索法了，
(这个二分法和以前的都不一样，要好好想想！！！）
我们在区间[1, n]中搜索，首先求出中点mid，然后遍历整个数组，统计所有小于等于mid的数的个数，如果个数大于mid，则说明重复值在[mid+1, n]之间，
反之，重复值应在[1, mid-1]之间，然后依次类推，直到搜索完成，此时的low就是我们要求的重复值，
 */
public class LC_287_FindtheDuplicateNumber {
    public static int findDuplicate(int[] nums) {
        //值在1到n之间。所以最小值是1。最大值是length-1。例如： 1，2，3，4，4，5（n=5，共6个数，每个数都在1到5之间）
        int low = 1;  //是最小值，不是指index
        int high = nums.length-1;  //是最大值，不是index

        while (low < high){
            int mid = low + (high-low)/2;
            int count = 0;

            for (int num : nums){
                if (num <= mid)
                    count++;
            }

            if (count <= mid)
                low = mid + 1;
            else
                high = mid;
        }

        return low;
    }

    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[]{1,2,3,4,4,5}));

    }
}
