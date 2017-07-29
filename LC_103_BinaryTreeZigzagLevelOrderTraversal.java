import java.util.*;

/**
 * Created by monkeyzxr on 2017/7/28.
 *
 Given a binary tree, return the zigzag level order traversal of its nodes' values.
 (ie, from left to right, then right to left for the next level and alternate between).

 For example:
 Given binary tree [3,9,20,null,null,15,7],
      3
     / \
    9  20
      /  \
     15   7
 return its zigzag level order traversal as:
 [
     [3],
     [20,9],
     [15,7]
 ]

 *
 */

//方法1：类似102题
//主要就是记录当前结点所在的层级，或者当前层的结点的个数。
//遇到需要反向的层的时候，调用Collections.reverse()方法

    //我自己写 BFS，成功！

/*
public class LC_103_BinaryTreeZigzagLevelOrderTraversal {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        boolean needReverse = false;  //初始化

        while (!queue.isEmpty()){
            ArrayList<Integer> level = new ArrayList<>();
            int size = queue.size();

            for (int i = 0; i < size; i++){
                TreeNode head = queue.poll();
                level.add(head.val);

                if (head.left != null)
                    queue.offer(head.left);
                if (head.right != null)
                    queue.offer(head.right);
            }

            if (!needReverse){
                result.add(level);
                needReverse = true;
            }
            else if (needReverse){  //必须写else if
                Collections.reverse(level);
                result.add(level);
                needReverse = false;
            }
        }

        return result;

    }

    public static void main(String[] args) {

    }
}
*/


//写DFS：
public class LC_103_BinaryTreeZigzagLevelOrderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        dfs(root, result, 0);

        return result;
    }

    public static void dfs (TreeNode currNode, List<List<Integer>> res, int currLevel){
        if (currNode == null) return;

        if (res.size() <= currLevel){   //写递归的base
            res.add(new ArrayList<>());
        }

        if (currLevel % 2 == 0)
            res.get(currLevel).add(currNode.val);
        else
            res.get(currLevel).add(0, currNode.val);  //倒着放数。把第0index放新数

        dfs(currNode.left, res, currLevel+1);
        dfs(currNode.right, res, currLevel+1);


    }

    public static void main(String[] args) {

    }
}