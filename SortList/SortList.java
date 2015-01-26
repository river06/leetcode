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
 
 // this is a bottom up implementation of the merge sort algorithm.
 // it takes O(nlogn) time and O(1) additional space
public class Solution {
    public ListNode sortList(ListNode head) {
        // get the length of the ListNode
		int nNode = 0;
		ListNode pIterate = head;
		while(pIterate.next != null){
			pInterate = pInterate.next;
			nNode ++;
		}
		
		for(int sortedWidth=1; sortedWidth < nNode; sortedWidth*=2){
			// each time, double the length of sortedWidth
			// sortedWidth starts with one, since the one-length list can be viewed as sorted
			
			ListNode p1 = head;
			ListNode p2 = head;
			
			for(int i=0; i<nNode; i+= 2*sortedWidth){
				// get the correct p1 and p2
				p1 = p2.next;
				p2 = slideReferenceBack(p1,sortedWidth);
				if( p2==null) break;
				
				bottomUpMergeSort(p1,p2,sortedWidth);
			}
			
		}
    }
	
	private void bottomUpMergeSort(ListNode p1, ListNode p2, int sortedWidth){
		for(int i=0; i<2*sortedWidth; i++){
			// use p1 to maintain the list
			// use p2 to refer to the other list
			
			if(p1.next == null)
			p1.val
			p2.val
			
			
			
		}
	}
}







