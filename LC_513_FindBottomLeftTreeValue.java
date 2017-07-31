import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by monkeyzxr on 2017/7/30.
 *
 Given a binary tree, find the leftmost value in the last row of the tree.

 Example 1:
 Input:

     2
    / \
   1   3

 Output:
 1

 Example 2:
 Input:

      1
     / \
    2   3
   /   / \
  4   5   6
     /
    7

 Output:
 7
 Note: You may assume the tree (i.e., the given root node) is not NULL.


 *
 */

//http://www.cnblogs.com/grandyang/p/6405128.html
//我写 用BFS
public class LC_513_FindBottomLeftTreeValue {
    public class TreeNode {
        int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public int findBottomLeftValue(TreeNode root) {
        if (root == null)
            return 0;
        int result = 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){  //历遍一棵树
            int size = queue.size();

            for (int i = 0; i < size; i++){  //历遍一层
                TreeNode head = queue.poll();  //remove
                if (i == 0)
                    result = head.val;   //更新每一层的第一个index数字，最后一层的第一个数，就是结果

                if (head.left != null)
                    queue.offer(head.left);
                if (head.right != null)
                    queue.offer(head.right);
            }
        }

        return result;


    }

    public static void main(String[] args) {

    }
}
