import java.util.Stack;

/**
 * Created by monkeyzxr on 2017/7/26.
 *
 Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

 Calling next() will return the next smallest number in the BST.

 Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.


 */

/*
题目大意：
实现一个二叉搜索树（BST）的迭代器。你的迭代器会使用BST的根节点初始化。

调用next()会返回BST中下一个最小的数字。

注意：next()和hasNext()应该满足平均O(1)时间复杂度和O(h)空间复杂度，其中h是树的高度。
 */


/*
解题思路：
维护一个栈，从根节点开始，每次迭代地将根节点的左孩子压入栈，直到左孩子为空为止。

调用next()方法时，弹出栈顶，如果被弹出的元素拥有右孩子，则以右孩子为根，将其左孩子迭代压栈。
 */

//http://www.programcreek.com/2014/04/leetcode-binary-search-tree-iterator-java/
//http://www.jiuzhang.com/solutions/binary-search-tree-iterator/
//http://blog.csdn.net/wen1158646729/article/details/47748649


public class LC_173_BinarySearchTreeIterator {




}

/*
import java.util.Stack;
public class BSTIterator {
    Stack<TreeNode> stack = new Stack<TreeNode>();

    public BSTIterator(TreeNode root) {

        while(root != null){
            stack.push(root);
            root = root.left;
        }
    }

    public boolean hasNext() {
        return !stack.isEmpty();

    }

    public int next() {
        TreeNode minCurrent = stack.pop();
        if(minCurrent.right != null){
            TreeNode rightNode = minCurrent.right;
            while(rightNode != null){
                stack.push(rightNode);
                rightNode = rightNode.left;
            }
        }

        return minCurrent.val;
    }
}

*/