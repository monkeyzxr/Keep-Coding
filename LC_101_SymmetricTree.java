/**
 * Created by monkeyzxr on 2017/6/15.
 *
 Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

 For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

      1
     / \
    2   2
   / \ / \
  3  4 4  3
 But the following [1,2,2,null,3,null,3] is not:
     1
    / \
   2   2
    \   \
     3    3
 Note:
 Bonus points if you could solve it both recursively and iteratively.
 *
 */

//我自己写，出错
    /*
public class LC_101_SymmetricTree {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return false;

        if (root.left == null && root.right == null)
            return true;

        if (root.left == null || root.right == null)
            return false;

        if (root.left.val == root.right.val)
            return true;

        if (root.left.val != root.right.val)
            return false;

        isSymmetric(root.left);
        isSymmetric(root.right);

        //return true;

    }

    public static void main(String[] args) {

    }
}
*/

    //http://blog.csdn.net/crazy1235/article/details/51541984
    //http://blog.csdn.net/DERRANTCM/article/details/47333335

//使用递归进行求解，先判断左右子结点是否相等，不等就返回false，
// 相等就将左子结点的左子树与右子结果的右子结点进行比较操作，同时将左子结点的左子树与右子结点的左子树进行比较，
// 只有两个同时为真是才返回true，否则返回false。
public class LC_101_SymmetricTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean checkNodes(TreeNode node1, TreeNode node2){
        if (node1 == null && node2 == null)
            return true;

        if (node1 == null || node2 == null)
            return false;

        if (node1.val != node2.val)
            return false;
        else {
            return checkNodes(node1.left, node2.right) && checkNodes(node1.right, node2.left);
        }
    }



    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;

        return checkNodes(root.left, root.right);

    }

    public static void main(String[] args) {

    }
}
