/**
 * Created by monkeyzxr on 2017/6/8.
 *
 * Reverse a singly linked list.

 Hint:
 A linked list can be reversed either iteratively or recursively. Could you implement both?
 */


//这个方法是在原来的linkedlist上，直接reverse。原来的linkedlist就不存在了。
public class LC_206_ReverseLinkedList {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode tmp;

        while (curr != null){
            tmp = curr.next;  //tmp用于存放当前node的下一个node .因为curr的next node要改指向，所以在没改变之前，存下来curr的next node。
            curr.next = prev;   // 把当前node指向前一个node；

            prev = curr;   //prev和curr 是两个指针，一直往下走
            curr = tmp;
        }
        return prev;
    }

    public static void main(String[] args) {

    }
}


//另一种做法：相当于创建新的node，node里面存原来list的node的值，然后反转
// 原来的linkedlist还是存在的。
    /*
public class LC_206_ReverseLinkedList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode pointer = head;
        ListNode prev = new ListNode(head.val);

        while(pointer.next != null){
            ListNode newAddNode = new ListNode(pointer.next.val);
            newAddNode.next = prev;
            prev  = newAddNode;
            pointer = pointer.next;
        }
        return prev;

    }

    public static void main(String[] args) {

    }
}
*/