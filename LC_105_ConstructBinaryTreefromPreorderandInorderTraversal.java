/**
 * Created by monkeyzxr on 2017/7/31.
 *
 Given preorder and inorder traversal of a tree, construct the binary tree.

 Note:
 You may assume that duplicates do not exist in the tree.
 *
 *
 */

/*
由于先序的顺序的第一个肯定是根，所以原二叉树的根节点可以知道，题目中给了一个很关键的条件就是树中没有相同元素，
有了这个条件我们就可以在中序遍历中也定位出根节点的位置，并以根节点的位置将中序遍历拆分为左右两个部分，分别对其递归调用原函数。
 */

/*
https://www.tianmaying.com/tutorial/LC105

对于给定的前序遍历preorder和中序遍历inorder，首先我们不难发现，这棵树的根结点其实就是preorder[0]。
由于preorder和inorder是对同一棵树的遍历，我们可以知道preorder[0]在inorder中一定也存在，不妨设preorder[0]==inorder[k]。

由于inorder是中序遍历，所以k左边的就是根节点左子树的中序遍历、k右边的就是根节点右子树的中序遍历。

并且，由于我们已经知道了根节点左子树的节点数（与中序遍历长度相同），不妨设为l，我们可以知道preorder从1到l+1就是根节点左子树的前序遍历，剩下的最后一部分就是根节点右子树的前序遍历。

也就是说，我们可以计算出左子树、右子树的前序遍历和中序遍历，从而可以用分治的思想，将规模较大的问题分解成为两个较小的问题，然后递归的进行处理，还原左子树和右子树，最后连通根节点一起组成一棵完整的树。
 */

//http://www.cnblogs.com/grandyang/p/4296500.html
public class LC_105_ConstructBinaryTreefromPreorderandInorderTraversal {
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);

    }

    public static TreeNode helper(int[] preorder, int pLeft, int pRight, int[] inorder, int iLeft, int iRight){
        if (pLeft > pRight || iLeft > iRight)  //left right代表index
            return null;

        int i;  //i 放在循环外，因为要i来找root在inorder中的位置，要传出去
        for (i = iLeft; i <= iRight; i++){
            if (preorder[pLeft] == inorder[i])  //preorder的最多端index，即第一个数，就是root的值
                break;
        }

        TreeNode root = new TreeNode(preorder[pLeft]);

        //这里好好想想
        root.left = helper(preorder, pLeft+1, pLeft+i-iLeft, inorder, iLeft, i-1);
        root.right = helper(preorder, pLeft+i-iLeft+1, pRight, inorder, i+1, iRight);

        return root;
    }

    public static void main(String[] args) {

    }
}
