import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by monkeyzxr on 2017/7/26.
 *
 Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

 For example:
 Given the following binary tree,
    1            <---
  /   \
 2     3         <---
  \     \
   5     4       <---
 You should return [1, 3, 4].
 *
 */


//这道题要求我们打印出二叉树每一行最右边的一个数字，
// 实际上是求二叉树层序遍历的一种变形，我们只需要保存每一层最右边的数字即可

//方法1： BFS
    //http://blog.csdn.net/ever223/article/details/45062305
    //http://www.programcreek.com/2014/04/leetcode-binary-tree-right-side-view-java/
public class LC_199_BinaryTreeRightSideView {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()){
            int currSize = queue.size();

            for (int i = 0; i < currSize; i++){
                TreeNode head = queue.poll();

                if (i == 0)  //the first element in the queue (right-most of the tree)
                    result.add(head.val);

                //add right first
                if (head.right != null)
                    queue.offer(head.right);

                //then add left
                if (head.left  != null){
                    queue.offer(head.left);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {

    }
}

/*http://blog.csdn.net/happyaaaaaaaaaaa/article/details/51549112
思路】递归实现  DFS
采用前序遍历。采用 根->右->左 顺序进行遍历，并将每一层的第一个节点添加到结果集中：

public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        dfs(root, res, 0);
        return res;
    }
    private void dfs(TreeNode root, List<Integer> res, int level) {
        if (root == null) return;

        // the line to check currDepth == result.size() makes sure the first element of that level will be added to the result list
        if (level == res.size()) {   //怎么理解？？？  currDepth = result.size() to be the condition to add the node.
            res.add(root.val);
        }

        dfs(root.right, res, level+1);
        dfs(root.left, res, level+1);
    }
}
 */