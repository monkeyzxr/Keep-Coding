/**
 * Created by monkeyzxr on 2017/7/27.
 *
 Follow up for problem "Populating Next Right Pointers in Each Node".

 What if the given tree could be any binary tree? Would your previous solution still work?

 Note:

 You may only use constant extra space.
 For example,
 Given the following binary tree,
      1
     /  \
    2    3
   / \    \
  4   5    7
 After calling your function, the tree should look like:
       1 -> NULL
     /  \
     2 -> 3 -> NULL
    / \    \
   4-> 5 -> 7 -> NULL

 *
 */

//比上一题复杂
//http://www.jiuzhang.com/solutions/populating-next-right-pointers-in-each-node-ii/

//based on level order traversal
    //https://discuss.leetcode.com/topic/1106/o-1-space-o-n-complexity-iterative-solution

//没看懂
public class LC_117_PopulatingNextRightPointersinEachNode_II {
    public class TreeLinkNode {
      int val;
      TreeLinkNode left, right, next;
      TreeLinkNode(int x) { val = x; }
  }

    public void connect(TreeLinkNode root) {

        if (root == null) {
            return;
        }

        TreeLinkNode parent = root;
        TreeLinkNode pre;
        TreeLinkNode next;
        while (parent != null) {
            pre = null;
            next = null;
            while (parent != null) {
                if (next == null){
                    next = (parent.left != null) ? parent.left: parent.right;
                }

                if (parent.left != null){
                    if (pre != null) {
                        pre.next = parent.left;
                        pre = pre.next;
                    } else {
                        pre = parent.left;
                    }
                }

                if (parent.right != null) {
                    if (pre != null) {
                        pre.next = parent.right;
                        pre = pre.next;
                    } else {
                        pre = parent.right;
                    }
                }
                parent = parent.next;
            }
            parent = next;
        }


    }
}
