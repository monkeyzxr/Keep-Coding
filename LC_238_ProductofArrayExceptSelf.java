import java.util.Arrays;

/**
 * Created by monkeyzxr on 2017/6/14.
 *
 Given an array of n integers where n > 1, nums,
 return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

 Solve it without division and in O(n).

 For example, given [1,2,3,4], return [24,12,8,6].

 Follow up:
 Could you solve it with constant space complexity?
 (Note: The output array does not count as extra space for the purpose of space complexity analysis.)
 *
 */

//对于某一个数字，如果我们知道其前面所有数字的乘积，同时也知道后面所有的数乘积，
// 那么二者相乘就是我们要的结果，
// 所以我们只要分别创建出这两个数组即可，
// 分别从数组的两个方向遍历就可以分别创建出乘积累积数组。

    //这个网址解释图片清楚：
    //http://fisherlei.blogspot.com/2015/10/leetcode-product-of-array-except-self.html

    //http://www.programcreek.com/2014/07/leetcode-product-of-array-except-self-java/
public class LC_238_ProductofArrayExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        int[] forward = new int[nums.length];
        forward[0] = 1;

        int[] backward = new int[nums.length];
        backward[nums.length-1] = 1;

        for (int i = 1; i < nums.length; i++){
            forward[i] = nums[i-1] * forward[i-1];  //对每一个位置，算其左边所有数的乘积

        }

        for(int i = nums.length-2; i >=0; i--){
            backward[i] = nums[i+1] * backward[i+1];
        }

        for (int i = 0; i < nums.length; i++){
            result[i] = forward[i] * backward[i];
        }

        return result;
    }

    public static void main(String[] args) {
        int[]test = {1,2,3,4};
        System.out.println(Arrays.toString(productExceptSelf(test)));

    }
}

/*进行空间上的优化，由于最终的结果都是要乘到结果res中，
所以我们可以不用单独的数组来保存乘积，而是直接累积到res中，
我们先从前面遍历一遍，将乘积的累积存入res中，然后从后面开始遍历，
用到一个临时变量right，初始化为1，然后每次不断累积，最终得到正确结果
Space is O(1).

public int[] productExceptSelf(int[] nums) {
    int[] result = new int[nums.length];

    result[nums.length-1]=1;
    for(int i=nums.length-2; i>=0; i--){
        result[i]=result[i+1]*nums[i+1];
    }

    int left=1;
    for(int i=0; i<nums.length; i++){
        result[i]=result[i]*left;
        left = left*nums[i];
    }

    return result;
}
 */
