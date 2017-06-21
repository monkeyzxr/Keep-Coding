/**
 * Created by monkeyzxr on 2017/6/20.
 *
 Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 Find the minimum element.

 You may assume no duplicate exists in the array.
 *
 */

/*
0 1 2 4 5 6 7

4 5 6 7 0 1 2   ／／最小在右半段

6 7 0 1 2 4 5   ／／ 最小在左半段


 */

// 我自己写，正确。思路：用mid的值和最右端的值比较，确定最小会在哪一段
    /*
public class LC_153_FindMinimumRotatedSortedArray {
    public static int findMin(int[] nums) {
        int start = 0;
        int end =  nums.length - 1;
        int mid = start + (end - start)/2;

        int min = nums[mid];

        if (nums[mid] < nums[end]){ //最小在左半边
            for (int i = 0; i < mid; i++){
                if (nums[i] < min)
                    min = nums[i];
            }
        }
        else {//最小在右半边
            for (int i = mid+1; i < nums.length; i++){
                if (nums[i] < min)
                    min = nums[i];
            }
        }

        return min;
    }

    public static void main(String[] args) {
        int[]test = {4,5,6,7,0,1,2};
        System.out.println(findMin(test));

    }
}
*/

    //网上思路：

/*
http://bangbingsyb.blogspot.com/2014/11/leecode-find-minimum-in-rotated-sorted.html
和Search in Rotated Sorted Array I这题换汤不换药。同样可以根据A[mid]和A[end]来判断右半数组是否sorted：
原数组：0 1 2 4 5 6 7
情况1：  6 7 0 1 2 4 5
情况2：  2 4 5 6 7 0 1
(1) A[mid] < A[end]：A[mid : end] sorted => min不在A[mid+1 : end]中
搜索A[start : mid]
(2) A[mid] > A[end]：A[start : mid] sorted且又因为该情况下A[end]<A[start] => min不在A[start : mid]中
搜索A[mid+1 : end]
(3) base case：
a. start =  end，必然A[start]为min，为搜寻结束条件。
b. start + 1 = end，此时A[mid] =  A[start]，而min = min(A[mid], A[end])。而这个条件可以合并到(1)和(2)中。

     */

/*
0 1 2 3 4 5 6 7

4 5 6 7 0 1 2 3    // 7 is mid value  后半段，从 mid可以加1 开始

5 6 7 0 1 2 3 4   // 0 is mid value   前半段， 不能mid-1，必须验证mid。mid可能为最小

3 4 5 6 7 0 1 2   // 6 is mid value  . 后半段，mid可以加1
 */
public class LC_153_FindMinimumRotatedSortedArray {
    public static int findMin(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        while (start < end){//注意这里和普通的二分查找不同，这里是start < end不是 start <= end.
            int mid = start+(end-start)/2;
            if (nums[mid] < nums[end])
                end = mid;//此时不能扔掉mid的值
            else
                start = mid + 1;//此时可以扔掉mid的值
        }
        return nums[start];

    }

    public static void main(String[] args) {
        int[]test = {4,5,6,7,0,1,2};
        System.out.println(findMin(test));

    }
}