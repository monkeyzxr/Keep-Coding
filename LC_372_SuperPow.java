/**
 * Created by monkeyzxr on 2017/7/23.
 *
 Your task is to calculate a^b mod 1337 where a is a positive integer and b is an extremely large positive integer given in the form of an array.

 Example1:

 a = 2
 b = [3]

 Result: 8

 Example2:

 a = 2
 b = [1,0]

 Result: 1024
 *
 */


//http://www.cnblogs.com/grandyang/p/5651982.html
// 记住： ab % k = (a%k)(b%k)%k
public class LC_372_SuperPow {
    public static int superPow(int a, int[] b) {
        int result = 1;
        for (int i = 0; i < b.length; i++){
            result = pow(a, b[i]) * pow(result,10)  % 1337;
        }

        return result;

    }

    public static int pow(int x, int n){
        if (n == 0) return 1;
        if (n == 1) return x%1337;  //

        return pow(x%1337, n/2) * pow(x%1337, n - n/2) % 1337;
    }

    public static void main(String[] args) {
        int[] b = {1,0};

        System.out.println(superPow(2, b));

    }
}
