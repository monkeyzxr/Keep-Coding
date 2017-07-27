import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by monkeyzxr on 2017/7/26.
 *
 Given a complete binary tree, count the number of nodes.

 Definition of a complete binary tree from Wikipedia:
 In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible.
 It can have between 1 and 2h nodes inclusive at the last level h.
 *
 */

/*最直接的方法是对二叉树进行遍历，然后逐个节点进行统计，时间复杂度是O(n)，n为节点数量。
在LeetCode上面会Time Limited Exceeded
因为，只是把它当作一颗普通的二叉树来处理了，因此它能够统计任意二叉树的节点数，但并没有利用到完全二叉树的特性

public class Solution {
    public int countNodes(TreeNode root) {
        return root == null ? 0 : 1 + countNodes(root.left) + countNodes(root.right);
    }
}
 */

//思路：
//如果当前子树的“极左节点”（从根节点出发一路向左）与“极右节点”（从根节点出发一路向右）的高度h相同，则当前子树为满二叉树，返回2^h - 1
//否则，递归计算左子树与右子树的节点个数。

    //http://blog.csdn.net/jmspan/article/details/51056085
    //http://www.cnblogs.com/grandyang/p/4567827.html

    //仍然超时空了
    /*
public class LC_222_CountCompleteTreeNodes {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public int countNodes(TreeNode root) {
        int hLeft = leftHeight(root);
        int hRight = rightHeight(root);

        if (hLeft == hRight)
            return (int)Math.pow(2, hLeft) - 1;

        return 1 + countNodes(root.left) + countNodes(root.right);  // 加1，代表起始的root的个数


    }

    public static int leftHeight (TreeNode root){
        if (root == null)
            return 0;

        return 1+leftHeight(root.left);
    }

    public static int rightHeight(TreeNode root){
        if (root == null)
            return 0;

        return 1+rightHeight(root.right);
    }

    public static void main(String[] args) {

    }
}
*/

    //我自己写，用BFS试试
    //仍然超时！！！！！！！！！！！！！！！！！
    /*
public class LC_222_CountCompleteTreeNodes {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int countNodes(TreeNode root) {
        int count = 0;

        if (root == null) return 0;

        Queue<TreeNode> queue =  new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()){
            int currSize = queue.size();

            for (int i = 0; i < currSize; i++){
                TreeNode head = queue.poll();
                count++;

                if (head.left != null)
                    queue.offer(head.left);
                if (head.right != null)
                    queue.offer(head.right);
            }

        }

        return count;

    }


    public static void main(String[] args) {

    }
}
    */



    /*http://blog.csdn.net/jmspan/article/details/51056085 里的方法5：
    对于根节点，如果在最底层能够找到它的右子节点的最左后代节点，说明根节点的左子树是完美二叉树，这个时候我们需要检查该最左后代节点的后面一段，
    而迭代的方法很巧妙，只需要深入一层到根节点的右子节点，继续寻找它的右子节点的最左后代节点即可，否则就深入一层到根节点的左子节点，继续寻找它的右子节点的最左后代节点，如此下去
     */
public class LC_222_CountCompleteTreeNodes {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static int leftMost(TreeNode root){  //求左子树的height
        /*
        int count = 0;
        while (root != null){
            count++;
            root = root.left;
        }
        return count;
        */
        //或者：
        if (root == null)
            return 0;

        return 1+leftMost(root.left);

    }

    public int countNodes(TreeNode root) {
        if (root == null) return 0;

        int leftMost = leftMost(root.left); //最左端的高度
        int middle = leftMost(root.right);  //底层中间node的高度

        int count  = 1;  //起始的root，数1个node

        if (leftMost == middle){  //root的左子树 是 满二叉树
            count += (1 << leftMost)-1; //2^hLeft - 1
            count += countNodes(root.right);
        }
        else {  //此时 root的右子树是 满二叉树
            count += (1 << middle)-1;
            count += countNodes(root.left);
        }

        return count;


    }


    public static void main(String[] args) {

    }
}
