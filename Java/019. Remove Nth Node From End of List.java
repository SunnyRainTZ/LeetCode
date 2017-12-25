/*
Given a linked list, remove the nth node from the end of list and return its head.
For example,
  Given linked list: 1->2->3->4->5, and n = 2.
  After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
  Given n will always be valid.
  Try to do this in one pass.
*/

/*
思路：前指针走n步时后指针开始走，前指针走到尾部时，后指针走到倒数第n个。
注意：在head前面添加一个头结点方便统一处理。
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode result = new ListNode(0);
        result.next = head;
        ListNode behind = result;
        ListNode front = result;
        int count = 0;
        while(count < n){
            front = front.next;
            count++;
        }
        while(front.next != null){
            front = front.next;
            behind = behind.next;
        }
        behind.next = behind.next.next;
        return result.next;
    }
}



