import java.util.HashSet;
import java.util.Set;

/**
 * Created by monkeyzxr on 2017/6/3.
 *
 * Write an algorithm to determine if a number is "happy".

 A happy number is a number defined by the following process:
 Starting with any positive integer,
 replace the number by the sum of the squares of its digits,
 and repeat the process until the number equals 1 (where it will stay),
 or it loops endlessly in a cycle which does not include 1.
 Those numbers for which this process ends in 1 are happy numbers.

 Example: 19 is a happy number

 12 + 92 = 82
 82 + 22 = 68
 62 + 82 = 100
 12 + 02 + 02 = 1
 *
 */

/*
* 範例：判斷4是不是happy number：
*           4 (要验证的数)
4^2       = 16
1^2 + 6^2 = 37
3^2 + 7^2 = 58
.....
......... = 20
2^2 + 0   = 4
4重複出現，因此進入無窮迴圈
*
* */

//http://www.programcreek.com/2014/04/leetcode-happy-number-java/
    //https://my.oschina.net/Tsybius2014/blog/524681

//思路： 计算出平方和，用一个set存放这个和，如果这个和已经存在于set了，表示无穷循环
public class LC_202HappyNumber {
    public static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();

        while(!set.contains(n)){   //如果计算sum得到的数，已经存在与set里，则跳出循环。
            set.add(n);    //把要验证的数先加入到set，随后的循环，加入计算得到的sum。
            n = getSum(n);
            if (n == 1)
                return true;
        }
        return false;

    }
    // 计算出当前数的平方和：如：19输入， 82 输出。
    public static int getSum(int n){
        int sum = 0;
        while(n > 0){
            sum += (n%10) * (n%10);  //每次把个位数字的平方和，加入到sum里
            n = n/10;   //把n／10，使n的后位变成个位。相当于数字一直往右移
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(19));
        System.out.println(isHappy(4));

    }
}
