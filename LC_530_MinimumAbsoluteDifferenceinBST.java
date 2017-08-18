/**
 * Created by monkeyzxr on 2017/8/17.
 *
 Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.

 Example:

 Input:

 1
  \
   3
  /
 2

 Output:
 1

 Explanation:
 The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).
 Note: There are at least two nodes in this BST.
 *
 */

//http://www.cnblogs.com/grandyang/p/6540165.html

    /*
    由于BST的左<根<右的性质可知，如果按照中序遍历会得到一个有序数组，那么最小绝对差肯定在相邻的两个节点值之间产生。
    所以我们的做法就是对BST进行中序遍历，然后当前节点值和之前节点值求绝对差并更新结果res。
    这里需要注意的就是在处理第一个节点值时，由于其没有前节点，所以不能求绝对差。
    这里我们用变量pre来表示前节点值，这里由于题目中说明了所以节点值不为负数，所以我们给pre初始化-1，这样我们就知道pre是否存在。
     */
public class LC_530_MinimumAbsoluteDifferenceinBST {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

  /*
    public int getMinimumDifference(TreeNode root) {
        int result = Integer.MAX_VALUE;
        int pre = -1;

        inorder(root, pre, result);

        return result;

    }

    public void inorder(TreeNode root, int pre, int res){
        if (root == null)
            return;

        inorder(root.left, pre, res);

        if (pre != -1){
            res = Math.min(res, root.val-pre);
        }
        pre = root.val;

        inorder(root.right, pre,res);

    }
*/
    int min = Integer.MAX_VALUE;
    Integer prev = null;

    public int getMinimumDifference(TreeNode root) {
        if (root == null) return min;

        getMinimumDifference(root.left);

        if (prev != null) {
            min = Math.min(min, root.val - prev);
        }
        prev = root.val;

        getMinimumDifference(root.right);

        return min;
    }



    public static void main(String[] args) {

    }
}
