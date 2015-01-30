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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;

		ListNode result = new ListNode(0);
		ListNode p2 = result;

		ListNode p = head;
		boolean if_du = false;
		
		while( p!= null && p.next != null) {
			if(p.val == p.next.val) {
				if_du = true;
				p = p.next;
			} else if(if_du) {
				p = p.next;
				if_du = false;
			} else {
				p2.next = new ListNode(p.val);
				p2 = p2.next;
				p = p.next;
			}
		}

		if(!if_du) p2.next = new ListNode(p.val); 

		return result.next;
    }
}