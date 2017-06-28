/**
 * Created by monkeyzxr on 2017/6/27.
 *
 You are climbing a stair case. It takes n steps to reach to the top.

 Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

 Note: Given n will be a positive integer.

 */

/*
思路

n = 1， result = 1
n = 2, result = 1+1 (爬1階兩次 + 一次爬兩階)
n = 3, result = 1+2 (前面兩個case相加)
n = 4, result = 3+2 (前面兩個case相加)
發現其實這題就是算費氏數列
 */

//你正在爬楼梯。爬到顶部需要n步。
//每一次你爬1步或者2步。爬到顶部有多少种不同的方式？

//每一次爬可以有1步活着2步，所以第i次的时候，可以找之前第i-1次的方式数，或者第i-2次的方式数。二者之和，就是总的方式数。
public class LC_70_ClimbingStairs {
    public static int climbStairs(int n) {
        if(n < 1)
            return 0;
        if (n == 1)
            return 1;
        if (n ==2)
            return 2;

        int[] dp = new int[n];  //创一个array，index是从0～n-1。 存放第i步时候，所总共产生的方式数

        dp[0] = 1; // 走了1步时（index=0），结果为1。因为只能走1步到1
        dp[1] = 2;  // 走了2步时（index=1）， 可以是先1步，后1步；也可直接走到第2步。所以共2种方式。

        for (int i = 2; i < n; i++){
            dp[i] = dp[i-1] + dp[i-2];  // 第n步的方式，取决的前一步和前二步的方式的总和
        }

        return dp[n-1]; //返回数组的最后一个数。



    }

    public static void main(String[] args) {
        System.out.println(climbStairs(10));

    }
}
