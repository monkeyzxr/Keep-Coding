import java.util.Arrays;

/**
 * Created by monkeyzxr on 2017/7/22.
 *
 Given a non-empty integer array, find the minimum number of moves required to make all array elements equal,
 where a move is incrementing a selected element by 1 or decrementing a selected element by 1.

 You may assume the array's length is at most 10,000.

 Example:

 Input:
 [1,2,3]

 Output:
 2

 Explanation:
 Only two moves are needed (remember each move increments or decrements one element):

 [1,2,3]  =>  [2,2,3]  =>  [2,2,2]
 *
 */

//题目大意：给定非空整数数组，求使得数组中的所有元素均相等的最小移动次数，一次移动是指将某个元素加1或者减1。
//即求一个数k，这个数距离所有数的距离绝对值之和最小，明显是中位数。
//http://www.caesium.space/2017/03/12/Leetcode-462-Minimum-Moves-to-Equal-Array-Elements-II/

    /*http://www.cnblogs.com/grandyang/p/6089060.html
    我们首先给数组排序，那么我们最终需要变成的相等的数字就是 中间的数，
    如果数组有奇数个，那么就是最中间的那个数字；如果是偶数个，那么就是中间两个数的区间中的任意一个数字。
    而两端的数字变成中间的一个数字需要的步数实际上就是两端数字的距离。那么我们就两对两对的累加它们的差值就可以了
    就是：求数组各元素与中位数差的绝对值之和
     */

    //http://blog.csdn.net/mebiuw/article/details/53264724
public class LC_462_MinimumMovesEqualArrayElements_II {
    public static int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        int median = nums[nums.length/2];

        for (int num : nums){
            sum += Math.abs(median - num);
        }

        return sum;

    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(minMoves2(nums));

    }
}
