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
		if(m==n) return head;
		
        // first find the pointer that points to the mth node
		// add one dummy node to deal with special case when m=0
		ListNode dummy = new ListNode(0);

		dummy.next = head;

		ListNode p1 = dummy;
		for(int i=1; i<m; i++) p1 = p1.next;

		// reverse the following n nodes
		ListNode p2 = p1;
		ListNode p3 = p2.next;
		p1.next = null; // break the list
		ListNode pTail = null;
		for(int j=0; j<=n-m; j++) {
			p2 = p3;
			p3 = p3.next;

            // insert node pointed by p2 to the list following by p1
			ListNode tmp = p1.next;
			p1.next = p2;
			p2.next = tmp;
			if(j==0) {
				pTail = p2;
			}


		}
		pTail.next = p3;

		return dummy.next;
			
    }
}