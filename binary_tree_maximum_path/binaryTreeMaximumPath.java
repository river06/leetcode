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
    
    private static int max_value = -Integer.MAX_VALUE;
	
    public int maxPathSum(TreeNode root) {
        //static int max_value = -Integer.MAX_VALUE;
		
		int result = getMaxPathSum(root, max_value);
		
		return result;
    }
	
	private int getMaxPathSum(TreeNode node, int max_value) {
		if(node == null) return 0;
		
		int left_max = getMaxPathSum(node.left, max_value);
		int right_max = getMaxPathSum(node.right, max_value);
		
		if( left_max + node.val > max_value ) max_value = left_max + node.val;
		if( right_max + node.val > max_value) max_value = right_max + node.val;
		if( node.val > max_value ) max_value = node.val;
		
		int return_val = node.val;
		return_val = Math.max( return_val, node.val + left_max );
		return_val = Math.max( return_val, node.val + right_max );
		//return_val = Math.max( return_val, 0 );
		
		return return_val;
		
	}
}