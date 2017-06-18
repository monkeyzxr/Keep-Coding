import java.util.ArrayList;
import java.util.List;

/**
 * Created by monkeyzxr on 2017/6/17.
 *
 Given a binary tree, return all root-to-leaf paths.

 For example, given the following binary tree:

     1
   /   \
  2     3
   \
    5
 All root-to-leaf paths are:

 ["1->2->5", "1->3"]
 *
 */


//http://www.jiuzhang.com/solutions/binary-tree-paths/
    //http://blog.csdn.net/crazy1235/article/details/51474128
    //http://www.programcreek.com/2014/05/leetcode-binary-tree-paths-java/


    //我没写出来，这个是网上的写法
    //好好体会

public class LC_257_BinaryTreePaths {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

  public void findPaths (TreeNode root, String path, List<String> result){
        if(root == null)
            return;

        if (root.left == null  && root.right == null){
            result.add(path);
            return;
        }

        if (root.left != null){
            findPaths(root.left, path + "->" + String.valueOf(root.left.val), result);
        }

        if (root.right != null){
            findPaths(root.right, path + "->" + String.valueOf(root.right.val), result);
        }
  }

    public List<String> binaryTreePaths(TreeNode root) {
      List<String> result = new ArrayList<>();
      if (root == null)
          return result;

      findPaths(root, String.valueOf(root.val), result);

      return result;
    }

    public static void main(String[] args) {

    }
}
