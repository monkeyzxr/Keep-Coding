/**
 * Created by monkeyzxr on 2017/8/5.
 *
 Given a linked list, remove the nth node from the end of list and return its head.

 For example,

 Given linked list: 1->2->3->4->5, and n = 2.

 After removing the second node from the end, the linked list becomes 1->2->3->5.
 Note:
 Given n will always be valid.
 Try to do this in one pass.
 *
 */


/*http://bangbingsyb.blogspot.com/2014/11/leetcode-remove-nth-node-from-end-of.html
常用技巧：
1. Dummy head：简化改变、删除头指针的处理。
2. 前后双指针：多用于链表反转。
 */

/*
如何找到倒数第k个节点?双指针before, after。让before先从head开始走k步，然后双指针同时走，当before为NULL时，after所指的就是倒数第k个节点。
以题中例子说明：

k=2

1->2->3->4->5->NULL
 |    |
after before

1->2->3->4->5->NULL
         |      |
        after  before


例如 1 2 3 4 5 6 7 8 9  k= 3
 */

//http://www.jiuzhang.com/solutions/remove-nth-node-from-end-of-list/
public class LC_19_RemoveNthNodeFromEndofList {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n <= 0)
            return null;

        ListNode dummy = new ListNode(-1);  //创造一个 假的head
        dummy.next = head;

        ListNode preDelete = dummy;

        for (int i = 0; i < n; i++){
            if (head == null)  //如果n的值 比 整个list 还要长，则不可能，返回null
                return null;

            head = head.next;  //把head想成一个before指针，先往右走n步
        }

        while(head != null){
            head = head.next;
            preDelete = preDelete.next;  //然后preDelete指针开始从头往右走。当head走到null时，preDelete指针 停在 要删除的node的左一位。
        }

        preDelete.next = preDelete.next.next; //删掉preDelete的右侧的node

        return dummy.next;
    }

    public static void main(String[] args) {

    }

}
