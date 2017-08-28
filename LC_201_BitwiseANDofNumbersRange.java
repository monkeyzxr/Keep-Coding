/**
 * Created by monkeyzxr on 2017/8/27.
 *
 Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.

 For example, given the range [5, 7], you should return 4.
 */

/*
题目大意：
给定范围[m, n]，其中 0 <= m <= n <= 2147483647，返回范围内所有整数的按位与，包括边界。

例如，给定范围[5, 7], 你应该返回4。

 bin     dec
 101       5
 110       6
 111       7
-------------
 100       4
 */

/*
仔细观察我们可以得出，最后的数是该数字范围内所有的数的左边共同的部分，如果上面那个例子不太明显，我们再来看一个范围[26, 30]，它们的二进制如下：

11010　　11011　　11100　　11101　　11110

发现了规律后，我们只要写代码找到左边公共的部分即可，

直接平移m和n，每次向右移一位，直到m和n相等，记录下所有平移的次数i，然后再把m左移i位即为最终结果
 */
public class LC_201_BitwiseANDofNumbersRange {
    public static int rangeBitwiseAnd(int m, int n) {
        int i  = 0;
        while (m != n){
            m >>= 1;
            n >>= 1;
            i++;
        }
        return (m << i);

    }

    public static void main(String[] args) {
        System.out.println(rangeBitwiseAnd(5, 7));

    }
}
