/**
 * Created by monkeyzxr on 2017/7/19.
 *
 A message containing letters from A-Z is being encoded to numbers using the following mapping:

 'A' -> 1
 'B' -> 2
 ...
 'Z' -> 26
 Given an encoded message containing digits, determine the total number of ways to decode it.

 For example,
 Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

 The number of ways decoding "12" is 2.
 *
 */

//题目大意：一种将字母转换成数字的方式是，a->1,b->2,c->2,……,z->26,现给出一个转换后的数字串，问其原来的字母串有多少种可能。

 /*
 //https://www.tianmaying.com/tutorial/LC91
这样的一道题目也许很多人一开始会想到搜索，但是对于“111111……”这样的数据来说，搜索是显然会超时的，所以我们不妨采用动态规划的方法，避免重复子问题的计算。

设定状态为：f[i]表示s从0开始，长度为i的子串的解码方式数量，于是我们最终要求的答案便是f[n]。

那么如何求解f[i]呢？这个很简单，枚举最后一个字母对应1位还是2位，将f转化为规模更小的子问题。

设f[i] = 0
枚举最后一个字母对应1位（要求s[i - 1] != '0')，那么有f[i] += f[i-1]；
枚举最后一个字母对应2位（要求i > 1且s[i - 2]和s[i - 1]组成的字符串在"10"~"26"的范围内），那么有f[i] += f[i - 2]；
也就是说，我们可以通过f[i - 1]和f[i - 2]计算出f[i]来，这就是我们的状态和转移方程。

在具体实现中，我们可以按照i从1到n的顺序，依次计算出所有的f[i]。
     */

 //http://www.jiuzhang.com/solutions/decode-ways/
public class LC_91_DecodeWays {
    public static int numDecodings(String s) {
        if (s == null || s.length() == 0)
            return 0;

        //f[i]表示s从0开始，长度为i的子串的解码方式数量
        int[] f = new int[s.length()+1];  //假如s的长度是10，则f的长度是11，index是0 ～ 10。f要计算最后的长度10的情况，所以f的长度加1。

        f[0] = 1;  //必须初始化

        char[] arr = s.toCharArray();

        for (int i = 1; i <= s.length(); i++){
            if (arr[i-1] != '0'){
                f[i] += f[i-1];   //把前一个字母 对应 1位数字的情况，加入到结果
            }
            if (i >= 2){
                int val = (arr[i-2] - '0') * 10 + (arr[i-1] - '0');
                if (val >= 10 && val <= 26){
                    f[i] += f[i-2]; //把前一个字母 对应 2位数字的情况，加入到结果
                }
            }
        }

        return f[s.length()];
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("12"));

    }
}
