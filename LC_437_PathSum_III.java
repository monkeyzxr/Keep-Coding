/**
 * Created by monkeyzxr on 2017/7/25.
 *
 You are given a binary tree in which each node contains an integer value.

 Find the number of paths that sum to a given value.

 The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).

 The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.

 Example:

 root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

      10
     /  \
    5   -3
   / \    \
  3   2   11
  / \   \
  3  -2   1

 Return 3. The paths that sum to 8 are:

 1.  5 -> 3
 2.  5 -> 2 -> 1
 You are given a binary tree in which each node contains an integer value.

 Find the number of paths that sum to a given value.

 The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).

 The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.

 Example:

 root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

 10
 /  \
 5   -3
 / \    \
 3   2   11
 / \   \
 3  -2   1

 Return 3. The paths that sum to 8 are:

 1.  5 -> 3
 2.  5 -> 2 -> 1
 3. -3 -> 11
  *
 */

//http://blog.csdn.net/mebiuw/article/details/52901592
    //http://rainykat.blogspot.com/2017/01/leetcode-437-path-sum-iii-2dfs.html
//这道题给了二叉树和一个sum，找出所有子路径和为sum的路径。 直接用递归方法做，把每个点都当做父节点遍历，找到存在的路径，相加即可
public class LC_437_PathSum_III {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public int pathSum(TreeNode root, int sum) {
        if (root == null)
            return 0;

        return dfs(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);


    }

    //dfs 是确定一个root后，进行的的验证
    public static int dfs(TreeNode root, int sum){
        int result = 0;
        if (root == null)
            return result;

        if (root.val == sum)
            result++;

        result += dfs(root.left, sum-root.val);
        result += dfs(root.right, sum-root.val);

        return result;
    }

    public static void main(String[] args) {

    }
}
