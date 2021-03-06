package hw;

public class Solution {
	
	private static void dfs(TreeLinkNode root) {
		if(root == null ) {
			return;
		}
		
		if( root.next == null) {
			// if root is on the right boundary of the tree
			if(root.right!=null) root.right.next = null;
			if(root.left!=null) root.left.next = root.right; // root.right = null is ok
		} else {
			// if root has next node
			TreeLinkNode pNext = root.next;
			TreeLinkNode pRNext = null;
			// find the next node that is on the right of root
			while(pNext!=null) {
				if(pNext.left!=null){
					pRNext = pNext.left;
					break;
				}
				if(pNext.right!=null){
					pRNext = pNext.right;
					break;
				}
				pNext = pNext.next;
			}
			if(root.right!=null && root.left!=null) {
				root.right.next = pRNext;
				root.left.next = root.right;
			}else if (root.right==null && root.left!=null) {
				root.left.next = pRNext;
			}else if (root.left== null && root.right!=null) {
				root.right.next = pRNext;
			}
				
			
			
		}
		dfs(root.right);
		dfs(root.left);
	}
	
	public static void connect(TreeLinkNode root) {
		if(root==null) return;
		root.next = null;
		dfs(root);
        
    }

}
