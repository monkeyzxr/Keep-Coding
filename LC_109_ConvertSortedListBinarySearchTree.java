/**
 * Created by monkeyzxr on 2017/8/14.
 *
 Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 */

//这题和Convert Sorted Array to Binary Search Tree那题看上去很像，但是从array变成了linked list，就不能O(1)寻找中间节点了。

/*
https://siddontang.gitbooks.io/leetcode-solution/content/tree/convert_sorted_listarray_to_binary_search_tree.html
对于一个二叉树来说，左子树一定小于根节点，而右子树大于根节点。所以我们需要找到链表的中间节点，这个就是根节点，
链表的左半部分就是左子树，而右半部分则是右子树，我们继续递归处理相应的左右部分，就能够构造出对应的二叉树了。
 */

//http://www.programcreek.com/2013/01/leetcode-convert-sorted-list-to-binary-search-tree-java/
//http://www.jiuzhang.com/solutions/convert-sorted-list-to-binary-search-tree/

//http://bangbingsyb.blogspot.com/2014/11/leetcode-convert-sorted-list-to-binary.html

public class LC_109_ConvertSortedListBinarySearchTree {
    public class ListNode {  //Definition for singly-linked list.
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    public class TreeNode {  //Definition for a binary tree node.
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    //////////////////////////////////////////
  private ListNode current;

    public int getListLength(ListNode head){
        int length = 0;
        while (head != null){
            length++;
            head = head.next;
        }
        return length;
    }

    public TreeNode sortedListtoBSTHelper(int size){
        if (size <= 0)
            return null;

        TreeNode left = sortedListtoBSTHelper(size/2);
        TreeNode root = new TreeNode(current.val);
        current = current.next;
        TreeNode right = sortedListtoBSTHelper(size - 1 - size/2);

        root.left = left;
        root.right = right;

        return root;
    }

    public TreeNode sortedListToBST(ListNode head) {
        int size = getListLength(head);

        current = head;

        return sortedListtoBSTHelper(size);

    }

    public static void main(String[] args) {

    }
}
