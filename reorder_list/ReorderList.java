/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
		if(head == null) {
			return;
		} else if (head.next == null) {
			return;
		}
		
		// get the half of the list and cut it in two lists
		ListNode pIterate = head;
		int nNode = 0;
		while(pIterate != null) {
			nNode ++;
			pIterate = pIterate.next;
		}
		
		int nHalf = nNode/2;
		pIterate = head;
		for(int i=0; i<nHalf-1; i++) {
			pIterate = pIterate.next;
		}
		ListNode head2 = pIterate.next;
		
		pIterate.next = null;
		
		// reverse the second list
		head2 = reverseListInPlace(head2);
		// merge the two lists
		head = mergeTwoLists(head,head2);
        
    }
	
	private ListNode mergeTwoLists(ListNode head1, ListNode head2) {
		// assuming head1 and head2 are neither null
		// merge two lists, starting with the first node of the first list
		ListNode p1 = head1;
		ListNode p2 = head2;
		
		ListNode p5 = head1;
		
		// assuming that p2 is longer
		int flag_sweep = 0;
		
		while( p1!=null ) {
			switch(flag_sweep) {
				case 0: 
					p1 = p1.next;
					p5.next = p2;
					p5 = p5.next;
					break;
				case 1:
					p2 = p2.next;
					p5.next = p1;
					p5 = p5.next;
					break;
			}
			flag_sweep ++;
			flag_sweep %= 2;
		}
		return head1;
	}
	
	private ListNode reverseListInPlace(ListNode pHead) {
		ListNode p1,p2,p3;
		
		if(pHead == null) {
			return pHead;
		} else if( pHead.next == null) {
			return pHead;
		} else {
			// cases of two or more nodes
			p1 = pHead;
			p2 = pHead.next;
			p3 = p2.next;
			
			p1.next = null; // first node to last node
			
			while( p3!=null ) {
				// reverse the link
				p2.next = p1;
				p1 = p2;
				p2 = p3;
				p3 = p3.next;		
			}
			
			// reverse the last pair of nodes
			// since p3 = p3.next is invalid
			p2.next = p1;
			pHead = p2;
			return pHead;
		}
	}
	
}
















