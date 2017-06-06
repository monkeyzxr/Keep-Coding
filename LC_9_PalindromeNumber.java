/**
 * Created by monkeyzxr on 2017/6/4.
 *
 * Determine whether an integer is a palindrome. Do this without extra space.
 */


// 复制将给定 x 从低位往高位开始，复制为另外一个高位至低位，得到一个给定值的反序。
// 再比较两者是否相等。
// 意思就是拿个镜子，然后照出镜子里跟自己左右相反的自己。如果是自己是完全对称的（这里是回文），那例外两个看一起一定一模一样的。
    //http://www.cnblogs.com/yrbbest/p/4430410.html
public class LC_9_PalindromeNumber {
    public static boolean isPalindrome(int x) {
        if (x < 0)
            return false;

        int newx = 0;
        int tmp = x;
        while (tmp > 0){
            newx = newx * 10 + tmp % 10;  //Reverse all digits 把每次加入的digit都乘以10，继续加新的digit
            tmp = tmp / 10;
        }

       // System.out.println("The new reverse int is " + newx);
        return newx == x;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(122));
        System.out.println(isPalindrome(0));

    }
}
