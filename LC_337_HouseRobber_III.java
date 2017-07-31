/**
 * Created by monkeyzxr on 2017/7/30.
 *
 The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root."
 Besides the root, each house has one and only one parent house.
 After a tour, the smart thief realized that "all houses in this place forms a binary tree".
 It will automatically contact the police if two directly-linked houses were broken into on the same night.

 Determine the maximum amount of money the thief can rob tonight without alerting the police.

 Example 1:
   3
  / \
  2   3
  \   \
   3   1
 Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.

 Example 2:
      3
     / \
    4   5
   / \   \
   1   3   1
 Maximum amount of money the thief can rob = 4 + 5 = 9.
 *
 */

//深度优先遍历二叉树，每次遍历返回两个值：分别表示偷窃或者不偷窃当前节点可以获得的最大收益。

    //http://www.cnblogs.com/grandyang/p/5275096.html
    //https://discuss.leetcode.com/topic/39834/step-by-step-tackling-of-the-problem/2
public class LC_337_HouseRobber_III {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public static int rob(TreeNode root) {
        if (root == null)
            return 0;

        int[] result = dfs(root);

        return Math.max(result[0], result[1]);

    }

    /*
    这种方法的递归函数返回一个大小为2的一维数组res，
    其中res[0]表示不包含当前节点值的最大值，res[1]表示包含当前值的最大值，
    那么我们在遍历某个节点时，首先对其左右子节点调用递归函数，分别得到包含与不包含左子节点值的最大值，和包含于不包含右子节点值的最大值，
    那么当前节点的res[0]就是左子节点两种情况的较大值加上右子节点两种情况的较大值，
    res[1]就是不包含左子节点值的最大值加上不包含右子节点值的最大值，和当前节点值之和，
    返回即可
     */
    public static int[] dfs(TreeNode root){
        if (root  == null){
            int[] result = {0,0};
            return result;
        }

        int[] result = new int[2];
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        // result[0] is when root is selected, result[1] is when not.
        result[0] = root.val + left[1] + right[1];    //0 代表偷， 1代表不偷
        result[1] =  Math.max(left[0],left[1]) + Math.max(right[0], right[1]);

        return result;

    }

    public static void main(String[] args) {

    }
}
