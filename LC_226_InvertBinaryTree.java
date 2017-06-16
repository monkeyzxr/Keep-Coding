/**
 * Created by monkeyzxr on 2017/6/15.
 *
 Invert a binary tree.

     4
   /   \
   2     7
 / \   / \
 1   3 6   9

 to
     4
   /   \
   7     2
  / \   / \
  9   6 3   1
 *
 */

//我写： 超时了
/*
public class LC_226_InvertBinaryTree {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;

        if (root.left == null && root.right == null)
            return root;

        if (root.left != null && root.right != null){
            int tmp = root.left.val;
            root.left.val = root.right.val;
            root.right.val = tmp;
        }

        if (root.left != null && root.right == null){
            root.right.val = root.left.val;
            root.left = null;
        }

        if (root.right != null && root.left == null){
            root.left.val = root.right.val;
            root.right = null;
        }

        invertTree(root.left);
        invertTree(root.right);

        return root;

    }

    public static void main(String[] args) {

    }
}
*/
public class LC_226_InvertBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        invertTree(root.left);
        invertTree(root.right);

        return root;





    }

    public static void main(String[] args) {

    }
}
