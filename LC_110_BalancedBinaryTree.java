/**
 * Created by monkeyzxr on 2017/6/13.
 *
 * Given a binary tree, determine if it is height-balanced.

 For this problem, a height-balanced binary tree is defined as a binary tree
 in which the depth of the two subtrees of every node never differ by more than 1.
 *
 */


//The depth of a node is the number of edges from the node to the tree's root node.


    //算height是对的，因为题目是要求depth的差值，depth是从root开始往下数，同一点的左右，走的一样。只有继续往下走到null，才比较差值。
    // 而往下走的差值，相当与从 底层 往上数算height



    //本题要好好想想
    /*
    A)  3            B)    3
       / \                  \
      9  20                 20
      /  \                 / \
     15   7               15  7

     二叉树A是高度平衡的二叉树，但是B不是
     */

//The height of a tree would be the height of its root node, or equivalently, the depth of its deepest node.


public class LC_110_BalancedBinaryTree {
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }



  //求tree的高度，就是求最大深度！！！！！！！！！！！！！！！！！！！！！！
  //Find the Maximum Depth OR Height of a Binary Tree, 都这么写！！！
   public static int  findHeight (TreeNode root){
        if (root == null) return 0;

        return 1 + Math.max(findHeight(root.left), findHeight(root.right));
   }




    public boolean isBalanced(TreeNode root) {
       if (root == null)
           return true;

       int leftHeight = findHeight(root.left);
       int rightHeight = findHeight(root.right);

       int diff  = Math.abs(leftHeight - rightHeight);

      //----------------------------------------------------------------
       if(diff > 1)
           return false;
       else if (!isBalanced(root.left) || !isBalanced(root.right))
           return false;

       return true;
       //----------------------------------------------------------------

        //或者，只写 return abs(left - right) <= 1 && isBalanced(root->left) && isBalanced(root->right);




    }

    public static void main(String[] args) {

    }
}


