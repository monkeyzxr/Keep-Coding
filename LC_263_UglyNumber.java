/**
 * Created by monkeyzxr on 2017/6/6.
 *
 * Write a program to check whether a given number is an ugly number.

 Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.

 Note that 1 is typically treated as an ugly number.
 *
 */

//丑数的含义是其因子只包含2,3,5，判断一个数是否为丑数，只需要将这个数与2,3,5循环相除，如果余数为1，则为丑数，否则不是。
    //http://blog.csdn.net/xujian_2014/article/details/50545174
    //http://blog.csdn.net/xudli/article/details/47786867
public class LC_263_UglyNumber {
    public static boolean isUgly(int num) {
        if(num < 0)
            return false;
        if (num == 1)
            return true;

        //用num一直除以2，3，和5，依次除，直到除不尽，然后看剩下的数是不是1
        while (num >= 2 && num%2 == 0)
            num = num/2;

        while(num >= 3 && num%3 == 0)
            num = num/3;

        while (num >= 5 && num%5 == 0)
            num = num/5;

        if (num == 1)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        System.out.println(isUgly(6));
        System.out.println(isUgly(8));
        System.out.println(isUgly(14));
    }

}
