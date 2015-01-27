package hw;

import java.util.*;

public class Solution{
	public static boolean isBalanced(TreeNode root) {
		if( root == null) return true;

		int height = DFS(root);

		boolean test_result = (height != -1);
		return test_result;
	}

	private static int DFS(TreeNode root) {
		if( root == null) {
			return 0;
		}

		
		int	left_height = DFS(root.left);
	   	int right_height = DFS(root.right);

		if(left_height == -1 || right_height == -1) return -1;

		if(Math.abs(left_height - right_height)>1) return -1;

		return (Math.max(left_height, right_height) + 1);
	}
}