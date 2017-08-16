/**
 * Created by monkeyzxr on 2017/8/15.
 *
 Reverse a linked list from position m to n. Do it in-place and in one-pass.

 For example:
 Given 1->2->3->4->5->NULL, m = 2 and n = 4,

 return 1->4->3->2->5->NULL.

 Note:
 Given m, n satisfy the following condition:
 1 ? m ? n ? length of list.
 *
 */

//题目主要考察链表的“就地逆置”操作（不改变链表的值，只操作指针）。

    //http://bangbingsyb.blogspot.com/2014/11/leetcode-reverse-linked-list-ii.html
    //http://www.jiuzhang.com/solutions/reverse-linked-list-ii/
    //http://blog.csdn.net/linhuanmars/article/details/24613781

    /*
    分为两个步骤，
    第一步是找到m结点所在位置，
    第二步就是进行反转直到n结点。
    反转的方法就是每读到一个结点，把它插入到m结点前面位置，然后m结点接到读到结点的下一个。
    总共只需要一次扫描，所以时间是O(n)，只需要几个辅助指针，空间是O(1)
     */
public class LC_92_ReverseLinkedList_II {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m >= n || head == null)
            return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        head = dummy;

        for (int i = 1; i < m; i++){  //找到m位置 之前的那个node
            if (head == null)
                return null;

            head = head.next;
        }

        ListNode pre_mNode = head;
        ListNode mNode = head.next;
        ListNode nNode = mNode;      // m ,n 开始指在同一个node
        ListNode post_nNode = mNode.next;

        // Given 1->2->3->4->5->NULL, m = 2 and n = 4,
        //          m     n

        // return 1->4->3->2->5->NULL.

        for (int i = m; i < n; i++){
            if (post_nNode == null){
                return null;
            }
            ListNode tmp = post_nNode.next;
            post_nNode.next = nNode;    //往后指。就是把n node放在m node之前
            nNode = post_nNode;
            post_nNode = tmp;
        }

        mNode.next = post_nNode;   //断裂旧的m node之后的链接，形成新的链接
        pre_mNode.next = nNode;

        return dummy.next;



    }

    public static void main(String[] args) {

    }
}
