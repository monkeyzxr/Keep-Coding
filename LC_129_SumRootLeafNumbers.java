import java.util.ArrayList;
import java.util.List;

/**
 * Created by monkeyzxr on 2017/7/27.
 *
 Given a binary tree containing digits from 0-9 only,
 each root-to-leaf path could represent a number.

 An example is the root-to-leaf path 1->2->3 which represents the number 123.

 Find the total sum of all root-to-leaf numbers.

 For example,

   1
  / \
 2   3
 The root-to-leaf path 1->2 represents the number 12.
 The root-to-leaf path 1->3 represents the number 13.

 Return the sum = 12 + 13 = 25.
 *
 */


//http://www.programcreek.com/2014/05/leetcode-sum-root-to-leaf-numbers-java/
public class LC_129_SumRootLeafNumbers {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public static int sumNumbers(TreeNode root) {
        int res = 0;
        if (root == null)
            return res;

        ArrayList<ArrayList<TreeNode>> all = new ArrayList<>();
        ArrayList<TreeNode> list = new ArrayList<>();

        list.add(root);  //把第一个数字加入list

        dfs(list, all, root);

        for (ArrayList<TreeNode> a : all){
            StringBuilder sb = new StringBuilder();
            for (TreeNode n : a){
                sb.append(String.valueOf(n.val));
            }
            int currNum = Integer.valueOf(sb.toString());
            res += currNum;
        }

        return res;



    }


    //回溯!!!!!!!!!!!!!!!!!
    public static void dfs(ArrayList<TreeNode> list, ArrayList<ArrayList<TreeNode>> allResults, TreeNode root){
        if (root.left == null && root.right == null){  //base
            ArrayList<TreeNode> singleResult = new ArrayList<>();  //创一个新的list，存放 有结果的 list
            singleResult.addAll(list);
            allResults.add(singleResult);
        }

        if (root.left != null){
            list.add(root.left);
            dfs(list, allResults, root.left);
            list.remove(list.size()-1);  //回溯。回退到上一层  //每次清除一个空位 让后续元素加入
            //这么想，从root往下走，遇见一个node，下一层可继续左或右。如果选择往左走，用递归到下一层后，要回到上一层的初始点，继续把往右的子node
            //继续走下去。所以要回溯，回到上一层。所以list要size减1
        }

        if (root.right != null){
            list.add(root.right);
            dfs(list, allResults, root.right);
            list.remove(list.size()-1);
        }

    }

    public static void main(String[] args) {

    }
}


//方法2：
//http://www.jiuzhang.com/solutions/sum-root-to-leaf-numbers/
//
/*
public class Solution {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int prev){
        if(root == null) {
            return 0;
        }

        int sum = root.val + prev * 10;
        if(root.left == null && root.right == null) {
            return sum;
        }

        return dfs(root.left, sum) + dfs(root.right, sum);
    }
*/