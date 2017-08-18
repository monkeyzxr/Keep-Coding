import java.util.Arrays;

/**
 * Created by monkeyzxr on 2017/8/17.
 *
 Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.

 Example:
 For num = 5 you should return [0,1,1,2,1,2].

 Follow up:

 It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
 Space complexity should be O(n).
 Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.
 *
 */

/*https://www.hrwhisper.me/leetcode-counting-bits/
想一想，当一个数为2的整数幂的时候，1的个数为1，比如2（10) 和4(100)，8(1000)
在这之后就是前一个序列的数+1 比如 9(1001) = 1(1) + 8 (1) = 2
就是把一个数分解为小于它的最大2的整数幂 + x
 */

/*
For number 2(10), 4(100), 8(1000), 16(10000), ..., the number of 1's is 1.
Any other number can be converted to be 2^m + x.
For example, 9=8+1, 10=8+2. The number of 1's for any other number is 1 + # of 1's in x.
 */

//有好图示：
//http://www.programcreek.com/2015/03/leetcode-counting-bits-java/

public class LC_338_CountingBits {
    public static int[] countBits(int num) {
        int [] res = new int[num+1];  //array的个数是num+1个
        int pow = 1;
        int p = 1; //p tracks the index for number x

        for (int i = 1; i <= num; i++){
            if (i == pow){
                res[i] = 1;
                pow  = pow << 1;
                p = 1;
            }
            else {
                res[i] = res[p] + 1;
                p++;
            }
        }

        return res;

    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(9)));

    }
}
