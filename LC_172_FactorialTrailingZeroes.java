/**
 * Created by monkeyzxr on 2017/6/9.
 *
 * Given an integer n, return the number of trailing zeroes in n!.

 Note: Your solution should be in logarithmic time complexity.
 */


//http://www.cnblogs.com/grandyang/p/4219878.html

//http://bookshadow.com/weblog/2014/12/30/leetcode-factorial-trailing-zeroes/


//求n的阶乘的末尾零的个数
    //首先求出n!，然后计算末尾0的个数。（重复÷10，直到余数非0）该解法在输入的数字稍大时就会导致阶乘得数溢出，不足取。

    //考虑n!的质数因子(不能继续分解的质数)。后缀0总是由质因子2和质因子5相乘得来的。如果我们可以计数2和5的个数，问题就解决了。
    //n = 5: 5!的质因子中 (2 * 2 * 2 * 3 * 5)包含一个5和三个2。因而后缀0的个数是1。

//n = 11: 11!的质因子中(2^8 * 3^4 * 5^2 * 7)包含两个5和三个2。于是后缀0的个数就是2。
    //我们很容易观察到质因子中2的个数总是大于等于5的个数。因此只要计数5的个数就可以了。
//仍需注意的一点就是，像25,125，这样的不只含有一个5的数字需要考虑进去
public class LC_172_FactorialTrailingZeroes {
    public static int trailingZeroes(int n) {
        int res = 0;
        while(n > 0){
            res += n/5;
            n = n/5;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(trailingZeroes(125));
        System.out.println(trailingZeroes(25));
        System.out.println(trailingZeroes(5));

    }
}
