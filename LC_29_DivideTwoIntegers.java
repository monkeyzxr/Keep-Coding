/**
 * Created by monkeyzxr on 2017/8/3.
 *
 Divide two integers without using multiplication, division and mod operator.

 If it is overflow, return MAX_INT.
 *
 */

//题目大意，给两个数，要求实现除法运算，但是不能用乘法、除法和模运算。
//用除数每次*2（向左移动一位）去逼近被除数，被除数减去新的除数如此循环。
    /*
    This problem can be solved based on the fact that any number can be converted to the format of the following:

    num=a_0*2^0+a_1*2^1+a_2*2^2+...+a_n*2^n
     */

    //http://www.jiuzhang.com/solutions/divide-two-integers/
public class LC_29_DivideTwoIntegers {
    public static int divide(int dividend, int divisor) {
        //dividend 被除数
        // divisor 除数

        if (divisor == 0)
            return dividend >= 0? Integer.MAX_VALUE : Integer.MIN_VALUE;

        if (dividend == 0)
            return 0;

        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;

        boolean isNegative = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0);

        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);

        int result = 0;

        while (a >= b){  //如果被除数 大于等于 除数
            int shift = 0;
            while (a >= (b << shift)){  //被除数 * 2
                shift++;
            }

            //dividend minus the largest shifted divisor
            a -= b << (shift-1);
            result += 1 <<(shift-1);
        }

        return isNegative? -result : result;

    }

    public static void main(String[] args) {
        System.out.println(divide(6, 2));
        System.out.println(divide(9, 2));


    }

}

//http://www.programcreek.com/2014/05/leetcode-divide-two-integers-java/
/*
Analysis:

This problem can be solved based on the fact that any number can be converted to the format of the following:

num=a_0*2^0+a_1*2^1+a_2*2^2+...+a_n*2^n
The time complexity is O(logn).

///////////////////////////////////////////////////

public int divide(int dividend, int divisor) {
    //handle special cases
    if(divisor==0) return Integer.MAX_VALUE;
    if(divisor==-1 && dividend == Integer.MIN_VALUE)
        return Integer.MAX_VALUE;

    //get positive values
    long pDividend = Math.abs((long)dividend);
    long pDivisor = Math.abs((long)divisor);

    int result = 0;
    while(pDividend>=pDivisor){
        //calculate number of left shifts
        int numShift = 0;
        while(pDividend>=(pDivisor<<numShift)){
            numShift++;
        }

        //dividend minus the largest shifted divisor
        result += 1<<(numShift-1);
        pDividend -= (pDivisor<<(numShift-1));
    }

    if((dividend>0 && divisor>0) || (dividend<0 && divisor<0)){
        return result;
    }else{
        return -result;
    }
}
 */
