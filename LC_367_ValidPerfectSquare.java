/**
 * Created by monkeyzxr on 2017/6/11.
 *
 Given a positive integer num, write a function which returns True if num is a perfect square else False.

 Note: Do not use any built-in library function such as sqrt.

 Example 1:
 Input: 16
 Returns: True

 Example 2:
 Input: 14
 Returns: False
 *
 */

//9 is a square number, since it can be written as 3 × 3

    //我写，用二分查找法：
    //提交，会显示Time Limit Exceeded
    /*
public class LC_367_ValidPerfectSquare {
    public static boolean isPerfectSquare(int num) {
        int begin = 0;
        int end  = num;

        while(begin <= end){
            int mid = begin + (end-begin)/2;
            if (mid * mid == num)
                return true;
            else if (mid * mid < num)
                begin = mid + 1;
            else if (mid * mid > num)
                end = mid - 1;
        }

        if (begin * begin == num || end * end == num)
            return true;

        return false;

    }

    public static void main(String[] args) {
        System.out.println(isPerfectSquare(4));
        System.out.println(isPerfectSquare(9));
        System.out.println(isPerfectSquare(16));
        System.out.println(isPerfectSquare(25));

        System.out.println(isPerfectSquare(8));
        System.out.println(isPerfectSquare(14));


    }
}
*/


    //http://www.cnblogs.com/grandyang/p/5619296.html
//修改：//这里可能会溢出，所以我选择了使用long的方式进行
    //修改成long，提交正常

public class LC_367_ValidPerfectSquare {
    public static boolean isPerfectSquare(int num) {
        long begin = 0;
        long end  = num;

        while(begin <= end){
            long mid = begin + (end-begin)/2;
            if (mid * mid == num)
                return true;
            else if (mid * mid < num)
                begin = mid + 1;
            else if (mid * mid > num)
                end = mid - 1;
        }

        //这两句可以不用
      //  if (begin * begin == num || end * end == num)
      //      return true;

        return false;

    }

    public static void main(String[] args) {
        System.out.println(isPerfectSquare(4));
        System.out.println(isPerfectSquare(9));
        System.out.println(isPerfectSquare(16));
        System.out.println(isPerfectSquare(25));

        System.out.println(isPerfectSquare(8));
        System.out.println(isPerfectSquare(14));


    }
}


    //
/*
* 纯数学解法了，利用到了这样一条性质，完全平方数是一系列奇数之和，例如：

1 = 1
4 = 1 + 3
9 = 1 + 3 + 5
16 = 1 + 3 + 5 + 7
25 = 1 + 3 + 5 + 7 + 9
36 = 1 + 3 + 5 + 7 + 9 + 11
....
1+3+...+(2n-1) = (2n-1 + 1)n/2 = n*n

这里就不做证明了，我也不会证明，知道了这条性质，就可以利用其来解题了，时间复杂度为O(sqrt(n))。
*
*
* */
/*
public class LC_367_ValidPerfectSquare {
    public static boolean isPerfectSquare(int num) {
        int i = 1;

        while (num > 0) {
            num -= i;
            i += 2;
        }
        return num == 0;
    }

    public static void main(String[] args) {
        System.out.println(isPerfectSquare(4));
        System.out.println(isPerfectSquare(9));
        System.out.println(isPerfectSquare(16));
        System.out.println(isPerfectSquare(25));

        System.out.println(isPerfectSquare(8));
        System.out.println(isPerfectSquare(14));


    }
}

*/