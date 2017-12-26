/*
Given a linked list, swap every two adjacent nodes and return its head.
For example,
  Given 1->2->3->4, you should return the list as 2->1->4->3.
Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
*/

/*
思路：设置一个计数器，计数器为奇数时将当前节点和下一个节点的数字交换。
*/
class Solution 
    public ListNode swapPairs(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode p = head;
        for(int i=1 ; p.next!=null ; i++ , p = p.next){
            if(i % 2 != 0){
                if(p.next != null){
                    int nextValue = p.next.val;
                    p.next.val = p.val;
                    p.val = nextValue;
                }
            }
        }
        return head;
    }
}

/*
另一种思路：递归
*/
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if ((head == null)||(head.next == null))
            return head;
        ListNode n = head.next;
        head.next = swapPairs(head.next.next);
        n.next = head;
        return n;
    }
}


