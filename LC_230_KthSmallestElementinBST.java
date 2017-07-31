import java.util.Stack;

/**
 * Created by monkeyzxr on 2017/7/30.
 *
 Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

 Note:
 You may assume k is always valid, 1 ? k ? BST's total elements.

 Follow up:
 What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently?
 How would you optimize the kthSmallest routine?
 */

/*
BST具有如下性质：

左子树中所有元素的值均小于根节点的值

右子树中所有元素的值均大于根节点的值

因此采用中序遍历（左 -> 根 -> 右）即可以递增顺序访问BST中的节点，从而得到第k小的元素，时间复杂度O(k)
 */

//http://www.programcreek.com/2014/07/leetcode-kth-smallest-element-in-a-bst-java/
public class LC_230_KthSmallestElementinBST {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public static int kthSmallest(TreeNode root, int k) {
        int result = 0;

        Stack<TreeNode> stack = new Stack<>(); //define a pointer to track nodes
        TreeNode p = root;

        while (!stack.isEmpty() || p != null){
            if (p != null){ // if it is not null, push to stack and go down the tree to left
                stack.push(p);
                p = p.left;
            }
            // if no left child, pop stack, process the node, then let p point to the right
            else{
                TreeNode t = stack.pop();
                k--;
                if (k == 0){
                    result = t.val;
                }
                p = t.right;
            }
        }

        return result;
    }

    public static void main(String[] args) {

    }
}
