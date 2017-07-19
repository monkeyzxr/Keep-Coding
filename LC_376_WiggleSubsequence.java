/**
 * Created by monkeyzxr on 2017/7/17.
 *
 A sequence of numbers is called a wiggle sequence if the differences between successive numbers strictly alternate between positive and negative.
 The first difference (if one exists) may be either positive or negative. A sequence with fewer than two elements is trivially a wiggle sequence.

 For example, [1,7,4,9,2,5] is a wiggle sequence because the differences (6,-3,5,-7,3) are alternately positive and negative.
 In contrast, [1,4,7,2,5] and [1,7,4,5,5] are not wiggle sequences,
 the first because its first two differences are positive and the second because its last difference is zero.

 Given a sequence of integers, return the length of the longest subsequence that is a wiggle sequence.
 A subsequence is obtained by deleting some number of elements (eventually, also zero) from the original sequence,
 leaving the remaining elements in their original order.

 Examples:
 Input: [1,7,4,9,2,5]
 Output: 6
 The entire sequence is a wiggle sequence.

 Input: [1,17,5,10,13,15,10,5,16,8]
 Output: 7
 There are several subsequences that achieve this length. One is [1,17,10,13,10,16,8].

 Input: [1,2,3,4,5,6,7,8,9]
 Output: 2
 Follow up:
 Can you do it in O(n) time?
 *
 */

/*题目大意：
如果一个序列的相邻数字之差在正数和负数之间交替变换，则称此序列为一个“摆动序列”。
第一个差值（如果存在的话）正负均可。
少于两个元素的序列也被认为是摆动序列。

例如，[1,7,4,9,2,5] 是一个摆动序列，因为差值(6,-3,5,-7,3)正负交替。
反例， [1,4,7,2,5] 以及 [1,7,4,5,5] 不是摆动序列，第一个是因为前两个差值连续为正，第二个是因为最后一个差值是0。

给定一个整数序列，返回其最长摆动子序列的长度。一个子序列可以通过从原始序列中删除一定数目的（也可以为0）元素得到。
 */

/*
摇摆序列要求升高，降低，升高。。。
或者降低，升高，降低。。。
那么我们只要找出数组中的“拐点” 即可 举个例子:
4 5 6  3 2 1这几个数中，4为起点，那么5和6中，我们肯定选6啊~因为之后的数要求小于5，小于5的必定也小于6 比如改为4 5 6 5，之前要是选5就没办法继续往下了。。
总之就是选最小的和选最大的（也就是拐点） 保证不丢最优解。
 */
//https://www.hrwhisper.me/leetcode-wiggle-subsequence/
    //http://www.programcreek.com/2014/07/leetcode-wiggle-subsequence-java/

    /*

public class LC_376_WiggleSubsequence {
    public static int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length < 2)
            return nums.length;

        int  count = 1;

        //j  i
        //4  5  6  3  2  1
        for (int i = 1,j = 0; i < nums.length; j = i, i++){  //循环结束时，j的位置时新找到的i的位置，即拐点位置。i往右再走一位。
            if (nums[j] < nums[i]){ //两个数是 升序 情况时：
                count++;
                while (i < nums.length-1 && nums[i] <= nums[i+1]) //找一直升序的最大值（最高点）
                    i++;
            }
            else if (nums[j] > nums[i]){  //两个数是 降序 情况时
                count++;
                while (i < nums.length-1 && nums[i] >= nums[i+1])
                    i++;
            }
        }

        return count;

    }

    public static void main(String[] args) {
        int[]nums = {1,17,5,10,13,15,10,5,16,8};
        System.out.println(wiggleMaxLength(nums));

    }
}
*/


    //方法2： DP
    /*https://discuss.leetcode.com/topic/52076/easy-understanding-dp-solution-with-o-n-java-version

    For every position in the array, there are only three possible statuses for it.

up position, it means nums[i] > nums[i-1]
down position, it means nums[i] < nums[i-1]
equals to position, nums[i] == nums[i-1]

So we can use two arrays up[] and down[] to record the max wiggle sequence length so far at index i.

If nums[i] > nums[i-1], that means it wiggles up. the element before it must be a down position. so up[i] = down[i-1] + 1; down[i] keeps the same with before.
If nums[i] < nums[i-1], that means it wiggles down. the element before it must be a up position. so down[i] = up[i-1] + 1; up[i] keeps the same with before.
If nums[i] == nums[i-1], that means it will not change anything becasue it didn't wiggle at all. so both down[i] and up[i] keep the same.

In fact, we can reduce the space complexity to O(1), but current way is more easy to understanding.


     */
public class LC_376_WiggleSubsequence {
    public static int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length < 2)
            return nums.length;

        int[] up = new int[nums.length];
        int[] down = new int[nums.length];

        up[0] = 1;
        down[0] = 1;

        for (int i = 1; i < nums.length; i++){
            if (nums[i] > nums[i-1]){
                up[i] = down[i-1] + 1;
                down[i] = down[i-1];
            }
            else if (nums[i] < nums[i-1]){
                down[i] = up[i-1] + 1;
                up[i] = up[i-1];
            }
            else {
                down[i] = down[i-1];
                up[i] = up[i-1];
            }
        }

        return Math.max(down[nums.length-1], up[nums.length-1]);



    }

    public static void main(String[] args) {
        int[]nums = {1,17,5,10,13,15,10,5,16,8};
        System.out.println(wiggleMaxLength(nums));

    }
}
