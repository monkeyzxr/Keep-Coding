/**
 * Created by monkeyzxr on 2017/6/26.
 *
 Given a linked list, swap every two adjacent nodes and return its head.

 For example,
 Given 1->2->3->4, you should return the list as 2->1->4->3.

 Your algorithm should use only constant space.
 You may not modify the values in the list, only nodes itself can be changed.


 *
 */

//http://www.jiuzhang.com/solutions/swap-nodes-in-pairs/
    //http://blog.csdn.net/linhuanmars/article/details/19948569
//这道题中用了一个辅助指针作为表头，这是链表中比较常用的小技巧，因为这样可以避免处理head的边界情况，一般来说要求的结果表头会有变化的会经常用这个技巧，大家以后会经常遇到。
public class LC_24_SwapNodesinPairs {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        head = dummy;
        while (head.next != null && head.next.next != null){
            ListNode n1 = head.next;
            ListNode n2 = head.next.next;
            // head->n1->n2->...
            // => head->n2->n1->...

            head.next = n2;
            n1.next = n2.next;
            n2.next = n1;

            head = n1;  //move to next pair

        }
        return dummy.next;



    }

    public static void main(String[] args) {

    }
}
