/**
 * Created by monkeyzxr on 2017/7/17.
 *
 Given an unsorted array of integers, find the length of longest increasing subsequence.

 For example,
 Given [10, 9, 2, 5, 3, 7, 101, 18],
 The longest increasing subsequence is [2, 3, 7, 101],
 therefore the length is 4. Note that there may be more than one LIS combination,
 it is only necessary for you to return the length.

 Your algorithm should run in O(n2) complexity.

 Follow up: Could you improve it to O(n log n) time complexity?
 *
 */

//http://www.jiuzhang.com/solutions/longest-increasing-subsequence/

    //这个有好的图示：
//http://www.programcreek.com/2014/04/leetcode-longest-increasing-subsequence-java/

//Let dp[i] represent the length of the longest increasing subsequence so far.
//If any element before i is smaller than nums[i], then dp[i] = max(dp[i], dp[j]+1).
public class LC_300_LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        //d[i]为subset0...i的Longest increasing sub.
        int[] dp = new int[nums.length];

        for (int i = 0; i < nums.length; i++){
            dp[i] = 1; //初始化dp[i] = 1，即一个元素的递增序列
            for (int j = 0; j < i; j++){
                if (nums[j] < nums[i])
                    dp[i] = Math.max(dp[i], dp[j]+1);
            }
        }

        int result = 0;
        for (int i = 0; i < dp.length; i++){
            if (dp[i] > result)
                result = dp[i];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(new LC_300_LongestIncreasingSubsequence().lengthOfLIS(nums)); //return 4

    }
}

//看这个 更好
//https://discuss.leetcode.com/topic/30721/my-easy-to-understand-o-n-2-solution-using-dp-with-video-explanation
/*
public int lengthOfLIS(int[] nums)
	{
		// Base case
		if(nums.length <= 1)
			return nums.length;

		// This will be our array to track longest sequence length
		int T[] = new int[nums.length];

		// Fill each position with value 1 in the array
		for(int i=0; i < nums.length; i++)
			T[i] = 1;


		// Mark one pointer at i. For each i, start from j=0.
		for(int i=1; i < nums.length; i++)
		{
			for(int j=0; j < i; j++)
			{
				// It means next number contributes to increasing sequence.
				if(nums[j] < nums[i])
				{
					// But increase the value only if it results in a larger value of the sequence than T[i]
					// It is possible that T[i] already has larger value from some previous j'th iteration
					if(T[j] + 1 > T[i])
					{
						T[i] = T[j] + 1;
					}
				}
			}
		}

		// Find the maximum length from the array that we just generated
		int longest = 0;
		for(int i=0; i < T.length; i++)
			longest = Math.max(longest, T[i]);

		return longest;
	}
 */