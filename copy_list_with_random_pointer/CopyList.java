/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
	
		if(head == null) {
			return head;
		}
        // insert duplicate nodes
		RandomListNode pIter = head;
		RandomListNode pNew;
		while(pIter != null) {
			pNew = new RandomListNode( pIter.label );
			pNew.next = pIter.next;
			pIter.next = pNew;
			pIter = pIter.next.next;
		}
		
		
		// copy random pointer
		pIter = head;
		while(pIter != null) {
			if(pIter.random != null) {
				pIter.next.random = pIter.random.next;
			}
			pIter = pIter.next.next;
		}
		
		// disolve into two lists
		RandomListNode head2 = head.next;
		pIter = head;
		RandomListNode pNext = head.next;
		while(pNext!=null) {
			pIter.next = pIter.next.next;
			pIter = pNext;
			pNext = pNext.next;
			
		}
		
		return head2;
		
    }
}