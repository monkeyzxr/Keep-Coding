/**
 * Created by monkeyzxr on 2017/8/6.
 *
 Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

 Note: Do not modify the linked list.

 Follow up:
 Can you solve it without using extra space?


 *
 */

//图示解释很清楚：
//http://www.qiujiawei.com/leetcode-problem-142/

//http://bookshadow.com/weblog/2015/07/10/leetcode-linked-list-cycle-ii/
/*
    1). 使用快慢指针法，若链表中有环，可以得到两指针的交点M

2). 记链表的头节点为H，环的起点为E

2.1) L1为H到E的距离
2.2) L2为从E出发，首次到达M时的路程
2.3) C为环的周长
2.4) n为快慢指针首次相遇时，快指针在环中绕行的次数

根据L1,L2和C的定义，我们可以得到：

慢指针行进的距离为L1 + L2

快指针行进的距离为L1 + L2 + n * C

由于快慢指针行进的距离有2倍关系，因此：

2 * (L1+L2) = L1 + L2 + n * C => L1 + L2 = n * C => L1 = (n - 1)* C + (C - L2)

可以推出H到E的距离 = 从M出发绕环到达E时的路程

因此，当快慢指针在环中相遇时，我们再令一个慢指针从头节点出发

接下来当两个慢指针相遇时，即为E所在的位置
     */


//http://www.jiuzhang.com/solutions/linked-list-cycle-ii/
public class LC_142_LinkedListCycle_II {
    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }

    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null)
            return null;
        ListNode fast,slow;
        fast = head.next;
        slow = head;

        while (fast != slow){  //本循环结束，找到了fast和slow在环里面的相遇的node
            if (fast == null || fast.next == null)  //验证是否有环
                return null;
            fast = fast.next.next;
            slow = slow.next;
        }

        while (head != slow.next){  //slow在环里继续走，head从头看是往右走。两者相遇点就是结果
            head = head.next;  //head比slow先走一步
            slow = slow.next;
        }

        return head;
    }

    public static void main(String[] args) {

    }

}
