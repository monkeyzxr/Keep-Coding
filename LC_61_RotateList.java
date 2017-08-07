/**
 * Created by monkeyzxr on 2017/8/6.
 *
 Given a list, rotate the list to the right by k places, where k is non-negative.

 For example:
 Given 1->2->3->4->5->NULL and k = 2,
 return 4->5->1->2->3->NULL.
 *
 */

//和第19题类似！
//只需要找到这个链表的倒数第k个元素，然后将从第k个元素开始的所有结点移到链表的开头即可。

    //http://www.jiuzhang.com/solutions/rotate-list/
public class LC_61_RotateList {
    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null)
            return null;

        int length = getLength(head);
        k = k % length;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        head = dummy;   //这里和19题不一样。本题要找倒数第k个node，不是找前一个preDelete的node
                       //所以 head 要指在 dummy head上。head和 下面的tail node都从dummy head开始跑

        ListNode tail = dummy;   //就是 后跑的node
        for (int i = 0; i < k; i++){   //让head 先跑k步
            head = head.next;
        }

        while (head.next != null){  //让tail node后跑 。head 同时继续跑
            tail = tail.next;
            head = head.next;
        }  //本循环结束后， tail的next所在的node就是倒数第k个node

        head.next = dummy.next;   // Given 1->2->3->4->5->NULL and k = 2,
                                    //return 4->5->1->2->3->NULL.
        dummy.next = tail.next;
        tail.next = null;

        return dummy.next;

    }

    public  static int getLength(ListNode head){
        int length = 0;
        while (head != null){
            length++;
            head = head.next;
        }
        return length;
    }

    public static void main(String[] args) {

    }
}

