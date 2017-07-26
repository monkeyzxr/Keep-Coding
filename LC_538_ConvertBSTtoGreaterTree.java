/**
 * Created by monkeyzxr on 2017/7/25.
 *
 Given a Binary Search Tree (BST), convert it to a Greater Tree such that
 every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.

 Example:

 Input: The root of a Binary Search Tree like this:
    5
  /   \
 2     13

 Output: The root of a Greater Tree like this:
    18
   /   \
  20     13
 *
 */

//给定一棵二叉查找树（BST），将其转化为“Greater Tree”，原始BST中的每一个节点都替换为不小于其本身的各节点的和。
    //解题思路：“右 - 根 - 左”顺序遍历BST

    //好好想想

    /*
    Since this is a BST, we can do a reverse inorder traversal to traverse the nodes of the tree in descending order.
    In the process, we keep track of the running sum of all nodes which we have traversed thus far.
     */

    //http://www.cnblogs.com/grandyang/p/6591526.html
    //http://www.cnblogs.com/dongling/p/6579689.html
public class LC_538_ConvertBSTtoGreaterTree {
    public static class TreeNode {
        int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

  public static int sum = 0;

    public static TreeNode convertBST(TreeNode root) {
        sum = 0;  //每次运行这个func 都要先初始化

        convert(root);

        return root;
    }

    public static void convert(TreeNode node){
        if (node == null)
            return;

        convert(node.right);

        sum += node.val;
        node.val = sum;

        convert(node.left);

    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(13);

        convertBST(root);

        System.out.println(root.val);
        System.out.println(root.left.val);
        System.out.println(root.right.val);






    }
}
