/**
 * Created by monkeyzxr on 2017/7/15.
 *
 Implement pow(x, n).
 */

//计算x的n次幂

//思路：分治递归
    //递归公式为：x^n = x^(n/2) * x^(n/2) * x^(n%2)  （n可能是偶数，也可能是奇数）
    //http://bangbingsyb.blogspot.com/2014/11/leetcode-powx-n.html

public class LC_50_Pow_x_n {
    public static double myPow(double x, int n) {
        if(n >=0 )
            return powPositive(x, n);
        else
            return 1/powPositive(x, -n);

    }

    public static double powPositive(double x, int n){
        if (n == 0)
            return 1; //base case

        double res = powPositive(x, n/2);
        res *= res;

        if (n%2 != 0) //即n是奇数，除以2，余数是1
            res *= x;  // 再把奇数的余数的那个x 乘进去

        return res;
    }

    public static void main(String[] args) {
        System.out.println(myPow(2, 3));
        System.out.println(myPow(2.0000, -2147483648));


    }
}



//相同的思路
    //http://www.jiuzhang.com/solutions/powx-n/
    /*
public class LC_50_Pow_x_n {
    public static double myPow(double x, int n) {
        if (n == 0)
            return 1;
        if (n == 1)
            return x;

        boolean isNegative = false;
        if (n < 0){
            isNegative = true;
            n *= -1;
        }

        int k = n/2;
        int r = n%2; //余数要么1，要么0
        //或者 r = n - k*2;
        double t1 = myPow(x, k);
        double t2 = myPow(x, r);

        if (isNegative)
            return 1 / (t1*t1*t2);

        else
            return t1*t1*t2;
    }



    public static void main(String[] args) {
        System.out.println(myPow(2, 3));

    }
}
    */