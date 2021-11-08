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
        int carry = 0;
        ListNode l3 = new ListNode();
        ListNode traverse = l3;
        ListNode last = null;
        
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            
            System.out.println("sum: " + sum);
            
            traverse.val = sum % 10;
            carry = sum > 9 ? 1 : 0;
            traverse.next = new ListNode();
            last = traverse;
            traverse = traverse.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        
        while (l1 != null) {
            int sum = l1.val + carry;
            
            traverse.val = sum % 10;
            carry = sum > 9 ? 1 : 0;
            traverse.next = new ListNode();
            last = traverse;
            traverse = traverse.next;
            l1 = l1.next;
        }
        
        while (l2 != null) {
            int sum = l2.val + carry;
            
            traverse.val = sum % 10;
            carry = sum > 9 ? 1 : 0;
            traverse.next = new ListNode();
            last = traverse;
            traverse = traverse.next;
            l2 = l2.next;
        }
        
        if (carry == 0) last.next = null;
        else traverse.val = 1;
        
        return l3;
    }
}