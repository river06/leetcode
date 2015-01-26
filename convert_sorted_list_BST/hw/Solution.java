package hw;

public class Solution {

	static ListNode pList; // global variable
    public static TreeNode sortedListToBST(ListNode head) {
        // this code create the BST in a bottom-up fation
		pList = head; 

		if(head == null) return null;
		
		int n = getListLength(head);
		
		TreeNode result = createBSTBottomUp(0, n-1);

		return result;
    }

	private static int getListLength(ListNode head) {
		int result = 0;

		ListNode p = head;

		while(p != null) {
			p = p.next;
			result ++;
		}
		return result;
	}

	private static TreeNode createBSTBottomUp(int start, int end) {
		if(start > end) return null;

		int mid = (start + end)/2;

		TreeNode left_child = createBSTBottomUp(start, mid -1);
		
		TreeNode root = new TreeNode( pList.val);
		pList = pList.next;
		
		TreeNode right_child = createBSTBottomUp(mid+1, end);

		root.left = left_child;
		root.right = right_child;

		return root;
	}
}