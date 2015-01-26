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
    public ListNode detectCycle(ListNode head) {
        ListNode pFast = head;
		ListNode pSlow = head;
		
		if(head == null) {
			return null;
		}
		
		while(pFast != null && pSlow != null) {
			
			pSlow = pSlow.next;
			
			pFast = pFast.next;
			
			if(pFast!=null) pFast = pFast.next;
			
			if(pFast == pSlow) {
				break;
			}
			
		}
		
		if(pFast == null) {
			return null;
		} else {
			pSlow = head;
			
			while(pFast!=pSlow) {
				pFast = pFast.next;
				pSlow = pSlow.next;
			}
			
			return pFast;
		}
    }
}