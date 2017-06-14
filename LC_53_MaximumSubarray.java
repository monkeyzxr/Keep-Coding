import java.util.Arrays;

/**
 * Created by monkeyzxr on 2017/5/31.
 *
 Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

 For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 the contiguous subarray [4,-1,2,1] has the largest sum = 6.

 */


// 我写： 另建一个sum array的思路，找sum array里的最大值减去之前最小值，就是结果
    //但是，不成功，切麻烦。因为，如果是-1，-1，-1，-1，就得不出结果
    /*
public class LC_53_MaximumSubarray {
    public static int maxSubArray(int[] nums) {
        int[] sumArray = new int[nums.length];
        sumArray[0] = nums[0];
        for (int i = 1; i < sumArray.length; i++){
            sumArray[i] = sumArray[i-1] + nums[i];
        }
        System.out.println(Arrays.toString(sumArray));

        int maxSum = Integer.MIN_VALUE;
        int minValue = sumArray[0];

        if (sumArray.length == 1)
            return sumArray[0];
        else {
            for (int i = 1; i < sumArray.length; i++){
                if(minValue > sumArray[i])
                    minValue = sumArray[i];
                else{
                    if (maxSum < sumArray[i] - minValue)
                        maxSum = sumArray[i] - minValue;
                }
            }
            return maxSum;
        }


    }

    public static void main(String[] args) {
        int[] test1 = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(test1));

        int[] test2 = {0,0,0,0,-1};
        System.out.println(maxSubArray(test2));

        int[] test3 = {1};
        System.out.println(maxSubArray(test3));

        int[] test4 = {-1,-1,-1,-1};             //这个情况下得不到正确结果
        System.out.println(maxSubArray(test4));

    }
}
*/

    //方法2：Dynamic programming
    //http://fisherlei.blogspot.com/2012/12/leetcode-maximum-subarray.html

    //这个思路正确，但是MIN——Value会得到奇怪的结果，所以，要用方法3
    /*
public class LC_53_MaximumSubarray {
    public static int maxSubArray(int[] nums) {
        int result = Integer.MIN_VALUE;
        int curr = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++){
            if (curr + nums[i] > nums[i])
                curr = curr + nums[i];
            else
                curr = nums[i];

            result = Math.max(result,curr);

        }
        return result;


    }

    public static void main(String[] args) {
        int[] test1 = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(test1));

        int[] test2 = {0,0,0,0,-1};
        System.out.println(maxSubArray(test2));

        int[] test3 = {1};
        System.out.println(maxSubArray(test3));

        int[] test4 = {-1,-1,-1,-1};             //这个情况下得不到正确结果
        System.out.println(maxSubArray(test4));

    }
}
*/

    //方法3：  好好体会啊
    //http://www.cnblogs.com/ganganloveu/p/3771408.html
    //http://fisherlei.blogspot.com/2012/12/leetcode-maximum-subarray.html
    //http://www.programcreek.com/2013/02/leetcode-maximum-subarray-java/
public class LC_53_MaximumSubarray {
    public static int maxSubArray(int[] nums) {
        int maxSum = nums[0];       //初始化，数组里的第一个数
        int currentSum = nums[0];  //初始化

        for (int i = 1; i < nums.length; i++){
            currentSum = Math.max(nums[i], currentSum+nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;

    }

    public static void main(String[] args) {
        int[] test1 = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(test1));

        int[] test2 = {0,0,0,0,-1};
        System.out.println(maxSubArray(test2));

        int[] test3 = {1};
        System.out.println(maxSubArray(test3));

        int[] test4 = {-1,-1,-1,-1};
        System.out.println(maxSubArray(test4));

    }
}

/*

http://www.programcreek.com/2013/02/leetcode-maximum-subarray-java/

The changing condition for dynamic programming is
"We should ignore the sum of the previous n-1 elements if nth element is greater than the sum."

public class Solution {
	public int maxSubArray(int[] A) {
		int max = A[0];
		int[] sum = new int[A.length];
		sum[0] = A[0];

		for (int i = 1; i < A.length; i++) {
			sum[i] = Math.max(A[i], sum[i - 1] + A[i]);
			max = Math.max(max, sum[i]);
		}

		return max;
	}
}


  public int maxSubArray(int[] A) {
       int newsum=A[0];
       int max=A[0];
       for(int i=1;i<A.length;i++){
           newsum=Math.max(newsum+A[i],A[i]);
           max= Math.max(max, newsum);
       }
       return max;
    }


 */

