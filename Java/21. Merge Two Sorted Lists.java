/*
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
Example:
  Input: 1->2->4, 1->3->4
  Output: 1->1->2->3->4->4
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
常规思路：
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        ListNode resultList = null;
        if(l1.val >= l2.val){
            resultList = new ListNode(l2.val);
            l2 = l2.next;
        }else{
            resultList = new ListNode(l1.val);
            l1 = l1.next;
        }
        ListNode tailNode = resultList;
        while(l1 != null && l2 != null){
            if(l1.val >= l2.val){
                tailNode.next = l2;
                l2 = l2.next;
            }else{
                tailNode.next = l1;
                l1 = l1.next;
            }
            tailNode = tailNode.next;
        }
        if(l1 == null){
            while(l2 != null){
                tailNode.next = l2;
                l2 = l2.next;
                tailNode = tailNode.next;
            }
        }
        if(l2== null){
            while(l1 != null){
                tailNode.next = l1;
                l1 = l1.next;
                tailNode = tailNode.next;
            }
        }
        return resultList;
    }
}

递归实现：
public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if(l1 == null){
        return l2;
    }
    if(l2 == null){
        return l1;
    }

    if(l1.val<l2.val){
        l1.next = mergeTwoLists(l1.next, l2);
        return l1;
    }else{
        l2.next = mergeTwoLists(l2.next, l1);
        return l2;
    }
}
