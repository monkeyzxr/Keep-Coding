/**
 * Created by monkeyzxr on 2017/6/13.
 *
 Given a binary tree, return the tilt of the whole tree.

 The tilt of a tree node is defined as the absolute difference between the sum of all left subtree node values and the sum of all right subtree node values.
 Null node has tilt 0.

 The tilt of the whole tree is defined as the sum of all nodes' tilt.

 Example:
 Input:
   1
 /   \
 2     3
 Output: 1

 Explanation:
 Tilt of node 2 : 0
 Tilt of node 3 : 0
 Tilt of node 1 : |2-3| = 1
 Tilt of binary tree : 0 + 0 + 1 = 1

 Note:

 The sum of node values in any subtree won't exceed the range of 32-bit integer.
 All the tilt values won't exceed the range of 32-bit integer.
 *
 *
 */

//我写，不对：
    /*
public class LC_563_BinaryTreeTilt {
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public static int findTilt(TreeNode root) {
        if (root == null)
            return 0;
        else if (root.left != null && root.right == null)
            return root.left.val;
        else if (root.right != null && root.left == null)
            return root.right.val;
        else if (root.left != null && root.right != null)
            return root.val + Math.abs(root.left.val - root.right.val);

        return findTilt(root) + findTilt(root.left)+findTilt(root.right);



    }

    public static void main(String[] args) {

    }
}
*/

    //重新写：https://leetcode.com/articles/binary-tree-tilt/

    //没看懂啊
public class LC_563_BinaryTreeTilt {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int tilt=0;
    public int findTilt(TreeNode root) {
        traverse(root);
        return tilt;
    }
    public int traverse(TreeNode root)
    {
        if(root==null )
            return 0;
        int left=traverse(root.left);
        int right=traverse(root.right);
        tilt+=Math.abs(left-right);
        return left+right+root.val;
    }


    public static void main(String[] args) {

    }
}