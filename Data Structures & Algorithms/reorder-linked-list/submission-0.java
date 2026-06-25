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
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;

        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode rev = reverse(slow.next);
        slow.next = null;

        slow = head.next;
        ListNode res = head;

        while(slow != null && rev != null) {
            res.next = rev;
            rev = rev.next;
            res.next.next = slow;
            slow = slow.next;
            res = res.next.next;
        }

        if(slow != null) res.next = slow;
        if(rev != null) res.next = rev;
    }
}