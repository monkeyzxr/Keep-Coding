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
    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    public static void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;

        ListNode mid = findMiddle(head);

        ListNode tail = reverse(mid.next);
        mid.next = null;  //设置左半段新的尾巴，相当于把原list截断

        merge(head, tail);
    }


    //双指针 快慢法  找middle
    private static ListNode findMiddle(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null){ //这个list不知道是奇偶的长度
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private static ListNode reverse(ListNode head){
        ListNode prev = null;  //构建一个指针，指向head的前一个node

        // pre 和 head 想象成两个指针
        while (head != null){
            ListNode tmp = head.next;  //先把head的右一个，保存下来
            head.next = prev;  //把head指向左边的node
            prev = head;
            head = tmp;
        }

        return prev;
    }


    private static void merge(ListNode head1, ListNode head2){
        ListNode dummyHead = new ListNode(-1);

        int index = 0;

        while (head1 != null && head2 != null){
            if (index%2 == 0){  //偶数位的index
                dummyHead.next = head1;
                head1 = head1.next;
            }
            else {  //奇数位的index
                dummyHead.next = head2;
                head2 = head2.next;
            }

            dummyHead = dummyHead.next;  //指针继续往下走
            index++;
        }

        if (head1 != null){ //如果head1 还有剩余的，没有merge进去
            dummyHead.next = head1;
        }
        if (head2 != null){
            dummyHead.next = head2;
        }

    }


    public static void main(String[] args) {

    }
}
