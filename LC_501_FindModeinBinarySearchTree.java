import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by monkeyzxr on 2017/6/15.
 *
 Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.

 Assume a BST is defined as follows:

 The left subtree of a node contains only nodes with keys less than or equal to the node's key.
 The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
 Both the left and right subtrees must also be binary search trees.
 For example:
 Given BST [1,null,2,2],
  1
   \
    2
   /
  2
 return [2].

 Note: If a tree has more than one mode, you can return them in any order.

 Follow up: Could you do that without using any extra space? (Assume that the implicit stack space incurred due to recursion does not count).
 */


//思路：中序遍历（对于整个树，先遍历左节点，再遍历中间节点，最后遍历右节点），使用中序遍历遍历二叉搜索树，可以获得一个从小到大的排好序的升序序列。

/*
https://zh.wikipedia.org/wiki/树的遍历
中序遍历(In-Order Traversal)
指先访问左（右）子树，然后访问根，最后访问右（左）子树的遍历方式，其C代码如下:

void in_order_traversal(TreeNode* root){
  if(root->lchild!=NULL)
    in_order_traversal(root->lchild);
  //Do Something with root
  if(root->rchild!=NULL)
    in_order_traversal(root->rchild);
}
 */

//http://blog.h5min.cn/mine_song/article/details/70904568
    //http://www.cnblogs.com/grandyang/p/6436150.html
public class LC_501_FindModeinBinarySearchTree {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

  public Map<Integer, Integer> map  = new HashMap<>();
    public int max;

  public void inOrder(TreeNode root){
        //先左子树
        if (root.left != null)
            inOrder(root.left);

        //do something with root here
      if (map.containsKey(root.val))
          map.put(root.val, map.get(root.val)+1);
      else
          map.put(root.val, 1);

      max = Math.max(max, map.get(root.val));  //计算出现最多的次数

      //最后右子树
      if (root.right != null)
          inOrder(root.right);

  }

    public int[] findMode(TreeNode root) {
        if (root == null)
            return new int[0];

        this.map = new HashMap<>();  //每次调用这个method的时候，map都要清空
        max = -1;    //每次都初始化max的值

        inOrder(root);  // 注意，在他之前，上面两个参数都要初始化

        List<Integer> list = new ArrayList<>();

        for (int key : map.keySet()){
            if (map.get(key) == max)
                list.add(key);
        }

        int[] res = new int[list.size()];
        for (int i = 0 ; i < res.length; i++){
            res[i] = list.get(i);
        }

        return res;
    }

    public static void main(String[] args) {

    }
}
