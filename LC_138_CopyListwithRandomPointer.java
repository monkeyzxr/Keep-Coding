/**
 * Created by monkeyzxr on 2017/8/14.
 *
 A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

 Return a deep copy of the list.
 *
 */

//翻译：给定一个链表，这个链表的每个节点包含两个指针，其中一个指针next指向下一个节点，另一个指针random指向任意一个节点，或者为空。复制这个链表并返回。

    //很好的图示：
    //http://blog.csdn.net/tmylzq187/article/details/50913211

    //http://www.jiuzhang.com/solutions/copy-list-with-random-pointer/
    /*第一遍扫的时候巧妙运用next指针， 开始数组是1->2->3->4  。
    然后扫描过程中 先建立copy节点 1->1`->2->2`->3->3`->4->4`, 然后第二遍copy的时候去建立边的copy，
    拆分节点, 一边扫描一边拆成两个链表，这里用到两个dummy node。
    第一个链表变回  1->2->3 , 然后第二变成 1`->2`->3`  */

public class LC_138_CopyListwithRandomPointer {
    static class RandomListNode {
      int label;
      RandomListNode next, random;
      RandomListNode(int x) { this.label = x; }
  };

    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null)
            return null;

        copyNext(head);
        copyRandom(head);

        return splitList(head);

    }




    //////helper/////////////////////////////////
    public static void copyNext(RandomListNode head){
        while (head != null){
            RandomListNode newNode = new RandomListNode(head.label); //当前的head之后创建一个新的node，要和head一模一样
            newNode.random = head.random;
            newNode.next = head.next;

            head.next = newNode;
            head = head.next.next;
        }
    }

    public static void copyRandom(RandomListNode head){
        while (head != null){
            if (head.next.random != null){
                head.next.random = head.random.next;
            }
            head = head.next.next;
        }
    }

    public static RandomListNode splitList(RandomListNode head){
        RandomListNode newHead = head.next;
        while (head != null){
            RandomListNode tmp = head.next;  //tmp想象成指针
            head.next = tmp.next;
            head = head.next;

            if (tmp.next != null){
                tmp.next = tmp.next.next;
            }
        }

        return newHead;
    }



    public static void main(String[] args) {

    }
}
