/**
 * Created by monkeyzxr on 2017/6/14.
 *
 * Given a binary tree, find its maximum depth.

 The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 */
public class LC_104_MaximumDepthBinaryTree {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

  //http://www.geeksforgeeks.org/write-a-c-program-to-find-the-maximum-depth-or-height-of-a-tree/
    public int maxDepth(TreeNode root) {
       //如果当前node是null，则返回空
        // 如果只有一个node，它没有左右子node时，则返回1 ：就是return 1 + max（left=null， right = null） = 1 + 0 = 1
        if (root == null)
            return 0;

        //add 1 to it for the current node
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public static void main(String[] args) {

    }
}
