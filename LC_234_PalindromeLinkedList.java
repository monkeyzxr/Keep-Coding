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

//思路2：不创建新的linkedlist， 使空间为 O（1）。
