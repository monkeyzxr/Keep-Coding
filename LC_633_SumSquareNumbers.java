/**
 * Created by monkeyzxr on 2017/7/10.
 *
 Given a non-negative integer c, your task is to decide whether there're two integers a and b such that a2 + b2 = c.

 Example 1:
 Input: 5
 Output: True
 Explanation: 1 * 1 + 2 * 2 = 5

 Example 2:
 Input: 3
 Output: False
 *
 */

//http://blog.csdn.net/kangbin825/article/details/74784377
//思路：类似于二分查找。从0 和sqrt(n)两端分别查找。
public class LC_633_SumSquareNumbers {
    public static boolean judgeSquareSum(int c) {
        int low = 0;
        int high = (int)Math.sqrt(c);

        while(low <= high){
            int sum = low*low + high*high;
            if (sum < c)
                low++;
            else if (sum > c)
                high--;
            else if (sum == c)
                return true;
        }

        return false;


    }

    public static void main(String[] args) {
        System.out.println(judgeSquareSum(5));
        System.out.println(judgeSquareSum(3));

    }
}
