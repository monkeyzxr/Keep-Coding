import java.util.Arrays;

/**
 * Created by monkeyzxr on 2017/8/27.
 *
 Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice.
 Find the two elements that appear only once.

 For example:

 Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].

 Note:
 The order of the result is not important. So in the above example, [5, 3] is also correct.
 Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
 *
 */

//题目大意：给定一个整数数组，其中除两个数字只出现一次外，其余数字均出现两次。找出这两个只出现一次的数字。



//这个有很好的解释：
//https://segmentfault.com/a/1190000004886431
/*
1. 通过遍历整个数组并求整个数组所有数字之间的 XOR，根据 XOR 的特性可以得到最终的结果为 AXORB = A XOR B；
2. 通过某种特定的方式，我们可以通过 AXORB 得到在数字 A 和数字 B 的二进制下某一位不相同的位；因为A 和 B 是不相同的，所以他们的二进制数字有且至少有一位是不相同的。我们将这一位设置为 1，并将所有的其他位设置为 0，我们假设我们得到的这个数字为 bitFlag；
3. 那么现在，我们很容易知道，数字 A 和 数字 B 中必然有一个数字与上 bitFlag 为 0；因为bitFlag 标志了数字 A 和数字 B 中的某一位不同，那么在数字 A 和 B 中的这一位必然是一个为 0，另一个为 1；而我们在 bitFlag 中将其他位都设置为 0，那么该位为 0 的数字与上 bitFlag 就等于 0，而该位为 1 的数字与上 bitFlag 就等于 bitFlag
4. 现在问题就简单了，我们只需要在循环一次数组，将与上 bitFlag 为 0 的数字进行 XOR 运算，与上 bitFlag 不为 0 的数组进行独立的 XOR 运算。那么最后我们得到的这两个数字就是 A 和 B。
*/


/* http://blog.csdn.net/sbitswc/article/details/48410781
Solution:
1. Use XOR to store the difference among these numbers, if XOR all elements, the result is the difference between two number like result = 3^5

then 3^result = 5 , 5^ result = 3
2. Find one digit 1 in the result, which can be used to distinguish 3 and 5. depends on this, XOR elements will be equal to 3^result = 5 , 5^ result = 3

O(n) use constant space
     */




///好好想想：
public class LC_260_SingleNumber_III {
    public static int[] singleNumber(int[] nums) {
        int [] res = new int[]{0,0};

        int result = nums[0];
        for (int i = 1; i < nums.length; i++){
            result = result ^ nums[i];
        }

        //找到数字 A 和数字 B 中不相同的一位，并将该位设置为 1，其他位设置为 0；
        // 根据 XOR 的定义，我们知道，在 AXORB 中，为 1 的位即 A 和 B 不相同的位，AXORB 中为 0 的位即 A 和 B 中相同的位
       // 所以，要找到 A 和 B 中不相同的位，只需要找到在 AXORB 中从右往左第一个为 1 的位，保留该位并将其他位置为 0 即可。
        int n = result & (~(result-1));


        for (int i = 0; i < nums.length; i++){
            if ((n & nums[i]) != 0){
                res[0] = res[0] ^ nums[i];
            }
            else {
                res[1] = res[1] ^ nums[i];
            }
        }

        return res;

    }

    public static void main(String[] args) {
        int [] nums = {1, 2, 1, 3, 2, 5};
        System.out.println(Arrays.toString(singleNumber(nums)));

    }
}
