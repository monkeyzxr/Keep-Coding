import java.util.Arrays;

/**
 * Created by monkeyzxr on 2017/6/26.
 *
 You are given two non-empty linked lists representing two non-negative integers.
 The digits are stored in reverse order and each of their nodes contain a single digit.
 Add the two numbers and return it as a linked list.

 You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 0 -> 8
 *
 */
public class LC_2_AddTwoNumbers {
    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);  //创建一个新的list儲存輸出的結果，因為list的指針要不斷往後移，因此用一個假節點方便操作
        ListNode curr = dummy;  //结果指向dummy的头的指针

        int carry = 0;  //处理进位：  两个数相加，carry要么是0，要么是1

        while (l1 != null || l2 != null){
            int digit1, digit2;

            if (l1 == null)  //取l1的val
                digit1 = 0;
            else
                digit1 = l1.val;

            if (l2 == null)  //取l2的val
                digit2 = 0;
            else
                digit2 = l2.val;

            int sum = digit1 + digit2 + carry;

            if (sum >= 10)  // 通过当前的sum，设置下一位上的carry的值
                carry = 1;
            else
                carry = 0;

            curr.next = new ListNode(sum % 10);  //创建新的node，作为结果
            curr = curr.next;

            if (l1 != null)  //l1， l2继续往下走
                l1 = l1.next;

            if (l2 != null)
                l2 = l2.next;
        }

        if (carry == 1)   // 如果循环结束，最高位相加还要进位，则新创造一个node存放最高位
            curr.next = new ListNode(1);

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode res = addTwoNumbers(l1, l2);
        System.out.println(res.val);  //7
        System.out.println(res.next.val); //0
        System.out.println(res.next.next.val); //8




    }
}
