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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // do this in one pass
		// use double pointer
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		
		ListNode p1 = dummy;
		ListNode p2 = dummy;

		// first move the second pointer n steps
		for(int i=0; i<n; i++) {
			p2=p2.next;
		}
		// move the second pointer to the end
		while(p2.next!=null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		p1.next = p1.next.next;
		return dummy.next;
    }
}