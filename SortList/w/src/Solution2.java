
public class Solution2 {
	public static ListNode sortList(ListNode head) {
		if(head==null) {
			return head;
		} else if (head.next == null) {
			return head;
		}
		
		
		int nNode = 0;
		ListNode pHead = head;
		while(pHead != null) {
			pHead = pHead.next;
			nNode ++;
		}
		
		
		
		for(int sortedWidth=1; sortedWidth<nNode; sortedWidth*=2) {
			
			ListNode nextHead = head;
			ListNode currHead;
			ListNode currTail;
			ListNode lastTail = null;
			ListNode currMid;
			ListNode currFirstTail;
			ListNode[] pHT = new ListNode[2];
			
			for(int i=0; i<nNode; i+= 2*sortedWidth) {
				
				//i is the initial index of the list
			
				
			
				currHead = nextHead;
				if( i+ sortedWidth >= nNode) {
					if(i>0){
						lastTail.next = currHead;
						break;
					} else {
						break;
					}
				} 
				
				// split the list in two, sort and merge them
					
				currFirstTail = slideReferenceBack(currHead,sortedWidth-1);
				currMid = slideReferenceBack(currFirstTail,1);
				currFirstTail.next = null;
					
				int numTillEnd = Math.min(sortedWidth-1, nNode - (i + sortedWidth+1));
				currTail = slideReferenceBack(currMid,numTillEnd);
				if(currTail.next == null) {
					nextHead = head; // do nothing
				} else {
					nextHead = currTail.next;
					currTail.next = null;
				}
					
					
				pHT = mergeSortBottom(currHead, currMid);
				
				if(i>0){
					lastTail.next = pHT[0];
				} else {
					head = pHT[0];
				}
				
				lastTail = pHT[1]; // tail of merged list
				
				
			}
		}
		
		
		return head;
	}
	
	private static ListNode[] mergeSortBottom(ListNode p, ListNode q){
		ListNode[] pHT = new ListNode[2];
		
		ListNode dummyHead = new ListNode(0);
		

		pHT[0] = dummyHead;
		pHT[1] = dummyHead;
		
		while(p!=null || q!=null) {
			if(p != null && q!= null) {
				if(p.val < q.val) {
					pHT[1].next = p;
					p = p.next;
				} else {
					pHT[1].next = q;
					q = q.next;
				}
			} else if (p == null) {
				pHT[1].next = q;
				q = q.next;
			} else {
				pHT[1].next = p;
				p = p.next;
			}
			
			pHT[1] = pHT[1].next;
		}
		
		pHT[0] = dummyHead.next;
		
		return pHT;
	}


	private static ListNode slideReferenceBack(ListNode p, int step) {
		
		if(p==null) {
			return p;
		}
		for(int i =0; i<step; i++){
			if(p.next == null){
				p = null;
				break;
			}
			p = p.next;
		}
		return p;
	}

}
