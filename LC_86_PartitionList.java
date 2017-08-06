/**
 * Created by monkeyzxr on 2017/8/5.
 *
 Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

 You should preserve the original relative order of the nodes in each of the two partitions.

 For example,
 Given 1->4->3->2->5->2 and x = 3,
 return 1->2->2->4->3->5.
 *
 */
//原有的顺序不能动，就是比x小的相对的顺序，大于等于x的相对顺序也不能变
//思路：保持两个链表

    /*https://www.tianmaying.com/tutorial/LC86
    我们建立less和greater，分别存储小于 x 的元素和不小于 x 的元素。遍历原链表，将其中的元素根据其val分别加入对应的链表。

最后将less的最后一个元素与greater的链表头相连即可。

需要注意的是，若less链表为空，则应该返回greater链表的头。
     */

    //http://www.jiuzhang.com/solutions/partition-list/
public class LC_86_PartitionList {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    public ListNode partition(ListNode head, int x) {
        if (head == null)
            return null;

        ListNode leftDummy = new ListNode(0);
        ListNode rightDummy = new ListNode(0);

        ListNode pLeft = leftDummy;
        ListNode pRight = rightDummy;

        while (head != null){
            if (head.val < x){
                pLeft.next = head;
                pLeft = head;  //指针往下移动
            }
            else {
                pRight.next = head;
                pRight = head; //指针往下移动
            }
            head = head.next;
        }

        pRight.next = null;  //设置新list的尾巴
        pLeft.next = rightDummy.next;  //链接两个list

        return leftDummy.next;
    }

    public static void main(String[] args) {

    }
}
