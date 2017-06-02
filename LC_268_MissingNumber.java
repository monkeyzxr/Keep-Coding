/**
 * Created by monkeyzxr on 2017/6/1.
 *
 *Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, //（就是说，n个数，等差数列，0到n，最大值也是n。最小值可以从1开始）
 * find the one that is missing from the array.

 For example,
 Given nums = [0, 1, 3] return 2.

 Note:
 Your algorithm should run in linear runtime complexity.
 Could you implement it using only constant extra space complexity?
 *
 */

//等差数列先求得总和，然后减去给定的队列，剩下的值就是缺失值。
    //http://blog.csdn.net/nk_test/article/details/49391369
public class LC_268_MissingNumber {
    public static int missingNumber(int[] nums) {
        int n = nums.length;  //n即为个数，也是array的最大值
        int expectSum = (1+n)*n/2;   //等差数列求和公式，从1开始加。第一个零忽略。
        int acturalSum = 0;          //实际的array不一定是排好序的。
        for (int i = 0; i < n; i++){
            acturalSum += nums[i];
        }
        return expectSum - acturalSum;
    }

    public static void main(String[] args) {
        int[]test1 = {0,1,3};
        System.out.println(missingNumber(test1));
    }
}
