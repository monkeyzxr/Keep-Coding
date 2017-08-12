/**
 * Created by monkeyzxr on 2017/8/11.
 *
 Write a program to find the node at which the intersection of two singly linked lists begins.


 For example, the following two linked lists:

 A:          a1 → a2
                     ↘
                       c1 → c2 → c3
                     ↗
 B:     b1 → b2 → b3

 begin to intersect at node c1.


 Notes:

 If the two linked lists have no intersection at all, return null.
 The linked lists must retain their original structure after the function returns.
 You may assume there are no cycles anywhere in the entire linked structure.
 Your code should preferably run in O(n) time and use only O(1) memory.
 *
 */


/*
因为如果两个链长度相同的话，那么对应的一个个比下去就能找到，所以只需要把长链表变短即可。
具体算法为：分别遍历两个链表，得到分别对应的长度。然后求长度的差值，把较长的那个链表向后移动这个差值的个数，然后一一比较即可
 */
//http://www.cnblogs.com/grandyang/p/4128461.html
    //http://bookshadow.com/weblog/2014/12/04/leetcode-intersection-two-linked-lists/
    //http://www.programcreek.com/2014/02/leetcode-intersection-of-two-linked-lists-java/
//图示：
//http://blog.csdn.net/nomasp/article/details/50572819
public class LC_160_IntersectionTwoLinkedLists {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;

        int lenA = getLength(headA);
        int lenB = getLength(headB);

        if (lenA < lenB){   //把较长的list，head先向后移动 length差值 个位置。
            for (int i = 0; i < lenB-lenA; i++){
                headB = headB.next;
            }
        }else {
            for (int i = 0; i < lenA-lenB; i++){
                headA = headA.next;
            }
        }

        //当两个list长度相等，再一个一个的比较下去
        while (headA != null && headB != null && headA != headB){
            headA = headA.next;
            headB = headB.next;
        }

        if (headA != null && headB != null)
            return headA;

        return null;

    }

    public static int getLength(ListNode head){
        int count = 0;
        while (head != null){
            count++;
            head = head.next;
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
