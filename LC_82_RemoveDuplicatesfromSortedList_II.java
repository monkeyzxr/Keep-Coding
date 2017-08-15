/**
 * Created by monkeyzxr on 2017/8/14.
 *
 Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

 For example,
 Given 1->2->3->3->4->4->5, return 1->2->5.
 Given 1->1->1->2->3, return 2->3.
 *
 */

//http://www.jiuzhang.com/solutions/remove-duplicates-from-sorted-list-ii/
    //http://bangbingsyb.blogspot.com/2014/11/leetcode-remove-duplicates-from-sorted_19.html

    //头节点也可能被删除。可以使用dummy节点来简化。
public class LC_82_RemoveDuplicatesfromSortedList_II {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head; //dummy成为新的head
        head = dummy;  //head成了指针

        while (head.next != null && head.next.next != null){
            if (head.next.val == head.next.next.val){ //开始出现第一次的重复
                int val = head.next.val;

                while (head.next != null && head.next.val == val){
                    head.next = head.next.next;  //继续往下找连续相等的数，并删掉
                }
            }
            else { //如果没有重复，继续往下走
                head = head.next;
            }
        }

        return dummy.next;

    }

    public static void main(String[] args) {

    }
}
