/**
 * Created by monkeyzxr on 2017/8/11.
 *
 Given a singly linked list L: L0?L1?…?Ln-1?Ln,
 reorder it to: L0?Ln?L1?Ln-1?L2?Ln-2?…

 You must do this in-place without altering the nodes' values.

 For example,
 Given {1,2,3,4}, reorder it to {1,4,2,3}.
 *
 *
 */

/*
http://www.jianshu.com/p/679d4a435b6a
原题:

给定一个单链表L: L0→L1→…→Ln-1→Ln,
重新排列后为：L0→Ln→L1→Ln-1→L2→Ln-2→…
必须在不改变节点值的情况下进行原地操作。
样例
给出链表 1->2->3->4->null，重新排列后为1->4->2->3->null。

解题思路:

把题目分解成一个个小的任务
首先根据1->2->3->4，找中点，然后得到两个链表1->2和3->4
翻转第二个链表得到1->2和4->3
最后合并两个链表得到1->4->2->3
 */

//http://www.cnblogs.com/yrbbest/p/4438931.html
//链表重排序。 可以分为三个步骤，找中点， reverse中点及以后部分，合并链表。

//http://www.jiuzhang.com/solutions/reorder-list/
public class LC_143_ReorderList {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    public static void reorderList(ListNode head) {

    }

    public static void main(String[] args) {

    }
}
