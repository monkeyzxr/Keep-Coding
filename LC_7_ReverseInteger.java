import java.util.Arrays;

/**
 * Created by monkeyzxr on 2017/6/9.
 *
 * Reverse digits of an integer.

 Example1: x = 123, return 321
 Example2: x = -123, return -321
 Note:
 The input is assumed to be a 32-bit signed integer.
 Your function should return 0 when the reversed integer overflows.

 If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.

 Did you notice that the reversed integer might overflow?
 Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows.

 For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.


 */

//我自己写，最简单思路。int转换成String。但是报错
    /*
public class LC_7_ReverseInteger {
    public static int reverse(int x) {
        if (x == 0)
            return 0;

        String s = String.valueOf(x);
        int length = s.length();
        char[] result = new char[length];

        if (s.charAt(0) == '-'){
            result[0] = '-';
            int j = 1;
            for (int i = length-1; i >= 1; i--){
                if (s.charAt(i) == '0')
                    continue;

                else {
                    result[j] = s.charAt(i);
                    j++;
                }
            }
        }

        if (s.charAt(0) != '-'){
            int j = 0;
            for (int i = length-1; i>=0; i--){
                if (s.charAt(i) == '0')
                    continue;
                else {
                    result[j] = s.charAt(i);
                    j++;
                }
            }
        }

        String a = String.valueOf(result);
        System.out.println(a);
        int r = Integer.valueOf(a);

        if (r > 2147483647 || r < -2147483648)
            return 0;

        return r;
    }

    public static void main(String[] args) {
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(0));
        System.out.println(reverse(100));


    }
}
*/

    //我重新写，还是int转成String的思路
    /*
public class LC_7_ReverseInteger {
    public static int reverse(int x) {
        int absX = Math.abs(x); //取x的绝对值

        String str = String.valueOf(absX);
        String newStr = (x < 0) ? "-" : "";
        for (int i = str.length()-1; i >= 0; i--){
            newStr += str.charAt(i);
        }

        Long l = Long.valueOf(newStr);  //001会变成1. 用Long来存。
        if (l > Integer.MAX_VALUE || l < Integer.MIN_VALUE)
            return 0;

        int i = Integer.valueOf(l.intValue());  // 把Long 转化成 int
        return i;


    //    return (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) ? 0:result;

    }

    public static void main(String[] args) {
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(0));
        System.out.println(reverse(100));
        System.out.println(reverse(1646324353));
        System.out.println(reverse(-246384741));

    }
}
    */

    //网上做法：不用转成String
    //int类型只能表示范围在[-2147483648, 2147483647]的数字
    //http://www.cnblogs.com/grandyang/p/4125588.html
public class LC_7_ReverseInteger {
    public static int reverse(int x) {
        long res = 0;
        while (x != 0){
            res = res * 10 + x % 10;
            x = x / 10;
        }
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE)
            return 0;

        return (int)res;


    }

    public static void main(String[] args) {
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(0));
        System.out.println(reverse(100));
        System.out.println(reverse(1646324353));
        System.out.println(reverse(-246384741));

    }
}