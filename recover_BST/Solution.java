/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
	TreeNode first;
	TreeNode second;
	TreeNode pre;
	
    public void recoverTree(TreeNode root) {
        // this is a O(log n) time O(log n) space solution
		// the O(1) space solution which uses the thread tree is saved for later
		first = null;
		second = null;
		pre = null;
		
		inOrderTravel(root);
		int tmp = first.val;
		first.val = second.val;
		second.val = tmp;
    }

	private void inOrderTravel(TreeNode root) {
		if(root == null) return;
		
		inOrderTravel(root.left);
		if( pre == null){
			// the first time reaching to a point
			pre = root;
		} else {
			if(pre.val > root.val) {
				if(first == null) { first = pre; }
				second = root;
			}
			pre = root;
		}
		inOrderTravel(root.right);
	}
}