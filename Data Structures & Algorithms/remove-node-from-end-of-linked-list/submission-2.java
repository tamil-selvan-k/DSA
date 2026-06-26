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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return head;

        head = reverse(head);

        int ptr = 1;
        ListNode curr = new ListNode(0, head);
        if(n == 1) head = head.next;
        else
        while(curr != null && curr.next != null) {
            if(ptr == n) {
                curr.next = curr.next.next;
                break;
            }
            ptr++;
            curr = curr.next;
        }

        return reverse(head);
    }
}
