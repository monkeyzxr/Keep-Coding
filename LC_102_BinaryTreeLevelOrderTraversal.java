import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by monkeyzxr on 2017/7/25.
 *
 Given a binary tree, return the level order traversal of its nodes' values.
 (ie, from left to right, level by level).

 For example:
 Given binary tree [3,9,20,null,null,15,7],
     3
    / \
   9  20
      /  \
     15   7
 return its level order traversal as:
 [
     [3],
     [9,20],
     [15,7]
 ]

 *
 */


//BFS: 最直观
//http://www.jiuzhang.com/solutions/binary-tree-level-order-traversal/
    /*
public class LC_102_BinaryTreeLevelOrderTraversal {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();  //实体化！
        queue.offer(root);  //insert

        while (!queue.isEmpty()){
            ArrayList<Integer> level = new ArrayList<>();  //其中一层的所有数
            int size = queue.size();  //当前queue的size。当前size的每一个queue里的元素都被历遍，加入到list里

            for (int i = 0; i < size; i++){
                TreeNode head = queue.poll(); //remove
                level.add(head.val);

                if (head.left != null)
                    queue.offer(head.left);
                if (head.right != null)
                    queue.offer(head.right);
            }

            result.add(level);
         }

         return result;

    }

    public static void main(String[] args) {

    }
}
*/


    //方法2： DFS，用递归
    //我觉得不如方法3 更直观
    /*
public class LC_102_BinaryTreeLevelOrderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        int maxLevel = 0;

        while (true){
            ArrayList<Integer> level = new ArrayList<>();
            dfs(root, level, 0, maxLevel);

            if (level.size() == 0)
                break;

            result.add(level);
            maxLevel++;
        }

        return result;



    }

    public static void dfs(TreeNode root, ArrayList<Integer> level, int currtLevel, int maxLevel){
        if (root == null || currtLevel > maxLevel)
            return;

        if (currtLevel == maxLevel){
            level.add(root.val);
            return;
        }

        dfs(root.left, level, currtLevel+1, maxLevel);
        dfs(root.right, level, currtLevel+1, maxLevel);
    }

    public static void main(String[] args) {

    }
}
    */



    //方法3： DFS
// https://discuss.leetcode.com/topic/47255/java-1ms-dfs-recursive-solution-and-2ms-bfs-iterative-solution

public class LC_102_BinaryTreeLevelOrderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        dfs(result, root, 0);

        return result;

    }

    public static void dfs(List<List<Integer>> res, TreeNode root, int level){
        if (root == null)
            return;

        List<Integer> curr;

        if (level >= res.size()){
            curr = new ArrayList<>();
            curr.add(root.val);
            res.add(curr);
        }
        else {
            curr = res.get(level);
            curr.add(root.val);
        }

        dfs(res, root.left, level+1);
        dfs(res, root.right, level+1);

    }

    public static void main(String[] args) {

    }
}
