/**
 * Created by monkeyzxr on 2017/6/11.
 *
 * Given an integer, write a function to determine if it is a power of three.

 Follow up:
 Could you do it without using any loop / recursion?
 */




//http://blog.csdn.net/ebowtang/article/details/50485622
//http://www.programcreek.com/2014/04/leetcode-power-of-three-java/

    //https://leetcode.com/articles/power-of-three/

//用循环：iteration
    /*
public class LC_326_PowerofThree {
    public static boolean isPowerOfThree(int n) {

        while(n > 0 && n%3 == 0){
            n = n/3;
        }
        return n==1;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfThree(9));
        System.out.println(isPowerOfThree(3));

    }
}
*/

    //用递归：recursion
    /*
public class LC_326_PowerofThree {
    public static boolean isPowerOfThree(int n) {
        if (n == 0) return false;
        if (n == 1) return true;

        if (n > 1)
            return n%3 == 0 && isPowerOfThree(n/3);

        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfThree(9));
        System.out.println(isPowerOfThree(3));

    }
}
    */

    //纯数学：
    //find the maximum integer that is a power of 3 and check if it is a multiple of the given input.
public class LC_326_PowerofThree {
    public static boolean isPowerOfThree(int n) {
     // we know maxPowerOfThree = 1162261467:
        return n > 0 && (1162261467 % n == 0);
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfThree(9));
        System.out.println(isPowerOfThree(3));

    }
}