/**
 * Created by monkeyzxr on 2017/6/21.
 *
 A peak element is an element that is greater than its neighbors.

 Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

 The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

 You may imagine that num[-1] = num[n] = -∞.

 For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
 *
 */

/*
这题要求我们在一个无序的数组里找到一个peak元素，所谓peak，就是值比两边邻居大就可以了。

对于这道题目，最简单的解法就是遍历数组，
只要找到第一个符合要求的元素就可以了，时间复杂度为O（n），
但是这题要求O(LogN)的时间复杂度，还可以用二分来做:

首先我们找到中间节点mid，如果大于两边返回当前的index就可以了，
如果左边的节点比mid大，那么我们可以继续在左半区间查找，这里面一定存在一个peak，为什么这么说呢？
假设此时的区间范围为[0,mid-1]，因为num[mid-1]一定大于num[mid]，如果num[mid-2]<=num[mid-1]，那么num[mid-1]就是一个peak。
如果num[mid-2]>num[mid-1]，那么我们就继续在[0,mid-2]区间查找，
因为num[-1]为负无穷，所以我们最终绝对能在左半区间找到一个peak。同理右半区间一样。
 */

//http://blog.csdn.net/nk_test/article/details/49926229
public class LC_162_FindPeakElement {
    public static int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        while (left < right){  //不能写等于，不然无限循环
            int mid1 = left + (right - left)/2;
            int mid2 = mid1 + 1;

            if (nums[mid1] < nums[mid2])
                left = mid2;
            else
                right = mid1;
        }
        return left;

    }

    public static void main(String[] args) {
        int[] test = {1,2,3,1};
        System.out.println(findPeakElement(test));

    }
}
