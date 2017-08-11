import java.util.Arrays;

/**
 * Created by monkeyzxr on 2017/8/10.
 *
 Assume you are an awesome parent and want to give your children some cookies. But, you should give each child at most one cookie. Each child i has a greed factor gi, which is the minimum size of a cookie that the child will be content with; and each cookie j has a size sj. If sj >= gi, we can assign the cookie j to the child i, and the child i will be content. Your goal is to maximize the number of your content children and output the maximum number.

 Note:
 You may assume the greed factor is always positive.
 You cannot assign more than one cookie to one child.

 Example 1:
 Input: [1,2,3], [1,1]

 Output: 1

 Explanation: You have 3 children and 2 cookies. The greed factors of 3 children are 1, 2, 3.
 And even though you have 2 cookies, since their size is both 1, you could only make the child whose greed factor is 1 content.
 You need to output 1.


 Example 2:
 Input: [1,2], [1,2,3]

 Output: 2

 Explanation: You have 2 children and 3 cookies. The greed factors of 2 children are 1, 2.
 You have 3 cookies and their sizes are big enough to gratify all of the children,
 You need to output 2.
 *
 */

/*http://www.cnblogs.com/grandyang/p/6077344.html
这道题给了我们一堆cookie，每个cookie的大小不同，还有一堆小朋友，每个小朋友的胃口也不同的，问我们当前的cookie最多能满足几个小朋友。
这是典型的利用贪婪算法的题目，我们可以首先对两个数组进行排序，让小的在前面。
然后我们先拿最小的cookie给胃口最小的小朋友，看能否满足，能的话，我们结果res自加1，然后再拿下一个cookie去满足下一位小朋友；
如果当前cookie不能满足当前小朋友，那么我们就用下一块稍大一点的cookie去尝试满足当前的小朋友。当cookie发完了或者小朋友没有了我们停止遍历
 */


//贪心法
//是一种在每一步选择中都采取在当前状态下最好或最优（即最有利）的选择，从而希望导致结果是最好或最优的算法
public class LC_455_AssignCookies {
    public static int findContentChildren(int[] g, int[] s) {
        int res = 0;
        int pointer = 0;  //历遍熊孩子
        Arrays.sort(g);
        Arrays.sort(s);

        for (int i = 0; i < s.length; i++){  //历遍饼干
            if (s[i] >= g[pointer]){
                res++;
                pointer++;

                if (pointer >= g.length)
                    break;
            }
        }

        return res;

    }

    public static void main(String[] args) {
        int[] g = {1,2};
        int[] s = {1,2,3};

        System.out.println(findContentChildren(g, s));

    }
}
