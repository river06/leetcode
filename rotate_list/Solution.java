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
    public ListNode rotateRight(ListNode head, int n) {
		if(head==null) return head;
		// get list length
		ListNode p = head;
		int length =0;
		while(p!=null) {
			length ++;
			p=p.next;
		}

		n %= length;

		if( n==0) return head;
		
		// use double pointer to get the correct position
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode p1 = dummy;
		ListNode p2 = dummy;
		for(int i=0; i<n; i++) {
			if(p2.next==null) return head;
			p2=p2.next;
		}
		while(p2.next!=null) {
			p1=p1.next;
			p2=p2.next;
		}

		if(p1==dummy) return dummy.next;

		ListNode p_second_head = p1.next;
		ListNode p_first_head = dummy.next;
		dummy.next = p_second_head;
		p2.next = p_first_head;
		p1.next = null;
		return dummy.next;
		
    }
}