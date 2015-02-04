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
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
		TreeNode left_child = root.left;
		TreeNode right_child = root.right;

		rotateTree(left_child);
		return isSameTree(left_child, right_child);
		
    }

	public boolean isSameTree( TreeNode T1, TreeNode T2 ) {
		if(T1 == null && T2==null ) {
			return true;
		} else if ( (T1 == null && T2!= null) || (T1!=null && T2==null) ) {
			return false;
		} else {
			if(T1.val != T2.val) return false;
			if( ! isSameTree(T1.left, T2.left) || !isSameTree(T1.right, T2.right) ) return false;
			return true;
		}
	}

	public void rotateTree( TreeNode root) {
		if(root == null ) return;
		TreeNode tmp = root.left;
		root.left = root.right;
		root.right = tmp;
		rotateTree(root.left);
		rotateTree(root.right);
	}
}