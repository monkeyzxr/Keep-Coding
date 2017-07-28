import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by monkeyzxr on 2017/7/27.
 *
 Given a binary tree, return the preorder traversal of its nodes' values.

 For example:
 Given binary tree {1,#,2,3},
  1
   \
    2
    /
   3
 return [1,2,3].

 Note: Recursive solution is trivial, could you do it iteratively?
 *
 */


// 递归1：http://blog.csdn.net/nomasp/article/details/50931535

    /*
public class LC_144_BinaryTreePreorderTraversal {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    List<Integer> result = new ArrayList<>();  //结果list放外面，不然每次生成新的list

    public List<Integer> preorderTraversal(TreeNode root) {

        if (root != null){
            result.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
        return result;

    }

    public static void main(String[] args) {

    }
}
*/


    //递归2：http://www.jiuzhang.com/solutions/binary-tree-preorder-traversal/
    //preorder，也就是DFS的一种
    /*
public class LC_144_BinaryTreePreorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        traverse(root, res);
        return res;
    }


    //DFS: 写一个helper，把上一个func的 返回结果和 传入变量，当作传入变量
    public static  void traverse (TreeNode root, ArrayList<Integer> result){
        if (root == null)
            return;

        result.add(root.val);
        traverse(root.left, result);
        traverse(root.right,result);
    }


    public static void main(String[] args) {

    }
}
    */


    //非递归，用stack
    //http://www.jiuzhang.com/solutions/binary-tree-preorder-traversal/
public class LC_144_BinaryTreePreorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        if (root == null)
            return result;

        stack.push(root);

        while (!stack.empty()){
            TreeNode node = stack.pop();
            result.add(node.val);

            if (node.right != null)  //先压右子树入栈，最后才出
                stack.push(node.right);

            if (node.left != null)
                stack.push(node.left);
        }

        return result;


    }

    public static void main(String[] args) {

    }
}