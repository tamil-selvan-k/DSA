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
    private ListNode reverse(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode node = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // l1 = reverse(l1);
        // l2 = reverse(l2);

        ListNode sum = new ListNode(0);
        ListNode res = sum;

        int carry = 0;
        int currSum = 0;
        int val = 0;

        while(l1 != null && l2 != null) {
            currSum = l1.val + l2.val + carry;
            val = currSum % 10;
            carry = currSum / 10;

            res.next = new ListNode(val);
            res = res.next;

            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1 != null) {
            currSum = l1.val + carry;
            val = currSum % 10;
            carry = currSum / 10;

            res.next = new ListNode(val);
            res = res.next;

            l1 = l1.next;
        }

        while(l2 != null) {
            currSum = l2.val + carry;
            val = currSum % 10;
            carry = currSum / 10;

            res.next = new ListNode(val);
            res = res.next;

            l2 = l2.next;
        }
        if(carry > 0) res.next = new ListNode(carry);

        return sum.next;
    }
}
