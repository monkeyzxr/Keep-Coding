import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by monkeyzxr on 2017/6/20.
 *
 Given a binary tree, return the inorder traversal of its nodes' values.

 For example:
 Given binary tree [1,null,2,3],
    1
     \
      2
     /
    3
 return [1,3,2].

 Note: Recursive solution is trivial, could you do it iteratively?
 *
 */

//我写，递归，正确
    /*
public class LC_94_BinaryTreeInorderTraversal {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }


    List<Integer> list = new ArrayList<>();  //这个list必须放在外面。不然，每次递归都创造新的list了。


    public  List<Integer> inorderTraversal(TreeNode root) {

        if (root != null) {
            inorderTraversal(root.left);
            list.add(root.val);
            inorderTraversal(root.right);
        }

        return list;

    }

    public static void main(String[] args) {

    }

}
*/

    //http://www.programcreek.com/2012/12/leetcode-solution-of-binary-tree-inorder-traversal-in-java/
    //http://www.jiuzhang.com/solutions/binary-tree-inorder-traversal/

    //好好想一想！
public class LC_94_BinaryTreeInorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public  List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();

        TreeNode curr = root;

        while(curr != null || !stack.empty()){
            while (curr != null){
                stack.add(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            list.add(curr.val);
            curr = curr.right;

        }

        return list;



    }

    public static void main(String[] args) {

    }

}