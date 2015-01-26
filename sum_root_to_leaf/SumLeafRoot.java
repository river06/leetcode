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
    public int sumNumbers(TreeNode root) {
		if(root == null) return 0;
        int result = sumChildren(root, 0);
		return result;
    }
	
	private int sumChildren(TreeNode root, int sumVal) {
		if(root.left == null && root.right == null) {
			return 10*sumVal + root.val;
		}
		
		int rootVal = root.val;
		int leftVal = 0;
		int rightVal = 0;
		
		if(root.left != null) {
			leftVal = sumChildren(root.left, sumVal*10+rootVal);
		}
		if(root.right != null) {
			rightVal = sumChildren(root.right, sumVal*10+rootVal);
		}
		
		return leftVal+rightVal; 
	}
}