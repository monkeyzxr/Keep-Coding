import java.util.Arrays;

/**
 * Created by monkeyzxr on 2017/6/25.
 *
 Given an integer array, find three numbers whose product is maximum and output the maximum product.

 Example 1:
 Input: [1,2,3]
 Output: 6

 Example 2:
 Input: [1,2,3,4]
 Output: 24

 Note:
 The length of the given array will be in range [3,104] and all elements are in the range [-1000, 1000].
 Multiplication of any three numbers in the input won't exceed the range of 32-bit signed integer.
 *
 */

//思路：数字可正可负。
// 求三个乘积最大，注意下负数的情况，两负*一正的情况也需要考虑。
    //http://www.dongcoder.com/detail-568603.html
public class LC_628_MaximumProductThreeNumbers {
    public static int maximumProduct(int[] nums) {
        Arrays.sort(nums);  //先排序
        int n = nums.length;

        int max = nums[n-1] * nums[n-2] * nums[n-3];  //后三个，比如全是正数
        max = Math.max(max, nums[n-1] * nums[n-2] * nums[0]); //前2个，后1个
        max = Math.max(max, nums[0] * nums[1] * nums[n-1]);   //前1个，后2个
        max = Math.max(max, nums[0] * nums[1] * nums[2]);  //前3个  ，比如全是负数

        return max;


    }

    public static void main(String[] args) {
        int[] test1 = {1,2,3,4};
        System.out.println(maximumProduct(test1));

        int[] test2 = {-1,-2,-3,-4};
        System.out.println(maximumProduct(test2));

        int[] test3 = {-1,-2,-3,-4, 0, 1,2,3};
        System.out.println(maximumProduct(test3));

    }
}
