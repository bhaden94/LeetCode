/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {        
        ListNode l3 = new ListNode(0);
        ListNode l3Start = l3;
        int carry = 0;
        
        while (l1 != null && l2 != null) {
            int sum = l2.val + l1.val + carry;
            int right = sum % 10;
            carry = sum / 10;
            l3.next = new ListNode(right);
            l3 = l3.next;
            l2 = l2.next;
            l1 = l1.next;
        }
        
        while (l1 != null || l2 != null) {
            int sum;
            if (l1 == null) {
                sum = l2.val + carry;
                l2 = l2.next;
            } else {
                sum = l1.val + carry;
                l1 = l1.next;
            }
            int right = sum % 10;
            carry = sum / 10;
            l3.next = new ListNode(right);
            l3 = l3.next;
        }
        
        if (carry == 1) {
            l3.next = new ListNode(1);
        }
        
        return l3Start.next;
    }
}