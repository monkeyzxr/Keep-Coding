/**
 * Created by monkeyzxr on 2017/6/5.
 *
 * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.

 Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3,
 the linked list should become 1 -> 2 -> 4 after calling your function.
 *
 */


//换种思路，我们把删除该结点改为删除该结点的下一个结点，但在删除之前把下一个结点的值覆盖此结点的值。
// 因此，虽然物理上删除的是下一个结点，但实际上该结点的值已经被删除了，而下一个结点的值仍然保留下来。
//https://leetcode.com/articles/delete-node-linked-list/
public class LC_237_DeleteNodeinLinkedList {

    public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }

    public static void deleteNode(ListNode node) {
        //check
        if(node == null)
            return;
        node.val = node.next.val;   //把要删除的node的下一个值，赋给要删除的node
        node.next = node.next.next;  //把要删除的node的next，指向next的next。这样，相当于删除了node的next。
    }

    public static void main(String[] args) {

    }
}
