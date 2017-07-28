import java.util.Stack;

/**
 * Created by monkeyzxr on 2017/7/27.
 *
 Given a binary tree, flatten it to a linked list in-place.

 For example,
 Given

       1
      / \
     2   5
    / \   \
   3   4   6

 The flattened tree should look like:  // 这也是一个 tree！！！
 1
  \
   2
    \
     3
      \
       4
         \
          5
           \
            6

 Hints:
 If you notice carefully in the flattened tree, each node's right child points to the next node of a pre-order traversal.
 *
 */

//https://www.jiuzhang.com/solutions/flatten-binary-tree-to-linked-list/
public class LC_114_FlattenBinaryTreetoLinkedList {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public void flatten(TreeNode root) {
        if (root == null) return;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.empty()){
            TreeNode node = stack.pop();  //remove the top

            if (node.right != null)
                stack.push(node.right);
            if (node.left != null)
                stack.push(node.left);

            //connect
            node.left = null;
            if (stack.empty())
                node.right = null;
            else
                node.right = stack.peek();  //get the top
        }

    }

    public static void main(String[] args) {

    }
}
