import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by monkeyzxr on 2017/7/28.
 *
 You need to find the largest value in each row of a binary tree.

 Example:
 Input:

      1
     / \
    3   2
   / \   \
  5   3   9

 Output: [1, 3, 9]
 *
 */


//BFS,我写：
    //http://www.voidcn.com/blog/huanghanqian/article/p-6611569.html
public class LC_515_FindLargestValueEachTreeRow {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            int max = Integer.MIN_VALUE;  //存放一层的max数
            int size = queue.size();

            for (int i = 0; i < size; i++){
                TreeNode head = queue.poll();

                if (head.left != null)
                    queue.offer(head.left);
                if (head.right != null)
                    queue.offer(head.right);

                max = (max > head.val)? max : head.val;
            }
            res.add(max);
        }

        return res;

    }

    public static void main(String[] args) {

    }
}


/* DFS:
https://discuss.leetcode.com/topic/79178/9ms-java-dfs-solution

Just a simple pre-order traverse idea. Use depth to expand result list size and put the max value in the appropriate position.

public class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        helper(root, res, 0);
        return res;
    }
    private void helper(TreeNode root, List<Integer> res, int d){
        if(root == null){
            return;
        }
       //expand list size
        if(d == res.size()){
            res.add(root.val);
        }
        else{
        //or set value
            res.set(d, Math.max(res.get(d), root.val));
        }
        helper(root.left, res, d+1);
        helper(root.right, res, d+1);
    }
}

 */