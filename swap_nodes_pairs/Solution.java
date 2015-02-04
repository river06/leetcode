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
    public ListNode swapPairs(ListNode head) {
        if(head == null) return head;
		if(head.next == null) return head;
		ListNode dum_h = new ListNode(0);
		dum_h.next = head;

		ListNode p = dum_h;
		while(true) {
			if( p == null ) break;
			if( p.next == null ) break;
			if( p.next.next == null ) break;

			ListNode p1 = p.next;
			ListNode p2 = p1.next;
			ListNode p3 = p2.next;

			p.next = p2;
			p2.next = p1;
			p1.next = p3;

			p = p1;
		}
		return dum_h.next;
    }
}