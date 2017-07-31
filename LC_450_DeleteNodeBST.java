/**
 * Created by monkeyzxr on 2017/7/30.
 *
 Given a root node reference of a BST and a key, delete the node with the given key in the BST.
 Return the root node reference (possibly updated) of the BST.

 Basically, the deletion can be divided into two stages:

 Search for a node to remove.
 If the node is found, delete the node.
 Note: Time complexity should be O(height of tree).

 Example:

 root = [5,3,6,2,4,null,7]
 key = 3

      5
     / \
    3   6
    / \   \
   2   4   7

 Given key to delete is 3. So we find the node with value 3 and delete it.

 One valid answer is [5,4,6,2,null,null,7], shown in the following BST.

      5
     / \
    4   6
    /     \
   2       7

 Another valid answer is [5,2,6,null,4,null,7].

      5
     / \
    2   6
     \   \
      4   7
 *
 */

/*
要保证整个性质，我们必须在删除的位置上，找一个合适的值来进行替换，使得BST上的每个节点都满足 当前节点的值大于左节点但是小于右节点

而替换策略就是：
1、当前删除位置，用左边子树的最大值的节点替换
2、或者是，用右边子树的最小值的节点替换
 */

//递归法：
    //http://www.cnblogs.com/grandyang/p/6228252.html
public class LC_450_DeleteNodeBST {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;

        if (key < root.val){  //key 在left
            root.left = deleteNode(root.left, key);
        }
        else if (key > root.val){
            root.right = deleteNode(root.right, key);
        }
        else {  //此时，就是root的值 == key。 相当于递归的base条件。上两个if是递归。
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
            else {  //此时，就是如果要删的是root，并且root的左右都有child
                TreeNode curr = root.right;  //curr指向root的右子树，并一直找右子树的最左端的值，是为右子树的最小值
                while (curr.left != null){
                    curr = curr.left;
                }
                root.val = curr.val;  //把找到的右子树的最小值 替换到root上
                root.right = deleteNode(root.right, curr.val); //并删除 右子树的最小值的 原来的所在的那个node
            }
        }

        return root;

    }
}
