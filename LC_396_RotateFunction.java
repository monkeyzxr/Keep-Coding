/**
 * Created by monkeyzxr on 2017/7/22.
 *
 Given an array of integers A and let n to be its length.

 Assume Bk to be an array obtained by rotating the array A k positions clock-wise,
 we define a "rotation function" F on A as follow:

 F(k) = 0 * Bk[0] + 1 * Bk[1] + ... + (n-1) * Bk[n-1].

 Calculate the maximum value of F(0), F(1), ..., F(n-1).

 Note:
 n is guaranteed to be less than 105.

 Example:

 A = [4, 3, 2, 6]

 F(0) = (0 * 4) + (1 * 3) + (2 * 2) + (3 * 6) = 0 + 3 + 4 + 18 = 25
 F(1) = (0 * 6) + (1 * 4) + (2 * 3) + (3 * 2) = 0 + 4 + 6 + 6 = 16
 F(2) = (0 * 2) + (1 * 6) + (2 * 4) + (3 * 3) = 0 + 6 + 8 + 9 = 23
 F(3) = (0 * 3) + (1 * 2) + (2 * 6) + (3 * 4) = 0 + 2 + 12 + 12 = 26

 So the maximum value of F(0), F(1), F(2), F(3) is F(3) = 26.

 *
 */

/*
http://bookshadow.com/weblog/2016/09/11/leetcode-rotate-function/

解题思路：
假设数组A的长度为5，其旋转函数F的系数向量如下所示：

0 1 2 3 4
1 2 3 4 0
2 3 4 0 1
3 4 0 1 2
4 0 1 2 3
用每一行系数与其上一行做差，差值恰好为sum(A) - size * A[size - x]，其中x为行数

因此，通过一次遍历即可求出F(0), F(1), ..., F(n-1)的最大值。
 */

/*
http://www.cnblogs.com/grandyang/p/5869791.html

我们为了找规律，先把具体的数字抽象为A,B,C,D，那么我们可以得到：

F(0) = 0A + 1B + 2C +3D

F(1) = 0D + 1A + 2B +3C

F(2) = 0C + 1D + 2A +3B

F(3) = 0B + 1C + 2D +3A

那么，我们通过仔细观察，我们可以得出下面的规律：

F(1) = F(0) + sum - 4D

F(2) = F(1) + sum - 4C

F(3) = F(2) + sum - 4B

那么我们就找到规律了, F(i) = F(i-1) + sum - n*A[n-i]
 */

//http://www.cnblogs.com/grandyang/p/5869791.html
public class LC_396_RotateFunction {
    public static int maxRotateFunction(int[] A) {
        if (A == null || A.length == 0)
            return 0;

        int sum = 0;
        int preSum = 0;

        for (int i = 0; i < A.length; i++){
            sum += A[i];
            preSum += i * A[i];  //首先得到的第一个F，即F（1）
        }

        int max = preSum;
        for (int i  = 1; i < A.length; i++){
            preSum = preSum + sum - A.length * A[A.length-i];  //更新下一个F
            max = Math.max(max, preSum);
        }

        return max;

    }

    public static void main(String[] args) {
        int[] A = {4,3,2,6};
        System.out.println(maxRotateFunction(A));

    }
}

//好的解释：https://discuss.leetcode.com/topic/58459/java-o-n-solution-with-explanation
/*
F(k) = 0 * Bk[0] + 1 * Bk[1] + ... + (n-1) * Bk[n-1]
F(k-1) = 0 * Bk-1[0] + 1 * Bk-1[1] + ... + (n-1) * Bk-1[n-1]
       = 0 * Bk[1] + 1 * Bk[2] + ... + (n-2) * Bk[n-1] + (n-1) * Bk[0]
Then,

F(k) - F(k-1) = Bk[1] + Bk[2] + ... + Bk[n-1] + (1-n)Bk[0]
              = (Bk[0] + ... + Bk[n-1]) - nBk[0]
              = sum - nBk[0]
Thus,

F(k) = F(k-1) + sum - nBk[0]




What is Bk[0]?

k = 0; B[0] = A[0];
k = 1; B[0] = A[len-1];
k = 2; B[0] = A[len-2];
...



int allSum = 0;
int len = A.length;
int F = 0;
for (int i = 0; i < len; i++) {
    F += i * A[i];
    allSum += A[i];
}
int max = F;
for (int i = len - 1; i >= 1; i--) {
    F = F + allSum - len * A[i];
    max = Math.max(F, max);
}
return max;
 */

