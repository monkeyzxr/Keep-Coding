/**
 * Created by monkeyzxr on 2017/6/7.
 *
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 *
 */

//[1,2,2,3] + [1,3] = [1,1,2,2,3,3]

//思路：
//只需要从头开始比较已排序的两个链表，新链表指针每次指向值小的节点，依次比较下去，
// 最后，当其中一个链表到达了末尾，我们只需要把新链表指针指向另一个没有到末尾的链表此时的指针即可。
    //http://www.jianshu.com/p/1ff9ba023561

public class LC_21_MergeTwoSortedLists {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode fakehead = new ListNode(-1);
        ListNode curr = fakehead;   //制造一个指针，从虚拟head开始向后指。

        while(l1 != null &&l2 != null){  //一直循环到一个list为null
            if (l1.val < l2.val){
                curr.next = l1;
                l1 = l1.next;
            }
            else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        if (l1 == null){   //把另一个不为null的list加入到结果list中。
            curr.next = l2;
        }
        if (l2 == null){
            curr.next = l1;
        }

        return fakehead.next;

    }

    public static void main(String[] args) {

    }
}
