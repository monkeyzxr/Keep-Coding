import java.util.ArrayList;
import java.util.List;

/**
 * Created by monkeyzxr on 2017/7/22.
 *
 Write a program to find the n-th ugly number.

 Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.

 Note that 1 is typically treated as an ugly number, and n does not exceed 1690.

 Hint:

 The naive approach is to call isUgly for every number until you reach the nth one. Most numbers are not ugly.
 Try to focus your effort on generating only the ugly ones.
 An ugly number must be multiplied by either 2, 3, or 5 from a smaller ugly number.
 The key is how to maintain the order of the ugly numbers. Try a similar approach of merging from three sorted lists: L1, L2, and L3.
 Assume you have Uk, the kth ugly number. Then Uk+1 must be Min(L1 * 2, L2 * 3, L3 * 5).

 *
 */

/*http://www.cnblogs.com/grandyang/p/4743837.html
根据提示中的信息，我们知道丑陋数序列可以拆分为下面3个子列表：

(1) 1×2, 2×2, 3×2, 4×2, 5×2, …
(2) 1×3, 2×3, 3×3, 4×3, 5×3, …
(3) 1×5, 2×5, 3×5, 4×5, 5×5, …

仔细观察上述三个列表，我们可以发现每个子列表都是一个丑陋数分别乘以2,3,5，
而要求的丑陋数就是从已经生成的序列中取出来的，我们每次都从三个列表中取出当前最小的那个加入序列
 */

//http://www.jiuzhang.com/solutions/ugly-number-ii/
//http://www.programcreek.com/2014/05/leetcode-ugly-number-ii-java/

    //好好想想，不是很明白
public class LC_264_UglyNumber_II {
    public static int nthUglyNumber(int n) {
        if (n <= 0)
            return 0;

        List<Integer> list = new ArrayList<>();
        list.add(1);  //把第一个丑数 1  加入list中

        int i = 0, j= 0, k = 0;  //设置三个变量存储list的index，初始值都为0
        while(list.size() < n){   // 1, 2, 3, 4, 5, 6, 8, 9, 10, 12
            int m2 = list.get(i) * 2;
            int m3 = list.get(j) * 3;
            int m5 = list.get(k) * 5;

            int min = Math.min(m2, Math.min(m3, m5));
            list.add(min);

            if (min == m2) i++;
            if (min == m3) j++;
            if (min == m5) k++;
        }

        return list.get(list.size()-1);

    }

    public static void main(String[] args) {
        System.out.println(nthUglyNumber(10));

    }
}

// 解释：
//https://discuss.leetcode.com/topic/21791/o-n-java-solution