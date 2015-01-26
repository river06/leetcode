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
    public boolean hasCycle(ListNode head) {
	
		if (head == null) {
			return false;
		}
		ListNode pFast = head;
		ListNode pSlow = head;
        while ((pFast != null) && (pFast.next != null) ) {
			pFast = pFast.next.next;
			pSlow = pSlow.next;
			if(pFast == pSlow) {
				return true;
			}
		}
		return false;
    }
}