/**
 * Created by monkeyzxr on 2017/8/17.
 *
 Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.

 Example:
 Given a = 1 and b = 2, return 3.
 *
 */

//Bit Manipulation

    /*http://blog.csdn.net/mebiuw/article/details/51788817
    用的是一个位运算，分为两个步骤：
1、输入 a，b
2、按照位把ab相加，不考虑进位，结果是 a xor b，即1+1 =0 0+0 = 0 1+0=1，进位的请看下面
3、计算ab的进位的话，只有二者同为1才进位，因此进位可以标示为 (a and b) << 1 ，注意因为是进位，所以需要向左移动1位
4、于是a+b可以看成 （a xor b）+ （(a and b) << 1），这时候如果 (a and b) << 1 不为0，就递归调用这个方式吧，因为（a xor b）+ （(a and b) << 1） 也有可能进位，所以我们需要不断的处理进位。


     */

   // http://www.cnblogs.com/grandyang/p/5631814.html
public class LC_371_SumTwoIntegers {
    public static int getSum(int a, int b) {
        int result = a ^ b;  //XOR
        int carry = (a & b) << 1;  //计算进的位

        if (carry != 0)
            return getSum(result,carry);

        return result;


    }

    public static void main(String[] args) {
        System.out.println(getSum(1,2));

    }
}
