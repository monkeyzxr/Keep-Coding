/**
 * Created by monkeyzxr on 2017/7/15.
 *
 Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

 Example:
 Given nums = [-2, 0, 3, -5, 2, -1]

 sumRange(0, 2) -> 1
 sumRange(2, 5) -> -1
 sumRange(0, 5) -> -3
 Note:
 You may assume that the array does not change.
 There are many calls to sumRange function.
 */

//http://www.cnblogs.com/yrbbest/p/5050025.html
    //给定数组，求range之内的数组和。
// 我们可以新建一个dp数组来保存数据，dp[i]表示 0到i-1(index)这i个数的sum，
// 每次我们就可以在使用O(n)初始化之后，用O(1)的时间得到搜索结果了。

public class LC_303_RangeSumQuery_Immutable {
    private int[] sum;
/*
    public  NumArray(int[] nums) {
        sum = new int[nums.length+1];

        for (int i = 1; i <= nums.length; i++){
            sum[i] = sum[i-1] + nums[i-1];
        }
    }

    public  int sumRange(int i, int j) {
        return sum[j+1] - sum[i];

    }
    */

    public static void main(String[] args) {

    }
}




/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */