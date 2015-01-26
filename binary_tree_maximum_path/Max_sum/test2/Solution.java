//package test;

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
    
    
	
    
    
    public static int maxPathSum(TreeNode root) {
        //static int max_value = -Integer.MAX_VALUE;
		int[] max_value = new int[1];
		max_value[0] = -Integer.MAX_VALUE;
		
		int result = getMaxPathSum(root, max_value);
		
		result = Math.max(result, max_value[0]);
		
		return result;
    }
	
	private static int getMaxPathSum(TreeNode node, int[] max_value) {
		
		System.out.println(max_value[0]);
		
		if(node == null) return 0;
		
		int left_max = getMaxPathSum(node.left, max_value);
		int right_max = getMaxPathSum(node.right, max_value);
		
		if( left_max + node.val > max_value[0] ) max_value[0] = left_max + node.val;
		if( right_max + node.val > max_value[0]) max_value[0] = right_max + node.val;
		if( right_max + left_max + node.val > max_value[0]) max_value[0] = right_max + left_max + node.val;
		if( node.val > max_value[0] ) max_value[0] = node.val;
		
		System.out.println(max_value[0]);
		
		int return_val = node.val;
		return_val = Math.max( return_val, node.val + left_max );
		return_val = Math.max( return_val, node.val + right_max );
		//return_val = Math.max( return_val, 0 );
		
		return return_val;
		
	}
}