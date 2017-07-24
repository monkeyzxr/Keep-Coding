import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by monkeyzxr on 2017/7/23.
 *
 Given a set of distinct positive integers,
 find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies: Si % Sj = 0 or Sj % Si = 0.

 If there are multiple solutions, return any subset is fine.

 Example 1:

 nums: [1,2,3]

 Result: [1,2] (of course, [1,3] will also be ok)

 Example 2:

 nums: [1,2,4,8]

 Result: [1,2,4,8]
 *
 */

//给定一个不重复正整数集合，寻找最大子集，使得子集中的任意一对元素 (Si, Sj) 均满足Si % Sj = 0或者Sj % Si = 0。
//思路：其实和求最大上升子序列LIS差不多，只不过这题要求输出序列而已。
// 先把数组排好序。首先要明确，若a<b且b%a==0 ,  b <c 且 c%b==0那么必然有c%a==0
// 我们设dp[i] 为最大的子集长度，更新的时候保存上一个的下标即可。

    /*
动态规划（Dynamic Programming）

状态转移方程：

dp[x] = max(dp[x], dp[y] + 1)  其中： 0 <= y < x 且 nums[x] % nums[y] == 0
     */

    //https://www.hrwhisper.me/leetcode-largest-divisible-subset/
    //http://www.cnblogs.com/grandyang/p/5625209.html
/*
    较小数对较大数取余一定为0，那么问题就变成了看较大数能不能整除这个较小数。
    那么如果数组是无序的，处理起来就比较麻烦，所以我们首先可以先给数组排序，这样我们每次就只要看后面的数字能否整除前面的数字。

    定义一个动态数组dp，其中dp[i]表示到数字nums[i]位置最大可整除的子集合的长度，

    还需要一个一维数组parent，来保存上一个能整除的数字的位置，
    两个整型变量mx和mx_idx分别表示最大子集合的长度和起始数字的位置，
    我们可以从后往前遍历数组，对于某个数字再遍历到末尾，在这个过程中，如果nums[j]能整除nums[i], 且dp[i] < dp[j] + 1的话，更新dp[i]和parent[i]，
    如果dp[i]大于mx了，还要更新mx和mx_idx，最后循环结束后，我们来填res数字，根据parent数组来找到每一个数字
     */
public class LC_368_LargestDivisibleSubset {
    public static List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums.length == 0) return result;

        Arrays.sort(nums);
        int[] dp = new int[nums.length];    // dp[i]表示到数字nums[i]位置最大可整除的子集合的长度
        int[] parent = new int[nums.length];  //parent，来保存上一个能整除的数字的位置，即存放index
        Arrays.fill(dp, 0);
        Arrays.fill(parent,0);

        int max = 0;  //记录最大的dp【i】，也就是最大的set里面的数字的个数
        int maxIndex = 0;  //最大的set的 起始的index

        for (int i = nums.length-1; i >= 0; i--){  //从右往左走  // 1 , 2, 4, 8
            for (int j = i; j < nums.length; j++){
                if (nums[j]%nums[i] == 0  && dp[i] < dp[j]+1){  //这里的if必须要判断dp[i] 和 dp[j]+1之间的大小，符合条件，才能继续下去
                    dp[i] = dp[j] +1;//加一，就是加上当前i对应的数字
                    parent[i] = j;  //存放i的右侧的数的index

                    if (dp[i] > max){
                        max = dp[i];
                        maxIndex = i;
                    }
                }
            }
        }

        for (int i = 0; i < max; i++){
            result.add(nums[maxIndex]);
            maxIndex = parent[maxIndex]; //这里好好想想。parent放的是 右侧能整除当前数字的 那个数字的index
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,4,8};
        System.out.println(largestDivisibleSubset(nums));

    }
}

/*
https://discuss.leetcode.com/topic/49741/easy-understood-java-dp-solution-in-28ms-with-o-n-2-time

The basic idea is like:

1. Sort
2. Find the length of longest subset
3. Record the largest element of it.
4. Do a loop from the largest element to nums[0], add every element belongs to the longest subset.
The old version cant pass the test case [1,2,4,8,9,72] and [4,8,10,240], thanks for that @Yanning and @svc
Here comes the revised version:

public static List<Integer> largestDivisibleSubset(int[] nums) {
    List<Integer> res = new ArrayList<Integer>();
    if (nums == null || nums.length == 0) return res;
    Arrays.sort(nums);
    int[] dp = new int[nums.length];
    dp[0] = 1;

    //for each element in nums, find the length of largest subset it has.
    for (int i = 1; i < nums.length; i++){
        for (int j = i-1; j >= 0; j--){
            if (nums[i] % nums[j] == 0){
                dp[i] = Math.max(dp[i],dp[j] + 1);
            }
        }
    }

    //pick the index of the largest element in dp.
    int maxIndex = 0;
    for (int i = 1; i < nums.length; i++){
        maxIndex = dp[i] > dp[maxIndex] ?  i :  maxIndex;
    }

    //from nums[maxIndex] to 0, add every element belongs to the largest subset.
    int temp = nums[maxIndex];
    int curDp = dp[maxIndex];
    for (int i = maxIndex; i >= 0; i--){
        if (temp % nums[i] == 0 && dp[i] == curDp){
            res.add(nums[i]);
            temp = nums[i];
            curDp--;
        }
    }
    return res;
}
 */