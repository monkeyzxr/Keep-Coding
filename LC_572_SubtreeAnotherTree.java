/**
 * Created by monkeyzxr on 2017/6/16.
 *
 Given two non-empty binary trees s and t,
 check whether tree t has exactly the same structure and node values with a subtree of s.
 A subtree of s is a tree consists of a node in s and all of this node's descendants.
 The tree s could also be considered as a subtree of itself.

 Example 1:
 Given tree s:

     3
    / \
   4   5
  / \
 1   2
 Given tree t:
   4
  / \
 1   2
 Return true, because t has the same structure and node values with a subtree of s.

 Example 2:
 Given tree s:

     3
    / \
   4   5
  / \
 1   2
    /
   0
 Given tree t:
   4
  / \
 1   2
 Return false.

 */


//我自己写，出错：
    /*
public class LC_572_SubtreeAnotherTree {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null)
            return false;

        if (s.val == t.val && s.left.val == t.left.val && s.right.val == t.right.val)
            return true;

        else
            return isSubtree(s.left,t) || isSubtree(s.right, t);

    }
}
*/


    //http://www.cnblogs.com/grandyang/p/6828687.html
    //http://www.geeksforgeeks.org/check-if-a-binary-tree-is-subtree-of-another-binary-tree/

public class LC_572_SubtreeAnotherTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    //判断两棵树是否相同
    public boolean isSameTree(TreeNode root1, TreeNode root2){
        //base case: 二者都是null时候，是true； 而至只有一个null，就是false
        if (root1 == null && root2 == null)
            return true;
        if (root1 == null || root2 == null)
            return false;

        if (root1.val != root2.val)
            return false;
        else// 如果两个root都相等，则比较各自的左右子树，一直比较到base case 的null 情况
            return isSameTree(root1.left, root2.left) && isSameTree(root1.right, root2.right);
    }

    //从s的根结点开始，跟t比较，如果两棵树完全相同，那么返回true，
    // 否则就分别对s的左子结点和右子结点调用递归再次来判断是否相同，只要有一个返回true了，就表示可以找得到。
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null)
            return false;

        if (isSameTree(s, t) == true)
            return true;

        else
            return isSubtree(s.left, t) || isSubtree(s.right, t);
    }
}