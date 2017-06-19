/**
 * Created by monkeyzxr on 2017/6/18.
 *
 Given two binary trees, write a function to check if they are equal or not.

 Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 */

//自己写，正确
public class LC_100_SameTree {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;

        if (p.val  != q.val)  //这里一定要写return false的条件，不能写return true的，不然，下一步递归的return就进行不到
            return false;
        else
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

    }

    public static void main(String[] args) {

    }
}


/*
或者：
http://www.programcreek.com/2012/12/check-if-two-trees-are-same-or-not/

public boolean isSameTree(TreeNode p, TreeNode q) {
    if(p==null && q==null){
        return true;
    }else if(p==null || q==null){
        return false;
    }

    if(p.val==q.val){
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }else{
        return false;
    }
}
 */
