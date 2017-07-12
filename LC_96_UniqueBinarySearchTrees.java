/**
 * Created by monkeyzxr on 2017/7/10.
 *
 Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

 For example,
 Given n = 3, there are a total of 5 unique BST's.

 1         3     3      2      1
 \       /     /      / \      \
 3     2     1      1   3      2
 /     /       \                 \
 2     1         2                 3
 */

/*// http://www.programcreek.com/2014/05/leetcode-unique-binary-search-trees-java/

Let count[i] be the number of unique binary search trees for i.
The number of trees are determined by the number of subtrees which have different root node. For example,

i=0, count[0]=1 //empty tree

i=1, count[1]=1 //one tree

i=2, count[2]=count[0]*count[1] // 0 is root
            + count[1]*count[0] // 1 is root

i=3, count[3]=count[0]*count[2] // 1 is root
            + count[1]*count[1] // 2 is root
            + count[2]*count[0] // 3 is root

i=4, count[4]=count[0]*count[3] // 1 is root
            + count[1]*count[2] // 2 is root
            + count[2]*count[1] // 3 is root
            + count[3]*count[0] // 4 is root
..
..
..

i=n, count[n] = sum(count[0..k]*count[k+1...n]) 0 <= k < n-1
 */


//或者：http://bangbingsyb.blogspot.com/2014/11/leetcode-unique-binary-search-trees-i-ii.html
/*
定义f(n)为unique BST的数量，以n = 3为例：

构造的BST的根节点可以取{1, 2, 3}中的任一数字。

如以1为节点，则left subtree只能有0个节点，而right subtree有2, 3两个节点。所以left/right subtree一共的combination数量为：f(0) * f(2) = 2

以2为节点，则left subtree只能为1，right subtree只能为2：f(1) * f(1) = 1

以3为节点，则left subtree有1, 2两个节点，right subtree有0个节点：f(2)*f(0) = 2

总结规律：
f(0) = 1
f(n) = f(0)*f(n-1) + f(1)*f(n-2) + ... + f(n-2)*f(1) + f(n-1)*f(0)

 */

/*
解法 //  https://www.tianmaying.com/tutorial/LC96

本题是一道比较容易的动态规划，对于一颗二叉树，简单来说可以分为：

     根节点
    /     \
 左子树   右子树
假如整个树有 n 个节点，根节点为 1 个节点，两个子树平分剩下的 n-1 个节点。

假设我们已经知道节点数量为 x 的二叉树有dp[x]种不同的形态。

则一颗二叉树左节点节点数量为 k 时，其形态数为dp[k] * dp[n - 1 - k]。

而对于一颗 n 个节点的二叉树，其两个子树分配节点的方案有 n-1 种：

(0, n-1), (1, n-2), ..., (n-1, 0)
因此我们可以得到对于 n 个节点的二叉树，其形态有：

Sigma(dp[i] * dp[n-1-i]) | i = 0 .. n-1
并且可以发现，dp数组有递推关系，我们可以使用递推或是记忆化搜索来实现。

边界条件为dp[0] = 1。
 */
public class LC_96_UniqueBinarySearchTrees {
    public static int numTrees(int n) {
        //定义数组
        int [] dp = new int [n+1];

        //初始化
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++){
            //用j来循环除了root之外的子树node,例如，想象j是左子树的node个数
            for (int j = 0; j <= i-1; j++){  //i-1，因为root已经确定了，只看子树
                dp[i] += dp[j] * dp[i-1-j];
            }
        }
        return dp[n];

    }

    public static void main(String[] args) {
        System.out.println(numTrees(3));

    }
}
