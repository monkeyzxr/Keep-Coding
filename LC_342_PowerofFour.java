/**
 * Created by monkeyzxr on 2017/8/15.
 *
 Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

 Example:
 Given num = 16, return true. Given num = 5, return false.

 Follow up: Could you solve it without loops/recursion?


 *
 */

// 给定一个有符号整形，让你判断它是不是4的次方数

    //方法1 - Naive Iteration
    //http://www.programcreek.com/2015/04/leetcode-power-of-four-java/
    /*
public class LC_342_PowerofFour {
    public static boolean isPowerOfFour(int num) {
        while (num > 0){
            if (num == 1){
                return true;
            }
            if (num%4 != 0){
                return false;
            }
            else{
                num = num/4;
            }
        }

        return false;

    }

    public static void main(String[] args) {
        System.out.println(isPowerOfFour(16));
        System.out.println(isPowerOfFour(5));
    }
}
*/


    //方法2：Bit Manipulation
    /*http://bookshadow.com/weblog/2016/04/18/leetcode-power-of-four/
    若一个整数是4的幂，则其二进制形式具有如下特点：

1. 最高位为1，其余位为0

2. 0的个数为偶数

条件1可以用num & (num - 1) == 0判断

条件2可以用num & 0x55555555 > 0判断
     */

    //解释清楚：
    //https://www.hrwhisper.me/leetcode-power-four/

    //http://www.programcreek.com/2015/04/leetcode-power-of-four-java/
public class LC_342_PowerofFour {
    public static boolean isPowerOfFour(int num) {
        int count0 = 0;
        int count1 = 0;

        while (num > 0){
            if ((num&1) == 1){
                count1++;
            }
            else {
                count0++;
            }

            num = num >> 1;
        }

        return (count1 == 1) && (count0%2 == 0);


    }

    public static void main(String[] args) {
        System.out.println(isPowerOfFour(16));
        System.out.println(isPowerOfFour(5));
    }
}
