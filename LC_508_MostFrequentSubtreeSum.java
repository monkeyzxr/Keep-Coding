import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by monkeyzxr on 2017/7/30.
 *
 Given the root of a tree, you are asked to find the most frequent subtree sum.
 The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself).
 So what is the most frequent subtree sum value? If there is a tie, return all the values with the highest frequency in any order.

 Examples 1
 Input:

   5
 /  \
 2   -3
 return [2, -3, 4], since all the values happen only once, return all of them in any order.

 Examples 2
 Input:

   5
 /  \
 2   -5
 return [2], since 2 happens twice, however -5 only occur once.
 Note: You may assume the sum of values in any subtree is in the range of 32-bit signed integer.
 *
 */
//题意：子树和的含义是指树中的一个节点所有子节点值得和（包含该节点）。一棵树每个节点都有子树和，找到存在数目最多的子树和。

//思路：子树是从下往上构建的，这种特点很适合使用后序遍历。
// 使用一个哈希表来建立子树和跟其出现频率的映射.
// 用一个变量cnt来记录当前最多的次数
//在递归函数中，我们先对当前结点的左右子结点调用递归函数，然后加上当前结点值，然后更新对应的哈希表中的值，然后看此时哈希表中的值是否大于等于cnt，
// 大于的话首先要清空res，等于的话不用，然后将sum值加入结果res中即可


    //http://www.cnblogs.com/grandyang/p/6481682.html
    //https://discuss.leetcode.com/topic/77775/verbose-java-solution-postorder-traverse-hashmap-18ms
public class LC_508_MostFrequentSubtreeSum {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

  //这两个要定义global variable： 要在func里面初始化！！！
    public static Map<Integer, Integer> map;  //map 存放的key是sum， value是sum出现的次数
    public static int maxCount;

    public static int[] findFrequentTreeSum(TreeNode root) {

        //在这里初始化，不然 如果重新run 整个func， 这两个global variable的数值会累计
        //也即是，每次调用findFrequentTreeSum，这两个variable都要是重新的新值。
        map = new HashMap<>();
        maxCount = 0;

        //并不知道结果的个数，所以用List
        List<Integer> res = new ArrayList<>();

        postOrder(root);

        for (int key : map.keySet()){
            if (map.get(key) == maxCount)
                res.add(key);
        }

        int[]result = new int[res.size()];  //结果从list转换成array
        for (int i = 0; i < res.size(); i++){
            result[i] = res.get(i);
        }

        return result;
    }


    //递归函数返回的是以当前结点为根结点的子树结点值之和
    public static int postOrder(TreeNode root){
        if (root == null)
            return 0;

        int left = postOrder(root.left);  //当前root的 左子树的和
        int right = postOrder(root.right);  //当前root的 右子树的和
        int sum = left + right + root.val;

       //map 存放的key是sum， value是sum出现的次数
        if (!map.containsKey(sum))
            map.put(sum, 1);
        else
            map.put(sum, map.get(sum)+1);

        maxCount = Math.max(maxCount, map.get(sum));

        return sum;
    }

    public static void main(String[] args) {

    }
}
