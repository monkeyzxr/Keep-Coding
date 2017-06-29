/**
 * Created by monkeyzxr on 2017/6/28.
 *
 Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10n.

 Example:
 Given n = 2, return 91. (The answer should be the total numbers in the range of 0 ≤ x < 100,
 excluding [11,22,33,44,55,66,77,88,99])


 *
 */

//题意：给定非负的整数n，求在 0 ≤ x < 10^n  中，有多少每个位上的数字互不相同的数？
// 如 n =2 时，范围为[0,100]， 共有91个数（除了11,22,33,44,55,66,77,88,99）


    /*
    思路：
排列组合题。
设i为长度为i的各个位置上数字互不相同的数。
i==1 : 1 0（0~9共10个数，均不重复）
i==2: 9 * 9 （第一个位置上除0外有9种选择，第2个位置上除第一个已经选择的数，还包括数字0，也有9种选择）
i ==3: 9* 9 * 8 （前面两个位置同i==2，第三个位置除前两个位置已经选择的数还有8个数可以用）
……
i== n: 9 * 9 * 8 *…… (9-i+2)

需要注意的是，9- i + 2 >0 即 i < 11，也就是i最大为10，正好把每个数都用了一遍。
     */

    //本题就是求在大于等于0，小于10的n次方的数，有多少个是独一的不重复位数的数？
//http://blog.csdn.net/qq508618087/article/details/51656771
    //https://www.hrwhisper.me/leetcode-count-numbers-unique-digits/
public class LC_357_CountNumberswithUniqueDigits {
    public static int countNumbersWithUniqueDigits(int n) {
        if (n == 0)  //10^0 = 1
            return 1;
        if (n == 1)  //10^1 = 10
            return 10;

        int val = 9;  //当n >= 1时（大于等于100）， 初始化为9.
                      // val用于计算不同长度时候的数字的个数，如100时，1000时，10000时。。。。。

        int res = 10;  // 初始化为10，就是一个数位长度时，有10个不同的数
        for (int i = 2; i <= n; i++){
            val = val * (9-i+2);
            res += val;

        }

        return res;


    }

    public static void main(String[] args) {
        System.out.println(countNumbersWithUniqueDigits(3));

    }
}
