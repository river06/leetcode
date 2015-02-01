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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // base case
		if(p==null || q==null) {
			if(p==null && q==null) {
				return true;
			} else {
				return false;
			}
		}

		if(p.val != q.val) return false;
		return (isSameTree(p.left, q.left)&&isSameTree(p.right, q.right));
    }
}