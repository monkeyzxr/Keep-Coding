/**
 * Created by monkeyzxr on 2017/6/5.
 *
 * Given a linked list, determine if it has a cycle in it.

 Follow up:
 Can you solve it without using extra space?
 *
 */

//http://blog.csdn.net/dream_angel_z/article/details/46439485
//思路：设置两个临时指针，一个一次走一步，一个一次走两步，如果再次相遇，表示有环。
public class LC_141_LinkedListCycle {

    class ListNode {
     int val;
      ListNode next;
      ListNode(int x) {
         val = x;
         next = null;
     }
  }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;

        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {

    }

}
