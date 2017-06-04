/**
 * Created by monkeyzxr on 2017/6/3.
 *
 * Given an array of integers, every element appears twice except for one. Find that single one.

 Note:
 Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 */

// 3,4,6,8,2,3,4,6,8

//给定一个数组，只有一个元素出现了一次，其它元素都出现了两次，找出那个只出现一次的数。可以遍历数组，分别进行异或运算。
// 注：异或运算：相同为0，不同为1。遍历并异或的结果就是那个只出现了一次的数
    //对于任何数x，都有x^x=0，x^0=x
    //采用异或运算^
        //a ^ a = 0
       // a ^ 0 = a
       // a ^ b ^ c = a ^ (b ^ c)
    //http://blog.csdn.net/xujian_2014/article/details/50555877


public class LC_136_SingleNumber {
    public static int singleNumber(int[] nums) {
        int result = nums[0];
        for (int i = 1; i < nums.length; i++){
            result ^= nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[]test = new int[]{3,4,6,8,2,3,4,6,8};
        System.out.println(singleNumber(test));
    }

}
