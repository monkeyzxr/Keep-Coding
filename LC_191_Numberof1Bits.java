/**
 * Created by monkeyzxr on 2017/6/14.
 *
 * Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).

 For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.
 */

//我自己写
    //提交报错，说2147483648得不错正确结果
    /*
public class LC_191_Numberof1Bits {
    // you need to treat n as an unsigned value
    public static int hammingWeight(int n) {
        int count = 0;
        while (n > 0){
            if ((n & 1) == 1)
                count++;

            n = n >> 1;

        }
        return count;

    }

    public static void main(String[] args) {
        System.out.println(hammingWeight(11));
        System.out.println(hammingWeight(8));

    }

}
*/

    //网上做法：
/*
题目要求算出一个int数二进制表示中1的个数。

n和n-1按位与可以去掉n二进制表示中最右边一位1.

令 n =1101011000

则 n-1=1101010111

n&(n-1)=1101010000  //每一次n & n-1， 都会使原来n的最右的1消掉1个

经过K次n&n-1,n变为0.    K即n的二进制表示中1的个数。

 */
public class LC_191_Numberof1Bits {
    // you need to treat n as an unsigned value
    public static int hammingWeight(int n) {
        int count = 0;
        while(n != 0){
            n &= n - 1;
            count++;
        }
        return count;

    }

    public static void main(String[] args) {
        System.out.println(hammingWeight(11));
        System.out.println(hammingWeight(8));
       // System.out.println(hammingWeight(2147483648));


    }

}