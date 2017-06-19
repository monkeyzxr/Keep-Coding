import java.util.ArrayList;
import java.util.List;

/**
 * Created by monkeyzxr on 2017/6/18.
 *
 Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

 For example:
 Given the below binary tree and sum = 22,
             5
            / \
           4   8
          /   / \
         11  13  4
        /  \    / \
       7    2  5   1
 return
 [
     [5,4,11,2],
     [5,8,4,5]
 ]

 *
 */


//http://www.cnblogs.com/grandyang/p/4042156.html
//http://blog.csdn.net/happyaaaaaaaaaaa/article/details/51636652
//采用回溯算法。
// 回溯算法要求我们准备一个中间集 temp，一个结果集 res。这里和以往题目递归中包含循环，循环中嵌套递归的不同。
// 本题没有包含循环。
// 递归遍历过程中，往中间集当中添加节点值，遍历结束的条件为 root 的左右节点均为空，即到叶子节点为止，
// 如果满足条件——路径上各节点值和等于 sum，那么就可以将结果集添加到中间集当中。
// 回溯是在递归完左右子树后，再将该节点移除
public class LC_113_PathSum_II {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null)
            return res;

        List<Integer> temp = new ArrayList<Integer>();

        dfs(root, res, temp, sum);

        return res;

    }

    private void dfs(TreeNode root, List<List<Integer>> res, List<Integer> temp, int sum) {
        temp.add(root.val);
        sum -= root.val;

        if(root.left == null && root.right == null)  //递归结束条件
            if(sum == 0)
                res.add(new ArrayList<>(temp));  //满足路径和等于 sum，添加到结果集中去

        if(root.left != null)
            dfs(root.left, res, temp, sum);

        if(root.right != null)
            dfs(root.right, res, temp, sum);

        temp.remove(temp.size()-1);  //回溯
    }

    public static void main(String[] args) {

    }
}
