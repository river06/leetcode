package hw;

import java.util.*;

public class Solution{
	public static boolean isBalanced(TreeNode root) {
		if( root == null) return true;

		int min_depth = BFS(root);

		int max_depth = DFS(root);

		boolean test_result = (Math.abs(max_depth - min_depth)<2);
		return test_result;
	}

	private static int DFS(TreeNode root, int cur_length) {
		if(root.left == null && root.right == null) {
			return cur_length;
		}

		int left_length = cur_length;
		int right_length = cur_length;

		if(root.left != null) {
			left_length = DFS(root.left, cur_length+1);
		}

		if(root.right != null) {
			right_length = DFS(root.right, cur_length + 1);
		}

		int result = Math.max(left_length, right_length);
		return result;
	}

	private static int BFS(TreeNode root) {

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		Queue<Integer> level = new LinkedList<Integer>();
		queue.add(root);
		level.add(1);

		TreeNode head = root;
		Integer hLevel = 1;

		while( head.left != null || head.right != null) {

			hLevel = level.peek();
			
			if(head.left != null) {
				queue.add(head.left);
				level.add(hLevel + 1);
			}
			if(head.right != null) {
				queue.add(head.right);
				level.add(hLevel + 1);
			}
			queue.remove();
			level.remove();
			
			head = queue.peek();
		}
		
		hLevel = level.peek();

		return (int) hLevel;
		
	}
}
