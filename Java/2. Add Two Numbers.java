/*
You are given two non-empty linked lists representing two non-negative integers. 
The digits are stored in reverse order and each of their nodes contain a single digit. 
Add the two numbers and return it as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.
Example
  Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
  Output: 7 -> 0 -> 8
  Explanation: 342 + 465 = 807.
*/

//思路：各位相加后首先处理l1比l2长的情况，然后处理l2比l1长的情况，最终仍存在进位则前面加1（这种情况处理了l1和l2等长且包含进位的情况）
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int num = (l1.val + l2.val)%10;
        int carry = (l1.val + l2.val)/10;
        ListNode result = new ListNode(num);
        ListNode endNode = result;
        l1 = l1.next;
        l2 = l2.next;
        while(l1!=null && l2!= null){
            endNode.next = new ListNode((l1.val + l2.val + carry)%10);
            carry = (l1.val + l2.val + carry)/10;
            endNode = endNode.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if(l1 == null && l2 != null){
            while(l2 != null){
                endNode.next = new ListNode((l2.val + carry)%10);
                carry = (l2.val + carry)/10;
                endNode = endNode.next;
                l2 = l2.next;
            }
        }else if(l1 != null && l2 == null){
            while(l1 != null){
                endNode.next = new ListNode((l1.val + carry)%10);
                carry = (l1.val + carry)/10;
                endNode = endNode.next;
                l1 = l1.next;
            }
        }
        if(carry == 1){
            endNode.next = new ListNode(1);
        }
        return result;
    }
}

//简洁的代码：
//1、增加了一个头节点，将第一位的计算也包括在了循环内
//2、将l1和l2长度不等的情况在循环内进行了解决

public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode c1 = l1;
    ListNode c2 = l2;
    ListNode sentinel = new ListNode(0);
    ListNode d = sentinel;
    int sum = 0;
    while (c1 != null || c2 != null) {
        sum /= 10;
        if (c1 != null) {
            sum += c1.val;
            c1 = c1.next;
        }
        if (c2 != null) {
            sum += c2.val;
            c2 = c2.next;
        }
        d.next = new ListNode(sum % 10);
        d = d.next;
    }
    if (sum / 10 == 1)
        d.next = new ListNode(1);
    return sentinel.next;
}

