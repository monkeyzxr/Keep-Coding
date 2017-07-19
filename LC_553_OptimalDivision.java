/**
 * Created by monkeyzxr on 2017/7/18.
 *
 Given a list of positive integers, the adjacent integers will perform the float division.
 For example, [2,3,4] -> 2 / 3 / 4.

 However, you can add any number of parenthesis at any position to change the priority of operations.
 You should find out how to add parenthesis to get the maximum result,
 and return the corresponding expression in string format.
 Your expression should NOT contain redundant parenthesis.

 Example:
 Input: [1000,100,10,2]
 Output: "1000/(100/10/2)"
 Explanation:
 1000/(100/10/2) = 1000/((100/10)/2) = 200
 However, the bold parenthesis in "1000/((100/10)/2)" are redundant,
 since they don't influence the operation priority. So you should return "1000/(100/10/2)".

 Other cases:
 1000/(100/10)/2 = 50
 1000/(100/(10/2)) = 50
 1000/100/10/2 = 0.5
 1000/100/(10/2) = 2
 Note:

 The length of the input array is [1, 10].
 Elements in the given array will be in range [2, 1000].
 There is only one optimal division for each test case.
 *
 */

/*
题目大意：
给定一组正整数，相邻整数之间使用除号连接。例如，[2,3,4] -> 2 / 3 / 4

在其中加入括号可以改变运算顺序，求运算结果最大时的加括号方案，返回表达式。
 */

/*

//http://www.cnblogs.com/hellowooorld/p/6807513.html

大牛原话：

“X1/X2/X3/../Xn will always be equal to (X1/X2) * Y,no matter how you place parentheses.

i.e no matter how you place parentheses, X1 always goes to the numerator and X2 always goes to the denominator.

Hence you just need to maximize Y. And Y is maximized when it is equal to X3 *..*Xn.

So the answer is always X1/(X2/X3/../Xn) = (X1 *X3 *..*Xn)/X2”

有了这个结果其实就简单了。。。重要的是过程，要想得到最大结果，那么第一个数字X1一定是作为分子，第二个数X2一定是作为分母。

于是就有了  》》》》》》》》》》》》   X1/(X2/X3/../Xn) 。


我们只需要考虑三种情况：
　　1.只有一个数，直接返回；
　　2.有两个数，第一个除以第二个返回；
　　3.有三个及以上的数，把第二个数后面的和第一个数全部乘起来，最后除以第二个数。（
因为note当中说明了，给的数字都是[2,1000]的，所以第二个数后面的所有数乘起来都只会让结果变大）
 */

//http://blog.csdn.net/qq_27262609/article/details/70208042
    //X1/(X2/X3/../Xn) 就是结果的形式

    /*
    X1/X2/X3/../Xn will always be equal to (X1/X2) * Y,
    no matter how you place parentheses.
    i.e no matter how you place parentheses, X1 always goes to the numerator and X2 always goes to the denominator.
    Hence you just need to maximize Y. And Y is maximized when it is equal to X3 *..*Xn.

    So the answer is always    X1/(X2/X3/../Xn) = (X1 *X3 *..*Xn)/X2
     */
public class LC_553_OptimalDivision {
    public static String optimalDivision(int[] nums) {

        if (nums.length == 1)
            return nums[0] + "";

        if (nums.length == 2)
            return nums[0] + "/" + nums[1];

        String str = "";
        for (int i = 1; i < nums.length-1; i++){  //从第二个数字开始，直到最后，所有的数字在一个括号里
            str = str + nums[i] + "/";

        }

        if (nums.length > 1){
            str = str + nums[nums.length-1]; //把最后一位的数字加进去，避免再加一次 "／"
        }

        return nums[0] + "/" + "(" + str + ")";


    }

    public static void main(String[] args) {
        int[] nums = {1000, 100, 10, 2};
        System.out.println(optimalDivision(nums));

    }
}
