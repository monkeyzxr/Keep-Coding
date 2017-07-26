import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by monkeyzxr on 2017/7/25.
 *
 Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.

 Example 1:
 Input:
     3
    / \
    9  20
       /  \
       15   7
 Output: [3, 14.5, 11]
 Explanation:
 The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].

 Note:
 The range of node's value is in the range of 32-bit signed integer.
 *
 */


//方法1： BFS 最直观
//http://www.cnblogs.com/hellowooorld/p/7141052.html
    //https://discuss.leetcode.com/topic/95214/java-bfs-solution

    /*
public class LC_637_AverageLevelsBinaryTree {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<>(); //LinkedList is a pretty standard queue implementation

        queue.add(root);

        while (!queue.isEmpty()){
            int n = queue.size();
            double sum = 0.0;

            for (int i = 0; i < n; i++){
                TreeNode node = queue.poll(); //Retrieves and removes the head of this queue, or returns null if this queue is empty.
                sum += node.val;
                if (node.left != null )
                    //Inserts the specified element into this queue if it is possible to do so immediately without violating capacity restrictions.
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }

            result.add(sum/n);
        }

        return result;
    }

    public static void main(String[] args) {


    }
}
*/


    //方法2： DFS
//http://www.jianshu.com/p/a68705d34f6e
    //https://discuss.leetcode.com/topic/95567/java-solution-using-dfs-with-full-comments
public class LC_637_AverageLevelsBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root == null)
            return result;
        List<List<Integer>> nodes = new ArrayList<>();

        dfs(nodes, root, 0);

        for (int i = 0; i < nodes.size(); i++){
            double sum = 0.0;
            for (int j = 0; j < nodes.get(i).size(); j++){
                sum += nodes.get(i).get(j);
            }
            result.add(sum/nodes.get(i).size());
        }

        return result;


    }

    //dfs，把每一层的val存放到res里
    public static void dfs(List<List<Integer>> res, TreeNode root, int level){
        if (root == null)
            return;

        if (level >= res.size())
            res.add(new ArrayList<>());

        //level想成index
        res.get(level).add(root.val);

        dfs(res, root.left, level+1);
        dfs(res, root.right, level+1);
    }

    public static void main(String[] args) {


    }
}