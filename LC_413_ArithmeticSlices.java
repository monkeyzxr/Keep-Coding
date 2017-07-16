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

public class LC_413_ArithmeticSlices {
    public static int numberOfArithmeticSlices(int[] A) {
        int len = 2

    }

    public static void main(String[] args) {

    }
}
