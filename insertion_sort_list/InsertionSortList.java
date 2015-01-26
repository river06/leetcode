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
    public ListNode insertionSortList(ListNode head) {
	
		if(head==null) {
			return head;
		} else if (head.next == null) {
			return head;
		}
        // break the list into two lists
		ListNode pFirst = head.next;
		ListNode pSecond = pFirst.next;
		
		head.next = null;
		
		while( pSecond !=null) {
			// cut the list
			pFirst.next = null;
			
			head = insertSortedList(head, pFirst);
			
			// move the pFirst and pSecond 
			pFirst = pSecond;
			pSecond = pSecond.next;
		}
		
		// sort the last node
		head = insertSortedList(head, pFirst);
		return head;
    }
	
	private ListNode insertSortedList(ListNode head, ListNode pLoose) {
		ListNode pDummy = new ListNode(0);
		pDummy.next = head;
		ListNode pIterate = pDummy;
		while(pIterate.next != null) {
			if(pIterate.next.val > pLoose.val) {
				pLoose.next = pIterate.next;
				pIterate.next = pLoose;
				return pDummy.next;
			}
			pIterate = pIterate.next;
		}
		pIterate.next = pLoose;
		return pDummy.next;
	}
}