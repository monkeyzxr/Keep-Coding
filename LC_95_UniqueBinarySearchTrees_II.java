import java.util.ArrayList;
import java.util.List;

/**
 * Created by monkeyzxr on 2017/7/30.
 *
 Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1...n.

 For example,
 Given n = 3, your program should return all 5 unique BST's shown below.

 1         3     3      2      1
 \       /     /      / \      \
 3     2     1      1   3      2
 /     /       \                 \
 2     1         2                 3

 *
 */

/*
http://bangbingsyb.blogspot.com/2014/11/leetcode-unique-binary-search-trees-i-ii.html

要求生成所有的unique BST，类似combination/permutation的题目，可以递归构造。

1. 根节点可以任取min ~ max (例如min  = 1, max = n)，假如取定为i。
2. 则left subtree由min ~ i-1组成，假设可以有L种可能。right subtree由i+1 ~ max组成，假设有R种可能。生成所有可能的left/right subtree。
3 对于每个生成的left subtree/right subtree组合<T_left(p), T_right(q)>，p = 1...L，q = 1...R，添加上根节点i而组成一颗新树。
 */

//http://www.programcreek.com/2014/05/leetcode-unique-binary-search-trees-ii-java/
//http://www.cnblogs.com/springfor/p/3884029.html
    //http://www.jiuzhang.com/solutions/unique-binary-search-trees-ii/
public class LC_95_UniqueBinarySearchTrees_II {
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public List<TreeNode> generateTrees(int n) {
        if(n == 0){
            return new ArrayList<TreeNode>();
        }

        return helper(1, n); //从1作为root开始，到n作为root结束
    }

    public static ArrayList<TreeNode> helper(int left, int right){
        ArrayList<TreeNode> res = new ArrayList<>();

        if (left > right){
            res.add(null);
            return res;
        }

        for (int i = left; i <= right; i++){    //i代表root
            ArrayList<TreeNode> leftSubTrees = helper(left, i-1); //以i作为根节点，左子树由[1,i-1]构成
            ArrayList<TreeNode> rightSubTrees = helper(i+1, right); //右子树由[i+1, n]构成

            for (int l = 0; l < leftSubTrees.size(); l++){
                for (int r = 0; r < rightSubTrees.size(); r++){
                    TreeNode root = new TreeNode(i);  //构造新tree
                    root.left = leftSubTrees.get(l);
                    root.right = rightSubTrees.get(r);
                    res.add(root); //存储所有可能行
                }
            }

        }

        return res;
    }

    public static void main(String[] args) {

    }
}
