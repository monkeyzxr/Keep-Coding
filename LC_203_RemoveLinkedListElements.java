/**
 * Created by monkeyzxr on 2017/6/5.
 *
 * Remove all elements from a linked list of integers that have value val.

 Example
 Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
 Return: 1 --> 2 --> 3 --> 4 --> 5


 */

//由于删除时候需要遍历链表，但遍历的开始必须是头结点，而头结点如果要删除就要额外处理了。
// 这里我们在头结点之前再插入一个临时结点，以统一处理整个链表。
    //https://wjqwsp.github.io/2016/09/24/LeetCode-203-Remove-Linked-List-Elements-题解/
public class LC_203_RemoveLinkedListElements {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;    //至此，建立新的linkedlist

        while (cur.next != null){   //check当前node的next node
            if (cur.next.val == val)
                cur.next = cur.next.next;
            else
                cur = cur.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {

    }
}
