/**
 * Created by monkeyzxr on 2017/8/10.
 *
 Given an array of non-negative integers, you are initially positioned at the first index of the array.

 Each element in the array represents your maximum jump length at that position.

 Determine if you are able to reach the last index.

 For example:
 A = [2,3,1,1,4], return true.

 A = [3,2,1,0,4], return false.
 *
 */


//方法1： DP， 复杂度是 O(n^2) 可能会超时，但是依然需要掌握
    //http://www.jiuzhang.com/solutions/jump-game/
    //https://www.tianmaying.com/tutorial/LC55

    //真的会超时
    /*
public class LC_55_JumpGame {
    public static boolean canJump(int[] nums) {
        boolean[] can = new boolean[nums.length];  //从index=0的位置到当前位置，能否jump,能否联通
        can[0] = true;

        for (int i = 1; i < nums.length; i++){
            for (int j = 0; j < i; j++){ //从第0位开始，向右查看，看看是否和i会联通
                if (can[j] && j + nums[j] >= i){
                    can[i] = true;
                    break;
                }
            }
        }

        return can[nums.length-1];


    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,0,4};
        System.out.println(canJump(nums));

    }
}
*/


    //Greedy
    /*
    本题用一个数 reach 表示能到达的最远下标，一步步走下去，
    如果发现在 reach 范围之内某处能达到的范围大于 reach，那么我们就用更大的范围来替换掉原先的 reach，
    这样一个局部的最优贪心策略，在全局看来也是最优的，因为 局部能够到达的最大范围也是全局能够到达的最大范围：
     */
    //http://blog.csdn.net/happyaaaaaaaaaaa/article/details/51636861
    //http://www.jiuzhang.com/solutions/jump-game/
public class LC_55_JumpGame {
    public static boolean canJump(int[] nums) {
       // think it as merging n intervals
        if (nums == null || nums.length == 0)
            return false;

        int farthest = nums[0];

        for (int i = 1; i < nums.length; i++){
            if (i <= farthest && nums[i] + i >= farthest)
                farthest = nums[i] + i;

        }

        return farthest >= nums.length-1;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,0,4};
        System.out.println(canJump(nums));

    }
}