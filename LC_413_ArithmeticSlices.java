import java.util.Arrays;

/**
 * Created by monkeyzxr on 2017/7/15.
 *
 A sequence of number is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.

 For example, these are arithmetic sequence:

 1, 3, 5, 7, 9
 7, 7, 7, 7
 3, -1, -5, -9
 The following sequence is not arithmetic.

 1, 1, 2, 5, 7

 A zero-indexed array A consisting of N numbers is given. A slice of that array is any pair of integers (P, Q) such that 0 <= P < Q < N.

 A slice (P, Q) of array A is called arithmetic if the sequence:
 A[P], A[p + 1], ..., A[Q - 1], A[Q] is arithmetic. In particular, this means that P + 1 < Q.

 The function should return the number of arithmetic slices in the array A.


 Example:

 A = [1, 2, 3, 4]

 return: 3, for 3 arithmetic slices in A: [1, 2, 3], [2, 3, 4] and [1, 2, 3, 4] itself.
 */

//http://www.cnblogs.com/grandyang/p/5968340.html
    //这道题让我们算一种算数切片，说白了就是找等差数列，限定了等差数列的长度至少为3
    //1,2,3,4]含有3个长度至少为3的算数切片，
// 我们再来看[1,2,3,4,5]有多少个呢:
// len = 3: [1,2,3], [2,3,4], [3,4,5]
        //len = 4: [1,2,3,4], [2,3,4,5]
        //len = 5: [1,2,3,4,5]
       // 那么我们可以找出递推式，长度为n的等差数列中含有长度至少为3的算数切片的个数为(n-1)(n-2)/2
    //那么题目就变成了找原数组中等差数列的长度，然后带入公式去算个数即可

    //http://blog.csdn.net/mebiuw/article/details/52876206
    //我认为，就是求数组中 等差数列的大于3的长度

    /*
public class LC_413_ArithmeticSlices {
    public static int numberOfArithmeticSlices(int[] A) {
        int res = 0;
        int len = 2; //初始化为2， 认为是等差数列两端的数。len大约等于3才能 套公式

        for (int i = 2; i < A.length; i++){  //公式里有A【i-2】，所以，i要从2开始循环
            if (A[i]-A[i-1] == A[i-1]-A[i-2])  //在找一段连续的等差数列的长度
                len++;
            else {
                if (len > 2)
                    res += (len-1)*(len-2)*0.5;

                len = 2; // 等差数列的长度恢复初始化2
            }
        }

        if (len > 2)
            res += (len-1)*(len-2)*0.5;
        return res;
    }

    public static void main(String[] args) {
        int[] A = {1,2,3,4,5};
        System.out.println(numberOfArithmeticSlices(A));

    }
}
*/

    /*
    用DP来做，定义一个一维dp数组，其中dp[i]表示，到i位置为止的算数切片的个数，
    那么我们从第三个数字开始遍历，如果当前数字和之前两个数字构成算数切片，那么我们更新dp[i]为dp[i-1]+1，然后res累加上dp[i]的值即可
     */

    /*
public class LC_413_ArithmeticSlices {
    public static int numberOfArithmeticSlices(int[] A) {
        int res = 0;
        int[] dp = new int[A.length];
        Arrays.fill(dp, 0);

        for (int i = 2; i < A.length; i++){
            if (A[i]-A[i-1] == A[i-1]-A[i-2])
                dp[i] = dp[i-1] + 1;

            res += dp[i];
        }
        return res;

    }

    public static void main(String[] args) {
        int[] A = {1,2,3,4,5};
        System.out.println(numberOfArithmeticSlices(A));

    }
}
    */


    //重新写DP
    //https://discuss.leetcode.com/topic/62992/3ms-c-standard-dp-solution-with-very-detailed-explanation
    //这个更好
public class LC_413_ArithmeticSlices {
    public static int numberOfArithmeticSlices(int[] A) {
        if (A.length < 3)
            return 0;

        int[] dp = new int[A.length];
        Arrays.fill(dp, 0);// dp[i] means the number of arithmetic slices ending with A[i]

        //初始化
        if (A[2] - A[1] == A[1] - A[0])// if the first three numbers are arithmetic or not
            dp[2] = 1;

        int result = dp[2];

        for (int i = 3; i < A.length; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2])
                dp[i] = dp[i - 1] + 1;

            result += dp[i];
        }
        return result;

    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        System.out.println(numberOfArithmeticSlices(A));

    }

}
