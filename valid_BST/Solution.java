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
    public boolean isValidBST(TreeNode root) {
		int[] bounds = {Integer.MAX_VALUE, Integer.MIN_VALUE};
        return isValidRecur( root, bounds);
    }

	public boolean isValidRecur( TreeNode root, int[] bounds) {
		if(root == null) {
			bounds[0] = Integer.MAX_VALUE;
			bounds[1] = Integer.MIN_VALUE;
			return true;
		}

		int root_val = root.val;

		// make copy of bounds
		int[] left_bounds = new int[2];
		int[] right_bounds = new int[2];
		for(int i=0; i<2; i++) {
			left_bounds[i] = bounds[i];
			right_bounds[i] = bounds[i];
		}

		if( !isValidRecur( root.left, left_bounds)||
			!isValidRecur( root.right, right_bounds) ) {
			return false;
		}
		if( root_val == Integer.MIN_VALUE ) {
			if( root.left != null ) return false;
			if( root_val >= right_bounds[0] ) return false;
		} else if (root_val == Integer.MAX_VALUE ) {
			if( root.right != null ) return false;
			if( left_bounds[1] >= root_val ) return false;
		} else {
			if( left_bounds[1] >= root_val ) return false;
			if( root_val >= right_bounds[0] ) return false;
		}
		// change bounds
		bounds[0] = Math.min( left_bounds[0], root_val);
		bounds[1] = Math.max( root_val, right_bounds[1] );
		return true;
	}
}