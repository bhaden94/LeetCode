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
        ListNode l1Walker = l1;
        ListNode l2Walker = l2;
        ListNode l3Start = l3;
        int carry = 0;
        
        while (l1Walker != null && l2Walker != null) {
            int sum = l2Walker.val + l1Walker.val + carry;
            int right = sum % 10;
            carry = sum / 10;
            l3.next = new ListNode(right);
            l3 = l3.next;
            l2Walker = l2Walker.next;
            l1Walker = l1Walker.next;
        }
        
        while (l1Walker != null || l2Walker != null) {
            int sum;
            if (l1Walker == null) {
                sum = l2Walker.val + carry;
                l2Walker = l2Walker.next;
            } else {
                sum = l1Walker.val + carry;
                l1Walker = l1Walker.next;
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