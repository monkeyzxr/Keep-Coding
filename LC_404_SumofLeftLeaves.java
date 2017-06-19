/**
 * Created by monkeyzxr on 2017/6/17.
 *
 Find the sum of all left leaves in a given binary tree.

 Example:

       3
      / \
     9  20
       /  \
      15   7

 There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.

 *
 */

//http://www.geeksforgeeks.org/find-sum-left-leaves-given-binary-tree/
    /*
public class LC_404_SumofLeftLeaves {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

  //写一个method，用来check这个node是不是 leaf node
  public boolean isLeaf(TreeNode node){
        if (node == null)
            return false;
        if (node.left == null && node.right == null)
            return true;

        else
            return false;

  }
    public int sumOfLeftLeaves(TreeNode root) {
      int sum = 0;

      if (root != null){
          if (isLeaf(root.left)) //如果root的左node是个leaf，则加入到结果里
              sum += root.left.val;
          else  //如果root的左node不是leaf node，则递归下去
              sum += sumOfLeftLeaves(root.left);

          // 将root的右node，也递归下去，找左leaf
          sum += sumOfLeftLeaves(root.right);
      }

      return sum;
    }
}
*/

    //https://discuss.leetcode.com/topic/60403/java-iterative-and-recursive-solutions
public class LC_404_SumofLeftLeaves {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    public static int sumOfLeftLeaves(TreeNode root) {
        if (root == null)
            return 0;

        int res = 0;

        if (root.left != null){
            if (root.left.left == null && root.left.right == null) //如果root的左node是个leaf，直接加入结果
                res += root.left.val;
            else  //如果root的左node不是leaf，其下还有node，则递归下去
                res += sumOfLeftLeaves(root.left);
        }

        res += sumOfLeftLeaves(root.right);  //将root的右node递归下去

        return res;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(sumOfLeftLeaves(root));  //return 24


    }
}