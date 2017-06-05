/**
 * Created by monkeyzxr on 2017/6/4.
 *
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

 For example:

 Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.

 Follow up:
 Could you do it without any loop/recursion in O(1) runtime?
 */


//我写：
    /*
public class LC_258_AddDigits {
    public static int addDigits(int num) {
        while(num >= 10){
            num = addCurrentDigit(num);
        }
     return num;
    }

    public static int addCurrentDigit(int num){
        int sum = 0;
        while (num != 0){
            sum += num % 10;
            num = num / 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(addDigits(38));
        System.out.println(addDigits(5));
        System.out.println(addDigits(58));
        System.out.println(addDigits(10));
    }
}
*/



    //网上思路：数根公式  https://en.wikipedia.org/wiki/Digital_root
    //http://www.cnblogs.com/ganganloveu/p/4749964.html

public class LC_258_AddDigits {
    public static int addDigits(int num) {
        return (int)(num - 9 * Math.floor((double)(num-1)/9));

    }


    public static void main(String[] args) {
        System.out.println(addDigits(38));
        System.out.println(addDigits(5));
        System.out.println(addDigits(58));
        System.out.println(addDigits(10));
    }
}


