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
    public static boolean hasPathSum(TreeNode root, int sum) {

		// judge if root is null
		if( root == null ){
			return false;
		}
		boolean result = DFS(root, sum);
		return result;
    }

	static boolean DFS(TreeNode root, int sum) {
		// base case: reaching the leaf
		if(root.left == null && root.right == null){
			if( sum - root.val == 0) {
				return true;
			} else {
				return false;
			}

		}

		boolean tmp_left = false;
		boolean tmp_right = false;
		if(root.left != null) {
			tmp_left = DFS(root.left, sum - root.val);
			if(tmp_left) return true;
		}

		if(root.right != null) {
			tmp_right = DFS(root.right, sum - root.val);
			if(tmp_right) return true;
		}
		return false;
	}
}