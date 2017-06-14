/**
 * Created by monkeyzxr on 2017/6/13.
 *
 Given a binary tree, you need to compute the length of the diameter of the tree.
 The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
 This path may or may not pass through the root.

 Example:
 Given a binary tree
     1
    / \
   2   3
  / \
 4   5
 Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

 Note: The length of path between two nodes is represented by the number of edges between them.
 *
 */

//我自己写，错误
    // 这个思路不对，因为最长的path可能不经过root
    // 例子可参考：http://www.geeksforgeeks.org/diameter-of-a-binary-tree/

    /*
public class LC_543_DiameterofBinaryTree {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    //Find the Maximum Depth OR Height of a Binary Tree
    public static int  findHeight (TreeNode root){
        if (root == null) return 0;

        return 1 + Math.max(findHeight(root.left), findHeight(root.right));
    }

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        int leftHeight = findHeight(root.left);
        int rightHeight = findHeight(root.right);

        return leftHeight+rightHeight;


    }

    public static void main(String[] args) {

    }
}
*/


public class LC_543_DiameterofBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int max = 0;

    public  int depth(TreeNode root){
        if (root == null)
            return 0;
        int left = depth(root.left);
        int right = depth(root.right);

        max = Math.max(max, left+right);
        return Math.max(left,right) +1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return max;

    }

    public static void main(String[] args) {

    }
}