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
    public ListNode reverseKGroup(ListNode head, int k) {
		if(k==1) return head;// special case
		
        // get the length of the list
		int length = 0;
		ListNode p = head;
		while(p!=null) {
			length ++;
			p=p.next;
		}

		int n_loop = length/k; // any problem with k=1?
		ListNode dummy_head = new ListNode(0);
		ListNode p_pre_tail = dummy_head;
		ListNode p_next_head = head;
		for(int i=0; i<n_loop; i++) {
			// reverse string
			p_pre_tail.next = null; // break the list
			ListNode p1 = p_next_head;
			ListNode p2 = p1.next;
			ListNode p_this_tail = null;
			for(int j=0; j<k-1; j++) {
				ListNode tmp = p_pre_tail.next;
				p_pre_tail.next = p1;
				p1.next = tmp;
				if(j==0) p_this_tail = p1;
				p1 = p2;
				p2 = p2.next;
			}
			// last node
			ListNode tmp = p_pre_tail.next;
			p_pre_tail.next = p1;
			p1.next = tmp;
			// maintain p_tail and p_next_head
			p_next_head = p2;
			p_pre_tail = p_this_tail;
		}
		// insert the rest part
		p_pre_tail.next = p_next_head;
		return dummy_head.next;
    }
}