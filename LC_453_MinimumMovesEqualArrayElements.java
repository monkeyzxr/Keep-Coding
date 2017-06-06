/**
 * Created by monkeyzxr on 2017/6/5.
 *
 * Given a non-empty integer array of size n,
 * find the minimum number of moves required to make all array elements equal,
 * where a move is incrementing n - 1 elements by 1.

 Example:

 Input:
 [1,2,3]

 Output:
 3

 Explanation:
 Only three moves are needed (remember each move increments two elements):

 [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 *
 */


//网上思路：http://www.cnblogs.com/grandyang/p/6053827.html
    //https://www.liuchuo.net/archives/3007
    //正确的解法相当的巧妙，需要换一个角度来看问题，
// 其实给n-1个数字加1，效果等同于给那个未被选中的数字减1，
// 比如数组[1，2，3], 给除去最大值的其他数字加1，变为[2，3，3]，
// 我们全体减1，并不影响数字间相对差异，变为[1，2，2]，
// 这个结果其实就是原始数组的最大值3自减1，那么问题也可能转化为，将所有数字都减小到最小值，这样难度就大大降低了，
// 我们只要先找到最小值，然后累加每个数跟最小值之间的差值即可
public class LC_453_MinimumMovesEqualArrayElements {
    public static int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        int result = 0;
        for (int num : nums)   //找到array中的最小值
            min = Math.min(min, num);

        for (int num : nums){
            result += num -min;   //也可以sum(array) - n * minimum
        }

        return result;
    }

    public static void main(String[] args) {
        int[]test ={1,2,3};
        System.out.println(minMoves(test));
    }
}

