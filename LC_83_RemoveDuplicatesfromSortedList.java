/**
 * Created by monkeyzxr on 2017/6/4.
 *
 * Given a sorted linked list, delete all duplicates such that each element appear only once.

 For example,
 Given 1->1->2, return 1->2.
 Given 1->1->2->3->3, return 1->2->3.
 *
 */


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */



//注意： 已经排好序了！
//http://blog.csdn.net/linhuanmars/article/details/24354291
// 维护两个指针，一个指向当前不重复的最后一个元素，一个进行依次扫描，
// 遇到不重复的则更新第一个指针，继续扫描，否则就把前面指针指向当前元素的下一个（即把当前元素从链表中删除)

public class LC_83_RemoveDuplicatesfromSortedList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return null;

        ListNode pre = head;
        ListNode cur = head.next;

        while (cur != null){
            if (cur.val == pre.val)
                pre.next = cur.next;

            else
                pre = cur;

            cur = cur.next;
        }

        return head;
    }

    public static void main(String[] args) {

    }
}


