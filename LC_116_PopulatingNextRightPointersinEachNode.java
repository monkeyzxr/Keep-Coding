/**
 * Created by monkeyzxr on 2017/7/27.
 *
 Given a binary tree

 struct TreeLinkNode {
 TreeLinkNode *left;
 TreeLinkNode *right;
 TreeLinkNode *next;
 }
 Populate(填充) each next pointer to point to its next right node.
 If there is no next right node, the next pointer should be set to NULL.

 Initially, all next pointers are set to NULL.

 Note:

 You may only use constant extra space.
 You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).

 For example,
 Given the following perfect binary tree,
        1
      /  \
     2    3
    / \  / \
   4  5  6  7
 After calling your function, the tree should look like:
        1 -> NULL
      /  \
     2 -> 3 -> NULL
    / \  / \
   4->5->6->7 -> NULL
 *
 */


/*
http://blog.csdn.net/DERRANTCM/article/details/47438089

将树的每一层节点用next串起来。这样每一层也会形成一个单链表。
而每层的链表头，则是，根的左孩子，左孩子，左孩子。
利用双循环，外层循环，沿着根的左孩子，一直向下。
内层循环，负责将下一层的节点串起来。
即，将自己右孩子放到左孩子的next上，而右孩子，则可通过自己的next指针，找到右邻居。
 */
public class LC_116_PopulatingNextRightPointersinEachNode {
    public static class TreeLinkNode {
      int val;
      TreeLinkNode left, right, next;
      TreeLinkNode(int x) { val = x; }
  }

    public void connect(TreeLinkNode root) {
        TreeLinkNode node;   //把node 想象成一个pointer，最开始指向root

        // 题中假设了输入的树是一棵完全叉树
        // 第一个循环用来处理整个树
        // root.left != null如果不用，则处理到最后第一个没有左右子树的结点会出错
        while (root != null && root.left != null){
            // 每个root表示第一个层的第一个结点
            // node记录每一个层的第一个结点
            node = root;

            // 处理每个层
            while (node != null){
                node.left.next = node.right; // 表示连接的是同一个结点的下的两子结点

                if (node.next != null){   //例如 图中的数字2
                    node.right.next = node.next.left; // 将这个结点的右子结点连接到这个结点的同层相邻结点的左子结点上
                }

                node = node.next;  // 移动到同层的下一个结点
            }

            root = root.left; // 移动到下一层的第一个结点
        }

    }

    public static void main(String[] args) {

    }
}

/*
用层次遍历(BFS)也可以相当容易解出来，而且这种方法用在下一题一点不用变。

 但是 这个解法不能符合题意。题目要求我们使用 constant extra space.


public void connect1(TreeLinkNode root) {
    if (root == null) {
        return;
    }

    TreeLinkNode dummy = new TreeLinkNode(0);
    Queue<TreeLinkNode> q = new LinkedList<TreeLinkNode>();
    q.offer(root);
    q.offer(dummy);

    while (!q.isEmpty()) {
        TreeLinkNode cur = q.poll();
        if (cur == dummy) {
            if (!q.isEmpty()) {
                q.offer(dummy);
            }
            continue;
        }

        if (q.peek() == dummy) {
            cur.next = null;
        } else {
            cur.next = q.peek();
        }

        if (cur.left != null) {
            q.offer(cur.left);
        }

        if (cur.right != null) {
            q.offer(cur.right);
        }
    }
}
 */
