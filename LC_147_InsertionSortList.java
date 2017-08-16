/**
 * Created by monkeyzxr on 2017/8/15.
 *
 Sort a linked list using insertion sort.
 */

/*
插入排序（英语：Insertion Sort）是一种简单直观的排序算法。
它的工作原理是通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。
插入排序在实现上，通常采用in-place排序（即只需用到O(1)的额外空间的排序），因而在从后向前扫描过程中，需要反复把已排序元素逐步向后挪位，为最新元素提供插入空间。
 */

//http://www.jiuzhang.com/solutions/insertion-sort-list/

    /*
public class LC_147_InsertionSortList {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        // 这个dummy的作用是，把head开头的链表一个个的插入到dummy开头的链表里
        // 所以这里不需要dummy.next = head;

        while (head != null){
            ListNode node = dummy;
            while (node.next != null && node.next.val < head.val)
                node = node.next;

            ListNode tmp = head.next;
            head.next = node.next;
            node.next = head;
            head = tmp;
        }

        return dummy.next;



    }

    public static void main(String[] args) {

    }
}
*/


    //方法2：http://blog.csdn.net/happyaaaaaaaaaaa/article/details/51619973
   /*
   用指针 p 逐一向后遍历
0. 申请一个 dummyHead 节点，其下一个节点指向头结点。如果要在头结点出插入，dummyHead 会给我们带来便利
1. 当 p 的值不大于下一节点值，就进行遍历下一节点
2. 当 p 的值大于下一节点，那么就将p 的下一节点取出，从前向后扫描，在第一个比它的值大的节点之前插入该节点
    */


   //自己画个图 就明白了
public class LC_147_InsertionSortList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode p = head;
        while (p.next != null){
            if (p.val <= p.next.val){ //p 的值不小于下一节点
                p = p.next;
            }
            else {
                ListNode tmp = p.next;
                ListNode q = dummy;

                p.next = p.next.next;
                while (q.next.val < tmp.val){//找到第一个大于该节点的前一节点
                    q = q.next;
                }

                tmp.next = q.next;
                q.next = tmp;
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {

    }
}
