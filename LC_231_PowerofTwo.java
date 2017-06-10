/**
 * Created by monkeyzxr on 2017/6/9.
 *
 * Given an integer, write a function to determine if it is a power of two.
 */

//If a number is power of 2, it's binary form should be 10...0
    //如果一个数是2的Power，那么该数的二进制串中只有一位为1，其余都为0。
    //这么想：如果n是2的几次幂，那么n一直除以2，结果就是1（例如n=8）。
// 对于 >> (right shift)，右移n的二进制的一位，相当于除2，右移n位相当于除以2的n次方。
// 那么，n一直右移，就相当于一直除以2，结果为1，则说明原来的n的二进制一定是 100000......。

    //http://www.programcreek.com/2014/07/leetcode-power-of-two-java/
public class LC_231_PowerofTwo {
    public static boolean isPowerOfTwo(int n) {
        if(n <=  0)
            return false;

        int a = n & (n-1);   // 10000 & 01111

        if (a == 0)
            return true;

        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(2));
        System.out.println(isPowerOfTwo(128));
        System.out.println(isPowerOfTwo(6));
    }
}
