import java.util.ArrayList;
import java.util.List;

/**
 * Created by monkeyzxr on 2017/7/29.
 *
 Given a binary tree, determine if it is a valid binary search tree (BST).

 Assume a BST is defined as follows:

 The left subtree of a node contains only nodes with keys less than the node's key.
 The right subtree of a node contains only nodes with keys greater than the node's key.
 Both the left and right subtrees must also be binary search trees.
 Example 1:
   2
  / \
 1   3
 Binary tree [2,1,3], return true.
 Example 2:
   1
  / \
 2   3
 Binary tree [1,2,3], return false.
 *
 */

//自己写 递归，出错
    /*
public class LC_98_ValidateBinarySearchTree {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public static boolean isValidBST(TreeNode root) {
        if (root == null)
            return false;
        if (root.left == null && root.right == null)
            return true;

        if (root.left.val >= root.val || root.right.val <= root.val) //java.lang.NullPointerExceptionv
            return false;
        return isValidBST(root.left) && isValidBST(root.right);



    }

    public static void main(String[] args) {

    }
}
*/


    //http://www.cnblogs.com/grandyang/p/4298435.html
//通过中序遍历将所有的节点值存到一个数组里，然后再来判断这个数组是不是有序的
    //中序遍历 DFS
public class LC_98_ValidateBinarySearchTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static boolean isValidBST(TreeNode root) {
        List<Integer> list  = new ArrayList<>();
        inorder(root, list);

        for (int i = 0; i < list.size()-1; i++){
            if (list.get(i) >= list.get(i+1))
                return false;
        }

        return true;


    }

    //左 根 右
    public static void inorder(TreeNode root, List<Integer> list){
        if (root == null)
            return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    public static void main(String[] args) {

    }
}

/*http://www.cnblogs.com/grandyang/p/4298435.html

这道验证二叉搜索树有很多种解法，可以利用它本身的性质来做，即左<根<右，
也可以通过利用中序遍历结果为有序数列来做，下面我们先来看最简单的一种，就是利用其本身性质来做，
初始化时带入系统最大值和最小值，在递归过程中换成它们自己的节点值，用long代替int就是为了包括int的边界条件

public class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return valid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean valid(TreeNode root, long low, long high) {
        if (root == null) return true;
        if (root.val <= low || root.val >= high) return false;


        //  left的大小范围: low to root.val
        // right的大小范围 : root.val to high
        return valid(root.left, low, root.val) && valid(root.right, root.val, high);
    }
}
 */

