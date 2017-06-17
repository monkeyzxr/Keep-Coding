/**
 * Created by monkeyzxr on 2017/6/15.
 *
 Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

 According to the definition of LCA on Wikipedia:
 “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants
 (where we allow a node to be a descendant of itself).”

     _______6______
    /              \
 ___2__          ___8__
 /      \        /      \
 0      _4       7       9
       /  \
      3   5
 For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6.
 Another example is LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
 *
 */

// 我写：
    /*
public class LC_235_LowestCommonAncestorBinarySearchTree {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

  //这个思路不对，如果求3和5的，应该为2。这个解法算不出答案。
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;

        if (p.val > root.val && q.val > root.val )
            return root;

        if (p.val < root.val && q.val < root.val && p.val > q.val)
            return q;

        if (p.val < root.val && q.val < root.val && p.val < q.val)
            return p;

        if (p.val > root.val && q.val < root.val)
            return q;

        if (p.val < root.val && q.val > root.val)
            return p;

        return null;
    }
}
*/


    //http://www.programcreek.com/2014/07/leetcode-lowest-common-ancestor-of-a-binary-search-tree-java/
    //http://www.geeksforgeeks.org/lowest-common-ancestor-in-a-binary-search-tree/
public class LC_235_LowestCommonAncestorBinarySearchTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;
        // If both n1 and n2 are smaller than root, then LCA lies in left
        if (p.val < root.val && q.val < root.val)
            return lowestCommonAncestor(root.left, p, q);
        // If both n1 and n2 are greater than root, then LCA lies in right
        else if (p.val > root.val && q.val > root.val)
            return lowestCommonAncestor(root.right, p, q);
        else
            return root;


    }

    public static void main(String[] args) {

    }
}