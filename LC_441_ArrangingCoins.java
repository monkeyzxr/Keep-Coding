/**
 * Created by monkeyzxr on 2017/6/5.
 *
 * You have a total of n coins that you want to form in a staircase shape,
 * where every k-th row must have exactly k coins.

 Given n, find the total number of full staircase rows that can be formed.

 n is a non-negative integer and fits within the range of a 32-bit signed integer.

 Example 1:

 n = 5

 The coins can form the following rows:
 ¤
 ¤ ¤
 ¤ ¤

 Because the 3rd row is incomplete, we return 2.


 Example 2:

 n = 8

 The coins can form the following rows:
 ¤
 ¤ ¤
 ¤ ¤ ¤
 ¤ ¤

 Because the 4th row is incomplete, we return 3.
 *
 */

/* 数学推导
假设完成K层，一共N个，由等差数列求和公式有：
(1+x)*x/2 <= n
x + x*x <= 2*n
4*x*x + 4*x <= 8*n
(2*x + 1)*(2*x + 1) - 1 <= 8*n
x <= (sqrt(8*n + 1) - 1) / 2
*/

//http://www.voidcn.com/blog/cloudox_/article/p-6255475.html
public class LC_441_ArrangingCoins {
    public static int arrangeCoins(int n) {
        if (n <= 0)
            return 0;

        //注意在此处n为32位有符号整型数，8 * n后有可能溢出，故在代码中应做相应处理, 转换成long。
        int row = (int)((Math.sqrt(8*(long)n + 1) - 1)/2);
        return row;
    }

    public static void main(String[] args) {
        System.out.println(arrangeCoins(8));
        System.out.println(arrangeCoins(5));

    }
}
