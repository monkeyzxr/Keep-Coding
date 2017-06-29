import java.util.Arrays;

/**
 * Created by monkeyzxr on 2017/6/27.
 *
 Given a non-empty array containing only positive integers,
 find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.

 Note:
 Each of the array element will not exceed 100.
 The array size will not exceed 200.
 Example 1:

 Input: [1, 5, 11, 5]

 Output: true

 Explanation: The array can be partitioned as [1, 5, 5] and [11].


 Example 2:

 Input: [1, 2, 3, 5]

 Output: false

 Explanation: The array cannot be partitioned into equal sum subsets.
 *
 */

/*
原数组所有数字和一定是偶数，不然根本无法拆成两个和相同的子集合，那么我们只需要算出原数组的数字之和，然后除以2，就是我们的target，
那么问题就转换为能不能找到一个非空子集合，使得其数字之和为target。
 */

/*
用动态规划。
我们定义一个一维的dp数组，其中dp[i]表示数字i是否是原数组的任意个子集合之和，
那么我们我们最后只需要返回dp[target]就行了。
我们初始化dp[0]为true，由于题目中限制了所有数字为正数，那么我们就不用担心会出现和为0或者负数的情况。

那么关键问题就是要找出递归公式了，
我们需要遍历原数组中的数字，对于遍历到的每个数字nums[i]，
我们需要更新我们的dp数组，要更新[nums[i], target]之间的值，
那么对于这个区间中的任意一个数字j，如果dp[j - nums[i]]为true的话，那么dp[j]就一定为true，

于是地推公式如下：

dp[j] = dp[j] || dp[j - nums[i]]         (nums[i] <= j <= target)
 */

//http://www.cnblogs.com/grandyang/p/5951422.html


    //http://bgmeow.xyz/2017/01/04/LeetCode-416/
    /*
    这个方法的关键句就在于 dp[j] = dp[j] || dp[j - nums[i-1]]; 。
    dp[j] 代表能否组合成和为 j 的结果。
    对于每一个数字，选择都是两个，放或者不放。
    所以，如果不放第 i 个数字，那问题就变成了前 i - 1 个数字能否组合成和为 j 的结果；
    如果放第 i 个数字，那问题就变成了前 i - 1 个数字能否组合成和为 j - nums[i] 的结果。
    只要这两种情况有一种存在， dp[j] 就成立。
    另注：本题里因为多加了 dp[0] 所以 dp[i] 其实对应的是 nums[i - 1] 。

    public boolean canPartition(int[] nums) {
    // 特殊情况
    if (nums == null || nums.length == 0) {
        return true;
    }
    // 求出总和先
    int volumn = 0;
    for (int num : nums) {
        volumn += num;
    }
    // 若为奇数，返回 false
    if (volumn % 2 != 0) {
        return false;
    }
    volumn /= 2;

    // dp def
    boolean[] dp = new boolean[volumn + 1];

    // dp init
    dp[0] = true;

    // dp transition
    for (int i = 1; i <= nums.length; i++) {
        for (int j = volumn; j >= nums[i-1]; j--) {
            dp[j] = dp[j] || dp[j - nums[i-1]];
        }
    }
    return dp[volumn];
}

     */

public class LC_416_PartitionEqualSubsetSum {
    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i : nums)
            sum += i;

        if (sum % 2 != 0)
            return false;

        int target = sum / 2;

        //size只要比target大就行
        boolean[] dp = new boolean[target+1]; //dp[i]表示: 数字i 是否 是原数组的任意个子集合之和


        //array初始化全部是false
        Arrays.fill(dp, false);

        dp[0] = true; //给定的元素都是正数，所以index一定大于0。这里设置等于零的情况。

        for (int num : nums){
            for (int i = target; i > 0; i--){
                if (i >= num)
                    dp[i] = dp[i] || dp[i - num];
            }
        }

        return dp[target];



    }

    public static void main(String[] args) {
        int[] test = {1,5,11,5};
        System.out.println(canPartition(test));

    }
}

/*
//http://blog.csdn.net/qq508618087/article/details/52774116
思路：一个背包的题目，背包容量为数组中元素和的一半＋１，这样只要看是否有元素可以正好填满背包即可．
但是每个元素只能用一次，所以在尝试放一个元素的时候还要避免他对尝试放其他位置时对自己的影响．
所以在尝试放一个元素到背包的时候需要从容量最大的位置开始，
如果（当前位置－当前元素大小）位置可以通过放置之前的元素达到，则当前位置也可以通过放置当前元素正好达到这个位置．
状态转移方程为：dp[i] = dp[i] || dp[i - nums[k]];

代码如下：


class Solution {
public:
    bool canPartition(vector<int>& nums) {
        int sum = accumulate(nums.begin(), nums.end(), 0);
        if(sum&1) return false;
        vector<int> dp(sum/2+1, 0);
        for(int i = 0, dp[0] = 1; i < nums.size(); i++)
        {
            for(int j = sum/2; j >= nums[i]; j--)
                dp[j] = dp[j] || dp[j-nums[i]];
        }
        return dp[sum/2];
    }
};
 */