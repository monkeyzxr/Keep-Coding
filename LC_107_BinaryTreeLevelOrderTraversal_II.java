import java.util.*;

/**
 * Created by monkeyzxr on 2017/7/26.
 *
 Given a binary tree, return the bottom-up level order traversal of its nodes' values.
 (ie, from left to right, level by level from leaf to root).

 For example:
 Given binary tree [3,9,20,null,null,15,7],
      3
     / \
    9  20
       /  \
       15   7
 return its bottom-up level order traversal as:
 [
     [15,7],
     [9,20],
     [3]
 ]
 *
 */

//http://www.jiuzhang.com/solutions/binary-tree-level-order-traversal-ii/
//BFS,然后reverse结果。和102题一样
public class LC_107_BinaryTreeLevelOrderTraversal_II {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<>();  //实体化，用linkedlist

        queue.offer(root);

        while (!queue.isEmpty()){
            int currSize = queue.size();
            ArrayList<Integer> level = new ArrayList<>();

            for (int i = 0; i < currSize; i++){
                TreeNode head = queue.poll();  //poll 英文： 剪短， 投票
                level.add(head.val);

                if (head.left != null)
                    queue.offer(head.left);
                if (head.right != null)
                    queue.offer(head.right);
            }

            result.add(level);
        }

        //Reverses the order of the elements in the specified list.
        Collections.reverse(result);  //跟Arrays.sort/fill 类比
        return result;
    }

    public static void main(String[] args) {

    }
}
