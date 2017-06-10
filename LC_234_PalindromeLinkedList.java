/**
 * Created by monkeyzxr on 2017/6/8.
 *
 * Given a singly linked list, determine if it is a palindrome.

 Follow up:
 Could you do it in O(n) time and O(1) space?
 */


//方法1：创建新的  reversed list
//and then compare each node. The time and space are O(n).
//http://www.programcreek.com/2014/07/leetcode-palindrome-linked-list-java/
    /*
public class LC_234_PalindromeLinkedList {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;

        ListNode point = head;
        ListNode prev = new ListNode(head.val);  //创建新node

        while (point.next != null){
            ListNode tmp = new ListNode(point.next.val); // 创建新node
            tmp.next = prev;
            prev = tmp;
            point = point.next;
        }
       // return prev;  新的reversed之后的list


        ListNode p1 = head;  //最初的list
        ListNode p2 = prev;   //reverse之后的list

        while(p1 != null){
            if (p1.val != p2.val)
                return false;

            p1 = p1.next;
            p2 = p2.next;
        }

        return true;
    }

    public static void main(String[] args) {

    }
}
*/


//思路2：不创建新的linkedlist， 使空间为 O（1）。
// use a fast and slow pointer to get the center of the list,
// then reverse the second list and compare two sub-lists.
// The time is O(n) and space is O(1).

//http://www.programcreek.com/2014/07/leetcode-palindrome-linked-list-java/

public class LC_234_PalindromeLinkedList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;

        //find the list center
        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null && fast.next.next !=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode secondHead = slow.next;  //当前slow位置的下一个，作为后半段list的第一个
        slow.next = null; //相当于把list劈成两段。第一段后面指向null

        //reverse 第二段的list
        ListNode p1 = secondHead;   //2个指针
        ListNode p2 = p1.next;
        while (p1 != null && p2 != null){
            ListNode tmp = p2.next;   //构建临时指针tmp，存放反转之前的p2的next
            p2.next = p1;
            p1 = p2;
            p2 = tmp;
        }
        secondHead.next = null;  // 把第一个node指向null，作为尾巴


        //比较两个sub lists

        //先找到反转后的第二段list的head
        ListNode p_second;
        if (p2 == null){
             p_second = p1;
        }
        else {
             p_second = p2;
        }

        ListNode p_first = head;

        while(p_second!= null){  //要以后半段的list进行历遍比较。因为如果是奇数个node，后半段的node会比前半段的node数量少一个！！
                                  // 若历遍前半段，若是奇数个node，则前半段比后半段多一个，比较起来，肯定两段会不一样！
            if(p_first.val != p_second.val){
                return false;
            }
            p_first = p_first.next;
            p_second = p_second.next;
        }

        return true;

    }

    public static void main(String[] args) {

    }
}