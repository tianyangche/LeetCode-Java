/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m == n) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        
        for (int i = 1; i < m; i++) {
            head = head.next;
        }
        
        ListNode pre = head.next;
        ListNode cur = head.next.next;
        
        for (int i = 1; i <= n - m; i++) {
            pre.next = cur.next;
            cur.next = head.next;
            head.next = cur;
            cur = pre.next;
        }
        
        return dummy.next;
    }
}